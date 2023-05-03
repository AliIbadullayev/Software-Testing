/*
   Licensed to the Apache Software Foundation (ASF) under one or more
   contributor license agreements.  See the NOTICE file distributed with
   this work for additional information regarding copyright ownership.
   The ASF licenses this file to You under the Apache License, Version 2.0
   (the "License"); you may not use this file except in compliance with
   the License.  You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
*/
var showControllersOnly = false;
var seriesFilter = "";
var filtersOnlySampleSeries = true;

/*
 * Add header in statistics table to group metrics by category
 * format
 *
 */
function summaryTableHeader(header) {
    var newRow = header.insertRow(-1);
    newRow.className = "tablesorter-no-sort";
    var cell = document.createElement('th');
    cell.setAttribute("data-sorter", false);
    cell.colSpan = 1;
    cell.innerHTML = "Requests";
    newRow.appendChild(cell);

    cell = document.createElement('th');
    cell.setAttribute("data-sorter", false);
    cell.colSpan = 3;
    cell.innerHTML = "Executions";
    newRow.appendChild(cell);

    cell = document.createElement('th');
    cell.setAttribute("data-sorter", false);
    cell.colSpan = 7;
    cell.innerHTML = "Response Times (ms)";
    newRow.appendChild(cell);

    cell = document.createElement('th');
    cell.setAttribute("data-sorter", false);
    cell.colSpan = 1;
    cell.innerHTML = "Throughput";
    newRow.appendChild(cell);

    cell = document.createElement('th');
    cell.setAttribute("data-sorter", false);
    cell.colSpan = 2;
    cell.innerHTML = "Network (KB/sec)";
    newRow.appendChild(cell);
}

/*
 * Populates the table identified by id parameter with the specified data and
 * format
 *
 */
function createTable(table, info, formatter, defaultSorts, seriesIndex, headerCreator) {
    var tableRef = table[0];

    // Create header and populate it with data.titles array
    var header = tableRef.createTHead();

    // Call callback is available
    if(headerCreator) {
        headerCreator(header);
    }

    var newRow = header.insertRow(-1);
    for (var index = 0; index < info.titles.length; index++) {
        var cell = document.createElement('th');
        cell.innerHTML = info.titles[index];
        newRow.appendChild(cell);
    }

    var tBody;

    // Create overall body if defined
    if(info.overall){
        tBody = document.createElement('tbody');
        tBody.className = "tablesorter-no-sort";
        tableRef.appendChild(tBody);
        var newRow = tBody.insertRow(-1);
        var data = info.overall.data;
        for(var index=0;index < data.length; index++){
            var cell = newRow.insertCell(-1);
            cell.innerHTML = formatter ? formatter(index, data[index]): data[index];
        }
    }

    // Create regular body
    tBody = document.createElement('tbody');
    tableRef.appendChild(tBody);

    var regexp;
    if(seriesFilter) {
        regexp = new RegExp(seriesFilter, 'i');
    }
    // Populate body with data.items array
    for(var index=0; index < info.items.length; index++){
        var item = info.items[index];
        if((!regexp || filtersOnlySampleSeries && !info.supportsControllersDiscrimination || regexp.test(item.data[seriesIndex]))
                &&
                (!showControllersOnly || !info.supportsControllersDiscrimination || item.isController)){
            if(item.data.length > 0) {
                var newRow = tBody.insertRow(-1);
                for(var col=0; col < item.data.length; col++){
                    var cell = newRow.insertCell(-1);
                    cell.innerHTML = formatter ? formatter(col, item.data[col]) : item.data[col];
                }
            }
        }
    }

    // Add support of columns sort
    table.tablesorter({sortList : defaultSorts});
}

$(document).ready(function() {

    // Customize table sorter default options
    $.extend( $.tablesorter.defaults, {
        theme: 'blue',
        cssInfoBlock: "tablesorter-no-sort",
        widthFixed: true,
        widgets: ['zebra']
    });

    var data = {"OkPercent": 99.16666666666667, "KoPercent": 0.8333333333333334};
    var dataset = [
        {
            "label" : "FAIL",
            "data" : data.KoPercent,
            "color" : "#FF6347"
        },
        {
            "label" : "PASS",
            "data" : data.OkPercent,
            "color" : "#9ACD32"
        }];
    $.plot($("#flot-requests-summary"), dataset, {
        series : {
            pie : {
                show : true,
                radius : 1,
                label : {
                    show : true,
                    radius : 3 / 4,
                    formatter : function(label, series) {
                        return '<div style="font-size:8pt;text-align:center;padding:2px;color:white;">'
                            + label
                            + '<br/>'
                            + Math.round10(series.percent, -2)
                            + '%</div>';
                    },
                    background : {
                        opacity : 0.5,
                        color : '#000'
                    }
                }
            }
        },
        legend : {
            show : true
        }
    });

    // Creates APDEX table
    createTable($("#apdexTable"), {"supportsControllersDiscrimination": true, "overall": {"data": [0.6606481481481481, 500, 1500, "Total"], "isController": false}, "titles": ["Apdex", "T (Toleration threshold)", "F (Frustration threshold)", "Label"], "items": [{"data": [0.4888888888888889, 500, 1500, "1"], "isController": false}, {"data": [0.4986111111111111, 500, 1500, "2"], "isController": false}, {"data": [0.9944444444444445, 500, 1500, "3"], "isController": false}]}, function(index, item){
        switch(index){
            case 0:
                item = item.toFixed(3);
                break;
            case 1:
            case 2:
                item = formatDuration(item);
                break;
        }
        return item;
    }, [[0, 0]], 3);

    // Create statistics table
    createTable($("#statisticsTable"), {"supportsControllersDiscrimination": true, "overall": {"data": ["Total", 1080, 9, 0.8333333333333334, 606.6083333333326, 313, 951, 617.5, 834.0, 840.0, 850.0, 7.77285976465508, 1.7534478570657455, 1.1917372881355932], "isController": false}, "titles": ["Label", "#Samples", "FAIL", "Error %", "Average", "Min", "Max", "Median", "90th pct", "95th pct", "99th pct", "Transactions/s", "Received", "Sent"], "items": [{"data": ["1", 360, 8, 2.2222222222222223, 805.6666666666671, 712, 912, 816.5, 843.0, 846.0, 855.3399999999999, 2.5909532548850263, 0.5844826190219152, 0.3972457627118644], "isController": false}, {"data": ["2", 360, 1, 0.2777777777777778, 607.1694444444444, 519, 951, 616.5, 642.0, 648.0, 688.0199999999998, 2.5931181525473783, 0.5849709894906684, 0.3975776854979867], "isController": false}, {"data": ["3", 360, 0, 0.0, 406.98888888888865, 313, 734, 414.0, 442.0, 446.0, 504.3399999999999, 2.5965221028944008, 0.585738872820905, 0.3980995802289267], "isController": false}]}, function(index, item){
        switch(index){
            // Errors pct
            case 3:
                item = item.toFixed(2) + '%';
                break;
            // Mean
            case 4:
            // Mean
            case 7:
            // Median
            case 8:
            // Percentile 1
            case 9:
            // Percentile 2
            case 10:
            // Percentile 3
            case 11:
            // Throughput
            case 12:
            // Kbytes/s
            case 13:
            // Sent Kbytes/s
                item = item.toFixed(2);
                break;
        }
        return item;
    }, [[0, 0]], 0, summaryTableHeader);

    // Create error table
    createTable($("#errorsTable"), {"supportsControllersDiscrimination": false, "titles": ["Type of error", "Number of errors", "% in errors", "% in all samples"], "items": [{"data": ["The operation lasted too long: It took 859 milliseconds, but should not have lasted longer than 850 milliseconds.", 1, 11.11111111111111, 0.09259259259259259], "isController": false}, {"data": ["The operation lasted too long: It took 851 milliseconds, but should not have lasted longer than 850 milliseconds.", 2, 22.22222222222222, 0.18518518518518517], "isController": false}, {"data": ["The operation lasted too long: It took 912 milliseconds, but should not have lasted longer than 850 milliseconds.", 1, 11.11111111111111, 0.09259259259259259], "isController": false}, {"data": ["The operation lasted too long: It took 910 milliseconds, but should not have lasted longer than 850 milliseconds.", 1, 11.11111111111111, 0.09259259259259259], "isController": false}, {"data": ["The operation lasted too long: It took 853 milliseconds, but should not have lasted longer than 850 milliseconds.", 3, 33.333333333333336, 0.2777777777777778], "isController": false}, {"data": ["The operation lasted too long: It took 951 milliseconds, but should not have lasted longer than 850 milliseconds.", 1, 11.11111111111111, 0.09259259259259259], "isController": false}]}, function(index, item){
        switch(index){
            case 2:
            case 3:
                item = item.toFixed(2) + '%';
                break;
        }
        return item;
    }, [[1, 1]]);

        // Create top5 errors by sampler
    createTable($("#top5ErrorsBySamplerTable"), {"supportsControllersDiscrimination": false, "overall": {"data": ["Total", 1080, 9, "The operation lasted too long: It took 853 milliseconds, but should not have lasted longer than 850 milliseconds.", 3, "The operation lasted too long: It took 851 milliseconds, but should not have lasted longer than 850 milliseconds.", 2, "The operation lasted too long: It took 859 milliseconds, but should not have lasted longer than 850 milliseconds.", 1, "The operation lasted too long: It took 912 milliseconds, but should not have lasted longer than 850 milliseconds.", 1, "The operation lasted too long: It took 910 milliseconds, but should not have lasted longer than 850 milliseconds.", 1], "isController": false}, "titles": ["Sample", "#Samples", "#Errors", "Error", "#Errors", "Error", "#Errors", "Error", "#Errors", "Error", "#Errors", "Error", "#Errors"], "items": [{"data": ["1", 360, 8, "The operation lasted too long: It took 853 milliseconds, but should not have lasted longer than 850 milliseconds.", 3, "The operation lasted too long: It took 851 milliseconds, but should not have lasted longer than 850 milliseconds.", 2, "The operation lasted too long: It took 859 milliseconds, but should not have lasted longer than 850 milliseconds.", 1, "The operation lasted too long: It took 912 milliseconds, but should not have lasted longer than 850 milliseconds.", 1, "The operation lasted too long: It took 910 milliseconds, but should not have lasted longer than 850 milliseconds.", 1], "isController": false}, {"data": ["2", 360, 1, "The operation lasted too long: It took 951 milliseconds, but should not have lasted longer than 850 milliseconds.", 1, "", "", "", "", "", "", "", ""], "isController": false}, {"data": [], "isController": false}]}, function(index, item){
        return item;
    }, [[0, 0]], 0);

});

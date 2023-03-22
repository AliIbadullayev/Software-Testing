package test.company.lab2;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

import java.io.*;
import java.nio.file.Paths;

public class Ln {
    public double ln(double x, double eps) {
        if (Double.isNaN(x) || x < 0.0) {
            return Double.NaN;
        } else if (x == Double.POSITIVE_INFINITY) {
            return Double.POSITIVE_INFINITY;
        } else if (x == 0.0) return Double.NEGATIVE_INFINITY;

        final double MULTIPLIER = Math.pow((x - 1), 2) / Math.pow((x + 1), 2);

        double res = 0;
        double currentTerm = (x - 1) / (x + 1);
        long stepNum = 1;


        while (Math.abs(currentTerm) > eps / 10e3) {
            res += currentTerm;
            currentTerm = (2 * stepNum - 1) * currentTerm * MULTIPLIER / (2 * stepNum + 1);
            stepNum++;
        }
        res = res * 2;

        return res;
    }

    public double writeResultToCSV(double x, double eps, Writer out) {
        double res = ln(x, eps);
        try (CSVPrinter printer = CSVFormat.DEFAULT.print(out)) {
            printer.printRecord(x, res);
        } catch (IOException e) {
            System.out.println("Wrong filename");
        }
        return res;
    }


    public static void main(String[] args) throws FileNotFoundException {
//        lnInPowerSeries(42, 0.1);
//        writeResultToCSV(0,0.01, new PrintWriter(new File(Paths.get("lab2/resources/csv/output/ln.csv").toUri())));
    }
}

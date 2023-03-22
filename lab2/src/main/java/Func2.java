import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

import java.io.*;
import java.nio.file.Paths;

public class Func2 {

    Log log;
    Ln ln;

    public Func2() {
        this.log = new Log();
        this.ln = new Ln();
    }

    public Func2(Log log, Ln ln) {
        this.log = log;
        this.ln = ln;
    }

    public double secondExpressionCalc(double x, double eps){
        if (x <= 0) return Double.NaN;

        return ((((log.log(x,10,eps)+log.log(x,3,eps)*log.log(x,2,eps))/ln.ln(x,eps))+log.log(x,5,eps))+log.log(x,5,eps));

    }

    public double writeResultToCSV(double x, double eps) throws FileNotFoundException {
        Writer out = new PrintWriter(new File(Paths.get("lab2/src/main/resources/csv/output/secondExpression.csv").toUri()));
        double res = secondExpressionCalc(x,eps);
        try (CSVPrinter printer = CSVFormat.DEFAULT.print(out)) {
            printer.printRecord(x, res);
        } catch (IOException e) {
            System.out.println("Wrong filename");
        }
        return res;
    }

    public static void main(String[] args) throws FileNotFoundException {
//        writeResultToCSV(0, 0.000000001);
//        System.out.println(secondExpressionCalc(0,0.000000001));
//        System.out.println(secondExpressionCalc(0.25,0.000000001));
//        System.out.println(secondExpressionCalc(0.5,0.000000001));
//        System.out.println(secondExpressionCalc(1,0.000000001));
//        System.out.println(secondExpressionCalc(2,0.000000001));
//        System.out.println(secondExpressionCalc(2.718281828,0.000000001));
//        System.out.println(secondExpressionCalc(3,0.000000001));
//        System.out.println(secondExpressionCalc(4,0.000000001));
//        System.out.println(secondExpressionCalc(5,0.000000001));
//        System.out.println(secondExpressionCalc(9,0.000000001));
//        System.out.println(secondExpressionCalc(10,0.000000001));
//        System.out.println(secondExpressionCalc(25,0.000000001));
//        System.out.println(secondExpressionCalc(100,0.000000001));
    }


}

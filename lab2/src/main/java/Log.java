import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

import java.io.*;
import java.nio.file.Paths;

public class Log {

    Ln ln;

    public Log(Ln ln) {
        this.ln = ln;
    }

    public Log(){
        this.ln = new Ln();
    }

    public double log(double x, double base, double eps){
        return ln.ln(x,eps)/ln.ln(base,eps);
    }

    public double writeResultToCSV(double x, double base, double eps) throws FileNotFoundException {
        Writer out = new PrintWriter(new File(Paths.get("lab2/csv/output/log.csv").toUri()));
        double res = log(x, base, eps);
        try (CSVPrinter printer = CSVFormat.DEFAULT.print(out)) {
//            printer.printRecord(x, base, res);
            printer.printRecord(x, res);
        } catch (IOException e) {
            System.out.println("Wrong filename");
        }
        return res;
    }

    public static void main(String[] args) throws FileNotFoundException {
//        writeResultToCSV(1000, 10, 0.0001);
    }



}

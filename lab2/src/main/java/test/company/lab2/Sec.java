package test.company.lab2;

public class Sec {
    Cos cos;

    public Sec() {
        this.cos = new Cos(new Sin());
    }

    public Sec(Cos cos) {
        this.cos = cos;
    }

    private static final int DIGITS_AFTER_COMMA = 3;

    public double calculate(double x){
        if (x % (Math.PI/2) == 0 && x % Math.PI != 0)
            return Double.NaN;
        double result = 1/cos.calculate(x);
        return formatOutput(result);
//        return result;
    }

    public double calculateExpected(double x){
        if (x % (Math.PI/2) == 0 && x % Math.PI != 0)
            return Double.NaN;
        return formatOutput(1/Math.cos(x));
//        return Math.cos(x);
    }

    private static double formatOutput(double value){
        return (double) Math.round(value*Math.pow(10, DIGITS_AFTER_COMMA))/Math.pow(10, DIGITS_AFTER_COMMA);
    }
}

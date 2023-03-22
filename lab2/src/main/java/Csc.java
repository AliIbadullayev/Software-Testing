public class Csc {
    Sin sin;

    public Csc() {
        this.sin = new Sin();
    }

    public Csc(Sin sin) {
        this.sin = sin;
    }

    private static final int DIGITS_AFTER_COMMA = 3;

    public double calculate(double x){
        if (x == 0 || x%Math.PI == 0)
            return Double.NaN;
        double result =  1/sin.calculate(x);
        return formatOutput(result);
//        return result;
    }

    public double calculateExpected(double x){
        if (x == 0 || x%Math.PI == 0)
            return Double.NaN;
        return formatOutput(1/Math.sin(x));
//        return Math.cos(x);
    }

    private static double formatOutput(double value){
        return (double) Math.round(value*Math.pow(10, DIGITS_AFTER_COMMA))/Math.pow(10, DIGITS_AFTER_COMMA);
    }
}

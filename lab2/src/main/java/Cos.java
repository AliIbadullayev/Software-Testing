public class Cos {
    Sin sin;

    public Cos() {
        this.sin = new Sin();
    }

    public Cos(Sin sin) {
        this.sin = sin;
    }

    private static final int DIGITS_AFTER_COMMA = 8;

    public double calculate(double x){
        double result = Math.abs(x) >= Math.PI/2? -1 * Math.sqrt(1- Math.pow(sin.calculate(x), 2)) : Math.sqrt(1- Math.pow(sin.calculate(x), 2));
        return formatOutput(result);
//        return result;
    }

    public double calculateExpected(double x){
        return formatOutput(Math.cos(x));
//        return Math.cos(x);
    }

    private static double formatOutput(double value){
        return (double) Math.round(value*Math.pow(10, DIGITS_AFTER_COMMA))/Math.pow(10, DIGITS_AFTER_COMMA);
    }
}

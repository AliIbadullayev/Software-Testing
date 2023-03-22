import com.sun.xml.internal.bind.v2.runtime.reflect.opt.Const;

public class Func1 {
    Sin sin;
    Cos cos;
    Csc csc;
    Sec sec;

    private static final int DIGITS_AFTER_COMMA = 8;

    public Func1(Sin sin, Cos cos, Csc csc, Sec sec) {
        this.sin = sin;
        this.cos = cos;
        this.csc = csc;
        this.sec = sec;
    }

    public double calculate(double x){
        if (x > 0) return Double.NaN;
        return (((((sec.calculate(x) * cos.calculate(x)) / sin.calculate(x)) + cos.calculate(x)) + sin.calculate(x)) * csc.calculate(x));
    }

    public double calculateExpected(double x){
        if (x > 0) return Double.NaN;
        return (((((sec.calculateExpected(x) * cos.calculateExpected(x)) / sin.calculateExpected(x)) + cos.calculateExpected(x)) + sin.calculateExpected(x)) * csc.calculateExpected(x));
    }

    private static double formatOutput(double value){
        return (double) Math.round(value*Math.pow(10, DIGITS_AFTER_COMMA))/Math.pow(10, DIGITS_AFTER_COMMA);
    }
}

package test.company.lab2;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;

public class Sin {
    private static final int DIGITS_AFTER_COMMA = 11;

    public double calculate(double x){
        BigDecimal res = BigDecimal.ZERO;
        for (int i = 0; i < 50; i++){
            res = res.add(BigDecimal.valueOf(Math.pow(-1, i)*Math.pow(x, 2*i+1)).divide(new BigDecimal(factorialUsingForLoop(2*i+1)), MathContext.DECIMAL128));
        }
        return formatOutput(res.doubleValue());
    }

    public double calculateExpected(double x){
        return formatOutput(Math.sin(x));
    }

    public static BigInteger factorialUsingForLoop(int n) {
        BigInteger factorial = BigInteger.ONE;

        for (int i = 1; i <= n; i++) {
            factorial = factorial.multiply(BigInteger.valueOf(i));
        }
        return factorial;
    }
    private static double formatOutput(double value){
        return (double) Math.round(value*Math.pow(10, DIGITS_AFTER_COMMA))/Math.pow(10, DIGITS_AFTER_COMMA);
    }
}

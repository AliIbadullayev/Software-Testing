package test.company.lab1.util;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;

public class Functions {
    private static final int DIGITS_AFTER_COMMA = 3;

    public static double funSecInPowerSeries(double x){
        BigDecimal res = BigDecimal.ZERO;
        if (Math.abs(x) == Math.PI/2) return Double.NaN;
        for (int i = 0; i < 60; i++){
            res = res.add(BigDecimal.valueOf(Math.pow(-1, i)*Math.pow(x, 2*i)).divide(new BigDecimal(factorialUsingForLoop(2*i)), MathContext.DECIMAL128));
        }
        return formatOutput(1/res.doubleValue());
    }

    public static BigInteger factorialUsingForLoop(int n) {
        BigInteger factorial = BigInteger.ONE;

        for (int i = 1; i <= n; i++) {
            factorial = factorial.multiply(BigInteger.valueOf(i));
        }
        return factorial;
    }

    public static double funSec(double x){
        if (Math.abs(x) == Math.PI/2) return Double.NaN;
        return formatOutput(1/Math.cos(x)) ;
    }

    private static double formatOutput(double value){
        return (double) Math.round(value*Math.pow(10, DIGITS_AFTER_COMMA))/Math.pow(10, DIGITS_AFTER_COMMA);
    }
}

package test.company.lab1.util;

public class Functions {
    public static double funSecInPowerSeries(double x){
        double res = 0D;
        if (Math.abs(x) == Math.PI/2) return Double.NaN;
        for (int i = 0; i < 16; i++){
            res += Math.pow(-1, i)/factorialUsingForLoop(2*i)*Math.pow(x, 2*i);
        }
        return (double) Math.round(1/res*1000)/1000;

    }
    public static long factorialUsingForLoop(int n) {
        long fact = 1;
        for (int i = 2; i <= n; i++) {
            fact = fact * i;
        }
        return fact;
    }

    public static double funSec(double x){
        if (Math.abs(x) == Math.PI/2) return Double.NaN;
        return  (double) Math.round(1/Math.cos(x)*1000)/1000 ;
    }
}

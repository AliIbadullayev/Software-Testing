package test.company.lab1.util;

public class Functions {
    public static double funSecInPowerSeries(double x){
        double res = 0D;
        if (Math.abs(x) >= Math.PI/2) return Double.NaN;
        for (int i = 0; i < 33; i++){
            res += Math.pow(-1, i)/factorialUsingForLoop(2*i)*Math.pow(x, 2*i);
        }
        return 1/res;

    }
    public static long factorialUsingForLoop(int n) {
        long fact = 1;
        for (int i = 2; i <= n; i++) {
            fact = fact * i;
        }
        return fact;
    }

    public static double funSec(double x){
        return 1/Math.cos(x);
    }
}

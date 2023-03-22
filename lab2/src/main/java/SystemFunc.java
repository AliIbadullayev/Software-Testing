public class SystemFunc {

    Func1 func1;
    Func2 func2;

    public SystemFunc(){
        this.func1 = new Func1();
        this.func2 = new Func2();
    }

    public SystemFunc(Func1 func1, Func2 func2) {
        this.func1 = func1;
        this.func2 = func2;
    }


    public double calculate(double x, double eps){
        if (x<=0) return func1.calculate(x);
            else return func2.secondExpressionCalc(x,eps);
    }


//    public static void main(String[] args) {
//        Ln ln = new Ln();
//        Sin sin = new Sin();
//        Cos cos = new Cos(sin);
//        Sec sec = new Sec(cos);
//        Csc csc = new Csc(sin);
//        SystemFunc systemFunc = new SystemFunc(sec, cos, sin, csc, new Log(ln), ln);
//        System.out.println(systemFunc.calculate(-100, 0.00000001));
//        System.out.println(systemFunc.calculate(-10, 0.00000001));
//        System.out.println(systemFunc.calculate(-9, 0.00000001));
//        System.out.println(systemFunc.calculate(-5, 0.00000001));
//        System.out.println(systemFunc.calculate(-4, 0.00000001));
//        System.out.println(systemFunc.calculate(-3, 0.00000001));
//        System.out.println(systemFunc.calculate(-2.718281828, 0.00000001));
//        System.out.println(systemFunc.calculate(-2, 0.00000001));
//        System.out.println(systemFunc.calculate(-1, 0.00000001));
//        System.out.println(systemFunc.calculate(-1.5707963,0.00000001));
//        System.out.println(systemFunc.calculate(-2.094395,0.00000001));
//        System.out.println(systemFunc.calculate(0,0.00000001));
//        System.out.println(systemFunc.calculate(0.25,0.00000001));
//        System.out.println(systemFunc.calculate(0.5,0.00000001));
//        System.out.println(systemFunc.calculate(1,0.00000001));
//        System.out.println(systemFunc.calculate(2,0.00000001));
//        System.out.println(systemFunc.calculate(2.718281828,0.00000001));
//        System.out.println(systemFunc.calculate(3,0.00000001));
//        System.out.println(systemFunc.calculate(4,0.00000001));
//        System.out.println(systemFunc.calculate(5,0.00000001));
//        System.out.println(systemFunc.calculate(9,0.00000001));
//        System.out.println(systemFunc.calculate(10,0.00000001));
//        System.out.println(systemFunc.calculate(25,0.00000001));
//        System.out.println(systemFunc.calculate(100,0.00000001));
//    }
}

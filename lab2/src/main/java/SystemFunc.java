public class SystemFunc {

    Sec sec;

    Cos cos;

    Sin sin;

    Csc csc;
    Log log;
    Ln ln;


    public SystemFunc(){
        this.sec = new Sec();
        this.cos = new Cos();
        this.sin = new Sin();
        this.csc = new Csc();
        this.log = new Log();
        this.ln = new Ln();
    }

    public SystemFunc(Sec sec, Cos cos, Sin sin, Csc csc, Log log, Ln ln) {
        this.sec = sec;
        this.cos = cos;
        this.sin = sin;
        this.csc = csc;
        this.log = log;
        this.ln = ln;
    }

    public double calculate(double x, double eps){
        if (x<=0) return new Func1(sin,cos,csc,sec).calculate(x);
            else return new Func2(log, ln).secondExpressionCalc(x,eps);
    }


    public static void main(String[] args) {
        Ln ln = new Ln();
        Sin sin = new Sin();
        Cos cos = new Cos(sin);
        Sec sec = new Sec(cos);
        Csc csc = new Csc(sin);
        SystemFunc systemFunc = new SystemFunc(sec, cos, sin, csc, new Log(ln), ln);
        System.out.println(systemFunc.calculate(-100, 0.00000001));
        System.out.println(systemFunc.calculate(-10, 0.00000001));
        System.out.println(systemFunc.calculate(-9, 0.00000001));
        System.out.println(systemFunc.calculate(-5, 0.00000001));
        System.out.println(systemFunc.calculate(-4, 0.00000001));
        System.out.println(systemFunc.calculate(-3, 0.00000001));
        System.out.println(systemFunc.calculate(-2.718281828, 0.00000001));
        System.out.println(systemFunc.calculate(-2, 0.00000001));
        System.out.println(systemFunc.calculate(-1, 0.00000001));
        System.out.println(systemFunc.calculate(-1.5707963,0.00000001));
        System.out.println(systemFunc.calculate(-2.094395,0.00000001));
        System.out.println(systemFunc.calculate(0,0.00000001));
        System.out.println(systemFunc.calculate(0.25,0.00000001));
        System.out.println(systemFunc.calculate(0.5,0.00000001));
        System.out.println(systemFunc.calculate(1,0.00000001));
        System.out.println(systemFunc.calculate(2,0.00000001));
        System.out.println(systemFunc.calculate(2.718281828,0.00000001));
        System.out.println(systemFunc.calculate(3,0.00000001));
        System.out.println(systemFunc.calculate(4,0.00000001));
        System.out.println(systemFunc.calculate(5,0.00000001));
        System.out.println(systemFunc.calculate(9,0.00000001));
        System.out.println(systemFunc.calculate(10,0.00000001));
        System.out.println(systemFunc.calculate(25,0.00000001));
        System.out.println(systemFunc.calculate(100,0.00000001));
    }
}

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class Func2Test {
    @ParameterizedTest
    @ValueSource(doubles = {
            -100,
            -10,
            -9,
            -5,
            -4,
            -3,
            -2.718281828,
            -2,
            -1,
            -1.5707963,
            -2.094395,
            0,
            0.25,
            0.5,
            1,
            2,
            2.718281828,
            3,
            4,
            5,
            9,
            10,
            25,
            100
    })
    void check(double x) {
        Func2 func2 = new Func2();
        System.out.println(x+", "+func2.secondExpressionCalc(x, 10e-8));
    }
}

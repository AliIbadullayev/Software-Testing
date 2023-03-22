import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class SecTest {
    @ParameterizedTest
    @ValueSource(doubles = {Math.PI/2, -Math.PI/2,  Math.PI, -Math.PI, 0})
    @DisplayName("Тест для проверки равности результата sec(x) и степенного ряда в точках разрыва и в координатах пересекающих ось X!")
    void checkSecFunc1(double x){
        Sec sec = new Sec(new Cos(new Sin()));
        System.out.println("х = " + x);
        System.out.print("sec(x) = " + sec.calculate(x) +"; " + "степенной ряд = "+sec.calculateExpected(x)+"\n\n");
        Assertions.assertEquals(sec.calculate(x) , sec.calculateExpected(x), "test not passed!");
    }

    @ParameterizedTest
    @ValueSource(doubles = {Math.PI/2 - 0.001 , Math.PI/2 + 0.001, 0.001, -0.001, Math.PI+0.001, -Math.PI + 0.001})
    @DisplayName("Тест для проверки равности результата sec(x) и степенного ряда в точках, где значение функции максимально/минимально!")
    void checkSecFunc2(double x){
        Sec sec = new Sec(new Cos(new Sin()));
        System.out.println("х = " + x);
        System.out.print("sec(x) = " + sec.calculate(x) +"; " + "степенной ряд = "+sec.calculateExpected(x)+"\n\n");
        Assertions.assertEquals(sec.calculate(x) , sec.calculateExpected(x), "test not passed!");
    }

    @ParameterizedTest
    @ValueSource(doubles = {Math.PI/4, Math.PI/6, Math.PI/3, 3*Math.PI/4, -Math.PI/3, -2*Math.PI/3})
    @DisplayName("Тест для проверки равности результата sec(x) и степенного ряда со значениями близкими к целочисленным кратным π")
    void checkSecFunc3(double x){
        Sec sec = new Sec(new Cos(new Sin()));
        System.out.println("х = " + x);
        System.out.print("sec(x) = " + sec.calculate(x) +"; " + "степенной ряд = "+sec.calculateExpected(x)+"\n\n");
        Assertions.assertTrue(Math.abs(sec.calculate(x)  - sec.calculateExpected(x)) < 0.001d, "test not passed!");
        System.out.println();
    }

//    @ParameterizedTest
//    @ValueSource(doubles = {Math.PI/2, -Math.PI/2,  Math.PI, -Math.PI, 0})
//    void someT(double x){
//        Assertions.assertTrue( x % Math.PI/2 == 0);
//    }

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
    @DisplayName("Тест для проверки равности результата sec(x) и степенного ряда со значениями близкими к целочисленным кратным π")
    void check(double x){
        Sec sec = new Sec();
        System.out.println(x+" , "+sec.calculate(x));
    }
}

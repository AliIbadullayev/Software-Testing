import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class CscTest {
    @ParameterizedTest
    @ValueSource(doubles = {Math.PI/2, -Math.PI/2,  Math.PI, -Math.PI, 0})
    @DisplayName("Тест для проверки равности результата sec(x) и степенного ряда в точках разрыва и в координатах пересекающих ось X!")
    void checkSecFunc1(double x){
        Csc csc = new Csc (new Sin());
        System.out.println("х = " + x);
        System.out.print("sec(x) = " + csc.calculate(x) +"; " + "степенной ряд = "+csc.calculateExpected(x)+"\n\n");
        Assertions.assertEquals(csc.calculate(x) , csc.calculateExpected(x), "test not passed!");
    }

    @ParameterizedTest
    @ValueSource(doubles = {Math.PI/2 - 0.001 , Math.PI/2 + 0.001, 0.001, -0.001, Math.PI+0.001, -Math.PI + 0.001})
    @DisplayName("Тест для проверки равности результата sec(x) и степенного ряда в точках, где значение функции максимально/минимально!")
    void checkSecFunc2(double x){
        Csc csc = new Csc (new Sin());
        System.out.println("х = " + x);
        System.out.print("sec(x) = " + csc.calculate(x) +"; " + "степенной ряд = "+csc.calculateExpected(x)+"\n\n");
        Assertions.assertEquals(csc.calculate(x) , csc.calculateExpected(x), "test not passed!");
    }

    @ParameterizedTest
    @ValueSource(doubles = {Math.PI/4, Math.PI/6, Math.PI/3, 3*Math.PI/4, -Math.PI/3, -2*Math.PI/3})
    @DisplayName("Тест для проверки равности результата sec(x) и степенного ряда со значениями близкими к целочисленным кратным π")
    void checkSecFunc3(double x){
        Csc csc = new Csc (new Sin());
        System.out.println("х = " + x);
        System.out.print("sec(x) = " + csc.calculate(x) +"; " + "степенной ряд = "+csc.calculateExpected(x)+"\n\n");
        Assertions.assertTrue(Math.abs(csc.calculate(x)  - csc.calculateExpected(x)) < 0.001d, "test not passed!");
        System.out.println();
    }
}

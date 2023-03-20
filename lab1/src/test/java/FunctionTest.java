import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import test.company.lab1.util.Functions;

public class FunctionTest {

    /*
    * 1) Значения, при которых функция sec(x) имеет разрыв или не определена (например, x=0, x=π/2, x=-π/2 и т.д.).
    * Эти значения могут быть важными для проверки корректности обработки исключительных ситуаций в коде.
      2) Значения, при которых функция sec(x) принимает очень большие или очень маленькие значения (например, x=π/2+0.001, x=π/2-0.001, x=0.001, x=-0.001 и т.д.).
      * Эти значения могут помочь обнаружить ошибки в вычислениях из-за потери точности при работе с большими или маленькими числами.
      3) Значения, при которых функция sec(x) принимает нормальные значения (например, x=π/6, x=π/3, x=π/4 и т.д.).
      * Эти значения могут быть важными для проверки соответствия реализации функции ее математическому определению и обнаружения ошибок в округлении или обработке аргументов функции.
    * */


    @ParameterizedTest
    @ValueSource(doubles = {Math.PI/2, -Math.PI/2,  Math.PI, -Math.PI, 0})
    @DisplayName("Тест для проверки равности результата sec(x) и степенного ряда в точках разрыва и в координатах пересекающих ось X!")
    void checkSecFunc1(double x){
        System.out.println("х = " + x);
        System.out.print("sec(x) = " + Functions.funSec(x)+"; " + "степенной ряд = "+Functions.funSecInPowerSeries(x)+"\n\n");
        Assertions.assertEquals(Functions.funSec(x), Functions.funSecInPowerSeries(x), "test not passed!");
    }

    @ParameterizedTest
    @ValueSource(doubles = {Math.PI/2 - 0.001 , Math.PI/2 + 0.001, 0.001, -0.001, Math.PI+0.001, -Math.PI + 0.001})
    @DisplayName("Тест для проверки равности результата sec(x) и степенного ряда в точках, где значение функции максимально/минимально!")
    void checkSecFunc2(double x){
        System.out.println("х = " + x);
        System.out.print("sec(x) = " + Functions.funSec(x)+"; " + "степенной ряд = "+Functions.funSecInPowerSeries(x)+"\n\n");
        Assertions.assertEquals(Functions.funSec(x), Functions.funSecInPowerSeries(x), "test not passed!");
    }

    @ParameterizedTest
    @ValueSource(doubles = {Math.PI/4, Math.PI/6, Math.PI/3, 3*Math.PI/4, -Math.PI/3, -2*Math.PI/3})
    @DisplayName("Тест для проверки равности результата sec(x) и степенного ряда со значениями близкими к целочисленным кратным π")
    void checkSecFunc3(double x){
        System.out.println("х = " + x);
        System.out.print("sec(x) = " + Functions.funSec(x)+"; " + "степенной ряд = "+Functions.funSecInPowerSeries(x)+"\n\n");
        Assertions.assertTrue(Math.abs(Functions.funSec(x) - Functions.funSecInPowerSeries(x)) < 0.001d, "test not passed!");
        System.out.println();
    }
}

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import test.company.lab1.util.Functions;

import java.util.ArrayList;
import java.util.List;

public class FunctionTest {

    static List<Integer> list;
    @BeforeAll
    static void start(){
        System.out.println("Test's started!");
        list = new ArrayList<Integer>();
        list.add(1);
    }

    @ParameterizedTest
    @ValueSource(doubles = {Math.PI/4, Math.PI/6, Math.PI/3})
    @DisplayName("Тест для проверки равности результата sec(x) и степенного ряда (-Pi/2;Pi/2)")
    void checkSecFunc1(double x){
        System.out.println("х = " + x);
        System.out.print("sec(x) = " + Functions.funSec(x)+"; " + "степенной ряд = "+Functions.funSecInPowerSeries(x)+"\n\n");
        Assertions.assertTrue(Math.abs(Functions.funSec(x) - Functions.funSecInPowerSeries(x)) < 0.001d, "test not passed!");
        System.out.println();
    }

    @ParameterizedTest
    @ValueSource(doubles = {Math.PI/2, -Math.PI/2,  Math.PI, -Math.PI})
    @DisplayName("Тест для проверки равности результата sec(x) и степенного ряда  в граничных точках Pi/2, -Pi/2 и Pi, -Pi!")
    void checkSecFunc2(double x){
        System.out.println("х = " + x);
        System.out.print("sec(x) = " + Functions.funSec(x)+"; " + "степенной ряд = "+Functions.funSecInPowerSeries(x)+"\n\n");
        Assertions.assertEquals(Functions.funSec(x), Functions.funSecInPowerSeries(x), "test not passed!");
    }

    @ParameterizedTest
    @ValueSource(doubles = {Math.PI - Math.PI/6, 2*Math.PI/3})
    @DisplayName("Тест для проверки равности результата sec(x) и степенного ряда  во второй четверти!")
    void checkSecFunc3(double x){
        System.out.println("х = " + x);
        System.out.print("sec(x) = " + Functions.funSec(x)+"; " + "степенной ряд = "+Functions.funSecInPowerSeries(x)+"\n\n");
        Assertions.assertEquals(Functions.funSec(x), Functions.funSecInPowerSeries(x), "test not passed!");
    }



}

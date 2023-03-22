import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;


public class LogUnitTest {

    Log log;
    Ln ln;

    @BeforeAll
    public void init(){

        this.log = new Log();
        this.ln = new Ln();
    }

    /*
     * Анализ эквивалентности:
     * Все логарифмы ведут себя схожим образом и имеют похожий график. Определены они на интервале (0;+Infinity) и равны 0 в точке 1. Следует проверить для каждого основания
     * 0, от 0 до 1, 1, а так же степени его основания. Например для основания 3: 3,9,27 и т.д.
     * */
    static final double EPSILON = 0.00001;



    @ParameterizedTest
    @ValueSource(doubles = {0, 0.25, 0.5, 1, 2, 2.718281828, 3, 4, 5, 9, 10, 25, 100})
    @DisplayName("Тесты для проверки натурального логарифма")
    void checkLn(double x) {
        System.out.println("х = " + x);
        double v = Math.log(x);
        System.out.print("Ln(x) = " + v + "; " + "степенной ряд = " + ln.ln(x, EPSILON) + "\n\n");
        if (v == Double.NEGATIVE_INFINITY || v == Double.POSITIVE_INFINITY)
            Assertions.assertEquals(Math.log(x), ln.ln(x, EPSILON), "test not passed!");
        else Assertions.assertTrue(Math.abs(v - ln.ln(x, EPSILON)) < 0.001d, "test not passed!");
        System.out.println();
    }

    @ParameterizedTest
    @ValueSource(doubles = {0, 0.25, 0.5, 1, 2, 2.718281828, 3, 4, 5, 9, 10, 25, 100})
    @DisplayName("Тесты для проверки логарифма по основанию 2")
    void checkLog2(double x) {
        final double base = 2;
        System.out.println("х = " + x);
        double v = Math.log(x) / Math.log(base);
        System.out.print("Log" + base + "(x) = " + v + "; " + "степенной ряд = " + log.log(x, base, EPSILON) + "\n\n");
        if (v == Double.NEGATIVE_INFINITY || v == Double.POSITIVE_INFINITY)
            Assertions.assertEquals(v, ln.ln(x, EPSILON), "test not passed!");
        else Assertions.assertTrue(Math.abs(v - log.log(x, base, EPSILON)) < 0.001d, "test not passed!");
        System.out.println();
    }

    @ParameterizedTest
    @ValueSource(doubles = {0, 0.25, 0.5, 1, 2, 2.718281828, 3, 4, 5, 9, 10, 25, 100})
    @DisplayName("Тесты для проверки логарифма по основанию 3")
    void checkLog3(double x) {
        final double base = 3;
        System.out.println("х = " + x);
        double v = Math.log(x) / Math.log(base);
        System.out.print("Log" + base + "(x) = " + v + "; " + "степенной ряд = " + log.log(x, base, EPSILON) + "\n\n");
        if (v == Double.NEGATIVE_INFINITY || v == Double.POSITIVE_INFINITY)
            Assertions.assertEquals(v, ln.ln(x, EPSILON), "test not passed!");
        else Assertions.assertTrue(Math.abs(v - log.log(x, base, EPSILON)) < 0.001d, "test not passed!");
        System.out.println();
    }

    @ParameterizedTest
    @ValueSource(doubles = {0, 0.25, 0.5, 1, 2, 2.718281828, 3, 4, 5, 9, 10, 25, 100})
    @DisplayName("Тесты для проверки логарифма по основанию 5")
    void checkLog5(double x) {
        final double base = 5;
        System.out.println("х = " + x);
        double v = Math.log(x) / Math.log(base);
        System.out.print("Log" + base + "(x) = " + v + "; " + "степенной ряд = " + log.log(x, base, EPSILON) + "\n\n");
        if (v == Double.NEGATIVE_INFINITY || v == Double.POSITIVE_INFINITY)
            Assertions.assertEquals(v, ln.ln(x, EPSILON), "test not passed!");
        else Assertions.assertTrue(Math.abs(v - log.log(x, base, EPSILON)) < 0.001d, "test not passed!");
        System.out.println();
    }

    @ParameterizedTest
    @ValueSource(doubles = {0, 0.25, 0.5, 1, 2, 2.718281828, 3, 4, 5, 9, 10, 25, 100})
    @DisplayName("Тесты для проверки логарифма по основанию 10")
    void checkLog10(double x) {
        final double base = 10;
        System.out.println("х = " + x);
        double v = Math.log(x) / Math.log(base);
        System.out.print("Log" + base + "(x) = " + v + "; " + "степенной ряд = " + log.log(x, base, EPSILON) + "\n\n");
        if (v == Double.NEGATIVE_INFINITY || v == Double.POSITIVE_INFINITY)
            Assertions.assertEquals(v, ln.ln(x, EPSILON), "test not passed!");
        else Assertions.assertTrue(Math.abs(v - log.log(x, base, EPSILON)) < 0.001d, "test not passed!");
        System.out.println();
    }

}

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import test.company.lab1.util.Functions;

public class Main {
    @BeforeAll
    static void start(){
        System.out.println("Test's started!");
    }

    @ParameterizedTest
    @ValueSource(doubles = {Math.PI/4, Math.PI/2})
    @DisplayName("Test for checking sec(x) function!")
    void checkSecFunc(double x){
//        System.out.println();
        Assertions.assertTrue(Math.abs(Functions.funSec(x) - Functions.funSecInPowerSeries(x)) < 0.001d, "test not passed!");

    }


}

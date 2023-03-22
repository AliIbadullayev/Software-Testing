import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.mockito.Mockito;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class IntTest {

    static final double EPSILON = 0.0000000001;
    static final double FUNC_EPS = 0.001;

    static Ln lnMock;
    static Sec secMock;
    static Cos cosMock;
    static Sin sinMock;
    static Csc cscMock;
    static Log logMock;

    static Func1 firstFuncMock;
    static Func2 secondFuncMock;

    static Reader secIn;
    static Reader cosIn;
    static Reader sinIn;
    static Reader cscIn;
    static Reader lnIn;
    static Reader log2In;
    static Reader log3In;
    static Reader log5In;
    static Reader log10In;
    static Reader firstFuncIn;
    static Reader secondFuncIn;

    @BeforeAll
    static void init() {
        sinMock = Mockito.mock(Sin.class);
        cosMock = Mockito.mock(Cos.class);
        secMock = Mockito.mock(Sec.class);
        cscMock = Mockito.mock(Csc.class);
        lnMock = Mockito.mock(Ln.class);
        logMock = Mockito.mock(Log.class);
        firstFuncMock = Mockito.mock(Func1.class);
        secondFuncMock = Mockito.mock(Func2.class);

        try {
            secIn = new FileReader("src/main/resources/csv/input/Sec.csv");
            cscIn = new FileReader("src/main/resources/csv/input/Csc.csv");
            cosIn = new FileReader("src/main/resources/csv/input/Cos.csv");
            sinIn = new FileReader("src/main/resources/csv/input/Sin.csv");
            lnIn = new FileReader("src/main/resources/csv/input/Ln.csv");
            log2In = new FileReader("src/main/resources/csv/input/Log2.csv");
            log3In = new FileReader("src/main/resources/csv/input/Log3.csv");
            log5In = new FileReader("src/main/resources/csv/input/Log5.csv");
            log10In = new FileReader("src/main/resources/csv/input/Log10.csv");
            firstFuncIn = new FileReader("src/main/resources/csv/input/SecondFunc.csv");
            secondFuncIn = new FileReader("src/main/resources/csv/input/FirstFunc.csv");

            Iterable<CSVRecord> records = CSVFormat.DEFAULT.parse(lnIn);
            for (CSVRecord record : records) {
                Mockito.when(lnMock.ln(Double.parseDouble(record.get(0)), EPSILON)).thenReturn(Double.valueOf(record.get(1)));
            }
            records = CSVFormat.DEFAULT.parse(log2In);
            for (CSVRecord record : records) {
                Mockito.when(logMock.log(Double.parseDouble(record.get(0)), 2, EPSILON)).thenReturn(Double.valueOf(record.get(1)));
            }

            records = CSVFormat.DEFAULT.parse(log3In);
            for (CSVRecord record : records) {
                Mockito.when(logMock.log(Double.parseDouble(record.get(0)), 3, EPSILON)).thenReturn(Double.valueOf(record.get(1)));
            }

            records = CSVFormat.DEFAULT.parse(log5In);
            for (CSVRecord record : records) {
                Mockito.when(logMock.log(Double.parseDouble(record.get(0)), 5, EPSILON)).thenReturn(Double.valueOf(record.get(1)));
            }

            records = CSVFormat.DEFAULT.parse(log10In);
            for (CSVRecord record : records) {
                Mockito.when(logMock.log(Double.parseDouble(record.get(0)), 10, EPSILON)).thenReturn(Double.valueOf(record.get(1)));
            }

            records = CSVFormat.DEFAULT.parse(sinIn);
            for (CSVRecord record : records) {
                Mockito.when(sinMock.calculate(Double.parseDouble(record.get(0)))).thenReturn(Double.valueOf(record.get(1)));
            }

            records = CSVFormat.DEFAULT.parse(cosIn);
            for (CSVRecord record : records) {
                Mockito.when(cosMock.calculate(Double.parseDouble(record.get(0)))).thenReturn(Double.valueOf(record.get(1)));
            }

            records = CSVFormat.DEFAULT.parse(secIn);
            for (CSVRecord record : records) {
                Mockito.when(secMock.calculate(Double.parseDouble(record.get(0)))).thenReturn(Double.valueOf(record.get(1)));
            }

            records = CSVFormat.DEFAULT.parse(cscIn);
            for (CSVRecord record : records) {
                Mockito.when(cscMock.calculate(Double.parseDouble(record.get(0)))).thenReturn(Double.valueOf(record.get(1)));
            }

            records = CSVFormat.DEFAULT.parse(firstFuncIn);
            for (CSVRecord record : records) {
                Mockito.when(firstFuncMock.calculate(Double.parseDouble(record.get(0)))).thenReturn(Double.valueOf(record.get(1)));
            }

            records = CSVFormat.DEFAULT.parse(secondFuncIn);
            for (CSVRecord record : records) {
                Mockito.when(secondFuncMock.secondExpressionCalc(Double.parseDouble(record.get(0)), EPSILON)).thenReturn(Double.valueOf(record.get(1)));
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }


    @ParameterizedTest
    @CsvFileSource(resources = "/csv/input/System.csv")
    void testSystemWithAllMocks(double value, double expected) {
        SystemFunc systemFunc = new SystemFunc(new Func1(sinMock, cosMock, cscMock, secMock), new Func2(logMock, lnMock));
        Assertions.assertEquals(expected, systemFunc.calculate(value, EPSILON), FUNC_EPS);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/csv/input/System.csv")
    void testWithSecCsc(double value, double expected) {
        SystemFunc systemFunc = new SystemFunc(new Func1(sinMock, cosMock, new Csc(sinMock), new Sec(cosMock)), new Func2(logMock, lnMock));
        Assertions.assertEquals(expected, systemFunc.calculate(value, EPSILON), FUNC_EPS);

    }

    @ParameterizedTest
    @CsvFileSource(resources = "/csv/input/System.csv")
    void testWithCos(double value, double expected) {
        SystemFunc systemFunc = new SystemFunc(new Func1(sinMock, new Cos(sinMock), new Csc(sinMock), new Sec(new Cos(sinMock))), new Func2(logMock, lnMock));
        Assertions.assertEquals(expected, systemFunc.calculate(value, EPSILON), FUNC_EPS);

    }

    @ParameterizedTest
    @CsvFileSource(resources = "/csv/input/System.csv")
    void testWithSin(double value, double expected) {
        SystemFunc systemFunc = new SystemFunc(new Func1(new Sin(), new Cos(new Sin()), new Csc(new Sin()), new Sec(new Cos(new Sin()))), new Func2(logMock, lnMock));
        Assertions.assertEquals(expected, systemFunc.calculate(value, EPSILON), FUNC_EPS);

    }

    @ParameterizedTest
    @CsvFileSource(resources = "/csv/input/System.csv")
    void testWithLog(double value, double expected) {
        SystemFunc systemFunc = new SystemFunc(new Func1(sinMock, cosMock, cscMock, secMock), new Func2(new Log(lnMock), lnMock));
        Assertions.assertEquals(expected, systemFunc.calculate(value, EPSILON), FUNC_EPS);

    }

    @ParameterizedTest
    @CsvFileSource(resources = "/csv/input/System.csv")
    void testWithLn(double value, double expected) {
        SystemFunc systemFunc = new SystemFunc(new Func1(sinMock, cosMock, cscMock, secMock), new Func2(new Log(new Ln()), new Ln()));
        Assertions.assertEquals(expected, systemFunc.calculate(value, EPSILON), FUNC_EPS);

    }

//    @ParameterizedTest
//    @CsvFileSource(resources = "/csv/input/System.csv")
//    void testWithFunc1(double value, double expected) {
//        SystemFunc systemFunc = new SystemFunc(new Func1(sinMock, new Cos(sinMock), new Csc(sinMock), new Sec(new Cos(sinMock))), new Func2(logMock, lnMock));
//        Assertions.assertEquals(expected, systemFunc.calculate(value, EPSILON), FUNC_EPS);
//
//    }
//
//    @ParameterizedTest
//    @CsvFileSource(resources = "/csv/input/System.csv")
//    void testWithFunc2(double value, double expected) {
//        SystemFunc systemFunc = new SystemFunc(firstFuncMock, new Func2());
//        Assertions.assertEquals(expected, systemFunc.calculate(value, EPSILON), FUNC_EPS);
//
//    }

    @ParameterizedTest
    @CsvFileSource(resources = "/csv/input/System.csv")
    void testWithAll(double value, double expected) {
        SystemFunc systemFunc = new SystemFunc();
        Assertions.assertEquals(expected, systemFunc.calculate(value, EPSILON), FUNC_EPS);

    }
}




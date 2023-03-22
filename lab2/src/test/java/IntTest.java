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

    static final double EPSILON = 0.00001;

    static Ln lnMock;
    static Sec secMock;
    static Cos cosMock;
    static Sin sinMock;
    static Csc cscMock;
    static Log logMock;

    static Reader secIn;
    static Reader cosIn;
    static Reader sinIn;
    static Reader cscIn;
    static Reader lnIn;
    static Reader log2In;
    static Reader log3In;
    static Reader log5In;
    static Reader log10In;

    @BeforeAll
    static void init() {
        sinMock = Mockito.mock(Sin.class);
        cosMock = Mockito.mock(Cos.class);
        secMock = Mockito.mock(Sec.class);
        cscMock = Mockito.mock(Csc.class);
        lnMock = Mockito.mock(Ln.class);
        logMock = Mockito.mock(Log.class);

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


            Iterable<CSVRecord> records = CSVFormat.DEFAULT.parse(lnIn);
            for (CSVRecord record : records) {
                Mockito.when(lnMock.ln(Double.parseDouble(record.get(0)), EPSILON)).thenReturn(Double.valueOf(record.get(1)));
            }
            records = CSVFormat.DEFAULT.parse(log2In);
            for (CSVRecord record : records) {
                Mockito.when(logMock.log(2, Double.parseDouble(record.get(0)), EPSILON)).thenReturn(Double.valueOf(record.get(1)));
            }

            records = CSVFormat.DEFAULT.parse(log3In);
            for (CSVRecord record : records) {
                Mockito.when(logMock.log(3, Double.parseDouble(record.get(0)), EPSILON)).thenReturn(Double.valueOf(record.get(1)));
            }

            records = CSVFormat.DEFAULT.parse(log5In);
            for (CSVRecord record : records) {
                Mockito.when(logMock.log(5, Double.parseDouble(record.get(0)), EPSILON)).thenReturn(Double.valueOf(record.get(1)));
            }

            records = CSVFormat.DEFAULT.parse(log10In);
            for (CSVRecord record : records) {
                Mockito.when(logMock.log(10, Double.parseDouble(record.get(0)), EPSILON)).thenReturn(Double.valueOf(record.get(1)));
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


        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }


        @ParameterizedTest
        @CsvFileSource(resources = "/csv/input/System.csv")
        void testSystemWithAllMocks ( double value, double expected){
            SystemFunc systemFunc = new SystemFunc(secMock, cosMock, sinMock, cscMock, logMock, lnMock);
            Assertions.assertEquals(expected, systemFunc.calculate(value, EPSILON), EPSILON);
        }

        @ParameterizedTest
        @CsvFileSource(resources = "/csv/input/System.csv")
        void testWithSecCsc ( double value, double expected){
            SystemFunc systemFunc = new SystemFunc(new Sec(cosMock), cosMock, sinMock, new Csc(sinMock), logMock, lnMock);
            Assertions.assertEquals(expected, systemFunc.calculate(value, EPSILON), EPSILON);

        }

        @ParameterizedTest
        @CsvFileSource(resources = "/csv/input/System.csv")
        void testWithCos ( double value, double expected){
            SystemFunc systemFunc = new SystemFunc(new Sec(new Cos(sinMock)), new Cos(sinMock), sinMock, new Csc(sinMock), logMock, lnMock);
            Assertions.assertEquals(expected, systemFunc.calculate(value, EPSILON), EPSILON);

        }

        @ParameterizedTest
        @CsvFileSource(resources = "/csv/input/System.csv")
        void testWithSin ( double value, double expected){
            SystemFunc systemFunc = new SystemFunc(new Sec(new Cos(new Sin())), new Cos(new Sin()), new Sin(), new Csc(new Sin()), logMock, lnMock);
            Assertions.assertEquals(expected, systemFunc.calculate(value, EPSILON), EPSILON);

        }

        @ParameterizedTest
        @CsvFileSource(resources = "/csv/input/System.csv")
        void testWithLog ( double value, double expected){
            SystemFunc systemFunc = new SystemFunc(secMock, cosMock, sinMock, cscMock, new Log(lnMock), lnMock);
            Assertions.assertEquals(expected, systemFunc.calculate(value, EPSILON), EPSILON);

        }

        @ParameterizedTest
        @CsvFileSource(resources = "/csv/input/System.csv")
        void testWithLn ( double value, double expected){
            SystemFunc systemFunc = new SystemFunc(secMock, cosMock, sinMock, cscMock, new Log(new Ln()), new Ln());
            Assertions.assertEquals(expected, systemFunc.calculate(value, EPSILON), EPSILON*20);

        }

        @ParameterizedTest
        @CsvFileSource(resources = "/csv/input/System.csv")
        void testWithAll ( double value, double expected){
            SystemFunc systemFunc = new SystemFunc();
            Assertions.assertEquals(expected, systemFunc.calculate(value, EPSILON), EPSILON*20);

        }
    }




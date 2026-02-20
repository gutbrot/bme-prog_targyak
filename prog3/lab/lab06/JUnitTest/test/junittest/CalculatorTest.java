package junittest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test; // moodositott
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {
    Calculator calc;

    @BeforeEach
    public void setUp() {
        calc = new Calculator();
    }
    @ParameterizedTest
    @MethodSource("parameters")
    public void testMultiply(double[] d) {
        double a = d[0], b = d[1];
        double result = calc.multiply(a, b);
        assertEquals(a * b, result, 0);
    }
    @ParameterizedTest @MethodSource("parameters")
    public void testDivide(double[] d) throws Exception {
        double a = d[0], b = d[1];
        double result = calc.divide(a, b);
        assertEquals(a / b, result, 0);
    }
    @ParameterizedTest @MethodSource("parameters")
    public void testDivideByZero(double[] d) throws Exception {
        double a = d[0], b = d[1];
        assertThrows(IllegalArgumentException.class,
                ()-> {
                    calc.divide(a, 0.0);
                });
    }
    public static Stream<double[]> parameters() {
        List<double[]> params = new ArrayList<double []>();
        params.add(new double[] {0.0, 0.0});
        params.add(new double [] {10.0, 0.0});
        params.add(new double [] {10.0, 3.0});
        params.add(new double [] {20.0, 4.0});
        params.add(new double [] {40.0, 5.0});
        return params.stream();
    }
}

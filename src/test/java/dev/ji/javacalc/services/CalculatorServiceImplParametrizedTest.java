package dev.ji.javacalc.services;

import dev.ji.javacalc.exceptions.DividingByZeroException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static dev.ji.javacalc.services.CalculatorServiceImplConstants.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorServiceImplParametrizedTest {

    private CalculatorServiceImpl out = new CalculatorServiceImpl();

    private static Stream<Arguments> provideArgsForParamTest() {
        return Stream.of(
                Arguments.of(ONE, TWO),
                Arguments.of(ZERO, TWO),
                Arguments.of(MINUS_ONE, THREE),
                Arguments.of(ONE, MINUS_ONE),
                Arguments.of(ZERO, MINUS_ONE),
                Arguments.of(MINUS_ONE, ZERO)
        );
    }

    @MethodSource("provideArgsForParamTest")
    @ParameterizedTest
    public void shouldReturnCorrectPlus(int num1, int num2) {
        assertEquals(num1 + num2, out.plus(num1, num2));
    }

    @MethodSource("provideArgsForParamTest")
    @ParameterizedTest
    public void shouldReturnCorrectMinus(int num1, int num2) {
        assertEquals(num1 - num2, out.minus(num1, num2));
    }

    @MethodSource("provideArgsForParamTest")
    @ParameterizedTest
    public void shouldReturnCorrectDivide(int num1, int num2) {
        if (num2 == ZERO) {
            Assertions.assertThrowsExactly(DividingByZeroException.class,()->out.divide(num1, num2));
        } else {
            assertEquals((double) num1  / num2, out.divide(num1, num2));
        }
    }

    @MethodSource("provideArgsForParamTest")
    @ParameterizedTest
    public void shouldReturnCorrectMultiply(int num1, int num2) {
        assertEquals(num1 * num2, out.multiply(num1, num2));
    }

}

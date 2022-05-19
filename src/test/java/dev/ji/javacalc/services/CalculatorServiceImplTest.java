package dev.ji.javacalc.services;

import dev.ji.javacalc.exceptions.DividingByZeroException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.web.client.HttpClientErrorException;

import static dev.ji.javacalc.services.CalculatorServiceImplConstants.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorServiceImplTest {
    private CalculatorServiceImpl out = new CalculatorServiceImpl();

    @Test
    public void shouldReturn3WhenSum2And1() {
        assertEquals(THREE,out.plus(TWO,ONE));
    }

    @Test
    public void shouldReturnZeroWhenSumMinus3And3() {
        assertEquals(ZERO,out.plus(MINUS_THREE,THREE));
    }

    @Test
    public void shouldReturnMinusThreeWhenMinus1And2() {
        assertEquals(MINUS_THREE,out.minus(MINUS_ONE,TWO));
    }

    @Test
    public void shouldReturn1When3Minus2() {
        assertEquals(ONE,out.minus(THREE,TWO));
    }

    @Test
    public void shouldReturnMinus2WhenMultiply1AndMinus2() {
        assertEquals(MINUS_TWO,out.multiply(ONE,MINUS_TWO));
    }

    @Test
    public void shouldReturn0WhenMultiply3And0() {
        assertEquals(ZERO,out.multiply(THREE,ZERO));
    }

    @Test
    public void shouldReturnMinus3WhenDivide3AndMinus1() {
        assertEquals(MINUS_THREE,out.divide(THREE,MINUS_ONE));
    }

    @Test
    public void shouldReturnOneHalfWhenDivide1And2() {
        assertEquals(ONE_HALF, out.divide(ONE,TWO));
    }

    @Test
    public void shouldReturnExceptionWhenDivideByZero() {
        Assertions.assertThrowsExactly(DividingByZeroException.class,()->out.divide(THREE,ZERO));
    }


}

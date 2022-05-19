package dev.ji.javacalc.services;

import dev.ji.javacalc.exceptions.DividingByZeroException;
import org.springframework.stereotype.Service;

@Service
public class CalculatorServiceImpl implements CalculatorService {

    @Override
    public int plus(int num1, int num2) {
        return num1 + num2;
    }

    @Override
    public int minus(int num1, int num2) {
        return num1 - num2;
    }

    @Override
    public double divide(int num1, int num2) {
        if (num2 == 0) {
            throw new DividingByZeroException("Can't devide by ZERO");
        }
        return (double) num1 / num2;
    }

    @Override
    public int multiply(int num1, int num2) {
        return num1 * num2;

    }


}

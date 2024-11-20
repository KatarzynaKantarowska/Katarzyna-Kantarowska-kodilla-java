package com.kodilla.spring.calculator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CalculatorTestSuite {

    @Autowired
    private Calculator calculator;

    @Test
    void testAdd() {
        //Given
        double a = 5.0;
        double b = 4.0;

        //When
        double result = calculator.add(a, b);

        //Then
        Assertions.assertEquals(9.0, result, 0.01);
    }
    @Test
    void testSubtract() {
        //Given
        double a = 5.0;
        double b = 4.0;

        //When
        double result = calculator.subtract(a, b);

        //Then
        Assertions.assertEquals(1.0, result, 0.01);
    }

    @Test
    void testMultiply() {
        //Given
        double a = 5.0;
        double b = 2.0;

        //When
        double result = calculator.multiply(a, b);

        //Then
        Assertions.assertEquals(10.0, result, 0.01);
    }
    @Test
    void testDivide() {
        //Given
        double a = 6.0;
        double b = 3.0;

        //When
        double result = calculator.divide(a, b);

        //Then
        Assertions.assertEquals(2.0, result, 0.01);
    }

}

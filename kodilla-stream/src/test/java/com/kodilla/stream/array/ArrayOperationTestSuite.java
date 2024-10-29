package com.kodilla.stream.array;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ArrayOperationTestSuite {
    @Test
    void testGetAverage(){
        //Given
        int[] numbers = {2, 4, 6, 8, 10, 2, 4, 6, 8, 10, 2, 4, 6, 8, 10, 2, 4, 6, 8, 10, 2, 4, 6, 8, 10};

        //When
        double result = ArrayOperation.getAverage(numbers);

        //Then
        double expected = 6.0;
        Assertions.assertEquals(expected, result, 0.01);
    }
}

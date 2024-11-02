package com.kodilla.exception.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ExceptionHandlingTestSuite {
    @Test
    void exceptionHandling() {
        //Given
        ExceptionHandling exceptionHandling = new ExceptionHandling();

        //When
        String result1 = exceptionHandling.handleException(2.0,0.0);
        String result2 = exceptionHandling.handleException(1.5,1.5);
        String result3 = exceptionHandling.handleException(0.5, 1.5);

        //Then
        Assertions.assertEquals("Got this exception!",result1);
        Assertions.assertEquals("Got this exception!",result2);
        Assertions.assertEquals("Got this exception!",result3);
    }

    @Test
    void exceptionHandling2() {
        //Given
        ExceptionHandling exceptionHandling = new ExceptionHandling();

        //When
        String result = exceptionHandling.handleException(1.5,1.0);

        //Then
        Assertions.assertEquals("Done!",result);

    }

}

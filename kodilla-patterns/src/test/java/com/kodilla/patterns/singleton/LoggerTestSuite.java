package com.kodilla.patterns.singleton;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LoggerTestSuite {

    @Test
    void testLog() {
        //Given
        Logger logger = Logger.getInstance();

        //When
        logger.log("First log");

        //Then
        Assertions.assertEquals("First log",logger.getLastLog());
    }
    @Test
    void testGetLastLog() {
        //Given
        Logger logger = Logger.getInstance();
        logger.log("First log");

        //When
        logger.log("Second log");

        //Then
        Assertions.assertEquals("Second log",logger.getLastLog());
    }
}

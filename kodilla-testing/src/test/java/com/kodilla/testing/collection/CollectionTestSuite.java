package com.kodilla.testing.collection;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CollectionTestSuite {
    @BeforeEach
    public void before(){
        System.out.println("Test Case: begin");
    }
    @AfterEach
    public void after(){
        System.out.println("Test Case: end");
    }
    @DisplayName("when list is empty, " +
            "then list contain numbers even and odd" )


    @Test
    public void testNumbersExterminatorEmptyList() {
        // Given
        OddNumbersExterminator exterminator = new OddNumbersExterminator();
        List<Integer> emptyList = new ArrayList<>();

        // When
        List<Integer> result = exterminator.exterminate(emptyList);

        // Then
        assertEquals(0, result.size(),"List has to be empty");
    }
    @Test
    public void testOddNumbersExterminatorNormalList() {
        // Given
        OddNumbersExterminator exterminator = new OddNumbersExterminator();
        List<Integer> normal = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        // When
        List<Integer> result = exterminator.exterminate(normal);

        // Then
        List<Integer> expected = Arrays.asList(2, 4, 6, 8, 10);
        assertEquals(expected,result,"Return only even numbers");
    }
}
package com.kodilla.patterns.factory.tasks;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TaskFactoryTestSuite {
    @Test
    void testShoppingTask() {
        // Given
        TaskFactory factory = new TaskFactory();

        // When
        Task task = factory.createTask(TaskFactory.SHOPPING);
        task.executeTask();

        // Then
        assertEquals("Buy in store", task.getTaskName());
        assertTrue(task.isTaskExecuted());
    }

    @Test
    void testPaintingTask() {
        // Given
        TaskFactory factory = new TaskFactory();

        // When
        Task task = factory.createTask(TaskFactory.PAINTING);
        task.executeTask();

        // Then
        assertEquals("Paint room", task.getTaskName());
        assertTrue(task.isTaskExecuted());
    }

    @Test
    void testDrivingTask() {
        // Given
        TaskFactory factory = new TaskFactory();

        // When
        Task task = factory.createTask(TaskFactory.DRIVING);
        task.executeTask();

        // Then
        assertEquals("Drive to Kindergarten", task.getTaskName());
        assertTrue(task.isTaskExecuted());
    }
}
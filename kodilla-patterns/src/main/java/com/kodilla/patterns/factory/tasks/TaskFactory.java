package com.kodilla.patterns.factory.tasks;

public class TaskFactory {
    public static final String SHOPPING = "SHOPPING";
    public static final String PAINTING = "PAINTING";
    public static final String DRIVING = "DRIVING";
    public Task createTask(String taskType) {
        switch (taskType) {
            case SHOPPING:
                return new ShoppingTask("Buy in store", "Milk", 2);
            case PAINTING:
                return new PaintingTask("Paint room", "White", "Living Room");
            case DRIVING:
                return new DrivingTask("Drive to Kindergarten", "Kindergarten", "Car");
            default:
                throw new IllegalArgumentException("Unknown task type: " + taskType);
        }
    }
}

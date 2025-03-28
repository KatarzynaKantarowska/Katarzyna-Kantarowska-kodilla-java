package com.kodilla.patterns.factory.tasks;

public class ShoppingTask implements Task {
    private final String taskName;
    private final String whatToBuy;
    private final double quantity;
    private boolean isExecuted;

    public ShoppingTask(String taskName, String whatToBuy, double quantity) {
    this.taskName = taskName;
    this.whatToBuy = whatToBuy;
    this.quantity = quantity;
    this.isExecuted = false;
    }

    @Override
    public void executeTask() {
        System.out.println("Executing " + taskName + " with quantity " + quantity);
        isExecuted = true;
    }

    @Override
    public String getTaskName() {
        return taskName;
    }

    @Override
    public boolean isTaskExecuted() {
        return isExecuted;
    }
}

package com.kodilla.stream.lambda;

public class ExecuteSaySomething implements Executor{
    @Override
    public void process() {
        System.out.println("This is a new overrided text.");
    }
}

package com.kodilla.kodillatesting.calculator;

public class Calculator {
    private int a;
    private int b;

    public static int dodaj (int a, int b) {
    return a + b;
    }
    public static int odejmowanie (int a, int b) {
        return a - b;
    }

    public Calculator(int a, int b) {
        this.a = a;
        this.b = b;
    }
}

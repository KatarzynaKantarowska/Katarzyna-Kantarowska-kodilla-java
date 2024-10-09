package com.kodilla.testing.calculator;

public class Calculator {
    private int a;
    private int b;

    public static int dodaj (int a, int b) {
    return a + b;
    }
    public static double odejmowanie (int a, int b) {
        return a - b;
    }

    public int getB() {
        return b;
    }

    public int getA() {
        return a;
    }

    public Calculator(int a, int b) {
        this.a = a;
        this.b = b;
        dodaj(a, b);
        odejmowanie(a, b);
    }
}

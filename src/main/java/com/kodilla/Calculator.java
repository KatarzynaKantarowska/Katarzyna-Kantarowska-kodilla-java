package com.kodilla;

public class Calculator {
    private int a = 20;
    private int b = 10;
    private int resumeSub;
    private int resumeAdd;



    public void adding() {
    this.resumeAdd = a + b;
    }
    public void subtracting() {
    this.resumeSub = a - b;
    }

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        calculator.adding();
        calculator.subtracting();
        System.out.println("Wynik odejmowanie liczb to: " + calculator.resumeSub);
        System.out.println("Wynik dodawania liczb to: " + calculator.resumeAdd);
    }
}

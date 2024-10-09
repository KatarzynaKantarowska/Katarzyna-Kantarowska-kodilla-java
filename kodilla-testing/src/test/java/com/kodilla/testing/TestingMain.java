package com.kodilla.testing;

import com.kodilla.testing.calculator.Calculator;


public class TestingMain {
    public static void main(String[] args) {
        System.out.println("Moduł 6. Wprowadzenie do testowania oprogramowania");
        SimpleUser simpleUser = new SimpleUser("TheForumUser");

        String result = simpleUser.getUsername();
        if (result.equals("TheForumUser")) {
            System.out.println("Test OK");
        } else {
            System.out.println("Test ERROR");
        }
        System.out.println("Test - pierwszy test jednostkowy: ");

        Calculator calculator = new Calculator(10, 5);
        int wynikDodawania = calculator.getA() + calculator.getB();
        int wynikOdejmowania = calculator.getA() - calculator.getB();

        if (wynikDodawania == 15 && wynikOdejmowania == 5) {
            System.out.println("Calculator test OK");
        } else {
            System.out.println("Calculator test ERROR");
        }
    }

}

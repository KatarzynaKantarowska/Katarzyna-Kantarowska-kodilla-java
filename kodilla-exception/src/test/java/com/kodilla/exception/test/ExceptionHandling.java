package com.kodilla.exception.test;

public class ExceptionHandling {

    public String handleException(double x, double y) {

    SecondChallenge secondChallenge = new SecondChallenge();
    try {
        return secondChallenge.probablyIWillThrowException(x, y);
    }catch (Exception e) {
        System.out.println(" Exception:  " + e);
        return "Got this exception!";
    } finally {
        System.out.println("It was executed");
        }
    }
}

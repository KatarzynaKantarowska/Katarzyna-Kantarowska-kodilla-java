package com.kodilla.exception.test;

public class FirstChallenge {

    public double divide(double a, double b) throws ArithmeticException {
        if (b == 0) {
            throw new ArithmeticException();
        }
        return a / b;
    }

    /**
     * This main can throw an ArithmeticException!!!
     * @param args
     */
    public static void main(String[] args) {
        FirstChallenge firstChallenge = new FirstChallenge();

        try {
            double result = firstChallenge.divide(3, 0);
            System.out.println(result);
        } catch (ArithmeticException e) {
            System.out.println("You can't divide by 0 ! ");
        } finally {
            System.out.println("Finally block");
        }

        Flight flight = new Flight("Katowice", "Wrocław");
        FlightFinder flightFinder = new FlightFinder();

        try {
            boolean isAvailable = flightFinder.findFlight(flight);
                if (isAvailable) {
                    System.out.println("Flight to " + flight.getArrivalAirport() + " is available.");
                } else {
                    System.out.println("Flight to " + flight.getArrivalAirport() + " is not available.");
                }
        } catch (RouteNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }
        System.out.println("The program is running");
    }
}

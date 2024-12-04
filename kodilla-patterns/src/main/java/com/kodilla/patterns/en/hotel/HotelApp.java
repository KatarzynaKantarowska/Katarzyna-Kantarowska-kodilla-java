package com.kodilla.patterns.en.hotel;

public class HotelApp {
    public static void main(String[] args) {
        System.out.println("Accomodation prices:");
        System.out.println("1. Single Bed rooms");
        System.out.println("   - low season: " + Season.LOW.getSingleBedPrice());
        System.out.println("   - high season: " + Season.HIGH.getSingleBedPrice());
        System.out.println("   - holiday season: " + Season.HOLIDAY.getSingleBedPrice());
        System.out.println("2. Double Bed rooms");
        System.out.println("   - low season: " + Season.LOW.getDoubleBedPrice());
        System.out.println("   - high season: " + Season.HIGH.getDoubleBedPrice());
        System.out.println("   - holiday season: " + Season.HOLIDAY.getDoubleBedPrice());

        Season season = Season.HOLIDAY;

        System.out.println(season);

    }
}

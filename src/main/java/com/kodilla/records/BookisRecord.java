package com.kodilla.records;

public record BookisRecord(String author, String title, int year) {
    public static void main(String[] args) {
        BookisRecord bookis = new BookisRecord("John Novak", "Algorithms and other nightmares", 2018);
        int year = bookis.year();
        System.out.println(bookis);
        System.out.println(year);
    }
}

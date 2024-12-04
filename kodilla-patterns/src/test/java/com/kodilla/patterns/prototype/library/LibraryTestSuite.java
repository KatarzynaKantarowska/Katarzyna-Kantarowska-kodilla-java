package com.kodilla.patterns.prototype.library;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.SQLOutput;
import java.time.LocalDate;

public class LibraryTestSuite {

    @Test
    void testGetBooks() throws CloneNotSupportedException {
        //Given
        Library library = new Library("Library");
        library.addBook(new Book("Harry Potter i Kamień Filozoficzny","J.K. Rowling", LocalDate.of(2000,5,5)));
        library.addBook(new Book("Harry Potter i Komnata Tajemnic","J.K. Rowling", LocalDate.of(2003,5,5)));
        library.addBook(new Book("Harry Potter i Więzień Azkabanu","J.K. Rowling", LocalDate.of(2006,5,5)));

        //When
        Library shallowClonedLibrary = library.clone();
        Library deepClonedLibrary = library.deepCopy();
        shallowClonedLibrary.getBooks().add(new Book("Harry Potter i Zakon Feniksa","J.K. Rowling", LocalDate.of(2003,5,5)));

        //Then
        System.out.println("Library: " + library);
        System.out.println("Shallow Cloned: " + shallowClonedLibrary);
        System.out.println("Deep Cloned: " + deepClonedLibrary);

        Assertions.assertEquals(3, deepClonedLibrary.getBooks().size());
        Assertions.assertEquals(4, library.getBooks().size());
        Assertions.assertEquals(4, shallowClonedLibrary.getBooks().size());
        Assertions.assertNotSame(deepClonedLibrary.getBooks(), library.getBooks());
    }
}

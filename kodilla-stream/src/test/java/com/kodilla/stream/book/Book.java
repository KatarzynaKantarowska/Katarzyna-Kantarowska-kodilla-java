package com.kodilla.stream.book;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.stream.IntStream;
import static org.junit.jupiter.api.Assertions.*;


class BookTestSuite {
    @Test
    void testGetListUsingFor(){
        //Given
        BookDirectory bookDirectory = new BookDirectory();

        //When
        List<Book> books = bookDirectory.getList();

        //Then
        int numberOfBooksPublicatedAfter2207 = 0;
              for(Book book : books){
                  if (book.getYearOfPublication() > 2007){
                      numberOfBooksPublicatedAfter2207++;
                  }
              }
        Assertions.assertEquals(3, numberOfBooksPublicatedAfter2207);
    }

    @Test
    void testGetListUsingIntStream(){
        //Given
        BookDirectory bookDirectory = new BookDirectory();

        //When
        List<Book> books = bookDirectory.getList();

        //Then
        long numberOfBooksPublicatedAfter2207 = IntStream.range(0,books.size())
                .filter(n-> books.get(n).getYearOfPublication() > 2007)
                .count();
        assertEquals(3, numberOfBooksPublicatedAfter2207);
    }
}

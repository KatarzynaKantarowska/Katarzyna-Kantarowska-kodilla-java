package com.kodilla.testing.library;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class BookDirectoryTestSuite {

    @Mock
    private LibraryDatabase libraryDatabaseMock;

    @Test
    void testListBooksWithConditionsReturnList() {
        //Given
        BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
        List<Book> resultListOfBooks = new ArrayList<>();
        Book book1 = new Book("Secrets of Alamo", "John Smith", 2008);
        Book book2 = new Book("Secretaries and Directors", "Dilbert Michigan", 2012);
        Book book3 = new Book("Secret life of programmers", "Steve Wolkowitz", 2016);
        Book book4 = new Book("Secrets of Java", "Ian Tenewitch", 2010);

        resultListOfBooks.add(book1);
        resultListOfBooks.add(book2);
        resultListOfBooks.add(book3);
        resultListOfBooks.add(book4);
        when(libraryDatabaseMock.listBooksWithCondition("Secret")).thenReturn(resultListOfBooks);

        //When
        List<Book> books = bookLibrary.listBooksWithCondition("Secret");

        //Then
        Assertions.assertEquals(4, books.size());
    }

    private List<Book> generateListOfNBooks(int booksQuantity) {
        List<Book> resultList = new ArrayList<>();
        for (int n = 1; n <= booksQuantity; n++) {
            Book theBook = new Book("Title" + n, "Author" + n, 1970 + n);
            resultList.add(theBook);
        }
        return resultList;
    }

    @Test
    void testListBooksWithConditionMoreThan20() {
        //Given
        BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
        List<Book> resultListOf0Books = new ArrayList<>();
        List<Book> resultListOf15Books = generateListOfNBooks(15);
        List<Book> resultListOf40Books = generateListOfNBooks(40);
        when(libraryDatabaseMock.listBooksWithCondition(anyString())).thenReturn(resultListOf15Books);
        when(libraryDatabaseMock.listBooksWithCondition("ZeroBooks")).thenReturn(resultListOf0Books);
        when(libraryDatabaseMock.listBooksWithCondition("FortyBooks")).thenReturn(resultListOf40Books);

        //When
        List<Book> theListOfBooks0 = bookLibrary.listBooksWithCondition("ZeroBooks");
        List<Book> theListOfBooks15 = bookLibrary.listBooksWithCondition("Any title");
        List<Book> theListOfBooks40 = bookLibrary.listBooksWithCondition("FortyBooks");


        //Then
        Assertions.assertEquals(0, theListOfBooks0.size());
        Assertions.assertEquals(15, theListOfBooks15.size());
        Assertions.assertEquals(0, theListOfBooks40.size());
    }

    @Test
    void testListBooksWithConditionFragmentShorterThan3() {
        //Given
        LibraryDatabase libraryDatabaseMock = mock(LibraryDatabase.class);
        BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
        //When
        List<Book> theListOfBooks10 = bookLibrary.listBooksWithCondition("An");

        //Then
        Assertions.assertEquals(0, theListOfBooks10.size());
        verify(libraryDatabaseMock, times(0)).listBooksWithCondition(anyString());
    }

    @Test
    void testListBooksInHandsOf0Books() {
        //Given
        LibraryDatabase libraryDatabaseMock = mock(LibraryDatabase.class);
        BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
        LibraryUser libraryUser = new LibraryUser("K", "K", "9404");

        //When
        List<Book> books = List.of();
        when(libraryDatabaseMock.listBooksInHandsOf(libraryUser)).thenReturn(books);
        List<Book> bookInHandsOfProvidedUser = bookLibrary.listBookInHandsOf(libraryUser);

        //Then
        Assertions.assertEquals(0, bookInHandsOfProvidedUser.size());
    }

    @Test
    void testListBooksInHandsOfOneBook() {
        //Given
        LibraryDatabase libraryDatabaseMock = mock(LibraryDatabase.class);
        BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
        LibraryUser libraryUser = new LibraryUser("K", "K", "9404");
        Book book1 = new Book("Secrets of Alamo", "John Smith", 2008);

        //When
        List<Book> books = List.of(book1);
        when(libraryDatabaseMock.listBooksInHandsOf(libraryUser)).thenReturn(books);
        List<Book> booksInHandsOfProvidedUser = bookLibrary.listBookInHandsOf(libraryUser);

        //Then
        Assertions.assertEquals(1, booksInHandsOfProvidedUser.size());
        Assertions.assertTrue(booksInHandsOfProvidedUser.contains(book1));

    }

    @Test
    void testListBooksInHandsOfFiveBooks() {
        //Given
        LibraryDatabase libraryDatabaseMock = mock(LibraryDatabase.class);
        BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
        LibraryUser libraryUser = new LibraryUser("K", "K", "9404");
        Book book1 = new Book("Secrets of Alamo", "John Smith", 2008);
        Book book2 = new Book("Secrets of Alam", "John Smith", 2009);
        Book book3 = new Book("Secrets of Ala", "John Smith", 2010);
        Book book4 = new Book("Secrets of Al", "John Smith", 2011);
        Book book5 = new Book("Secrets of A", "John Smith", 2012);

        //When
        List<Book> books = List.of(book1, book2, book3, book4, book5);
        when(libraryDatabaseMock.listBooksInHandsOf(libraryUser)).thenReturn(books);
        List<Book> booksInHandsOfProvidedUser = bookLibrary.listBookInHandsOf(libraryUser);

        //Then
        Assertions.assertEquals(5, booksInHandsOfProvidedUser.size());
        Assertions.assertTrue(booksInHandsOfProvidedUser.contains(book1));
        Assertions.assertTrue(booksInHandsOfProvidedUser.contains(book2));
        Assertions.assertTrue(booksInHandsOfProvidedUser.contains(book3));
        Assertions.assertTrue(booksInHandsOfProvidedUser.contains(book4));
        Assertions.assertTrue(booksInHandsOfProvidedUser.contains(book5));
    }
}

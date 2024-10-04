package collections;

import java.util.ArrayDeque;
import java.util.Queue;

class BooksCollection {
    String nameOfBook;
    String authorName;
    String authorLastName;
    int yearOfRelease;

    public BooksCollection(String nameOfBook, String authorName, String authorLastName,
                           int yearOfRelease) {
        this.nameOfBook = nameOfBook;
        this.authorName = authorName;
        this.authorLastName = authorLastName;
        this.yearOfRelease = yearOfRelease;
    }

    public int hashCode() {
        return yearOfRelease;
    }

    public boolean equals(Object o) {
        BooksCollection b = (BooksCollection) o;
        return (nameOfBook.equals(b.getNameOfBook())) &&
                (authorName.equals(b.getAuthorName())) &&
                (authorLastName.equals(b.getAuthorLastName())) &&
                (yearOfRelease == b.getYearOfRelease());
    }

    public String toString() {
        return nameOfBook + ", author: " + authorName + " " + authorLastName + ", year of release: " + yearOfRelease;
    }

    public String getNameOfBook() {
        return nameOfBook;
    }

    public String getAuthorName() {
        return authorName;
    }

    public String getAuthorLastName() {
        return authorLastName;
    }

    public int getYearOfRelease() {
        return yearOfRelease;
    }
}

public class ColEx6 {
    public static void main(String[] args) {
        Queue<BooksCollection> booksToDelete = new ArrayDeque<>();
        booksToDelete.offer(new BooksCollection("Harry Potter i Kamień Filozoficzny", "J.K. ",
                "Rowling", 2005));
        booksToDelete.offer(new BooksCollection("Harry Potter i Komnata Tajemnic", "J.K. ",
                "Rowling", 2007));
        booksToDelete.offer(new BooksCollection("Harry Potter i Czara Ognia", "J.K. ",
                "Rowling", 2009));
        booksToDelete.offer(new BooksCollection("Harry Potter i Więzień Azkabanu", "J.K. ",
                "Rowling", 2011));

        System.out.println(booksToDelete.size());
        BooksCollection theLastBook = ((ArrayDeque<BooksCollection>) booksToDelete).peekLast();
        while (booksToDelete.size() > 0) {
            BooksCollection bookDel = booksToDelete.poll();
        }
        System.out.println(booksToDelete.size());
        System.out.println("Ostatnia usunięta książka to: " + theLastBook);
    }
}

package com.kodilla.patterns.prototype.library;

import java.util.HashSet;
import java.util.Set;

public final class Library implements Cloneable {

    private final String name;
    private final Set<Book> books = new HashSet<>();

    public Library(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public Set<Book> getBooks(){
        return books;
    }
    public void addBook( Book book) {
        books.add(book);
    }

    @Override
    public String toString() {
        return "Library{" +
                "name='" + name + '\'' +
                ", books=" + books +
                '}';
    }
    @Override
    public Library clone() throws CloneNotSupportedException {
        return (Library) super.clone();
    }

    public Library deepCopy() throws CloneNotSupportedException {
        Library shallowCopy = clone();
        Library deepCopyLibrary = new Library(this.name);

        for (Book shallowCopyBook : shallowCopy.books) {
            deepCopyLibrary.getBooks()
                    .add(new Book(shallowCopyBook.getTitle(), shallowCopyBook.getAuthor(), shallowCopyBook.getPublicationDate()));
        }
        return deepCopyLibrary;
    }
}
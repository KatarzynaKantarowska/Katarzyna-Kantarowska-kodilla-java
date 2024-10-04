package collections;

import java.util.*;

public class ColEx9 {
    static class BookAT {
        String title;
        String author;

        public BookAT(String title, String author) {
            this.title = title;
            this.author = author;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            BookAT bookAT = (BookAT) o;
            return Objects.equals(title, bookAT.title) && Objects.equals(author, bookAT.author);
        }

        @Override
        public int hashCode() {
            return Objects.hash(title, author);
        }
    }

    public static void main(String[] args) {
        LinkedList<Object> bookAT  = new LinkedList<>();
        for (int n = 0; n < 300000; n++) {
            String e = String.valueOf(n);
            bookAT.add(e);
        }
        long begin = System.nanoTime();
        bookAT.remove("0");
        long end = System.nanoTime();

        long begin1 = System.nanoTime();
        bookAT.remove("299999");
        long end1 = System.nanoTime();

        long begin2 = System.nanoTime();
        bookAT.add(0,"Harry Potter");
        long end2 = System.nanoTime();

        long begin3 = System.nanoTime();
        bookAT.add(bookAT.size(),"Harry Potter");
        long end3 = System.nanoTime();

        System.out.println("Removing element from begin of the list taken: " + (end - begin) + "ns");
        System.out.println("Removing element from end of the list taken: " + (end1 - begin1) + "ns");
        System.out.println("Adding element to begin of the list taken: " + (end2 - begin2) + "ns");
        System.out.println("Adding element to end of the list taken: " + (end3 - begin3) + "ns");

        Map<BookAT, String> bookMap = new HashMap<>();
        Random random = new Random();

        for (int i = 0; i < 5000 ; i++) {
            String title = "Book" + i;
            String author = "Author" + i;
            BookAT newlyCreatedBook = new BookAT(title, author);
            bookMap.put(newlyCreatedBook,"something" +i);
        }
        BookAT newBook = new BookAT("New Book","New Author");
        BookAT searchKey = new BookAT("Book5","Author5");


        long startSearchTime = System.nanoTime();
        String result = bookMap.get(searchKey);
        long endSearchTime = System.nanoTime();
        System.out.println("The key was found in time: " + (endSearchTime - startSearchTime) + "ns");

        long startAddTime = System.nanoTime();
        bookMap.putIfAbsent(newBook,"Book5");
        long endAddTime = System.nanoTime();
        System.out.println("Adding element taken: " + (endAddTime - startAddTime) + "ns");

        long startRemoveTime = System.nanoTime();
        bookMap.remove(searchKey);
        long endRemoveTime = System.nanoTime();
        System.out.println("Removing element taken: " + (endRemoveTime - startRemoveTime) + "ns");
    }
}
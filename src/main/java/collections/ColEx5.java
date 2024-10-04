package collections;

import java.util.HashSet;

    class BooksColl {
        String nameOfBook;
        String authorName;
        String authorLastName;
        int yearOfRelease;

        public BooksColl(String nameOfBook, String authorName, String authorLastName,
                         int yearOfRelease){
            this.nameOfBook = nameOfBook;
            this.authorName = authorName;
            this.authorLastName = authorLastName;
            this.yearOfRelease = yearOfRelease;
        }

        public int hashCode(){
            return yearOfRelease;
        }

        public boolean equals(Object o) {
            BooksColl b = (BooksColl) o;
            return (nameOfBook.equals(b.getNameOfBook())) &&
                    (authorName.equals(b.getAuthorName())) &&
                    (authorLastName.equals(b.getAuthorLastName())) &&
                    (yearOfRelease== b.getYearOfRelease());
        }
        public String toString(){
            return nameOfBook + ", author: " + authorName + " " + authorLastName + ", year of release: " + yearOfRelease;
        }
        public String getNameOfBook(){
            return nameOfBook;
        }public String getAuthorName(){
            return authorName;
        }public String getAuthorLastName(){
            return authorLastName;
        }public int getYearOfRelease(){
            return yearOfRelease;
        }
    }

    public class ColEx5 {
        public static void main(String[] args) {

            BooksColl book1 = new BooksColl("Harry Potter i Kamień Filizoficzny", "J.K.", "Rowling", 2006);
            BooksColl book2 = new BooksColl("Harry Potter i Komnata Tajemnic", "J.K.", "Rowling", 2008);
            BooksColl book3 = new BooksColl("Harry Potter i Więzień Azkabanu", "J.K.", "Rowling", 2010);
            BooksColl book4 = new BooksColl("Harry Potter i Czara Ognia", "J.K.", "Rowling", 2012);
            BooksColl book5 = new BooksColl("Harry Potter i Zakon Feniksa", "J.K.", "Rowling", 2014);
            BooksColl book6 = new BooksColl("Harry Potter i Książe Półkrwi", "J.K.", "Rowling", 2016);

            HashSet<BooksColl> booksSet = new HashSet<BooksColl>();
            booksSet.add(book1);
            booksSet.add(book2);
            booksSet.add(book3);
            booksSet.add(book4);
            booksSet.add(book5);
            booksSet.add(book6);

            for (BooksColl theBooks : booksSet) {
                if(theBooks.yearOfRelease < 2010)
                    System.out.println(theBooks);
            }
        }
    }


package collections;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class Book {
    private String name;
    private int publicationYear;

    public Book (String name, int publicationYear) {
        this.name = name;
        this.publicationYear = publicationYear;
    }

    public String getName(){
        return name;
    }
    public int getPublicationYear(){
        return publicationYear;
    }

    @Override
    public String toString(){
        return "tytuł: " +  this.name + ", rok wydania: " + this.publicationYear;
    }
}

public class ColEx3 {
    public static void main(String[] args) {
        List<Integer> marks = new ArrayList<Integer>();
        marks.add(3);
        marks.add(3);
        marks.add(3);
        marks.add(3);
        marks.add(4);
        marks.add(4);
        marks.add(4);
        marks.add(4);
        marks.add(4);
        marks.add(5);
        marks.add(5);
        marks.add(5);
        marks.add(6);
        marks.add(6);
        marks.add(6);
        marks.add(6);

        int sum = 0;
        for (int i = 1; i < marks.size() - 1; i++) {
            sum += marks.get(i);

        }

        System.out.println("Średnia ocen z przedmiotu informatyka: ");
        double srednia = (double) sum / marks.size();
        System.out.println(srednia);


        List<Book> books = new LinkedList<>();
        books.add(new Book("Kicia Kocia",2020));
        books.add(new Book("Pokemony",1994));
        books.add(new Book("Miś Pracuś",2019));
        books.add(new Book("Wiersze i wierszyki",2010));
        books.add(new Book("Cztery pory roku w przedszkolu",2021));

        System.out.println("Książki wydane po 2000 roku: ");

        for (Book book : books) {
            if (book.getPublicationYear() > 2000) {
                System.out.println(book);
            }
        }
    }
}


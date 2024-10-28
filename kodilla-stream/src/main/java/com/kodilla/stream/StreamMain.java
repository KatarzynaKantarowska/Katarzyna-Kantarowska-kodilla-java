package com.kodilla.stream;

import com.kodilla.stream.book.Book;
import com.kodilla.stream.book.BookDirectory;
import com.kodilla.stream.forumuser.Forum;
import com.kodilla.stream.forumuser.ForumUser;
import com.kodilla.stream.person.People;
import com.kodilla.stream.reference.FunctionalCalculator;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamMain extends FunctionalCalculator {
    public static void main(String[] args) {
//        People.getList().stream()
//                .map((s -> s.toUpperCase())) // .map(String::toUpperCase)
//                .filter(s -> s.length() > 5)
//                .map(s -> s.substring(0, s.indexOf(' ') + 2) + ".")
//                .filter(s -> s.substring(0,1).equals("J"))
//                .forEach(System.out::println);


//        BookDirectory theBookDirectory = new BookDirectory();
//        Map<String, Book> theResultMapOfBooks = theBookDirectory.getList().stream()
//                .filter(book -> book.getYearOfPublication() > 2005)
//                .collect(Collectors.toMap(Book::getSignature, book -> book));
//
//        System.out.println("# elements: " + theResultMapOfBooks.size());
//        theResultMapOfBooks.entrySet().stream()
//                .map(entry -> entry.getKey() + ": " + entry.getValue())
//                .forEach(System.out::println);

//

        Forum forum = new Forum();

        ForumUser forumUser1 = new ForumUser(1,"JohnSmith",'M', LocalDate.of(1980,11,19),3);
        ForumUser forumUser2 = new ForumUser(2,"JessSmith",'F', LocalDate.of(1985,11,19),5);
        ForumUser forumUser3 = new ForumUser(3,"JanSmit",'M', LocalDate.of(1999,11,19),8);
        ForumUser forumUser4 = new ForumUser(4,"JohnSons",'M', LocalDate.of(2015,11,19),1);
        ForumUser forumUser5 = new ForumUser(5,"Jesssss",'F', LocalDate.of(2016,11,19),0);

        forum.addUser(forumUser1);
        forum.addUser(forumUser2);
        forum.addUser(forumUser3);
        forum.addUser(forumUser4);
        forum.addUser(forumUser5);

        Map<Integer, ForumUser> mapsOfUsers = forum.getUserList().stream()
                .filter(u -> u.getSex() == 'M')
                .filter(u -> Period.between(u.getDateOfBirth(), LocalDate.now()).getYears() >= 20)
                .filter(p -> p.getAmountOfPosts() > 0)
                .collect(Collectors.toMap(ForumUser::getId, u -> u));

        System.out.println("Filtered Forum Users Map: " + mapsOfUsers);
    }
}

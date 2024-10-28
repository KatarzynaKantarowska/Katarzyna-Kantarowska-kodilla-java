package com.kodilla.stream.forumuser;

import java.time.LocalDate;

public final class ForumUser {

    private final int id;
    private final String username;
    private final char sex;
    private final LocalDate dateOfBirth;
    private final int amountOfPosts;

    public ForumUser(int id, String username, char sex, LocalDate dateOfBirth, int amountOfPosts) {
        this.id = id;
        this.username = username;
        this.sex = sex;
        this.dateOfBirth = dateOfBirth;
        this.amountOfPosts = amountOfPosts;

    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public char getSex() {
        return sex;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public int getAmountOfPosts() {
        return amountOfPosts;
    }

    @Override
    public String toString() {
        return "ForumUser{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", sex=" + sex +
                ", dateOfBirth=" + dateOfBirth +
                ", amountOfPosts=" + amountOfPosts +
                '}';
    }
}

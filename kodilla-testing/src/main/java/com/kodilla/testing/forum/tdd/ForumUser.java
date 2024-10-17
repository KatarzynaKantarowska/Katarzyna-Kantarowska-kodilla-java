package com.kodilla.testing.forum.tdd;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ForumUser {

    private String name;
    private String realName;
    private List<ForumPost> posts = new ArrayList<>();
    private List<ForumComment> comments = new LinkedList<>();

    public ForumUser(String name, String realName) {
        this.name = name;
        this.realName = realName;
    }

    public void addPost(String author, String postBody) {
        // do nothing
    }

    public String getName() {
        return name;
    }

    public String getRealName() {
        return realName;
    }

    public List<ForumPost> getPosts() {
        return posts;
    }

    public List<ForumComment> getComments() {
        return comments;
    }

    public void addComment(ForumPost thePost, String author, String commentBody) {
        // do nothing
    }

    public int getPostsQuantity() {
        // return 100 temporarily
        return 100;
    }

    public int getCommentsQuantity() {
        // return 100 temporarily
        return 100;
    }
    public boolean removePost(ForumPost thePost) {
        // return true temporarily
        return true;
    }
    public boolean removeComment(ForumComment theComment) {
        // return true temporarily
        return true;
    }
}

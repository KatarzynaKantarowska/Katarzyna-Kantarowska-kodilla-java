package com.kodilla.testing.forum.tdd;

import java.util.Objects;

public class ForumPost {
    private final String postBody;
    private final String author;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ForumPost forumPost = (ForumPost) o;
        return Objects.equals(postBody, forumPost.postBody) && Objects.equals(author, forumPost.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(postBody, author);
    }

    public String getPostBody() {
        return postBody;
    }

    public String getAuthor() {
        return author;
    }

    public ForumPost(String postBody, String author) {
        this.postBody = postBody;
        this.author = author;
    }
}

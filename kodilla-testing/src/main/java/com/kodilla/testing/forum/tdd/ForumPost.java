package com.kodilla.testing.forum.tdd;

import java.util.Objects;

public class ForumPost {
    private String postBody;
    private String author;

//    public ForumPost getPost(int postNumber) {
//        if (postNumber >= 0 && postNumber < posts.size()) {
//            return posts.get(postNumber);
//        }
//        return null;
//    }
//
//    public ForumComment getComment(int commentNumber) {
//        ForumComment theComment = null;
//        if (commentNumber >= 0 && commentNumber < comments.size()) {
//            theComment = comments.get(commentNumber);
//        }
//        return theComment;
//    }

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

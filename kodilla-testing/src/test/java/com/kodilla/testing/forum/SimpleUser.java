package com.kodilla.testing.forum;

public class SimpleUser {
    private String username;
    private String realName;

    public SimpleUser(String username, String realName) {

        this.username = username;
        this.realName = realName;
    }

    public String getRealName() {
        return realName;
    }

    public String getUsername() {
        return username;
    }
}

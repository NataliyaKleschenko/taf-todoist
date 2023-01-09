package com.todoist.ui.model;

public class User {
    private final String email;
    private final String password;
    private String name;
    public User(final String email,final String password) {
        this.email = email;
        this.password = password;
    }
    public String getEmail() {
        return email;
    }
    public String getPassword() {
        return password;
    }
}

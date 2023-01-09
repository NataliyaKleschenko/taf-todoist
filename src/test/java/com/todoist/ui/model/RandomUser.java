package com.todoist.ui.model;

import com.todoist.ui.util.RandomString;

public class RandomUser extends User{
    public static final String EMAIL = RandomString.generateRandomString() + "@gmail.com";
    public static final String PASSWORD = RandomString.generateRandomString();
    public RandomUser() {
        super(EMAIL, PASSWORD);
    }
}

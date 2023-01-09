package com.todoist.ui.util;

import org.apache.commons.lang3.RandomStringUtils;

public class RandomString {
    public static String generateRandomString() {
        return RandomStringUtils.randomAlphabetic(9);
    }
}

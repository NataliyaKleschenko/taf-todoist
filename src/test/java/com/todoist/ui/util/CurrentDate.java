package com.todoist.ui.util;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class CurrentDate {
    public static String getCurrentDate() {
        return DateTimeFormatter.ofPattern(("EEE d MMM"), Locale.ENGLISH)
                .format(LocalDateTime.now());
    }
}

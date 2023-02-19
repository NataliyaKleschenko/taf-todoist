package com.todoist.ui.browsers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class Firefox {
    public static WebDriver createFirefoxDriver() {
        FirefoxOptions options = new FirefoxOptions()
                .addArguments("--lang=en")
                .addArguments("--incognito")
                .addArguments("--headless")
                .addArguments("--window-size=1920x1200");
        return new FirefoxDriver(options);
    }
}

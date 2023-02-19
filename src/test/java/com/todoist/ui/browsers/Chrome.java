package com.todoist.ui.browsers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Chrome {
    public static WebDriver createChromeDriver() {
        ChromeOptions options = new ChromeOptions()
                .addArguments("--lang=en")
                .addArguments("--incognito")
                .addArguments("--headless")
                .addArguments("--window-size=1920x1200");
        return new ChromeDriver(options);
    }
}

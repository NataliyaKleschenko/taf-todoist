package com.todoist.ui.browsers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;

public class WebDriverFactory {
    public static WebDriver createWebDriver(String browser) {
        switch (browser) {
            case "chrome":
                return Chrome.createChromeDriver();
            case "firefox":
                return Firefox.createFirefoxDriver();
            case "edge":
                return Edge.createEdgeDriver();
            default:
                throw new WebDriverException("Undefined driver");
        }

    }
}

package com.todoist.ui.driver;

import com.todoist.ui.browsers.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class DriverSingleton {
    private static WebDriver driver;
    private static final long IMPLICITLY_WAIT = 10;
    private DriverSingleton() {
    }
    public static WebDriver getDriver() {
        if (driver == null) {
            driver = WebDriverFactory.createWebDriver("chrome");
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(IMPLICITLY_WAIT));
        }
        return driver;
    }
    public static void closeDriver() {
        driver.quit();
        driver = null;
    }
}

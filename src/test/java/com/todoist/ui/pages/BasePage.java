package com.todoist.ui.pages;

import com.todoist.ui.driver.DriverSingleton;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    static Logger logger = LogManager.getLogger();
    protected WebDriver driver;
    private static final String URL = "https://todoist.com/";
    private static final int WAIT_FOR_ELEMENT = 4;

    protected BasePage() {
        driver = DriverSingleton.getDriver();
        PageFactory.initElements(driver, this);
    }

    public BasePage openPage() {
        driver.navigate().to(URL);
        logger.info("Page opened");
        return this;
    }

    protected WebElement waitForElementToBeClickable(WebElement webElement) {
        return new WebDriverWait(driver, Duration.ofSeconds(WAIT_FOR_ELEMENT)).until(ExpectedConditions.elementToBeClickable(webElement));
    }

    protected WebElement waitForVisibilityOfElement(WebElement webElement) {
        WebElement element = new WebDriverWait(driver, Duration.ofSeconds(WAIT_FOR_ELEMENT)).until(ExpectedConditions.visibilityOf(webElement));
        logger.info("Wait until the element is visible");
        return element;
    }
}

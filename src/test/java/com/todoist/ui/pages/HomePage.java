package com.todoist.ui.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{
    @FindBy(xpath = "//ul[@class='hGJuHEzyrDQU5nwls2PW']//a[contains(text(),'Features')]")
    private WebElement featureButton;
    @FindBy(xpath = "//ul[@class='hGJuHEzyrDQU5nwls2PW']//a[contains(text(),'Templates')]")
    private WebElement templatesButton;
    @FindBy(xpath = "//ul[@class='hGJuHEzyrDQU5nwls2PW']//a[contains(text(),'For Teams')]")
    private WebElement forTeamsButton;
    @FindBy(xpath = "//ul[@class='hGJuHEzyrDQU5nwls2PW']//button[contains(text(),'Resources')]")
    private WebElement resourcesButton;
    @FindBy(xpath = "//ul[@class='hGJuHEzyrDQU5nwls2PW']//a[contains(text(),'Pricing')]")
    private WebElement pricingButton;
    @FindBy(xpath = "//ul[@class='hGJuHEzyrDQU5nwls2PW']//a[contains(text(),'Start for free')]")
    private WebElement startForFreeButton;
    @FindBy(xpath = "//h1")
    private WebElement headerLocator;
    @FindBy(xpath = "//footer//a[contains(text(),'How It Works')]")
    private WebElement howItWorkButton;
    @FindBy(xpath = "//footer//a[contains(text(),'Download Apps')]")
    private WebElement downloadAppButton;
    @FindBy(xpath = "//footer//a[contains(text(),'About Us')]")
    private WebElement aboutUsButton;
    @FindBy(xpath = "//a[@href='/auth/login']")
    private WebElement loginButton;
    @FindBy(xpath = "//footer//p[@class='Z2j5FoeQ_umI7vX0SmxF EkQLWhUQXERswBk6sxIb']")
    private WebElement footerTextLocator;

    public HomePage scrollPageDown(WebElement webElement) {
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        javascriptExecutor.executeScript("arguments[0].scrollIntoView(true);", webElement);
        waitForVisibilityOfElement(webElement);
        return this;
    }
    public HomePage clickToLoginIn() {
        waitForElementToBeClickable(loginButton).click();
        return this;
    }
    public boolean isLoginButtonDisplayed() {
        return loginButton.isDisplayed();
    }
    public boolean isFeatureButtonDisplayed() {
        return featureButton.isDisplayed();
    }
    public boolean isTemplatesButtonDisplayed() {
        return templatesButton.isDisplayed();
    }
    public boolean isForTeamsButtonDisplayed() {
        return forTeamsButton.isDisplayed();
    }
    public boolean isResourcesButtonDisplayed() {
        return resourcesButton.isDisplayed();
    }
    public boolean isPricingButtonDisplayed() {
        return pricingButton.isDisplayed();
    }
    public boolean isStartForFreeButtonDisplayed() {
        return startForFreeButton.isDisplayed();
    }
    public boolean isHowItWorkButtonDisplayed() {
        return howItWorkButton.isDisplayed();
    }
    public boolean isDownloadAppButtonDisplayed() {
        return downloadAppButton.isDisplayed();
    }
    public boolean isAboutUsButtonDisplayed() {
        return aboutUsButton.isDisplayed();
    }
    public String getTextFromHeaderLocator() {
        return headerLocator.getText();
    }
    public String getTextFromFooterTextLocator() {
        return footerTextLocator.getText();
    }
}

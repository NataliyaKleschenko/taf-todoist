package com.todoist.ui.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.HashMap;
import java.util.Map;

public class LoginPage extends BasePage {

    @FindBy(xpath = "//input[@type='email']")
    private WebElement inputEmail;
    @FindBy(xpath = "//input[@type='password']")
    private WebElement inputPassword;
    @FindBy(xpath = "//button[@type='submit']")
    private WebElement submitButton;
    @FindBy(xpath = "//h1")
    private WebElement loginLabel;
    @FindBy(xpath = "//span[contains(text(),'Continue with Google')]")
    private WebElement continueWithGoogleLabel;
    @FindBy(xpath = "//span[contains(text(),'Continue with Facebook')]")
    private WebElement continueWithFacebookLabel;
    @FindBy(xpath = "//span[contains(text(),'Continue with Apple')]")
    private WebElement continueWithAppleLabel;
    @FindBy(xpath = "//a[@href='/auth/password']") //
    private WebElement forgotPasswordLabel;
    @FindBy(xpath = "//div[contains(text(),'Don’t have an account? ')]")
    private WebElement doNotHaveAccountLabel;
    @FindBy(xpath = "//p[contains(text(),'Passwords must be at least 8 characters long.')]")
    private WebElement tooShortPasswordMessage;
    @FindBy(xpath = "//div[contains(text(),'Wrong email or password.')]")
    private WebElement wrongEmailOrPasswordMessage;
    @FindBy(xpath = "//p[contains(text(),'Please enter a valid email address.')]")
    private WebElement wrongEmailMessage;
    public static final String LOG_IN = "Log in";
    public static final String GOOGLE = "Continue with Google";
    public static final String FACEBOOK = "Continue with Facebook";
    public static final String APPLE = "Continue with Apple";
    public static final String PASSWORD = "Forgot your password?";
    public static final String DO_NOT_HAVE_ACCOUNT = "Don’t have an account? Sign up";

    public LoginPage typeEmail(String email) {
        waitForVisibilityOfElement(inputEmail).clear();
        inputEmail.sendKeys(email);
        logger.info(inputEmail.getLocation());
        return this;
    }

    public LoginPage typePassword(String password) {
        waitForVisibilityOfElement(inputPassword).clear();
        inputPassword.sendKeys(password);
        logger.info(inputPassword.getLocation());
        return this;
    }

    public LoginPage clearFilledField(WebElement webElement) {
        CharSequence[] deleteAllSymbols = {Keys.chord(Keys.SHIFT, Keys.HOME), Keys.DELETE};
        webElement.sendKeys(deleteAllSymbols);
        return this;
    }

    public LoginPage clearInputEmail() {
        clearFilledField(inputEmail);
        return this;
    }

    public LoginPage clearInputPassword() {
        clearFilledField(inputPassword);
        return this;
    }

    public LoginPage clickOnSubmitButton() {
        submitButton.click();
        logger.info(submitButton.getLocation());
        return this;
    }

    public String getTextFromLoginLabel() {
        return loginLabel.getText();
    }

    public String getTextFromContinueWithGoogleLabel() {
        return continueWithGoogleLabel.getText();
    }

    public String getTextFromContinueWithFacebookLabel() {
        return continueWithFacebookLabel.getText();
    }

    public String getTextFromContinueWithAppleLabel() {
        return continueWithAppleLabel.getText();
    }

    public String getTextFromForgotPasswordLabel() {
        return forgotPasswordLabel.getText();
    }

    public String getTextFromDoNotHaveAccountLabel() {
        return doNotHaveAccountLabel.getText();
    }

    public String getTextFromTooShortPasswordMessage() {
        return waitForVisibilityOfElement(tooShortPasswordMessage).getText();
    }

    public String getTextFromWrongEmailOrPasswordMessage() {
        return waitForVisibilityOfElement(wrongEmailOrPasswordMessage).getText();
    }

    public String getTextFromWrongEmailMessage() {
        return waitForVisibilityOfElement(wrongEmailMessage).getText();
    }

    public Map<String, String> getLoginPageAttributes() {
        return new HashMap<>() {{
            put(LOG_IN, getTextFromLoginLabel());
            put(GOOGLE, getTextFromContinueWithGoogleLabel());
            put(FACEBOOK, getTextFromContinueWithFacebookLabel());
            put(APPLE, getTextFromContinueWithAppleLabel());
            put(PASSWORD, getTextFromForgotPasswordLabel());
            put(DO_NOT_HAVE_ACCOUNT, getTextFromDoNotHaveAccountLabel());
        }};
    }
}



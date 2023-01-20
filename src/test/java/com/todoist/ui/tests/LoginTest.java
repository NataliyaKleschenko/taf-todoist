package com.todoist.ui.tests;

import com.todoist.ui.model.CorrectUser;
import com.todoist.ui.model.RandomUser;
import com.todoist.ui.model.User;
import com.todoist.ui.pages.LoginPage;
import com.todoist.ui.steps.AuthorizedUserStep;
import com.todoist.ui.steps.HomeStep;
import com.todoist.ui.steps.LoginStep;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class LoginTest extends BaseTest{
    @BeforeMethod
    public void openPage() {
        HomeStep homeStep = new HomeStep();
        homeStep.openPageAndClickToLoginIn();
    }
    @Test
    public void testCheckPageAttributes() {
        LoginStep loginStep = new LoginStep();
        Map<String,String> expectedAttributes = new HashMap<>();
        expectedAttributes.put(LoginStep.LOG_IN,"Log in");
        expectedAttributes.put(LoginStep.GOOGLE,"Continue with Google");
        expectedAttributes.put(LoginStep.FACEBOOK,"Continue with Facebook");
        expectedAttributes.put(LoginStep.APPLE,"Continue with Apple");
        expectedAttributes.put(LoginStep.PASSWORD,"Forgot your password?");
        expectedAttributes.put(LoginStep.DO_NOT_HAVE_ACCOUNT,"Don’t have an account? Sign up");
        Map<String,String> actualAttributes = loginStep.getLoginPageAttributes();

        Assert.assertEquals(actualAttributes,expectedAttributes);
    }
    @Test
    public void testLoginInWithCorrectUser() {
        LoginStep loginStep = new LoginStep();
        loginStep.loginIn(new CorrectUser());
        AuthorizedUserStep authorizedUserStep = new AuthorizedUserStep();
        String actual = authorizedUserStep.getUserEmail();

        Assert.assertEquals(actual,"selenaspotify99@gmail.com");
    }
    @Test
    public void testLoginInWithEmptyEmailAndEmptyPassword() {
        LoginStep loginStep = new LoginStep();
        loginStep.loginInWithEmptyEmailAndEmptyPassword(new CorrectUser());

        Assert.assertEquals(loginStep.getTextFromWrongEmailMessage(),"Please enter a valid email address.");
    }
    @Test
    public void testLoginInWithCorrectEmailAndEmptyPassword() {
        LoginStep loginStep = new LoginStep();
        loginStep.loginInWithFilledEmailAndEmptyPassword(new CorrectUser());

        Assert.assertEquals(loginStep.getTextFromTooShortPasswordMessage(),"Passwords must be at least 8 characters long.");
    }
    @Test
    public void testLoginInWithEmptyEmailAndCorrectPassword() {
        LoginStep loginStep = new LoginStep();
        loginStep.loginInWithEmptyEmailAndFilledPassword(new CorrectUser());

        Assert.assertEquals(loginStep.getTextFromWrongEmailMessage(),"Please enter a valid email address.");
    }
    @Test
    public void testLoginInWithCorrectEmailAndIncorrectPassword() {
        LoginStep loginStep = new LoginStep();
        loginStep.loginIn(new User(CorrectUser.EMAIL,RandomUser.PASSWORD));

        Assert.assertEquals(loginStep.getTextFromWrongEmailOrPasswordMessage(),"Wrong email or password.");
    }
    @Test
    public void testLoginInWithIncorrectEmailAndCorrectPassword() {
        LoginStep loginStep = new LoginStep();
        loginStep.loginIn(new User(RandomUser.EMAIL,CorrectUser.PASSWORD));

        Assert.assertEquals(loginStep.getTextFromWrongEmailOrPasswordMessage(),"Wrong email or password.");
    }
    @Test
    public void testLoginInWithIncorrectEmailAndIncorrectPassword() {
        LoginStep loginStep = new LoginStep();
        loginStep.loginIn(new RandomUser());

        Assert.assertEquals(loginStep.getTextFromWrongEmailOrPasswordMessage(),"Wrong email or password.");
    }
}

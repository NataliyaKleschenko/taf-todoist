package com.todoist.ui.tests;

import com.todoist.ui.driver.DriverSingleton;
import com.todoist.ui.model.CorrectUser;
import com.todoist.ui.pages.AuthorizedUserPage;
import com.todoist.ui.steps.AuthorizedUserStep;
import com.todoist.ui.steps.HomeStep;
import com.todoist.ui.steps.LoginStep;
import com.todoist.ui.util.CurrentDate;
import io.qameta.allure.Description;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AuthorizedUserTest extends BaseTest{
    private final Logger logger = LogManager.getRootLogger();
    @BeforeMethod
    public void openPageAndLogIn() {
        HomeStep homeStep = new HomeStep();
        homeStep.openPageAndClickToLoginIn();
        LoginStep loginStep = new LoginStep();
        loginStep.loginIn(new CorrectUser());
    }
    @AfterMethod
    public void testEnd(ITestResult result) {
        checkAlert();
    }
    public void checkAlert() {
        try{
            DriverSingleton.getDriver().switchTo().alert().accept();
            logger.warn("Alert has been found and accepted.");
        }catch (NoAlertPresentException e){
            e.getStackTrace();
        }
    }
    @Test
    public void testCheckIsButtonDisplayed() {
    AuthorizedUserStep authorizedUserStep = new AuthorizedUserStep();

    Assert.assertTrue(authorizedUserStep.checkIsAuthorizedUserPageButtonsDisplayed());
    }
    @Test
    @Description("compare date on page with current date")
    public void testCheckCurrentDate() {
        AuthorizedUserPage authorizedUserPage = new AuthorizedUserPage();
        String actual = authorizedUserPage.getTextFromDateButton();
        String expected = CurrentDate.getCurrentDate();

        Assert.assertEquals(actual,expected);
    }
    @Test
    public void testAddTaskAndCheck() {
        AuthorizedUserStep authorizedUserStep = new AuthorizedUserStep();
        String taskName = "test";
        authorizedUserStep.addTask(taskName);

        Assert.assertEquals(taskName,authorizedUserStep.getTextFromAddedTaskLocator());
    }
    @Test
    public void testAddProjectAndCheck() {
        AuthorizedUserStep authorizedUserStep = new AuthorizedUserStep();
        String projectName = "test";
        authorizedUserStep.addProject(projectName);

        Assert.assertEquals(projectName,authorizedUserStep.getTextFromAddedProjectLocator());
    }
}

package com.todoist.ui.tests;

import com.todoist.ui.model.CorrectUser;
import com.todoist.ui.pages.AuthorizedUserPage;
import com.todoist.ui.steps.AuthorizedUserStep;
import com.todoist.ui.steps.HomeStep;
import com.todoist.ui.steps.LoginStep;
import com.todoist.ui.util.CurrentDate;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AuthorizedUserTest extends BaseTest{
    @BeforeMethod
    public void openPageAndLogIn() {
        HomeStep homeStep = new HomeStep();
        homeStep.openPageAndClickToLoginIn();
        LoginStep loginStep = new LoginStep();
        loginStep.loginIn(new CorrectUser());
    }
    @Test
    public void testCheckIsButtonDisplayed() {
        AuthorizedUserPage authorizedUserPage = new AuthorizedUserPage();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(authorizedUserPage.isTodayButtonDisplayed());
        softAssert.assertTrue(authorizedUserPage.isInboxButtonDisplayed());
        softAssert.assertTrue(authorizedUserPage.isFilterAndLabelButtonDisplayed());
        softAssert.assertTrue(authorizedUserPage.isProjectButtonDisplayed());
        softAssert.assertTrue(authorizedUserPage.isUpcomingButtonDisplayed());
        softAssert.assertAll();
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

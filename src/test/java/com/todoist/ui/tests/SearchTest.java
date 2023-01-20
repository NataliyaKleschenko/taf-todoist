package com.todoist.ui.tests;

import com.todoist.ui.model.CorrectUser;
import com.todoist.ui.steps.HomeStep;
import com.todoist.ui.steps.LoginStep;
import com.todoist.ui.steps.SearchStep;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SearchTest extends BaseTest{
    @BeforeMethod
    public void openPageAndLogIn() {
        HomeStep homeStep = new HomeStep();
        homeStep.openPageAndClickToLoginIn();
        LoginStep loginStep = new LoginStep();
        loginStep.loginIn(new CorrectUser());
    }
    @Test
    public void testSendRequestAndCheckResult() {
        SearchStep searchStep = new SearchStep();
        String request = "task";
        searchStep.typeRequestInSearchInput(request);

        Assert.assertEquals(searchStep.checkTheNumberOfResultsFound(request),2);
    }
}

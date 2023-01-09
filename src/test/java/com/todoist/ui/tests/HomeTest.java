package com.todoist.ui.tests;

import com.todoist.ui.pages.HomePage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class HomeTest extends BaseTest{
    @BeforeMethod
    public void openPage() {
        HomePage homePage = new HomePage();
        homePage.openPage();
    }
    @Test
    public void testIsHomePageButtonDisplayed() {
        HomePage homePage = new HomePage();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(homePage.isLoginButtonDisplayed());
        softAssert.assertTrue(homePage.isFeatureButtonDisplayed());
        softAssert.assertTrue(homePage.isTemplatesButtonDisplayed());
        softAssert.assertTrue(homePage.isForTeamsButtonDisplayed());
        softAssert.assertTrue(homePage.isResourcesButtonDisplayed());
        softAssert.assertTrue(homePage.isPricingButtonDisplayed());
        softAssert.assertTrue(homePage.isStartForFreeButtonDisplayed());
        softAssert.assertTrue(homePage.isAboutUsButtonDisplayed());
        softAssert.assertTrue(homePage.isHowItWorkButtonDisplayed());
        softAssert.assertTrue(homePage.isDownloadAppButtonDisplayed());
        softAssert.assertAll();
    }
    @Test
    public void testGetHomePageText() {
        String expectedHeaderText = "Organize your\n" +
                "work and life, finally.";
        String expectedFooterText = "Join millions of people who organize work and life with Todoist.";
        HomePage homePage = new HomePage();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(expectedHeaderText,homePage.getTextFromHeaderLocator());
        softAssert.assertEquals(expectedFooterText,homePage.getTextFromFooterTextLocator());
        softAssert.assertAll();
    }
}

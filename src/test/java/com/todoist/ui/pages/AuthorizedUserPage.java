package com.todoist.ui.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class AuthorizedUserPage extends BasePage {
    @FindBy(xpath = "//div[contains(@class,'Vo settings_avatar')]")
    private WebElement userInfoButton;
    @FindBy(xpath = "//p[@class='user_menu_email']")
    private WebElement userEmailLocator;
    @FindBy(xpath = "//li[@id='filter_inbox']")
    private WebElement inboxButton;
    @FindBy(xpath = "//li[@id='filter_today']")
    private WebElement todayButton;
    @FindBy(xpath = "//li[@id='filter_upcoming']")
    private WebElement upcomingButton;
    @FindBy(xpath = "//li[@id='filters_labels']")
    private WebElement filterAndLabelButton;
    @FindBy(xpath = "//a[@href='/app/projects']")
    private WebElement projectButton;
    @FindBy(xpath = "//button[@aria-label='Add project']")
    private WebElement addProjectButton;
    @FindBy(xpath = "//input[@id='edit_project_modal_field_name']")
    private WebElement addProjectInput;
    @FindBy(xpath = "//input[@placeholder='Search']")
    private WebElement searchInput;
    @FindBy(xpath = "//small")
    private WebElement currentDateButton;
    @FindBy(xpath = "//button[@id='quick_add_task_holder']")
    private WebElement addTaskButton;
    @FindBy(xpath = "//p[@data-placeholder='Task name']")
    private WebElement taskNameField;
    @FindBy(xpath = "//p[@data-placeholder='Description']")
    private WebElement taskDescriptionField;
    @FindBy(xpath = "//span[@data-action-hint='task-actions-priority-picker']")
    private WebElement priorityButton;
    @FindBy(xpath = "//li[@data-action-hint='task-actions-priority-4']")
    private WebElement priorityHighLocator;
    @FindBy(xpath = "//button[@data-testid='task-editor-submit-button']")
    private WebElement submitTaskButton;
    @FindBy(xpath = "//div[contains(@class,'task_content')]")
    private WebElement addedTaskLocator;
    @FindBy(xpath = "//span[@class='color_dropdown_select__name']")
    private WebElement colorButton;
    @FindBy(xpath = "//li[@aria-label='sky_blue']")
    private WebElement colorSkyBlue;
    @FindBy(xpath = "//button[@type='submit']")
    private WebElement submitProjectButton;
    @FindBy(xpath = "//ul[contains(@id,'projects_list')]")
    private WebElement addedProjectLocator;

    public AuthorizedUserPage clickOnUserInfoButton() {
        waitForElementToBeClickable(userInfoButton).click();
        return this;
    }
    public String getTextFromUserEmailLocator() {
        return waitForVisibilityOfElement(userEmailLocator).getText();
    }

    public boolean isInboxButtonDisplayed() {
        return inboxButton.isDisplayed();
    }

    public boolean isTodayButtonDisplayed() {
        return todayButton.isDisplayed();
    }

    public boolean isUpcomingButtonDisplayed() {
        return upcomingButton.isDisplayed();
    }

    public boolean isFilterAndLabelButtonDisplayed() {
        return filterAndLabelButton.isDisplayed();
    }

    public boolean isProjectButtonDisplayed() {
        return projectButton.isDisplayed();
    }

    public void typeInSearchInput(String query) {
        searchInput.sendKeys(query,Keys.ENTER);
    }

    public String getTextFromDateButton() {
        return currentDateButton.getText();
    }

    public void clickOnAddTaskButton() {
        addTaskButton.click();
    }

    public void typeTextInTaskNameField(String taskName) {
        waitForElementToBeClickable(taskNameField).sendKeys(taskName);
    }

    public void typeTextInDescriptionField(String taskDescription) {
        waitForElementToBeClickable(taskDescriptionField).sendKeys(taskDescription);
    }

    public void clickOnPriorityButton() {
        waitForElementToBeClickable(priorityButton).click();
    }

    public void selectPriority() {
        waitForVisibilityOfElement(priorityHighLocator);
        waitForElementToBeClickable(priorityHighLocator).click();
    }

    public void clickOnSubmitTaskButton() {
        waitForElementToBeClickable(submitTaskButton).click();
    }

    public String getTextFromAddedTaskLocator() {
        return waitForVisibilityOfElement(addedTaskLocator).getText();
    }

    public void clickOnAddProjectButton() {
        Actions actions = new Actions(driver);
        actions.moveToElement(addProjectButton);
        addProjectButton.click();
    }

    public void typeTextInAddProjectInput(String text) {
        waitForVisibilityOfElement(addProjectInput).sendKeys(text);
    }

    public void clickOnColorButton() {
        waitForElementToBeClickable(colorButton).click();
    }

    public void clickOnColorSkyBlue() {
        waitForVisibilityOfElement(colorSkyBlue).click();
    }

    public void clickOnSubmitProjectButton() {
        waitForElementToBeClickable(submitProjectButton).click();
    }

    public String getTextFromAddedProjectLocator() {
        return waitForVisibilityOfElement(addedProjectLocator).getText();
    }
}


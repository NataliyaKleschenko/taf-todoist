package com.todoist.ui.steps;

import com.todoist.ui.pages.AuthorizedUserPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
public class AuthorizedUserStep extends AuthorizedUserPage {
    private final Logger logger = LogManager.getRootLogger();
    public String getUserEmail() {
        clickOnUserInfoButton();
        return getTextFromUserEmailLocator();
    }
    public void addTask(String taskName) {
        clickOnAddTaskButton();
        typeTextInTaskNameField(taskName);
        typeTextInDescriptionField(taskName);
        clickOnPriorityButton();
        selectPriority();
        clickOnSubmitTaskButton();
        logger.info("Created task with name: [" + taskName  +
                "] and description: [" + taskName + "]");
    }
    public void addProject(String projectName) {
        clickOnAddProjectButton();
        typeTextInAddProjectInput(projectName);
        clickOnColorButton();
        clickOnColorSkyBlue();
        clickOnSubmitProjectButton();
        logger.info("Created project with name: [" + projectName  + "]");
    }
}

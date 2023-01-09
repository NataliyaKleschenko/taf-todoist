package com.todoist.ui.steps;

import com.todoist.ui.model.User;
import com.todoist.ui.pages.LoginPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoginStep extends LoginPage {
    private final Logger logger = LogManager.getRootLogger();

    public void loginIn(User user) {
        typeEmail(user.getEmail())
                .typePassword(user.getPassword())
                .clickOnSubmitButton();
        logger.info("Login performed");

    }

    public void loginInWithEmptyEmailAndEmptyPassword(User user) {
        typeEmail(user.getEmail())
                .typePassword(user.getPassword())
                .clearInputEmail()
                .clearInputPassword()
                .clickOnSubmitButton();
        logger.info("Login failed");
    }

    public void loginInWithFilledEmailAndEmptyPassword(User user) {
        typeEmail(user.getEmail())
                .typePassword(user.getPassword())
                .clearInputPassword()
                .clickOnSubmitButton();
        logger.info("Login failed");
    }

    public void loginInWithEmptyEmailAndFilledPassword(User user) {
        typeEmail(user.getEmail())
                .typePassword(user.getPassword())
                .clearInputEmail()
                .clickOnSubmitButton();
        logger.info("Login failed");
    }
}

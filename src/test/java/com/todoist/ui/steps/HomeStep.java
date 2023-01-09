package com.todoist.ui.steps;

import com.todoist.ui.pages.HomePage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class HomeStep extends HomePage {
    private final Logger logger = LogManager.getRootLogger();
    public void openPageAndClickToLoginIn() {
        openPage();
        clickToLoginIn();
        logger.info("Page opened");
    }
}

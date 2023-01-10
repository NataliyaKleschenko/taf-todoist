package com.todoist.api.tests;

import com.todoist.api.steps.DeleteLabelSteps;
import org.testng.annotations.AfterSuite;

public class BaseTest {
    @AfterSuite
    public void deleteAllLabels() {
        DeleteLabelSteps.deleteAllLabels();
    }
}
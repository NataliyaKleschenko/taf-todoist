package com.todoist.api.tests;

import com.todoist.api.steps.DeleteLabelSteps;
import org.testng.annotations.AfterClass;
public class BaseTest {
    @AfterClass
    public void deleteAllLabels() {
        DeleteLabelSteps.deleteAllLabels();
    }
}
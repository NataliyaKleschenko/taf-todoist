package com.todoist.ui.tests;

import com.todoist.ui.driver.DriverSingleton;
import com.todoist.ui.util.TestListener;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Listeners;

@Listeners({TestListener.class})
public abstract class BaseTest {

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        DriverSingleton.closeDriver();
    }
}

package com.todoist.ui.browsers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

public class Edge {
    public static WebDriver createEdgeDriver() {
        EdgeOptions options = new EdgeOptions()
                .addArguments("--lang=en")
                .addArguments("--incognito")
                .addArguments("--headless")
                .addArguments("--window-size=1920x1200");
        return new EdgeDriver(options);
    }
}

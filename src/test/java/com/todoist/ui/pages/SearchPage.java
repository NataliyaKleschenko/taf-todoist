package com.todoist.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.List;
import java.util.stream.Collectors;

public class SearchPage extends AuthorizedUserPage{
    private final By taskListLocator = By.xpath("//li[@class='task_list_item']");

    public List<String> resultsContainsInputValue(String value) {
        List<WebElement> elements = driver.findElements(taskListLocator);
        for (WebElement webElement : elements) {
            if(!webElement.isDisplayed()) {
                logger.info(webElement.getLocation());
            }
        }
        return elements.stream()
                .map(WebElement::getText)
                .filter(title -> title.contains(value))
                .collect(Collectors.toList());
    }
    public int checkTheNumberOfResultsFound(String value) {
        return resultsContainsInputValue(value).size();
    }


}

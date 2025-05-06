package org.epam.page;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GmailMainPage extends AbstractPage{
    public GmailMainPage(WebDriver driver) {
        super(driver);
    }

    private final By searchBarLocator = By.id("aso_search_form_anchor");
    private final By searchBarTextField = By.xpath("//input[@class=\"gb_pe aJh\"]");

    private final By labelsLabel = By.xpath("//span[@role=\"heading\"][@class=\"aAv\"]");

    private final By noMatchMessage = By.className("TC");

    public String getLabelsText(){
        return getText(labelsLabel);
    }

    public String searchMailNoMatch(String text){
        waitForElement(searchBarLocator);
        this.click(searchBarLocator);
        this.sendKeys(searchBarTextField, text);
        this.sendKeys(searchBarTextField, Keys.RETURN);
        waitForElement(noMatchMessage);
        return getText(noMatchMessage);
    }
}

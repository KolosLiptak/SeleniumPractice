package org.epam.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GmailMainPage extends AbstractPage{
    public GmailMainPage(WebDriver driver) {
        super(driver);
    }

    private final By searchBarLocator = By.id("aso_search_form_anchor");
    WebElement searchBar = find(searchBarLocator);

    private final By accountInfoButton = By.xpath("//a[@class=\"gb_B gb_Za gb_0\"]");

    private final By closeMenuButton = By.xpath("//button[@aria-label=\"Close menu\"]");

    private final By labelsLabel = By.xpath("//span[@role=\"heading\"][@class=\"aAv\"]");

    public void clickAccountInfo(){
        click(accountInfoButton);
        waitForElement(closeMenuButton);
    }

    public void clickCloseMenuButton(){
        click(closeMenuButton);
    }

    public String getLabelsText(){
        return getText(labelsLabel);
    }
}

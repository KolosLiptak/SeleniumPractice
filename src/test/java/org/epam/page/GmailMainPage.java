package org.epam.page;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GmailMainPage extends AbstractPage{


//
//    private final By searchBarLocator = By.id("aso_search_form_anchor");
//    private final By searchBarTextField = By.xpath("//input[@class=\"gb_pe aJh\"]");
//
//    private final By labelsLabel = By.xpath("//span[@role=\"heading\"][@class=\"aAv\"]");
//
//    private final By noMatchMessage = By.className("TC");

    @FindBy(id = "aso_search_form_anchor")
    WebElement emailSearchBar;

    @FindBy(xpath = "//input[@class='gb_qe aJh']" )
    WebElement emailSearchBarTextField;

    @FindBy(xpath = "//span[@role='heading'][@class='aAv']")
    WebElement labelsLabel;

    @FindBy(className = "TC")
    WebElement noMatchMessage;

    public GmailMainPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    public String getLabelsText(){
        return labelsLabel.getText();
    }

    public String searchMailNoMatch(String text){
        waitForElement(emailSearchBar);
        emailSearchBar.click();
        emailSearchBarTextField.sendKeys(text);
        emailSearchBarTextField.sendKeys(Keys.RETURN);
        waitForElement(noMatchMessage);
        return noMatchMessage.getText();
    }
}

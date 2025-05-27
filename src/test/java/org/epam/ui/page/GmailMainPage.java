package org.epam.ui.page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GmailMainPage extends AbstractPage{

    private static final Logger logger = LogManager.getLogger(GmailMainPage.class);

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
        logger.info("Returning Text 'labels' to verify page");
        return labelsLabel.getText();
    }

    public String searchMailNoMatch(String text){
        waitForElement(emailSearchBar);
        logger.info("Clicking into search bar");
        emailSearchBar.click();
        logger.info("Entering sample text into search bar");
        emailSearchBarTextField.sendKeys(text);
        emailSearchBarTextField.sendKeys(Keys.RETURN);
        waitForElement(noMatchMessage);
        logger.info("Retrieving result message");
        return noMatchMessage.getText();
    }
}

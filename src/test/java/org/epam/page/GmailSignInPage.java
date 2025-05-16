package org.epam.page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class GmailSignInPage extends AbstractPage{

    private static final Logger logger = LogManager.getLogger(GmailSignInPage.class);

//    private final By emailFieldLocator = By.xpath("//input[@type=\"email\"]");
//    private final By nextButtonLocator =
//            By.xpath("//span[text()='Next']");
//    private final By passwordFieldLocator = By.xpath("//input[@type=\"password\"]");

    @FindBy(xpath = "//input[@type='email']")
    WebElement emailField;

    @FindBy(xpath = "//input[@type='password']")
    WebElement passwordField;

    @FindBy(xpath = "//span[text()='Next']")
    WebElement nextButton;

    public GmailSignInPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void enterEmail(String email){
        logger.info("Entering email into email field");
        enterText(emailField, email);

    }

    public void enterPassword(String password){
        waitForElement(passwordField);
        logger.info("Entering password into password field");
        enterText(passwordField, password);
    }

    public void clickNextButton(){
        logger.info("Clicking Next button");
        click(nextButton);
    }


}

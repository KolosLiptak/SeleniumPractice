package org.epam.page;

import org.epam.util.Util;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class GmailSignInPage extends AbstractPage{

    public GmailSignInPage(WebDriver driver) {
        super(driver);
    }

    private final By emailFieldLocator = By.xpath("//input[@type=\"email\"]");
    public WebElement emailField = find(emailFieldLocator);

    private final By nextButtonLocator =
            By.xpath("//span[text()='Next']");
    WebElement nextButton = find(nextButtonLocator);

    private final By passwordFieldLocator = By.xpath("//input[@type=\"password\"]");
    WebElement passwordField = find(passwordFieldLocator);


    public void enterEmail(){
        this.sendKeys(emailFieldLocator, Util.EMAIL);
        this.click(nextButtonLocator);
        waitForElement(passwordFieldLocator);

    }

    public void enterPassword(){

        this.sendKeys(passwordFieldLocator, Util.PASSWORD);
        this.click(nextButtonLocator);
    }


    public GmailMainPage login(){
        enterEmail();
        enterPassword();
        return new GmailMainPage(driver);
    }

}

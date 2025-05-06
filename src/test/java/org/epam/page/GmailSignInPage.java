package org.epam.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class GmailSignInPage extends AbstractPage{

    public GmailSignInPage(WebDriver driver) {
        super(driver);
    }

    private final By emailFieldLocator = By.xpath("//input[@type=\"email\"]");
    private final By nextButtonLocator =
            By.xpath("//span[text()='Next']");
    private final By passwordFieldLocator = By.xpath("//input[@type=\"password\"]");

    public void enterEmail(String email){
        this.sendKeys(emailFieldLocator, email);
        this.click(nextButtonLocator);
        waitForElement(passwordFieldLocator);

    }

    public void enterPassword(String password){

        this.sendKeys(passwordFieldLocator, password);
        this.click(nextButtonLocator);
    }


    public GmailMainPage login(String email, String password){
        enterEmail(email);
        enterPassword(password);
        return new GmailMainPage(driver);
    }

}

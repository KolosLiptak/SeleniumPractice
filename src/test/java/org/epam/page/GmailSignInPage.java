package org.epam.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class GmailSignInPage extends AbstractPage{



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
        enterText(emailField, email);

        click(nextButton);
        waitForElement(passwordField);

    }

    public void enterPassword(String password){
        enterText(passwordField, password);
        click(nextButton);
    }
//
//
//    public GmailMainPage login(String email, String password){
//        enterEmail(email);
//        enterPassword(password);
//        return new GmailMainPage(driver);
//    }

//    private void enterText(WebElement element, String text){
//        element.sendKeys(text);
//    }
//
//    private void clickButton(WebElement element){
//        element.click();
//    }

}

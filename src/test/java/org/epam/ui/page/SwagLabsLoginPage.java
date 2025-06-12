package org.epam.ui.page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SwagLabsLoginPage extends AbstractPage{

    @FindBy(id = "user-name")
    WebElement usernameTextBox;
    @FindBy(id = "password")
    WebElement passwordTextBox;
    @FindBy(id = "login-button")
    WebElement loginButton;
    @FindBy(css = "[data-test='error']")
    WebElement errorMessage;

    private static final Logger logger = LogManager.getLogger(SwagLabsLoginPage.class);
    public SwagLabsLoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    public void enterUsername(String username){
        usernameTextBox.click();
        usernameTextBox.sendKeys(username);
        logger.info("Username entered: {}", username);
    }

    public void enterPassword(String password){
        passwordTextBox.click();
        passwordTextBox.sendKeys(password);
        logger.info("Password entered: {}", password);
    }

    public void clickLoginButton(){
        loginButton.click();
        logger.info("Login button clicked");
    }

    public String getErrorMessage() throws InterruptedException {
        return errorMessage.getText();
    }
}

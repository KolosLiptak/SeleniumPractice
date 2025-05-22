package org.epam.page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LambdatestKeyPressPage extends AbstractPage{

//    private final By header = By.xpath("//h1");
//    private final By inputField = By.id("my_field");
//    private final By resultField = By.id("result");

    private static final Logger logger = LogManager.getLogger(LambdatestKeyPressPage.class);


    @FindBy(xpath = "//h1")
    WebElement header;

    @FindBy(id = "my_field")
    WebElement inputField;

    @FindBy(id = "result")
    WebElement resultField;

    public LambdatestKeyPressPage(WebDriver driver) {
        super(driver);
        driver.getCurrentUrl();
        PageFactory.initElements(driver, this);
    }


    public void enterTextToInputField(String text){
        logger.info("Entering text to input field");
        enterText(inputField, text);
        waitForElement(resultField);

    }

    public String getResultFieldText(){
        logger.info("Retrieving text from result field");
        return getText(resultField);
    }


    public String getHeaderText(){
        logger.info("Retrieving text from header");
        return getText(header);
    }
}

package org.epam.page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.epam.driver.DriverSingleton;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LambdatestMainPage extends AbstractPage{
//
//
//    private final By keyPressLink = By.linkText("Key Press");
//    private final By checkBoxDemoLink = By.linkText("Checkbox Demo");

    @FindBy(linkText = "Key Press")
    WebElement keyPressLink;

    @FindBy(linkText = "Checkbox Demo")
    WebElement checkBoxDemoLink;

    public LambdatestMainPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        logger = LogManager.getLogger(LambdatestMainPage.class);
    }
    public LambdatestKeyPressPage navigateToKeyPressPage(){
        click(keyPressLink);
        logger.info("Navigating to Key Press page");
        return new LambdatestKeyPressPage(driver);
    }

    public LambdatestCheckBoxDemoPage navigateToCheckBoxDemoPage(){
        click(checkBoxDemoLink);
        logger.info("Navigating to CheckBox Demo page");
        return new LambdatestCheckBoxDemoPage(driver);
    }
}

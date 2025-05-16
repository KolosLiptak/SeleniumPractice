package org.epam.page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.epam.driver.DriverSingleton;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LambdatestMainPage extends AbstractPage{
    public LambdatestMainPage(WebDriver driver) {
        super(driver);
        logger = LogManager.getLogger(LambdatestMainPage.class);
    }

    private final By keyPressLink = By.linkText("Key Press");
    private final By checkBoxDemoLink = By.linkText("Checkbox Demo");

    public LambdatestKeyPressPage navigateToKeyPressPage(){
        this.click(keyPressLink);
        logger.info("Navigating to Key Press page");
        return new LambdatestKeyPressPage(driver);
    }

    public LambdatestCheckBoxDemoPage navigateToCheckBoxDemoPage(){
        this.click(checkBoxDemoLink);
        logger.info("Navigating to CheckBox Demo page");
        return new LambdatestCheckBoxDemoPage(driver);
    }

}

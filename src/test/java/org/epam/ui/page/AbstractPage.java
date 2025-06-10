package org.epam.ui.page;

import io.qameta.allure.testng.AllureTestNg;
import org.apache.logging.log4j.Logger;
import org.epam.ui.util.TestListener;
import org.epam.ui.util.WaitHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Listeners;


public abstract class AbstractPage {

    protected WebDriver driver;
    protected static Logger logger;
    private WaitHelper waitHelper = new WaitHelper();

    public AbstractPage(WebDriver driver) {
        this.driver = driver;
    }

    protected void click(WebElement element){
        element.click();
    }

    protected void enterText(WebElement element, String keys){
        element.sendKeys(keys);
    }

    protected String getText(WebElement element){
        return element.getText();
    }

    protected void waitForElement(WebElement element){
        waitHelper.waitForElement(driver, element);
    }

}

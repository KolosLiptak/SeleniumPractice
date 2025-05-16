package org.epam.page;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.epam.driver.DriverSingleton;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class AbstractPage {

    protected static WebDriver driver;
    protected static Logger logger;

    public AbstractPage(WebDriver driver) {
        AbstractPage.driver = driver;
    }

    protected WebElement find(By locator){
        return driver.findElement(locator);
    }

    protected void click(WebElement element){
        element.click();
    }

    protected void enterText(WebElement element, String keys){
        element.sendKeys(keys);
    }

//    public void enterText(WebElement element, Keys keys){
//        element.sendKeys(keys);
//    }

    protected String getText(WebElement element){
        return element.getText();
    }

    protected void waitForElement(WebElement element){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

}

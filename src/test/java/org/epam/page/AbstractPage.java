package org.epam.page;

import org.apache.logging.log4j.Logger;
import org.epam.util.TestListener;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Listeners;

import java.time.Duration;

@Listeners(TestListener.class)
public abstract class AbstractPage {

    protected static WebDriver driver;
    protected static Logger logger;

    public AbstractPage(WebDriver driver) {
        AbstractPage.driver = driver;
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
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

}

package org.epam.page;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class AbstractPage {

    protected static WebDriver driver;

    //protected abstract AbstractPage openPage();

    public AbstractPage(WebDriver driver) {
        AbstractPage.driver = driver;
    }

    protected WebElement find(By locator){
        return driver.findElement(locator);
    }

    public void click(By locator){
        find(locator).click();
    }

    public void sendKeys(By locator, String keys){
        find(locator).sendKeys(keys);
    }

    public String getText(By locator){
        return find(locator).getText();
    }

    public void waitForElement(By locator){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

}

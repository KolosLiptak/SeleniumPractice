package org.epam.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class LambdatestCheckBoxDemoPage extends AbstractPage{
    public LambdatestCheckBoxDemoPage(WebDriver driver) {
        super(driver);
    }

    private final By singleCheckBox = By.id("isAgeSelected");
    private final By singleCheckBoxChecked = By.id("txtAge");

    private final By multipleCheckBoxSelectAll = By.id("box");

    public String interactWithSingleCheckBox(){
        this.click(singleCheckBox);
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        return this.getText(singleCheckBoxChecked);
    }

    public void interactWithMultipleCheckBox(){
        this.click(multipleCheckBoxSelectAll);
    }

    public String getButtonText(){
        return driver.findElement(multipleCheckBoxSelectAll).getAttribute("value").toString();
    }
}

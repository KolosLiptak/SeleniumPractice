package org.epam.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v133.page.Page;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class LambdatestCheckBoxDemoPage extends AbstractPage{


//    private final By singleCheckBox = By.id("isAgeSelected");
//    private final By singleCheckBoxChecked = By.id("txtAge");
//
//    private final By multipleCheckBoxSelectAll = By.id("box");
//
    @FindBy(id = "isAgeSelected")
    WebElement singleCheckBox;

    @FindBy(id = "txtAge")
    WebElement singleCheckedCheckBox;

    @FindBy(id = "box")
    WebElement multipleSelectAllCheckBox;

    public LambdatestCheckBoxDemoPage(WebDriver driver) {

        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void clickSingleCheckBox(){
        click(singleCheckBox);
    }

    public String getSingleCheckBoxCheckedText(){
        return getText(singleCheckedCheckBox);
    }

    public void clickSelectAllCheckBox(){
        click(multipleSelectAllCheckBox);
    }

    public String getSelectAllCheckBoxText(){
        return getText(multipleSelectAllCheckBox);
    }

//    public String getButtonText(){
//        return driver.findElement(multipleCheckBoxSelectAll).getAttribute("value").toString();
//    }
}

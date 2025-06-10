package org.epam.ui.page;

import io.qameta.allure.Step;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LambdatestCheckBoxDemoPage extends AbstractPage{


    private static final Logger logger = LogManager.getLogger(LambdatestCheckBoxDemoPage.class);

//    private final By singleCheckBox = By.id("isAgeSelected");
//    private final By singleCheckBoxChecked = By.id("txtAge");
//    private final By multipleCheckBoxSelectAll = By.id("box");

    @FindBy(xpath = "//label[normalize-space()='Click on check box']/input[@type='checkbox']")
    WebElement singleCheckBox;

    @FindBy(css = "button.bg-\\[\\#00c5cd\\].text-white")
    WebElement multipleSelectAllCheckBox;

    public LambdatestCheckBoxDemoPage(WebDriver driver) {

        super(driver);
        driver.getCurrentUrl();
        PageFactory.initElements(driver, this);
    }

    @Step
    public void clickSingleCheckBox(){
        logger.info("Clicking Single CheckBox");
        click(singleCheckBox);
    }

    @Step
    public String getSingleCheckBoxCheckedText(){
        logger.info("Retrieving Single CheckBox Text");
        return getText(singleCheckBox);
    }

    @Step
    public void clickCheckAllCheckBox(){
        logger.info("Clicking SelectAll CheckBox");
        click(multipleSelectAllCheckBox);
    }

    @Step
    public String getCheckAllCheckBoxText(){
        logger.info("Retrieving SelectAll CheckBox Text");
        return getText(multipleSelectAllCheckBox);
    }

//    public String getButtonText(){
//        return driver.findElement(multipleCheckBoxSelectAll).getAttribute("value").toString();
//    }
}

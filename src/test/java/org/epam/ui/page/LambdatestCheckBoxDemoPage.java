package org.epam.ui.page;

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

    @FindBy(id = "isAgeSelected")
    WebElement singleCheckBox;

    @FindBy(id = "txtAge")
    WebElement singleCheckedCheckBox;

    @FindBy(id = "box")
    WebElement multipleSelectAllCheckBox;

    public LambdatestCheckBoxDemoPage(WebDriver driver) {

        super(driver);
        driver.getCurrentUrl();
        PageFactory.initElements(driver, this);
    }

    public void clickSingleCheckBox(){
        logger.info("Clicking Single CheckBox");
        click(singleCheckBox);
    }

    public String getSingleCheckBoxCheckedText(){
        logger.info("Retrieving Single CheckBox Text");
        return getText(singleCheckedCheckBox);
    }

    public void clickCheckAllCheckBox(){
        logger.info("Clicking SelectAll CheckBox");
        click(multipleSelectAllCheckBox);
    }

    public String getCheckAllCheckBoxText(){
        logger.info("Retrieving SelectAll CheckBox Text");
        return getText(multipleSelectAllCheckBox);
    }

//    public String getButtonText(){
//        return driver.findElement(multipleCheckBoxSelectAll).getAttribute("value").toString();
//    }
}

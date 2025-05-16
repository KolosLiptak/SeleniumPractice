package org.epam.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v133.page.Page;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LambdatestKeyPressPage extends AbstractPage{
//
//
//    private final By header = By.xpath("//h1");
//    private final By inputField = By.id("my_field");
//    private final By resultField = By.id("result");

    @FindBy(xpath = "//h1")
    WebElement header;

    @FindBy(id = "my_field")
    WebElement inputField;

    @FindBy(id = "result")
    WebElement resultField;

    public LambdatestKeyPressPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }


    public void enterTextToInputField(String text){
        enterText(inputField, text);
        waitForElement(resultField);

    }

    public String getResultFieldText(){
        return getText(resultField);
    }


    public String getHeaderText(){
        return getText(header);
    }
}

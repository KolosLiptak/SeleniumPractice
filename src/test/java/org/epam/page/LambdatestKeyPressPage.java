package org.epam.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LambdatestKeyPressPage extends AbstractPage{
    public LambdatestKeyPressPage(WebDriver driver) {
        super(driver);
    }

    private final By header = By.xpath("//h1");
    private final By inputField = By.id("my_field");
    private final By resultField = By.id("result");


    public String enterTextToInputField(String text){
        this.sendKeys(inputField, text);
        waitForElement(resultField);
        return this.getText(resultField);
    }


    public String getHeaderText(){
        return this.getText(header);
    }
}

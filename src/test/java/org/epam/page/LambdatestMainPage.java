package org.epam.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LambdatestMainPage extends AbstractPage{
    public LambdatestMainPage(WebDriver driver) {
        super(driver);
    }

    private final By keyPressLink = By.linkText("Key Press");
    private final By checkBoxDemoLink = By.linkText("Checkbox Demo");

    public LambdatestKeyPressPage navigateToKeyPressPage(){
        this.click(keyPressLink);
        return new LambdatestKeyPressPage(driver);
    }

    public LambdatestCheckBoxDemoPage navigateToCheckBoxDemoPage(){
        this.click(checkBoxDemoLink);
        return new LambdatestCheckBoxDemoPage(driver);
    }

}

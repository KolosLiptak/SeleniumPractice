package org.epam.test;

import org.epam.page.LambdatestCheckBoxDemoPage;
import org.epam.page.LambdatestKeyPressPage;
import org.epam.page.LambdatestMainPage;
import org.epam.util.Util;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LambdatestTest extends AbstractTest{


    private LambdatestMainPage lambdatestMainPage;
    private LambdatestKeyPressPage lambdatestKeyPressPage;
    private LambdatestCheckBoxDemoPage lambdatestCheckBoxDemoPage;

    @BeforeClass
    public void setUp(){
        super.setUp();
        driver.get(Util.LAMBDATEST_URL);

        if(driver.findElement(By.id("CybotCookiebotDialogBodyLevelButtonLevelOptinAllowAll")).isDisplayed()) {
            driver.findElement(By.id("CybotCookiebotDialogBodyLevelButtonLevelOptinAllowAll")).click();
        }

        lambdatestMainPage = new LambdatestMainPage(driver);

    }

//    @Test
//    public void keyPressPageTest(){
//
//        lambdatestKeyPressPage = lambdatestMainPage.navigateToKeyPressPage();
//
//        Assert.assertEquals(lambdatestKeyPressPage.getHeaderText(), "Key Press");
//
//        String resultOfInput = lambdatestKeyPressPage.enterTextToInputField(Util.INVALID_TEXT).toLowerCase();
//
//        String expectedResultOfInput = Util.INVALID_TEXT.toLowerCase();
//
//        Assert.assertEquals(resultOfInput.charAt(resultOfInput.length()-1),
//                            expectedResultOfInput.charAt(expectedResultOfInput.length()-1));
//
//        driver.navigate().to(Util.LAMBDATEST_URL);
//
//        lambdatestCheckBoxDemoPage = lambdatestMainPage.navigateToCheckBoxDemoPage();
//
//        String expectedResultOfButton = lambdatestCheckBoxDemoPage.getButtonText();
//
//        Assert.assertEquals(expectedResultOfButton, "Check All");
//
//
//
//        lambdatestCheckBoxDemoPage.interactWithMultipleCheckBox();
//
//        expectedResultOfButton = lambdatestCheckBoxDemoPage.getButtonText();
//
//        Assert.assertEquals(expectedResultOfButton, "Uncheck All");
//
//        String singleCheckBoxChecked = lambdatestCheckBoxDemoPage.interactWithSingleCheckBox();
//
//        Assert.assertEquals(singleCheckBoxChecked, "Checked");
//
//        singleCheckBoxChecked = lambdatestCheckBoxDemoPage.interactWithSingleCheckBox();
//
//        Assert.assertEquals(singleCheckBoxChecked, "");
//
//    }

    @Test
    public void navigateToKeyPressPageTest(){
        lambdatestKeyPressPage = lambdatestMainPage.navigateToKeyPressPage();
        Assert.assertEquals(lambdatestKeyPressPage.getHeaderText(), "Key Press");
    }

    @Test(dependsOnMethods = {"navigateToKeyPressPageTest"})
    public void enterTextToKeyPressPageTest(){

        String expectedResultOfInput = Util.INVALID_TEXT.toLowerCase();
        lambdatestKeyPressPage.enterTextToInputField(Util.INVALID_TEXT);
        String actualResultOfInput = lambdatestKeyPressPage.getResultFieldText().toLowerCase();

        Assert.assertEquals(actualResultOfInput.charAt(actualResultOfInput.length()-1),
                expectedResultOfInput.charAt(expectedResultOfInput.length()-1));

    }

    @Test(dependsOnMethods = {"enterTextToKeyPressPageTest"})
    public void navigateToCheckBoxDemoPageTest(){
        driver.navigate().to(Util.LAMBDATEST_URL);

        lambdatestCheckBoxDemoPage = lambdatestMainPage.navigateToCheckBoxDemoPage();

        String expectedResultOfButton = lambdatestCheckBoxDemoPage.getSelectAllCheckBoxText();

        Assert.assertEquals(expectedResultOfButton, "");
    }

    @Test(dependsOnMethods = {"navigateToCheckBoxDemoPageTest"})
    public void clickOnSingleCheckBoxTest(){
        lambdatestCheckBoxDemoPage.clickSingleCheckBox();
        String expectedResult = lambdatestCheckBoxDemoPage.getSingleCheckBoxCheckedText();
        Assert.assertEquals(expectedResult, "Checked");
    }

    @Test(dependsOnMethods = {"clickOnSingleCheckBoxTest"})
    public void clickOffSingleCheckBoxTest(){
        lambdatestCheckBoxDemoPage.clickSingleCheckBox();
        String expectedResult = lambdatestCheckBoxDemoPage.getSingleCheckBoxCheckedText();
        Assert.assertEquals(expectedResult, "");
    }

    @Test(dependsOnMethods = {"clickOffSingleCheckBoxTest"})
    public void clickSelectAllCheckBoxTest(){
        lambdatestCheckBoxDemoPage.clickSelectAllCheckBox();
        String expectedResult = lambdatestCheckBoxDemoPage.getSelectAllCheckBoxText();
        Assert.assertEquals(expectedResult, "");
    }
}

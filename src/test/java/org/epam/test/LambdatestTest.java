package org.epam.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.epam.page.LambdatestCheckBoxDemoPage;
import org.epam.page.LambdatestKeyPressPage;
import org.epam.page.LambdatestMainPage;
import org.epam.util.Util;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class LambdatestTest extends AbstractTest{


    private LambdatestMainPage lambdatestMainPage;
    private LambdatestKeyPressPage lambdatestKeyPressPage;
    private LambdatestCheckBoxDemoPage lambdatestCheckBoxDemoPage;

    private static final Logger logger = LogManager.getLogger(LambdatestTest.class);



    @BeforeClass
    public void setUp(){
        super.setUp();
        driver.get(Util.LAMBDATEST_URL);

        try {
            if(driver.findElement(By.id("CybotCookiebotDialogBodyLevelButtonLevelOptinAllowAll")).isDisplayed()) {
                logger.warn("Cookies popup appeared");
                driver.findElement(By.id("CybotCookiebotDialogBodyLevelButtonLevelOptinAllowAll")).click();
                logger.warn("Cookies popup accepted");
            }
        } catch (Exception e) {
            logger.error("Cookies popup exception occurred{}", String.valueOf(e));
        }

        lambdatestMainPage = new LambdatestMainPage(driver);

    }


    @Test
    public void navigateToKeyPressPageTest(){
        lambdatestKeyPressPage = lambdatestMainPage.navigateToKeyPressPage();
        logger.info("Navigated to Key Press page");
        Assert.assertEquals(lambdatestKeyPressPage.getHeaderText(), "Key Press");
    }

    @Test(dependsOnMethods = {"navigateToKeyPressPageTest"})
    public void enterTextToKeyPressPageTest(){

        String expectedResultOfInput = Util.INVALID_TEXT.toLowerCase();
        lambdatestKeyPressPage.enterTextToInputField(Util.INVALID_TEXT);
        logger.info("Entered text to Key Press page input field");
        String actualResultOfInput = lambdatestKeyPressPage.getResultFieldText().toLowerCase();

        Assert.assertEquals(actualResultOfInput.charAt(actualResultOfInput.length()-1),
                expectedResultOfInput.charAt(expectedResultOfInput.length()-1));

    }

    @Test(dependsOnMethods = {"enterTextToKeyPressPageTest"})
    public void navigateToCheckBoxDemoPageTest(){
        driver.navigate().to(Util.LAMBDATEST_URL);


        lambdatestCheckBoxDemoPage = lambdatestMainPage.navigateToCheckBoxDemoPage();
        logger.info("Navigated to CheckBox Demo page");
        String expectedResult = lambdatestCheckBoxDemoPage.getCheckAllCheckBoxText();

        Assert.assertEquals(expectedResult, "");

    }

    @Test(dependsOnMethods = {"navigateToCheckBoxDemoPageTest"})
    public void clickOnSingleCheckBoxTest(){
        clickSingleCheckBox();
        String expectedResult = lambdatestCheckBoxDemoPage.getSingleCheckBoxCheckedText();
        Assert.assertEquals(expectedResult, "Checked");
    }

    @Test(dependsOnMethods = {"clickOnSingleCheckBoxTest"})
    public void clickOffSingleCheckBoxTest(){
        clickSingleCheckBox();
        String expectedResult = lambdatestCheckBoxDemoPage.getSingleCheckBoxCheckedText();
        Assert.assertEquals(expectedResult, "");

    }

    private void clickSingleCheckBox() {
        lambdatestCheckBoxDemoPage.clickSingleCheckBox();
        logger.info("Clicked Single CheckBox");
    }

    @Test(dependsOnMethods = {"clickOffSingleCheckBoxTest"})
    public void clickCheckAllCheckBoxTest(){
        lambdatestCheckBoxDemoPage.clickCheckAllCheckBox();
        logger.info("Clicked CheckAll CheckBox");
        String expectedResult = lambdatestCheckBoxDemoPage.getCheckAllCheckBoxText();
        Assert.assertEquals(expectedResult, "");

    }
}

package org.epam.test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.epam.page.GmailMainPage;
import org.epam.page.GmailSignInPage;
import org.epam.util.Util;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class GmailSignInTest {

    private GmailSignInPage gmailSignInPage;
    private GmailMainPage gmailMainPage;
    private WebDriver driver;

    @BeforeClass
    public void setUp(){
        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get(Util.MAIL_URL);
        gmailSignInPage = new GmailSignInPage(driver);
    }

    @AfterClass
    public void finish(){
        driver.quit();
    }

    @Test
    public void signInTest(){

        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

        gmailMainPage = gmailSignInPage.login();

        String expectedText = "Labels";
        Assert.assertEquals(gmailMainPage.getLabelsText(), expectedText);

    }
}

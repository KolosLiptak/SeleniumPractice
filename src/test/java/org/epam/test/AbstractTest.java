package org.epam.test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.epam.page.GmailSignInPage;
import org.epam.util.Util;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class AbstractTest {

    protected WebDriver driver;



    @BeforeClass
    public void setUp(){
        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();
        driver.manage().window().maximize();

    }

    @AfterClass
    public void finish(){
        driver.quit();
    }
}

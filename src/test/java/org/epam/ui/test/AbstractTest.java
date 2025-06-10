package org.epam.ui.test;


import io.qameta.allure.testng.AllureTestNg;
import org.epam.ui.driver.DriverSingleton;
import org.epam.ui.util.TestListener;
import org.openqa.selenium.WebDriver;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;


public class AbstractTest {

    protected WebDriver driver;

    @BeforeClass
    public void setUp(){
        driver = DriverSingleton.getDriver();
    }
    @AfterClass
    public void finish(){
        DriverSingleton.closeDriver();
    }
}

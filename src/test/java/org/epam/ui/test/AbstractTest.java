package org.epam.ui.test;


import org.epam.ui.driver.DriverSingleton;
import org.epam.ui.util.TestListener;
import org.openqa.selenium.WebDriver;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;

@Listeners(TestListener.class)
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

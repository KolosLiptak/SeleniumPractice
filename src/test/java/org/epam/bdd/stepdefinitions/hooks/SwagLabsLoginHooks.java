package org.epam.bdd.stepdefinitions.hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.epam.ui.driver.DriverSingleton;
import org.openqa.selenium.WebDriver;

public class SwagLabsLoginHooks {

    private static WebDriver driver;

    @Before
    public void setUp(){
        driver = DriverSingleton.getDriver();
    }

    @After
    public void close(){
        DriverSingleton.closeDriver();
    }

    public WebDriver getDriver(){
        return driver;
    }
}

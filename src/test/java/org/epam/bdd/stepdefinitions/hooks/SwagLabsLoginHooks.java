package org.epam.bdd.stepdefinitions.hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.epam.ui.driver.DriverSingleton;
import org.openqa.selenium.WebDriver;

public class SwagLabsLoginHooks {

    public static WebDriver driver;

    @Before
    public void setUp(){
        driver = DriverSingleton.getDriver();
    }

    @After
    public void close(){
        DriverSingleton.closeDriver();
    }
}

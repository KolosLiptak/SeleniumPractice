package org.epam.driver;

import org.apache.logging.log4j.LogManager;

import org.openqa.selenium.WebDriver;


import org.apache.logging.log4j.Logger;

public class DriverSingleton {

    private static WebDriver driver;
    private static final Logger logger = LogManager.getLogger(DriverSingleton.class);


    private DriverSingleton(){}

    public static WebDriver getDriver() {
        if (driver == null) {
            driver = DriverFactory.createDriver();
        }

        return driver;
    }

    public static void closeDriver(){
        if(driver != null){
            driver.quit();
            driver = null;
            logger.info("Closed browser");
        }
    }
}

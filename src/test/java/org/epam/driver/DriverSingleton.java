package org.epam.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.epam.util.ConfigReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.Logger;

public class DriverSingleton {

    private static WebDriver driver;
    private static final Logger logger = LogManager.getLogger(DriverSingleton.class);


    private DriverSingleton(){}

    public static WebDriver getDriver() {
        if (driver == null) {

            driver = DriverFactory.createDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

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

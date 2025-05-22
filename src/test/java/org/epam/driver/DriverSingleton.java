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

            String browser = ConfigReader.getData("browser");
            logger.info("Starting browser {}", browser);

            switch (browser){
                case "chrome" : {
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    break;
                }
                case "firefox" : {
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;
                }
                default : {
                    WebDriverManager.edgedriver().setup();
                    driver = new EdgeDriver();
                    browser = "edge";
                    logger.warn("Incorrect browser property, switched to Edge");
                    break;
                }
            }
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            logger.info("Started browser {}", browser);
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

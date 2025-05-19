package org.epam.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.epam.util.ConfigReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {

    private static final Logger logger = LogManager.getLogger(DriverFactory.class);

    public static WebDriver createDriver(){

        String browser = ConfigReader.getData("browser");
        logger.info("Creating browser {}", browser);
        switch (browser){
            case "chrome" : {
                WebDriverManager.chromedriver().setup();

                return new ChromeDriver();
            }
            case "firefox" : {
                WebDriverManager.firefoxdriver().setup();
                return new FirefoxDriver();
            }
            default : {
                WebDriverManager.edgedriver().setup();

                browser = "edge";
                logger.warn("Incorrect browser property, switched to Edge");
                return new EdgeDriver();
            }
        }
    }
}

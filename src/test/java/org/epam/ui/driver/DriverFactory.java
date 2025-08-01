package org.epam.ui.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.epam.ui.util.ConfigReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class DriverFactory {

    private static final Logger logger = LogManager.getLogger(DriverFactory.class);

    public static WebDriver createDriver(){

        WebDriver baseDriver;
        String browser = ConfigReader.getData("browser");

        switch (browser){
            case "chrome" : {
                WebDriverManager.chromedriver().setup();
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--incognito");
                baseDriver = new ChromeDriver(chromeOptions);
                break;
            }
            case "firefox" : {
                WebDriverManager.firefoxdriver().setup();
                baseDriver =  new FirefoxDriver();
                break;
            }
            default : {
                WebDriverManager.edgedriver().setup();
                browser = "edge";
                logger.warn("Incorrect browser property, switched to Edge");
                baseDriver = new EdgeDriver();
            }
        }
        baseDriver.manage().window().maximize();
        baseDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        logger.info("Creating browser {}", browser);

        return new LoggingWebDriver(baseDriver);
    }
}

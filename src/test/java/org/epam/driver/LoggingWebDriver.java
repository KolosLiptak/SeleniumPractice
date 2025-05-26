package org.epam.driver;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jspecify.annotations.Nullable;
import org.openqa.selenium.*;

import java.util.List;
import java.util.Set;

public class LoggingWebDriver implements WebDriver, TakesScreenshot {

    private static final Logger logger = LogManager.getLogger(LoggingWebDriver.class);
    private final WebDriver driver;

    public LoggingWebDriver(WebDriver driver){
        this.driver = driver;
    }
    @Override
    public void get(String url) {
        logger.info("Navigated to {}", url);
        driver.get(url);
    }

    @Override
    public @Nullable String getCurrentUrl() {
        logger.info("Navigated to {}", driver.getCurrentUrl());
        return driver.getCurrentUrl();
    }

    @Override
    public @Nullable String getTitle() {
        return driver.getTitle();
    }

    @Override
    public List<WebElement> findElements(By by) {
        return driver.findElements(by);
    }

    @Override
    public WebElement findElement(By by) {
        return driver.findElement(by);
    }

    @Override
    public @Nullable String getPageSource() {
        return driver.getPageSource();
    }

    @Override
    public void close() {
        driver.close();
    }

    @Override
    public void quit() {
        driver.quit();
    }

    @Override
    public Set<String> getWindowHandles() {
        return driver.getWindowHandles();
    }

    @Override
    public String getWindowHandle() {
        return driver.getWindowHandle();
    }

    @Override
    public TargetLocator switchTo() {
        return driver.switchTo();
    }

    @Override
    public Navigation navigate() {
        return new LoggingNavigation(driver.navigate());
    }

    @Override
    public Options manage() {
        return driver.manage();
    }

    @Override
    public <X> X getScreenshotAs(OutputType<X> target) throws WebDriverException {
        if (driver instanceof TakesScreenshot) {
            return ((TakesScreenshot) driver).getScreenshotAs(target);
        } else {
            logger.error("Underlying driver does not support creating a screenshot");
            throw new UnsupportedOperationException("Underlying driver does not support screenshots");
        }
    }
}

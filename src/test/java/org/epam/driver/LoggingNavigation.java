package org.epam.driver;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import java.net.URL;

public class LoggingNavigation implements WebDriver.Navigation {

    private final WebDriver.Navigation navigator;
    private static final Logger logger = LogManager.getLogger(LoggingNavigation.class);

    public LoggingNavigation(WebDriver.Navigation navigator){
        this.navigator = navigator;
    }
    @Override
    public void back() {
        navigator.back();
    }

    @Override
    public void forward() {
        navigator.forward();
    }

    @Override
    public void to(String url) {
        logger.info("Navigated to {}", url);
        navigator.to(url);
    }

    @Override
    public void to(URL url) {
        navigator.to(url);
    }

    @Override
    public void refresh() {
        navigator.refresh();
    }
}

package org.epam.util;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.epam.driver.DriverSingleton;
import org.epam.test.AbstractTest;
import org.epam.test.LambdatestTest;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class TestListener implements ITestListener {


    private static final Logger logger = LogManager.getLogger(TestListener.class);
    private final ScreenshotHelper screenshotHelper = new ScreenshotHelper();

    @Override
    public void onTestFailure(ITestResult result) {
        screenshotHelper.takeScreenshot();
    }

}
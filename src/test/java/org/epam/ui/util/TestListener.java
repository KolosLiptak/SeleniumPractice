package org.epam.ui.util;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestListener;
import org.testng.ITestResult;



public class TestListener implements ITestListener {


    private static final Logger logger = LogManager.getLogger(TestListener.class);
    private final ScreenshotHelper screenshotHelper = new ScreenshotHelper();

    @Override
    public void onTestFailure(ITestResult result) {
        screenshotHelper.takeScreenshot();
    }

}
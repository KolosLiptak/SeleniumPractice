package org.epam.ui.util;

import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import io.qameta.allure.testng.AllureTestNg;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.epam.ui.driver.DriverSingleton;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.Listeners;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class ScreenshotHelper {

    private static final Logger logger = LogManager.getLogger(ScreenshotHelper.class);


    @Attachment(value = "Screenshot on Failure", type = "image/png")
    public byte[] takeScreenshot() {
        File screenCapture = ((TakesScreenshot) DriverSingleton
                .getDriver())
                .getScreenshotAs(OutputType.FILE);
        try {
            String filePath = "screenshots/" + getCurrentTimeAsString() + ".png";
            FileUtils.copyFile(screenCapture, new File(
                    filePath));

            logger.warn("Screenshot of a failed test has been created");
            Allure.addAttachment(filePath, FileUtils.openInputStream(screenCapture));
            return FileUtils.readFileToByteArray(screenCapture);


        } catch (IOException e) {
            logger.error("Failed to create screenshot of a failed test");
            return new byte[0];
        }
    }


    private String getCurrentTimeAsString(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss");
        return ZonedDateTime.now().format(formatter);
    }
}

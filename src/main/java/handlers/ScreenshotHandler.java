package handlers;

import io.appium.java_client.AppiumDriver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;

import java.io.File;
import java.io.IOException;

public class ScreenshotHandler {
    public static void captureScreenshot(AppiumDriver driver, String fullPath) throws IOException {
        File screenshotFile = driver.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenshotFile, new File(fullPath));
    }
}
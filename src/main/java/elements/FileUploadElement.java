package elements;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

import java.io.*;

public class FileUploadElement extends BaseElement {
    public FileUploadElement(AppiumDriver driver, By selector) {
        super(driver, selector);
    }

    public void selectFile(String xpath, String filePath) {
        String fullPath = (new File(filePath)).getAbsolutePath();
        appiumDriver.executeScript("WebElement element = document.evaluate('" + xpath + "', document, null, 9, null).singleNodeValue;");
        appiumDriver.findElement(By.xpath(xpath)).sendKeys(fullPath);
    }
}
package handlers;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;

public class FocusHandler {
    public static void focusElement(AppiumDriver appiumDriver, WebElement element) {
        appiumDriver.executeScript("arguments[0].focus();", element);
    }
}
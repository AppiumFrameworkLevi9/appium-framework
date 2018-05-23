package elements;

import handlers.FocusHandler;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class InputElement extends BaseElement {
    public InputElement(AppiumDriver driver, By selector) {
        super(driver, selector);
    }

    public void sendKeys(String keys) {
        clearField();
        element.sendKeys(keys);
    }

    public void clearField() {
        element.clear();
    }

    public void focusElement() {
        FocusHandler.focusElement(appiumDriver, element);
    }
}
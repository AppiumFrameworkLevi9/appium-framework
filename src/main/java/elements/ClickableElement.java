package elements;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class ClickableElement extends BaseElement {
    public ClickableElement(AppiumDriver driver, By selector) {
        super(driver, selector);
    }

    public void click() {
        element.click();
    }

    public boolean isDisplayed() {
        return element.isDisplayed();
    }

    public boolean isEnabled() {
        return element.isEnabled();
    }
}
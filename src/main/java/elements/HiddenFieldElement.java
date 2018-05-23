package elements;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class HiddenFieldElement extends BaseElement {
    public HiddenFieldElement(AppiumDriver driver, By selector) {
        super(driver, selector);
    }

    public void setFieldValue(String value) {
        appiumDriver.executeScript("arguments[0].value='" + value + "';", element);
    }
}
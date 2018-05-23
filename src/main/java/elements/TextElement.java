package elements;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class TextElement extends BaseElement {
    public TextElement(AppiumDriver driver, By selector) {
        super(driver, selector);
    }

    public String getValue() {
        return getAttribute("value");
    }

    public String getText() {
        return element.getText();
    }
}
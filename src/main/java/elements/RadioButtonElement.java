package elements;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class RadioButtonElement extends BaseElement {
    public RadioButtonElement(AppiumDriver driver, By selector) {
        super(driver, selector);
    }

    public void selectValue() {
        element.click();
    }

    public String getValue() {
        return getAttribute("value");
    }

    public boolean isSelected() {
        return element.isSelected();
    }

    public void iterateRadioButtons(AppiumDriver driver, By by, String value) {
        List<WebElement> webElements= driver.findElements(by);
        for (WebElement rb : webElements) {
            if(rb.getAttribute("value").equals(value)) {
                rb.click();
            }
        }
    }
}
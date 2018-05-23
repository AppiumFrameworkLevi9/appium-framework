package elements;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class CheckBoxElement extends BaseElement {
    public CheckBoxElement(AppiumDriver driver, By selector) {
        super(driver, selector);
    }

    public void select() {
        if(!isSelected()){
            element.click();
        }
    }

    private boolean isSelected() {
        return element.isSelected();
    }

    public void unSelect() {
        if(isSelected()) {
            element.click();
        }
    }

    public String getValue() {
        return getAttribute("value");
    }

    public boolean isEnabled() {
        return element.isEnabled();
    }
}
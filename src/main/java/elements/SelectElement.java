package elements;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class SelectElement extends BaseElement {
    public SelectElement(AppiumDriver driver, By selector) {
        super(driver, selector);
    }

    public void selectByText(String text) {
        Select select = new Select(element);
        select.selectByVisibleText(text);
    }

    public void selectByValue(String value) {
        Select select = new Select(element);
        select.selectByValue(value);
    }

    public void selectMultipleValues(List<String> texts) {
        Select select = new Select(element);

        for(String text : texts) {
            select.selectByVisibleText(text);
        }
    }

    public void deselectByText(String text) {
        Select select = new Select(element);
        select.deselectByVisibleText(text);
    }

    public void deselectAll() {
        Select select = new Select(element);
        select.deselectAll();
    }
}
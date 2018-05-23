package elements;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public abstract class BaseElement {
    // TODO: make both variables final
    protected AppiumDriver appiumDriver;
    protected By elementSelector;

    protected BaseElement(AppiumDriver driver, By selector){
        appiumDriver = driver;
        elementSelector = selector;
    }

    public WebElement element = appiumDriver.findElement(elementSelector);

    public String getAttribute(String attribute){
        return element.getAttribute(attribute);
    }
}
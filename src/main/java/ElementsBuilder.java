import elements.*;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.function.Function;

public class ElementsBuilder implements IElementsBuilder{
    private final HashMap<Type, Object> supportedTypesCatalogue = new HashMap<Type, Object>();

    private Object createCheckboxElement(AppiumDriver driver, By selector) {
        return new CheckBoxElement(driver, selector);
    }

    public void registerAppiumFrameworkTypes() {
        Element checkboxElement = (driver, selector) -> new CheckBoxElement(driver, selector);
        Element clickableElement = (driver, selector) -> new ClickableElement(driver, selector);
        Element fileUploadElement = (driver, selector) -> new CheckBoxElement(driver, selector);
        Element inputElement = (driver, selector) -> new CheckBoxElement(driver, selector);
        Element radioButtonElement = (driver, selector) -> new CheckBoxElement(driver, selector);
        Element selectElement = (driver, selector) -> new CheckBoxElement(driver, selector);
        Element tableElement = (driver, selector) -> new CheckBoxElement(driver, selector);
        Element textElement = (driver, selector) -> new CheckBoxElement(driver, selector);
        Element webElement = (driver, selector) -> driver.findElement(selector);

        supportedTypesCatalogue.put(CheckBoxElement.class, checkboxElement);
        supportedTypesCatalogue.put(ClickableElement.class, clickableElement);
        supportedTypesCatalogue.put(FileUploadElement.class, fileUploadElement);
        supportedTypesCatalogue.put(InputElement.class, inputElement);
        supportedTypesCatalogue.put(RadioButtonElement.class, radioButtonElement);
        supportedTypesCatalogue.put(SelectElement.class, selectElement);
        supportedTypesCatalogue.put(TableElement.class, tableElement);
        supportedTypesCatalogue.put(TextElement.class, textElement);
        supportedTypesCatalogue.put(WebElement.class, webElement);
    }

    public Object buildElement(Type elementType, AppiumDriver driver, By selector) {
        if(!supportedTypesCatalogue.containsKey(elementType))
            throw new UnsupportedOperationException("Type " + elementType + " is not supported");

        return supportedTypesCatalogue.get(elementType);
    }

}

interface Element {
    Object createElement(AppiumDriver driver, By selector);
}
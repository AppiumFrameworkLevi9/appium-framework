import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.lang.reflect.Type;

public interface IElementsBuilder {
    Object buildElement(Type elementType, AppiumDriver driver, By selector);
}

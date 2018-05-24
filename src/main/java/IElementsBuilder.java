import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.lang.reflect.Type;

public interface IElementsBuilder {
    Object BuildElement(Type elementType, WebDriver driver, By selector);
}

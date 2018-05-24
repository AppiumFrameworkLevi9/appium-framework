import org.openqa.selenium.By;

public class SelectorExtensionMethods {
    public static By MapToSeleniumBy(SelectorAttribute selector) throws UnsupportedOperationException {
        switch (selector.getType()) {
            case Id:
                return By.id(selector.getValue());
            case Name:
                return By.name(selector.getValue());
            case TagName:
                return By.tagName(selector.getValue());
            case ClassName:
                return By.className(selector.getValue());
            case CssSelector:
                return By.cssSelector(selector.getValue());
            case LinkText:
                return By.linkText(selector.getValue());
            case PartialLinkText:
                return By.partialLinkText(selector.getValue());
            case XPath:
                return By.xpath(selector.getValue());
            default:
                throw new UnsupportedOperationException("Mapping for selector type: " + selector.getType().toString() + " is not supported.");
        }
    }
}

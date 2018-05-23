package elements;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class TableElement extends BaseElement {
    public TableElement(AppiumDriver driver, By selector) {
        super(driver, selector);
    }

    public WebElement getCellByContent(String content) {
        return element.findElement(By.xpath("//td[contains(.,'" + content + "')]"));
    }

    public String getCellTextByLocator(By locator) {
        return element.findElement(locator).getText();
    }

    public List getElementsByRow() {
        List<WebElement> rows = element.findElements(By.tagName("tr"));
        List<String> elements = new ArrayList<>();
        for(WebElement row : rows) {
            elements.add(row.getText());
        }
        return elements;
    }

    public List getHeaders() {
        List<WebElement> headers = element.findElements(By.tagName("th"));
        List<String> elements = new ArrayList<>();
        for(WebElement header : headers) {
            elements.add(header.getText());
        }
        return headers;
    }

    public int getRowSize() {
        List<WebElement> rows = element.findElements(By.tagName("tr"));
        return rows.size();
    }

    public int getColumnSize() {
        List<WebElement> columns = element.findElements(By.tagName("th"));
        return columns.size();
    }
}
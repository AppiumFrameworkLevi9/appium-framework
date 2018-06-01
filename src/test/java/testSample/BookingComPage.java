package testSample;

import baseFolder.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class BookingComPage {
    @FindBy(how = How.ID, using = "input_destination")
    public WebElement destination;
}
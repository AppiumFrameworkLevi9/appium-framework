package testSample;

import elements.InputElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class BookingComPage {
    @FindBy(how = How.ID, using = "input_destination")
    public InputElement destination;
}

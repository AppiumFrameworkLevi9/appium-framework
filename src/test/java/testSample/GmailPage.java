package testSample;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class GmailPage {
    @FindBy(how = How.ID, using = "com.google.android.gm:id/search")
    public WebElement search;
}

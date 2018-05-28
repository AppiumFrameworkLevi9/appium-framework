package testSample;

import baseFolder.BaseTest;
import handlers.WaitHandler;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class BookingComTest extends BaseTest {
    public static final String PROPERTIES_CSV = "../../src/test/resources/data/Properties1.csv";

    @ParameterizedTest
    @CsvFileSource(resources = PROPERTIES_CSV)
    @BeforeClass
    public void setUp(String appPackage, String appActivity, String platformAndroid, String deviceNameAndroid, String url, String platformName, String platformVersion, String platfromIOS, String deviceNameIOS, String automationName) throws IOException {
        super.setUp(appPackage, appActivity, platformAndroid, deviceNameAndroid, url, platformName, platformVersion, platfromIOS, deviceNameIOS, automationName);
    }

    @Test
    public void BookingComTest() {

        BookingComPage page = PageFactory.initElements(driver, BookingComPage.class);

        page.destination.sendKeys("test");

        WaitHandler.waitAdditional(5);
    }
}
package testSample;

import baseFolder.BaseTest;
import handlers.WaitHandler;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.*;

import java.io.IOException;

public class BookingComTest extends BaseTest {
    private static final String URL = "http://booking.com";

    @Parameters({ "appPackage", "appActivity", "platformAndroid", "deviceNameAndroid", "url", "platformName",
            "platformVersion", "platformIOS", "deviceNameIOS", "browserName"})

    @BeforeClass
    public void setUp(@Optional("") String appPackage,
                      @Optional("") String appActivity,
                      @Optional("") String platformAndroid, @Optional("emulator-5554") String deviceNameAndroid,
                      @Optional("http://127.0.0.1:4723/wd/hub") String url, @Optional("") String platformName,
                      @Optional("") String platformVersion, @Optional("") String platformIOS,
                      @Optional("") String deviceNameIOS, @Optional("Chrome") String browserName) throws IOException {
        super.setUp(appPackage, appActivity, platformAndroid, deviceNameAndroid, url, platformName, platformVersion, platformIOS, deviceNameIOS, browserName);
    }

    @Test
    public void bookingComTest() {

        driver.navigate().to(URL);

        BookingComPage page = PageFactory.initElements(driver, BookingComPage.class);

        page.destination.sendKeys("test");

        WaitHandler.waitAdditional(2);
    }

    @AfterClass
    public void tearDown() {
        super.tearDown();
    }
}
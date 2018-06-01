package testSample;

import baseFolder.BaseTest;
import handlers.WaitHandler;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.*;

import java.io.IOException;

import static handlers.ActionHandler.goBack;

public class GmailSampleTest extends BaseTest {
    @Parameters({ "appPackage", "appActivity", "platformAndroid", "deviceNameAndroid", "url", "platformName",
            "platformVersion", "platformIOS", "deviceNameIOS", "browserName"})

    @BeforeClass
    public void setUp(@Optional("com.google.android.gm") String appPackage,
                      @Optional("com.google.android.gm.ConversationListActivityGmail") String appActivity,
                      @Optional("") String platformAndroid, @Optional("emulator-5554") String deviceNameAndroid,
                      @Optional("http://127.0.0.1:4723/wd/hub") String url, @Optional("") String platformName,
                      @Optional("") String platformVersion, @Optional("") String platformIOS,
                      @Optional("") String deviceNameIOS, @Optional("") String browserName) throws IOException {
        super.setUp(appPackage, appActivity, platformAndroid, deviceNameAndroid, url, platformName, platformVersion, platformIOS, deviceNameIOS, browserName);
    }

    @Test
    public void gmailTest() {
        GmailPage page = PageFactory.initElements(driver, GmailPage.class);

        goBack(driver);

        page.search.click();

        WaitHandler.waitAdditional(2);
    }

    @AfterClass
    public void tearDown() {
        super.tearDown();
    }
}

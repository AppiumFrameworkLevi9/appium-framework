package testSample;

import handlers.WaitHandler;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;

import java.net.MalformedURLException;
import java.net.URL;

public class BookingComTest {
    public static void main(String[] args) throws MalformedURLException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability(CapabilityType.BROWSER_NAME, "Chrome");
        desiredCapabilities.setCapability(CapabilityType.PLATFORM_NAME, "Android");
        desiredCapabilities.setCapability(CapabilityType.VERSION, "8.0");
        desiredCapabilities.setCapability("deviceName", "device");
        desiredCapabilities.setCapability("udid", "ce0317130a9f1f1602");
        AppiumDriver driver = new AppiumDriver(new URL("http://127.0.0.1:4723/wd/hub"), desiredCapabilities);
        driver.get("http://booking.com");

        BookingComPage page = PageFactory.initElements(driver, BookingComPage.class);

        page.destination.sendKeys("test");

        WaitHandler.waitAdditional(5);
    }
}

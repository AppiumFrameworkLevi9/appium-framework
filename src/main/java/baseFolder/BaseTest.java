package baseFolder;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import static baseFolder.BasePage.getValueFromProperties;

public class BaseTest {
    protected AppiumDriver driver;
    private String iOSDevice;
    private String url;
    DesiredCapabilities capabilities;

    private static final String NOT_RECOGNIZED = "Platform is not recognized";
    private static final String USER_DIR = "user.dir";
    private static final String OBJECTIVE_C_EXTENSION = "//objC.txt";
    private static final String OBJECTIVE_C_APP = "";   // Add Objective-C ipa name
    private static final String SWIFT_APP = ""; // Add Swift ipa name

    public void setUp(String appPackage, String appActivity, String platformAndroid, String deviceNameAndroid, String url, String platformName, String platformVersion, String platformIOS, String deviceNameIOS, String browserName) throws IOException {
        this.url = url;
        if(verifyPlatform().equals(getValueFromProperties("APP_ANDROID"))){
            setAndroidCapabilities(appPackage, appActivity, platformAndroid, deviceNameAndroid, url, browserName);
        }else if(verifyPlatform().equals(getValueFromProperties("APP_IOS"))){
            setiPhoneCapabilities(platformIOS, platformVersion, platformName, deviceNameIOS, url, browserName);
        }else{
            System.out.println(verifyPlatform());
        }
    }

    public static String verifyPlatform() {
        if(Platform.getCurrent().is(Platform.LINUX) || Platform.getCurrent().is(Platform.WIN10) || Platform.getCurrent().is(Platform.ANDROID) || Platform.getCurrent().is(Platform.WINDOWS)) {
            return getValueFromProperties("APP_ANDROID");
        } else if (Platform.getCurrent().is(Platform.EL_CAPITAN) || Platform.getCurrent().is(Platform.SIERRA) || Platform.getCurrent().is(Platform.MAC)) {
            return getValueFromProperties("APP_IOS");
        } else {
            return NOT_RECOGNIZED;
        }
    }

    public void setAndroidCapabilities(String appPackage, String appActivity, String platform, String deviceName, String url, String browserName) throws MalformedURLException{
        capabilities = DesiredCapabilities.android();
        capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, appPackage);
        capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, appActivity);
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, platform);
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, deviceName);
        capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 60 * 5);
        capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, browserName);

        driver = new AndroidDriver(new URL(url), capabilities);
    }

    public void setiPhoneCapabilities(String platformIOS, String platformVersion, String platformName, String deviceNameIOS, String url, String browserName) throws MalformedURLException{
        capabilities = DesiredCapabilities.iphone();
        capabilities.setCapability(MobileCapabilityType.APP, returnTheApp());
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, platformIOS);
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, platformVersion);
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, platformName);
        capabilities.setCapability(MobileCapabilityType.UDID, deviceNameIOS);
        capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 60 * 5);
        capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, browserName);

        driver = new IOSDriver(new URL(url), this.capabilities);
    }

    public String returnTheApp(){
        if(verifyPlatform().equals(getValueFromProperties("APP_ANDROID"))){
            return "";
        }else{
            String workingDir = System.getProperty(USER_DIR);
            File file = new File(workingDir);
            File f = new File(file.getParentFile() + OBJECTIVE_C_EXTENSION);

            if(f.exists()){
                return OBJECTIVE_C_APP;
            }else{
                return SWIFT_APP;
            }
        }
    }

    public void tearDown(){
        driver.quit();
    }
}
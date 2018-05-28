package baseFolder;

import io.appium.java_client.AppiumDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import static baseFolder.BaseTest.verifyPlatform;

public class BasePage {
    public final AppiumDriver driver;
    public static String os;
    protected static Properties locators;
    private static final String ANDROID = "Android";
    private static final String IOS = "iOS";

    public BasePage(AppiumDriver driver) {
        this.driver = driver;
        os = verifyPlatform();
    }

    public AppiumDriver getDriver() {
        return driver;
    }

    public static Properties findProperties(String locator) {

        if (os.contentEquals(ANDROID)) {

            if (locator.startsWith("SAMSUNG") || locator.startsWith("AVD")) {
                locators = loadProperties("src/test/resources/devices/android_ios_devices");
            } else if (locator.startsWith("LOG_SCREEN")) {
                locators = loadProperties("src/test/resources/properties/application_log_labels.properties");
            } else {
                locators = loadProperties("src/test/resources/properties/android_locators.properties");
            }

        } else if (os.contentEquals(IOS)) {

            if (locator.startsWith("IPHONE")) {
                locators = loadProperties("src/test/resources/devices/android_ios_devices");
            } else if (locator.startsWith("LOG_SCREEN")) {
                locators = loadProperties("src/test/resources/properties/application_log_labels.properties");
            } else {
                locators = loadProperties("src/test/resources/properties/ios_locators.properties");
            }

        } else {
            System.out.println("TEST CANNOT SET LOCATORS ON PLATFORMS DIFFERENT THAN LINUX, MAC OR WINDOWS");
        }
        return locators;
    }

    public static Properties loadProperties(String propertiesLocation) {
        InputStream propertiesFile;
        Properties properties = new Properties();
        try {
            propertiesFile = new FileInputStream(propertiesLocation);
            properties.load(propertiesFile);
            propertiesFile.close();
        } catch (FileNotFoundException e) {
            final String msg = "Something went wrong while trying to load properties from: " + propertiesLocation;
            throw new RuntimeException(msg, e);
        } catch (IOException e) {
            final String msg = "Something went wrong while trying to load properties from: " + propertiesLocation;
            throw new RuntimeException(msg, e);
        }

        return properties;
    }

    public static String getValueFromProperties(String property) {
        Properties properties = findProperties(property);
        return properties.getProperty(property);
    }
}
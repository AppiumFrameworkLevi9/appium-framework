package handlers;

import io.appium.java_client.AppiumDriver;

import java.util.Collections;
import java.util.Set;

public class TabHandler {
    public static void switchToTab(AppiumDriver driver, String textPartUrl) {
        Set<String> windowHandles = Collections.unmodifiableSet(driver.getWindowHandles());
        for(String handle : windowHandles) {
            boolean tabFound = driver.switchTo().window(handle).getCurrentUrl().contains(textPartUrl);
            if(tabFound) {
                driver.switchTo().window(handle);
                break;
            }
        }
    }
}
package handlers;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Rotatable;
import org.openqa.selenium.ScreenOrientation;

import java.time.Duration;

import static baseFolder.BasePage.getValueFromProperties;
import static baseFolder.BaseTest.verifyPlatform;

public class ActionHandler {
    public String os;

    public static void swipeUp(AppiumDriver driver) {
        Dimension size = driver.manage().window().getSize();
        int startX = size.height / 2;
        int startY = (int) (size.height * 0.8);
        int endY = (int) (size.height * 0.4);
        TouchAction swipe = new TouchAction(driver).press(startX, startY).waitAction(Duration.ofSeconds(1))
                .moveTo(startX, endY).release();
        swipe.perform();
    }

    public static void swipeDown(AppiumDriver driver) {
        Dimension size = driver.manage().window().getSize();
        int startX = size.height / 2;
        int startY = (int) (size.height * 0.2);
        int endY = (int) (size.height * 0.8);
        TouchAction swipe = new TouchAction(driver).press(startX, startY).waitAction(Duration.ofSeconds(1))
                .moveTo(startX, endY).release();
        swipe.perform();
    }

    public static String getScreenOrientation(AppiumDriver driver) {
        return driver.getOrientation().value();
    }

    public static void rotateToLandscapeMode(AppiumDriver driver) {
        ((Rotatable) driver).rotate(ScreenOrientation.LANDSCAPE);
    }

    public static void rotateToPortraitMode(AppiumDriver driver) {
        ((Rotatable) driver).rotate(ScreenOrientation.PORTRAIT);
    }

    public static void goBack(AppiumDriver driver) {
        if (verifyPlatform().equals(getValueFromProperties("APP_ANDROID"))) {
            driver.navigate().back();

        } else if (verifyPlatform().equals(getValueFromProperties("APP_IOS"))) {
            driver.findElementByXPath(getValueFromProperties("IOS_BACK_BUTTON")).click();
        }
    }
}
package handlers;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitHandler {
    public static boolean waitUntilElementExists(AppiumDriver driver, By locator, long timeOutInSeconds) {
        WebDriverWait driverWait = new WebDriverWait(driver, timeOutInSeconds);
        try {
            driverWait.until(ExpectedConditions.presenceOfElementLocated(locator));
            return true;
        } catch (TimeoutException te) {
            return false;
        } catch (Exception e) {
            System.out.println(e);
            throw e;
        }
    }

    public static boolean waitUntilElementIsVisible(AppiumDriver driver, By locator, long timeOutInSeconds) {
        WebDriverWait driverWait = new WebDriverWait(driver, timeOutInSeconds);
        try {
            driverWait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            return true;
        } catch (TimeoutException te) {
            return false;
        } catch (Exception e) {
            System.out.println(e);
            throw e;
        }
    }

    public static boolean waitUntilElementIsClickable(AppiumDriver driver, By locator, long timeOutInSeconds) {
        WebDriverWait driverWait = new WebDriverWait(driver, timeOutInSeconds);
        try {
            driverWait.until(ExpectedConditions.elementToBeClickable(locator));
            return true;
        } catch (TimeoutException te) {
            return false;
        } catch (Exception e) {
            System.out.println(e);
            throw e;
        }
    }

    public static boolean waitUntilElementIsNotVisible(AppiumDriver driver, By locator, long timeOutInSeconds) {
        WebDriverWait driverWait = new WebDriverWait(driver, timeOutInSeconds);
        try {
            driverWait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
            return true;
        } catch (TimeoutException te) {
            return false;
        } catch (Exception e) {
            System.out.println(e);
            throw e;
        }
    }

    public static boolean waitUntilElementIsStale(AppiumDriver driver, WebElement element, long timeOutInSeconds) {
        WebDriverWait driverWait = new WebDriverWait(driver, timeOutInSeconds);
        try {
            driverWait.until(ExpectedConditions.stalenessOf(element));
            return true;
        } catch (TimeoutException te) {
            return false;
        } catch (Exception e) {
            System.out.println(e);
            throw e;
        }
    }

    public static boolean waitUntilElementsArePresent(AppiumDriver driver, By locator, long timeOutInSeconds) {
        WebDriverWait driverWait = new WebDriverWait(driver, timeOutInSeconds);
        try {
            driverWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
            return true;
        } catch (TimeoutException te) {
            return false;
        } catch (Exception e) {
            System.out.println(e);
            throw e;
        }
    }

    public static boolean waitUntilTextIsPresentInElement(AppiumDriver driver, By locator, String text, long timeOutInSeconds) {
        WebDriverWait driverWait = new WebDriverWait(driver, timeOutInSeconds);
        try {
            driverWait.until(ExpectedConditions.textToBePresentInElementLocated(locator, text));
            return true;
        } catch (TimeoutException te) {
            return false;
        } catch (Exception e) {
            System.out.println(e);
            throw e;
        }
    }

    public static boolean waitUntilTextIsPresentInElementValue(AppiumDriver driver, By locator, String text, long timeOutInSeconds) {
        WebDriverWait driverWait = new WebDriverWait(driver, timeOutInSeconds);
        try {
            driverWait.until(ExpectedConditions.textToBePresentInElementValue(locator, text));
            return true;
        } catch (TimeoutException te) {
            return false;
        } catch (Exception e) {
            System.out.println(e);
            throw e;
        }
    }

    public static boolean waitUntilTitleIs(AppiumDriver driver, String title, long timeOutInSeconds) {
        WebDriverWait driverWait = new WebDriverWait(driver, timeOutInSeconds);
        try {
            driverWait.until(ExpectedConditions.titleIs(title));
            return true;
        } catch (TimeoutException te) {
            return false;
        } catch (Exception e) {
            System.out.println(e);
            throw e;
        }
    }

    public static boolean waitUntilTitleContains(AppiumDriver driver, String title, long timeOutInSeconds) {
        WebDriverWait driverWait = new WebDriverWait(driver, timeOutInSeconds);
        try {
            driverWait.until(ExpectedConditions.titleContains(title));
            return true;
        } catch (TimeoutException te) {
            return false;
        } catch (Exception e) {
            System.out.println(e);
            throw e;
        }
    }

    public static boolean waitUntilUrlIs(AppiumDriver driver, String url, long timeOutInSeconds) {
        WebDriverWait driverWait = new WebDriverWait(driver, timeOutInSeconds);
        try {
            driverWait.until(ExpectedConditions.urlToBe(url));
            return true;
        } catch (TimeoutException te) {
            return false;
        } catch (Exception e) {
            System.out.println(e);
            throw e;
        }
    }

    public static boolean waitUntilUrlContains(AppiumDriver driver, String text, long timeOutInSeconds) {
        WebDriverWait driverWait = new WebDriverWait(driver, timeOutInSeconds);
        try {
            driverWait.until(ExpectedConditions.urlContains(text));
            return true;
        } catch (TimeoutException te) {
            return false;
        } catch (Exception e) {
            System.out.println(e);
            throw e;
        }
    }

    public static void waitAdditional(double seconds) {
        if(seconds > 0) {
            int miliseconds = (int)(seconds * 1000);

            try {
                Thread.sleep(miliseconds);
            } catch (Exception e) {
                System.out.println(e);
                Thread.currentThread().interrupt();
                throw new WebDriverException();
            }
        }
    }
}
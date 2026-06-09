package utilities;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtils {

    private static final int DEFAULT_TIMEOUT = 30;

    /* =====================================================
       BASIC WAITS
    ===================================================== */

    // Wait until element is visible
    public static WebElement waitForVisible(WebDriver driver, By locator) {
        return new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_TIMEOUT))
                .until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    // Wait until element is present in DOM
    public static WebElement waitForPresence(WebDriver driver, By locator) {
        return new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_TIMEOUT))
                .until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    // Wait until element is clickable
    public static WebElement waitForClickable(WebDriver driver, By locator) {
        return new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_TIMEOUT))
                .until(ExpectedConditions.elementToBeClickable(locator));
    }

    // Wait and click
    public static void waitAndClick(WebDriver driver, By locator) {
        waitForClickable(driver, locator).click();
    }

    // Wait and send keys
    public static void waitAndSendKeys(WebDriver driver, By locator, String value) {
        WebElement element = waitForVisible(driver, locator);
        element.clear();
        element.sendKeys(value);
    }

    /* =====================================================
       TEXT & ATTRIBUTE WAITS
    ===================================================== */

    // Wait until text is present
    public static boolean waitForText(WebDriver driver, By locator, String text) {
        return new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_TIMEOUT))
                .until(ExpectedConditions.textToBePresentInElementLocated(locator, text));
    }

    // Wait until attribute contains value
    public static boolean waitForAttribute(WebDriver driver, By locator, String attribute, String value) {
        return new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_TIMEOUT))
                .until(ExpectedConditions.attributeContains(locator, attribute, value));
    }

    /* =====================================================
       INVISIBLE / LOADER WAITS
    ===================================================== */

    // Wait until element disappears
    public static boolean waitForInvisibility(WebDriver driver, By locator) {
        return new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_TIMEOUT))
                .until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    // Wait until loading spinner disappears
    public static void waitForLoaderToDisappear(WebDriver driver, By loaderLocator) {
        new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_TIMEOUT))
                .until(ExpectedConditions.invisibilityOfElementLocated(loaderLocator));
    }

    /* =====================================================
       FRAME HANDLING
    ===================================================== */

    // Switch to iframe by locator
    public static void switchToFrame(WebDriver driver, By frameLocator) {
        try {
            new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_TIMEOUT))
                    .until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameLocator));
        } catch (TimeoutException e) {
            throw new RuntimeException("Frame not found: " + frameLocator);
        }
    }

    // Switch to iframe by name or id
    public static void switchToFrame(WebDriver driver, String frameNameOrId) {
        try {
            new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_TIMEOUT))
                    .until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameNameOrId));
        } catch (TimeoutException e) {
            throw new RuntimeException("Frame not found: " + frameNameOrId);
        }
    }

    // Switch back to main page
    public static void switchToDefault(WebDriver driver) {
        driver.switchTo().defaultContent();
    }

    /* =====================================================
       KENDO / AUTOCOMPLETE DROPDOWN SUPPORT
    ===================================================== */

    // Select value from auto-suggest dropdown
    public static void selectFromAutoComplete(
            WebDriver driver,
            By inputLocator,
            By dropdownListLocator,
            By dropdownOptions,
            String expectedValue) {

        WebElement input = driver.findElement(inputLocator);
        input.click();
        input.clear();
        input.sendKeys(expectedValue.substring(0, 3));
        
        input.sendKeys(Keys.ARROW_DOWN);

        WaitUtils.waitForVisible(driver, dropdownListLocator);
        
        List<WebElement> options = driver.findElements(dropdownOptions);

        for (WebElement option : options) {
            if (option.getText().contains(expectedValue)) {
                option.click();
                return;
            }
        }
        throw new RuntimeException("Value not found in dropdown: " + expectedValue);
    }

    /* =====================================================
       JAVASCRIPT FALLBACKS (FOR STUBBORN UI)
    ===================================================== */

    // Click using JavaScript
    public static void jsClick(WebDriver driver, WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
    }

    // Scroll element into view
    public static void scrollIntoView(WebDriver driver, WebElement element) {
        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].scrollIntoView(true);", element);
    }

    /* =====================================================
       PAGE LOAD WAIT
    ===================================================== */

    // Wait until page fully loaded
    public static void waitForPageLoad(WebDriver driver) {
        new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_TIMEOUT))
                .until(webDriver ->
                        ((JavascriptExecutor) webDriver)
                                .executeScript("return document.readyState")
                                .equals("complete"));
    }
}




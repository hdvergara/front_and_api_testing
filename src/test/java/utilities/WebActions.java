package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WebActions {

    private final int TIME_OUT = 20;

    /**
     * Function for writing on an element
     *
     * @param driver  driver
     * @param element Element to interact
     * @param text    Text to enter
     */
    public void sendText(WebDriver driver, WebElement element, String text) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TIME_OUT));
        wait.until(ExpectedConditions.visibilityOf(element));
        element.sendKeys(text);
    }

    /**
     * Click function
     *
     * @param driver  driver
     * @param element Element to interact
     */
    public void click(WebDriver driver, WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TIME_OUT));
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

    /**
     * Validates if an element is visible
     *
     * @param driver  driver
     * @param element Element to interact
     * @return true or false
     */
    public boolean isVisible(WebDriver driver, WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TIME_OUT));
        wait.until(ExpectedConditions.visibilityOf(element));
        return true;
    }
}

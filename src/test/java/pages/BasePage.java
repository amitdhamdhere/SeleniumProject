package pages;

import base.DriverFactory;
import org.jspecify.annotations.Nullable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    protected WebDriver driver;
    private WebDriverWait webDriverWait;

    public BasePage() {
        this.driver = DriverFactory.getDriver();
        this.webDriverWait= new WebDriverWait(this.driver, Duration.ofSeconds(10));
    }

    @Nullable
    protected WebElement waitForElementVisible(By locator) {
        return webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    protected void type(By locator, String text) {
        WebElement element = waitForElementVisible(locator); // Checking element is visible
        element.clear();    // Clearing element
        element.sendKeys(text); //Entering text
    }

    protected void click(By locator) {
        WebElement element = waitForElementVisible(locator); // Checking element is visible
        if (element.isEnabled()) {
            element.click();
        }
    }

    protected String getText(By locator) {
        WebElement element = waitForElementVisible(locator);
        return element.getText();
    }
}

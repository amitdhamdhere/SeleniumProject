package pages;

import org.openqa.selenium.By;

public class HomePage extends BasePage{
    private By successText = By.tagName("h1");

    public String getSuccessMessage() {
        return getText(successText);
    }
}

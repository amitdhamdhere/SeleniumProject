package pages;

import org.openqa.selenium.By;

public class LoginPage extends BasePage {
    private By usernameField = By.id("username");
    private By passwordField = By.id("password");
    private By loginButton = By.id("submit");

    public void enterUsername(String username) {
        type(usernameField,username);
    }

    public void enterPassword(String password) {
        type(passwordField,password);
    }

    public void clickLogin() {
        click(loginButton);
    }
}

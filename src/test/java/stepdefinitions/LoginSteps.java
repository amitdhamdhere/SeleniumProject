package stepdefinitions;

import context.ScenarioContext;
import context.ScenarioContextKey;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import managers.PageObjectManager;
import org.slf4j.Logger;
import utils.Log;

public class LoginSteps {
    private final PageObjectManager pageObjectManager;
    private final ScenarioContext scenarioContext;
    private static final Logger logger = Log.getLogger(LoginSteps.class);

    public LoginSteps(PageObjectManager pageObjectManager, ScenarioContext scenarioContext) {
        this.pageObjectManager = pageObjectManager;
        this.scenarioContext = scenarioContext;
    }

    @Given("user is on login page")
    public void user_is_on_login_page() {
    }

    @When("user enters valid username {string} and password {string}")
    public void user_enters_valid_username_and_password(String username, String password) {
        logger.info("Logging in with username: {}", username);

        pageObjectManager.getLoginPage().enterUsername(username);
        pageObjectManager.getLoginPage().enterPassword(password);

        // To store data
        scenarioContext.set(ScenarioContextKey.LOGGED_IN_USER, username);
    }

    @When("user clicks on login button")
    public void user_clicks_on_login_button() {
        pageObjectManager.getLoginPage().clickLogin();
        logger.info("Login submitted");
    }
}

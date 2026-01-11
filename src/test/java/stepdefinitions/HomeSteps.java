package stepdefinitions;

import context.ScenarioContext;
import context.ScenarioContextKey;
import io.cucumber.java.en.Then;
import managers.PageObjectManager;
import org.testng.Assert;

public class HomeSteps {
    private final PageObjectManager pageObjectManager;
    private final ScenarioContext scenarioContext;

    public HomeSteps(PageObjectManager pageObjectManager, ScenarioContext scenarioContext) {
        this.pageObjectManager = pageObjectManager;
        this.scenarioContext=scenarioContext;
    }

    @Then("{string} message should be displayed")
    public void message_should_be_displayed(String expectedMessage) {
        Assert.assertEquals(pageObjectManager.getHomePage().getSuccessMessage(), expectedMessage, "Message is not matched!");
    }
}

package hooks;

import base.DriverFactory;
import context.ScenarioContext;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import managers.PageObjectManager;
import org.slf4j.Logger;
import utils.ConfigReader;
import utils.Log;
import utils.ScreenshotUtil;

import java.io.IOException;

public class Hooks {
    private final PageObjectManager pageObjectManager;
    private final ScenarioContext scenarioContext;
    private static final Logger logger = Log.getLogger(Hooks.class);

    public Hooks(PageObjectManager pageObjectManager, ScenarioContext scenarioContext) {
        this.pageObjectManager = pageObjectManager;
        this.scenarioContext = scenarioContext;
    }

    @Before
    public void setUp() throws IOException {
        logger.info("Initializing WebDriver");
        DriverFactory.initDriver();

        String url = ConfigReader.getValue("baseUrl");
        logger.info("Navigating to URL: {}", url);
        DriverFactory.getDriver().get(url);
    }

    @After
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            byte[] screenshot = ScreenshotUtil.takeScreenshot(scenario.getName());
            scenario.attach(screenshot, "image/png", scenario.getName());
        }

        logger.info("Clearing scenario context and quitting driver");
        scenarioContext.clear();
        DriverFactory.quitDriver();
    }
}

package utils;

import base.DriverFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;

public class ScreenshotUtil {

    public static byte[] takeScreenshot(String scenarioName) {
        try {
            TakesScreenshot ts = (TakesScreenshot) DriverFactory.getDriver();

            byte[] screenshot = ts.getScreenshotAs(OutputType.BYTES);

            // Save locally (optional but enterprise-preferred)
            Path path = Path.of("target/screenshots/" + scenarioName.replace(" ", "_") + ".png");
            Files.createDirectories(path.getParent());
            Files.write(path, screenshot);

            return screenshot;

        } catch (Exception e) {
            throw new RuntimeException("Failed to capture screenshot");
        }
    }
}

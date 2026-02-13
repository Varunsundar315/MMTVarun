package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;
import base.DriverSetup;
import utils.ScreenshotUtils;

public class Hooks {

    @After
    public void takeScreenshotOnFailure(Scenario scenario) {

        if (scenario.isFailed()) {

            WebDriver driver = DriverSetup.driver;

            String path =
                    ScreenshotUtils.takeScreenshot(driver, scenario.getName());

            byte[] screenshot =
                    ((org.openqa.selenium.TakesScreenshot) driver)
                    .getScreenshotAs(org.openqa.selenium.OutputType.BYTES);

            scenario.attach(screenshot, "image/png", "Failure Screenshot");
        }
    }
}

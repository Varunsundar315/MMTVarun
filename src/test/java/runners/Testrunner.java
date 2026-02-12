package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;

import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import base.DriverSetup;

@CucumberOptions(
    features = {"src/test/resources/feature/flight.feature",
    },
    glue = "cucu",
    plugin = {
        "pretty",
        "html:target/cucumber-reports.html",
        "json:target/cucumber.json"
    },
    monochrome = true
)
public class Testrunner extends AbstractTestNGCucumberTests {
   
}
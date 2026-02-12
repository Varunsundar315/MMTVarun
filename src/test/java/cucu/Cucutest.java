package cucu;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.After;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import base.DriverSetup;
import pages.HomePage;

public class Cucutest {
    
    private WebDriver driver;
    private HomePage homePage;
    
    @Given("Open website {string}")
    public void open_website(String browser) {
        driver = DriverSetup.initializeDriver(browser);
        homePage = new HomePage(driver);
        driver.get("https://www.makemytrip.com/");
        System.out.println("Website opened: " + driver.getCurrentUrl());
    }
    
    @Then("Title contains {string}")
    public void title_contains(String text) {
        Assert.assertTrue(driver.getTitle().contains(text), 
            "Title does not contain: " + text);
        System.out.println("Title verified: " + driver.getTitle());
    }
    
    @Then("Close login popup")
    public void close_login_popup() {
        homePage.closeLoginPopup();
    }
    
    @Then("Check {string} tab")
    public void check_tab(String tab) {
        if(tab.equalsIgnoreCase("Flights")) {
            Assert.assertTrue(homePage.isFlightsDisplayed(), "Flights tab not displayed");
        } else if(tab.equalsIgnoreCase("Hotels")) {
            Assert.assertTrue(homePage.isHotelsDisplayed(), "Hotels tab not displayed");
        } else if(tab.equalsIgnoreCase("Trains")) {
            Assert.assertTrue(homePage.isTrainsDisplayed(), "Trains tab not displayed");
        }
        System.out.println(tab + " tab verified");
    }
    
    @When("Click Flights")
    public void click_flights() {
        homePage.clickFlights();
    }
    
    @Then("Check From field")
    public void check_from_field() {
        Assert.assertTrue(homePage.isFromCityDisplayed(), "From field not displayed");
        System.out.println("From field verified");
    }
    
    @Then("Check To field")
    public void check_to_field() {
        Assert.assertTrue(homePage.isToCityDisplayed(), "To field not displayed");
        System.out.println("To field verified");
    }
    
    @Then("Check Departure picker")
    public void check_departure_picker() {
        Assert.assertTrue(homePage.isDepartureDisplayed(), "Departure picker not displayed");
        System.out.println("Departure picker verified");
    }
    
    @After
    public void closeBrowser() {
        DriverSetup.quitDriver();
    }
}
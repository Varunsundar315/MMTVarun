package cucu;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.time.Duration;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import base.DriverSetup;
import pages.HomePage;
import pages.FlightsPage;

public class Cucuflight {
    
    private HomePage homePage;
    private FlightsPage flightsPage;
    
    @When("Enter from {string}")
    public void enter_from(String city) {
        homePage = new HomePage(DriverSetup.driver);
        homePage.closeLoginPopup();
        flightsPage = new FlightsPage(DriverSetup.driver);
        flightsPage.enterFrom(city);
    }
    
    @When("Enter to {string}")
    public void enter_to(String city) {
        flightsPage = new FlightsPage(DriverSetup.driver);
        flightsPage.enterTo(city);
    }
    
    @And("Select departure date and search")
    public void select_departure_date_and_search() {
        flightsPage.selectDate();
    }
    
    @When("Click search")
    public void click_search() {
        flightsPage = new FlightsPage(DriverSetup.driver);
        flightsPage.clickSearch();
    }
    
    @Then("Results page shown")
    public void results_page_shown() {
        WebDriverWait wait = new WebDriverWait(DriverSetup.driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.urlContains("flight"));
        Assert.assertTrue(DriverSetup.driver.getCurrentUrl().contains("flight"), 
            "Results page not shown");
        System.out.println("Results page verified");
    }
    
    @Then("Error message shown")
    public void error_message_shown() {
        Assert.assertTrue(DriverSetup.driver.getPageSource().contains("same"), 
            "Error message not shown");
        System.out.println("Error message verified");
    }
    
    @Then("URL contains {string}")
    public void url_contains(String text) {
        Assert.assertTrue(DriverSetup.driver.getCurrentUrl().contains(text), 
            "URL does not contain: " + text);
        System.out.println("URL verified: " + DriverSetup.driver.getCurrentUrl());
    }
    
    @Then("Flight list displayed")
    public void flight_list_displayed() {
        flightsPage = new FlightsPage(DriverSetup.driver);
        Assert.assertTrue(flightsPage.areResultsDisplayed(), 
            "Flight list not displayed");
        System.out.println("Flight list verified");
    }
}
package cucu;

import org.testng.Assert;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import base.DriverSetup;
import pages.ResultsPage;
import pages.FlightsPage;

public class CucuResult {
    
    private ResultsPage resultPage;
    private FlightsPage flightPage;
    
    @When("Search flight from {string} to {string}")
    public void search_flight_from_to(String from, String to) {
        flightPage = new FlightsPage(DriverSetup.driver);
        flightPage.enterFrom(from);
        flightPage.enterTo(to);
        flightPage.selectDate();
        flightPage.clickSearch();
    }
    
    @Then("Flight results shown")
    public void flight_results_shown() {
        resultPage = new ResultsPage(DriverSetup.driver);
        Assert.assertTrue(resultPage.isFlightResultsDisplayed(), 
            "Flight results not displayed");
        System.out.println("Flight results verified");
    }
    
    @When("Click first flight")
    public void click_first_flight() {
        resultPage = new ResultsPage(DriverSetup.driver);
        resultPage.clickFirstFlight();
    }
    
    @Then("Flight details page shown")
    public void flight_details_page_shown() {
        resultPage = new ResultsPage(DriverSetup.driver);
        Assert.assertTrue(resultPage.isFlightDetailsPageDisplayed(), 
            "Flight details page not displayed");
        System.out.println("Flight details page verified");
    }
    
    @Then("Fare details shown")
    public void fare_details_shown() {
        resultPage = new ResultsPage(DriverSetup.driver);
        Assert.assertTrue(resultPage.isFareDisplayed(), 
            "Fare details not displayed");
        System.out.println("Fare details verified");
    }
}
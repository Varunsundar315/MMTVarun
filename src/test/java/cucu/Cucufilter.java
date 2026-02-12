package cucu;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import base.DriverSetup;
import pages.HotelsPage;
import pages.ResultsPage;

public class Cucufilter {
    
    private ResultsPage resultsPage;
    private HotelsPage hotelsPage;
    
    @When("Apply price filter")
    public void apply_price_filter() {
        resultsPage = new ResultsPage(DriverSetup.driver);
        resultsPage.applyPriceFilter();
    }
    
    @Then("Filtered results shown")
    public void filtered_results_shown() {
        resultsPage = new ResultsPage(DriverSetup.driver);
        Assert.assertTrue(resultsPage.resultsDisplayed(), 
            "Filtered results not shown");
        System.out.println("Filtered results verified");
    }
    
    @When("Enter hotel city {string}")
    public void enter_hotel_city(String city) {
        hotelsPage = new HotelsPage(DriverSetup.driver);
        hotelsPage.enterCity(city);
    }
    
    @When("Apply rating filter")
    public void apply_rating_filter() {
        resultsPage = new ResultsPage(DriverSetup.driver);
        resultsPage.applyRatingFilter();
    }
    
    @When("Sort by price")
    public void sort_by_price() {
        resultsPage = new ResultsPage(DriverSetup.driver);
        resultsPage.sortByPrice();
    }
    
    @Then("Sorted results shown")
    public void sorted_results_shown() {
        resultsPage = new ResultsPage(DriverSetup.driver);
        Assert.assertTrue(resultsPage.resultsDisplayed(), 
            "Sorted results not shown");
        System.out.println("Sorted results verified");
    }
    
    @When("Clear all filters")
    public void clear_all_filters() {
        resultsPage = new ResultsPage(DriverSetup.driver);
        resultsPage.clearFilters();
    }
    
    @Then("All results shown")
    public void all_results_shown() {
        resultsPage = new ResultsPage(DriverSetup.driver);
        Assert.assertTrue(resultsPage.resultsDisplayed(), 
            "All results not shown");
        System.out.println("All results verified");
    }
}
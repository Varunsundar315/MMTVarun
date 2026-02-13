package cucu;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import base.DriverSetup;
import pages.ResultsPage;

public class Cucufilter {

    private ResultsPage hotelResultsPage;

    @When("Apply price filter")
    public void apply_price_filter() {
        hotelResultsPage = new ResultsPage(DriverSetup.driver);
        hotelResultsPage.applyPriceFilter();
    }

    @Then("Filtered results shown")
    public void filtered_results_shown() {
        hotelResultsPage = new ResultsPage(DriverSetup.driver);
        Assert.assertTrue(hotelResultsPage.resultsDisplayed(),"Filtered results not shown");
    }

    @When("Apply rating filter")
    public void apply_rating_filter() {
        hotelResultsPage = new ResultsPage(DriverSetup.driver);
        hotelResultsPage.applyRatingFilter();
    }

    @When("Sort by price")
    public void sort_by_price() {
        hotelResultsPage = new ResultsPage(DriverSetup.driver);
        hotelResultsPage.sortByPrice();
    }

    @Then("Sorted results shown")
    public void sorted_results_shown() {
        hotelResultsPage = new ResultsPage(DriverSetup.driver);
        Assert.assertTrue(hotelResultsPage.resultsDisplayed(),"Sorted results not shown");
    }

    @When("Clear all filters")
    public void clear_all_filters() {
        hotelResultsPage = new ResultsPage(DriverSetup.driver);
        hotelResultsPage.clearFilters();
    }

    @Then("All results shown")
    public void all_results_shown() {
        hotelResultsPage = new ResultsPage(DriverSetup.driver);
        Assert.assertTrue(hotelResultsPage.resultsDisplayed(),"All results not shown");
    }
}
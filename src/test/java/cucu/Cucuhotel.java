package cucu;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import pages.HotelsPage;
import base.DriverSetup;

public class Cucuhotel {
    
    private HotelsPage hotelsPage;
    
    @And("Enter city {string}")
    public void enter_city(String city) {
        hotelsPage = new HotelsPage(DriverSetup.driver);
        hotelsPage.enterCity(city);
    }
    
    @And("Select checkin date {string}")
    public void select_checkin_date(String day) {
        hotelsPage.selectCheckIn(day);
    }
    
    @And("Select checkout date {string}")
    public void select_checkout_date(String day) {
        hotelsPage.selectCheckOut(day);
    }
    
    @And("Select rooms {string} adults {string}")
    public void select_rooms_adults(String rooms, String adults) {
        hotelsPage.selectGuests(rooms, adults);
    }
    
    @And("Click hotel search")
    public void click_hotel_search() {
        hotelsPage.clickSearch();
    }
    
    @Then("Hotel results shown")
    public void hotel_results_shown() {
        Assert.assertTrue(hotelsPage.isHotelResultsDisplayed(), 
            "Hotel results not shown");
        System.out.println("Hotel results verified");
    }
}
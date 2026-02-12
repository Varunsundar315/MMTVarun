package cucu;

import io.cucumber.java.en.When;
import base.DriverSetup;
import pages.HomePage;

public class Cucunav {
    
    private HomePage homePage;
    
    @When("Click Hotels")
    public void click_hotels() {
        homePage = new HomePage(DriverSetup.driver);
        homePage.clickHotels();
    }
    
    @When("Click Trains")
    public void click_trains() {
        homePage = new HomePage(DriverSetup.driver);
        homePage.clickTrains();
    }
}
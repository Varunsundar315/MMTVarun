package cucu;

import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import base.DriverSetup;
import pages.TrainsPage;

public class Cucutrain {
    
    private WebDriver driver;
    private TrainsPage trainsPage;
    
    public Cucutrain() {
        this.driver = DriverSetup.driver;
        this.trainsPage = new TrainsPage(driver);
    }
    
    @When("Enter from station {string}")
    public void enter_from_station(String station) {
        trainsPage = new TrainsPage(driver);
        trainsPage.enterFrom(station);
    }
    
    @When("Enter to station {string}")
    public void enter_to_station(String station) {
        trainsPage.enterTo(station);
    }
    
    @When("Select departure date {string}")
    public void select_departure_date(String day) {
        trainsPage.selectDepartureDate(day);
    }
    
    @When("Click train search")
    public void click_train_search() {
        trainsPage.clickSearch();
    }
}
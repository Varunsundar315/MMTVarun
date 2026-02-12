package pages;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.WaitUtils;

public class HomePage {
    
    private WebDriver driver;
    private WebDriverWait wait;
    private WaitUtils waitUtils;
    private JavascriptExecutor js;
    
    // Locators
    @FindBy(xpath = "//span[@data-cy='closeModal']")
    private WebElement closeLogin;
    
    @FindBy(xpath = "//li[@data-cy='menu_Flights']")
    private WebElement flights;
    
    @FindBy(xpath = "//li[@data-cy='menu_Hotels']")
    private WebElement hotels;
    
    @FindBy(xpath = "//li[@data-cy='menu_Trains']")
    private WebElement trains;
    
    @FindBy(id = "fromCity")
    private WebElement fromCity;
    
    @FindBy(id = "toCity")
    private WebElement toCity;
    
    @FindBy(xpath = "//span[text()='Departure']")
    private WebElement departure;
    
    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        this.waitUtils = new WaitUtils(driver);
        this.js = (JavascriptExecutor) driver;
        PageFactory.initElements(driver, this);
    }
    
    public void closeLoginPopup() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(closeLogin));
            js.executeScript("arguments[0].click();", closeLogin);
            System.out.println("Login popup closed");
            waitUtils.sleep(1000);
        } catch (Exception e) {
            System.out.println("No login popup to close or already closed");
        }
    }
    
    public void clickFlights() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(flights));
            js.executeScript("arguments[0].click();", flights);
            System.out.println("Flights tab clicked");
            wait.until(ExpectedConditions.visibilityOf(fromCity));
        } catch (Exception e) {
            System.out.println("Error clicking flights: " + e.getMessage());
        }
    }
    
    public void clickHotels() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(hotels));
            js.executeScript("arguments[0].click();", hotels);
            System.out.println("Hotels tab clicked");
            waitUtils.sleep(1000);
        } catch (Exception e) {
            System.out.println("Error clicking hotels: " + e.getMessage());
        }
    }
    
    public void clickTrains() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(trains));
            js.executeScript("arguments[0].click();", trains);
            System.out.println("Trains tab clicked");
            waitUtils.sleep(1000);
        } catch (Exception e) {
            System.out.println("Error clicking trains: " + e.getMessage());
        }
    }
    
    public boolean isFlightsDisplayed() {
        try {
            wait.until(ExpectedConditions.visibilityOf(flights));
            return flights.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
    
    public boolean isHotelsDisplayed() {
        try {
            wait.until(ExpectedConditions.visibilityOf(hotels));
            return hotels.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
    
    public boolean isTrainsDisplayed() {
        try {
            wait.until(ExpectedConditions.visibilityOf(trains));
            return trains.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
    
    public boolean isFromCityDisplayed() {
        try {
            wait.until(ExpectedConditions.visibilityOf(fromCity));
            return fromCity.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
    
    public boolean isToCityDisplayed() {
        try {
            wait.until(ExpectedConditions.visibilityOf(toCity));
            return toCity.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
    
    public boolean isDepartureDisplayed() {
        try {
            wait.until(ExpectedConditions.visibilityOf(departure));
            return departure.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}
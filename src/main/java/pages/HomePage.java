package pages;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    
    private WebDriver driver;
    private WebDriverWait wait;
    private WebDriverWait shortWait;
    private JavascriptExecutor js;
    
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
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.shortWait = new WebDriverWait(driver, Duration.ofSeconds(3));
        this.js = (JavascriptExecutor) driver;
        PageFactory.initElements(driver, this);
    }
    
    public void closeLoginPopup() {
        try {
            shortWait.until(ExpectedConditions.elementToBeClickable(closeLogin));
            js.executeScript("arguments[0].click();", closeLogin);
            System.out.println("Login popup closed");
        } catch (Exception e) {
            System.out.println("No login popup to close or already closed");
        }
    }
    
    public void clickFlights() {
        shortWait.until(ExpectedConditions.elementToBeClickable(flights));
        js.executeScript("arguments[0].click();", flights);
        System.out.println("Flights tab clicked");
        wait.until(ExpectedConditions.visibilityOf(fromCity));
    }
    
    public void clickHotels() {
        shortWait.until(ExpectedConditions.elementToBeClickable(hotels));
        js.executeScript("arguments[0].click();", hotels);
        System.out.println("Hotels tab clicked");
    }
    
    public void clickTrains() {
        shortWait.until(ExpectedConditions.elementToBeClickable(trains));
        js.executeScript("arguments[0].click();", trains);
        System.out.println("Trains tab clicked");
    }
    
    public boolean isFlightsDisplayed() {
        return shortWait.until(ExpectedConditions.visibilityOf(flights)).isDisplayed();
    }
    
    public boolean isHotelsDisplayed() {
        return shortWait.until(ExpectedConditions.visibilityOf(hotels)).isDisplayed();
    }
    
    public boolean isTrainsDisplayed() {
        return shortWait.until(ExpectedConditions.visibilityOf(trains)).isDisplayed();
    }
    
    public boolean isFromCityDisplayed() {
        return shortWait.until(ExpectedConditions.visibilityOf(fromCity)).isDisplayed();
    }
    
    public boolean isToCityDisplayed() {
        return shortWait.until(ExpectedConditions.visibilityOf(toCity)).isDisplayed();
    }
    
    public boolean isDepartureDisplayed() {
        return shortWait.until(ExpectedConditions.visibilityOf(departure)).isDisplayed();
    }
}
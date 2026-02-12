package pages;

import java.time.Duration;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.WaitUtils;

public class HotelsPage {
    
    private WebDriver driver;
    private WebDriverWait wait;
    private JavascriptExecutor js;
    private WaitUtils waitUtils;
    
    @FindBy(xpath = "//span[@data-cy='hotelCityLabel']")
    private WebElement cityLabel;
    
    @FindBy(xpath = "//input[@placeholder='Where do you want to stay?']")
    private WebElement cityInput;
    
    @FindBy(xpath = "//input[@data-cy='checkin']")
    private WebElement checkin;
    
    @FindBy(xpath = "//input[@data-cy='checkout']")
    private WebElement checkout;
    
    @FindBy(xpath = "//input[@data-cy='guest']")
    private WebElement guest;
    
    @FindBy(xpath = "//button[text()='APPLY']")
    private WebElement apply;
    
    @FindBy(xpath = "//button[@data-cy='submit']")
    private WebElement searchButton;
    
    public HotelsPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        this.js = (JavascriptExecutor) driver;
        this.waitUtils = new WaitUtils(driver);
        PageFactory.initElements(driver, this);
    }
    
    public void enterCity(String city) {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(cityLabel));
            js.executeScript("arguments[0].click();", cityLabel);
            waitUtils.sleep(20);
            
            wait.until(ExpectedConditions.visibilityOf(cityInput));
            cityInput.clear();
            cityInput.sendKeys(city);
            waitUtils.sleep(20);
            
            WebElement suggestion = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//li//span[contains(text(),'" + city + "')]")));
            js.executeScript("arguments[0].click();", suggestion);
            
            System.out.println("City entered: " + city);
        } catch (Exception e) {
            System.out.println("Error entering city: " + e.getMessage());
        }
    }
    
    public void selectCheckIn(String day) {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(checkin));
            js.executeScript("arguments[0].click();", checkin);
            waitUtils.sleep(20);
            selectDate(day);
        } catch (Exception e) {
            System.out.println("Error selecting check-in: " + e.getMessage());
        }
    }
    
    public void selectCheckOut(String day) {
        try {
            waitUtils.sleep(20);
            selectDate(day);
        } catch (Exception e) {
            System.out.println("Error selecting check-out: " + e.getMessage());
        }
    }
    
    public void selectDate(String day) {
        try {
            WebElement date = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//div[contains(@class,'DayPicker-Day') and @aria-disabled='false' and text()='" + day + "']")));
            js.executeScript("arguments[0].click();", date);
            waitUtils.sleep(20);
            System.out.println("Date selected: " + day);
        } catch (Exception e) {
            System.out.println("Error selecting date: " + e.getMessage());
        }
    }
    
    public void selectGuests(String rooms, String adults) {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(guest));
            js.executeScript("arguments[0].click();", guest);
            waitUtils.sleep(20);
            
            wait.until(ExpectedConditions.elementToBeClickable(apply));
            js.executeScript("arguments[0].click();", apply);
            
            System.out.println("Guests selected");
        } catch (Exception e) {
            System.out.println("Error selecting guests: " + e.getMessage());
        }
    }
    
    public void clickSearch() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(searchButton));
            js.executeScript("arguments[0].scrollIntoView(true);", searchButton);
            waitUtils.sleep(20);
            js.executeScript("arguments[0].click();", searchButton);
            System.out.println("Search button clicked");
            waitUtils.sleep(20);
        } catch (Exception e) {
            System.out.println("Error clicking search: " + e.getMessage());
        }
    }
    
    public boolean isHotelResultsDisplayed() {
        try {
            waitUtils.sleep(20);
            return driver.getCurrentUrl().contains("hotel");
        } catch (Exception e) {
            return false;
        }
    }
}
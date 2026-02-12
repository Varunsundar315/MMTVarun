package pages;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FlightsPage {
    
    private WebDriver driver;
    private WebDriverWait wait;
    private JavascriptExecutor js;
    
    @FindBy(xpath = "//span[text()='From']")
    private WebElement fromLabel;
    
    @FindBy(xpath = "//input[@placeholder='From']")
    private WebElement fromInput;
    
    @FindBy(xpath = "//span[text()='To']")
    private WebElement toLabel;
    
    @FindBy(xpath = "//input[@placeholder='To']")
    private WebElement toInput;
    
    @FindBy(xpath = "//p[@data-cy='submit']")
    private WebElement searchButton;
    
    @FindBy(xpath = "//span[text()='Departure']")
    private WebElement departureLabel;
    
    @FindBy(xpath = "//div[contains(@class,'DayPicker-Day--today')]")
    private WebElement todayDate;
    
    public FlightsPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        this.js = (JavascriptExecutor) driver;
        PageFactory.initElements(driver, this);
    }
    
    public void enterFrom(String city) {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(fromLabel));
            js.executeScript("arguments[0].click();", fromLabel);
            
            wait.until(ExpectedConditions.visibilityOf(fromInput));
            fromInput.clear();
            fromInput.sendKeys(city);
            
            
            WebElement firstSuggestion = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//ul[@role='listbox']//li[1]")));
            js.executeScript("arguments[0].click();", firstSuggestion);
            
            System.out.println("From city entered: " + city);
        } catch (Exception e) {
            System.out.println("Error entering from city: " + e.getMessage());
        }
    }
    
    public void enterTo(String city) {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(toLabel));
            js.executeScript("arguments[0].click();", toLabel);
            
            wait.until(ExpectedConditions.visibilityOf(toInput));
            toInput.clear();
            toInput.sendKeys(city);
            
            // Select first suggestion - simplified xpath
            WebElement firstSuggestion = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//ul[@role='listbox']//li[1]")));
            js.executeScript("arguments[0].click();", firstSuggestion);
            
            System.out.println("To city entered: " + city);
        } catch (Exception e) {
            System.out.println("Error entering to city: " + e.getMessage());
        }
    }
    
    public void selectDate() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(departureLabel));
            js.executeScript("arguments[0].click();", departureLabel);
            
            wait.until(ExpectedConditions.elementToBeClickable(todayDate));
            js.executeScript("arguments[0].click();", todayDate);
            
            System.out.println("Departure date selected");
        } catch (Exception e) {
            System.out.println("Error selecting date: " + e.getMessage());
        }
    }
    
    public void clickSearch() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(searchButton));
            js.executeScript("arguments[0].scrollIntoView({block: 'center'});", searchButton);
            js.executeScript("arguments[0].click();", searchButton);
            System.out.println("Search button clicked");
            
            // Wait for URL change instead of fixed sleep
            wait.until(ExpectedConditions.urlContains("www.makemytrip.com"));
            System.out.println("Results page loaded");
        } catch (Exception e) {
            System.out.println("Error clicking search: " + e.getMessage());
        }
    }
    
    public boolean areResultsDisplayed() {
        try {
            return driver.getCurrentUrl().contains("www.makemytrip.com");
        } catch (Exception e) {
            return false;
        }
    }
}
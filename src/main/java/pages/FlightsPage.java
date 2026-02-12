package pages;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.PageFactory;

public class FlightsPage {
    
    private WebDriver driver;
    private WebDriverWait wait;
    private JavascriptExecutor js;
    
    public FlightsPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.js = (JavascriptExecutor) driver;
        PageFactory.initElements(driver, this);
    }
    
    public void enterFrom(String city) {
        // Click container to activate field
        WebElement fromContainer = wait.until(ExpectedConditions.elementToBeClickable(
            By.xpath("//label[@for='fromCity'] | //span[text()='From']")));
        fromContainer.click();
        
        // Type in the input
        WebElement fromInput = wait.until(ExpectedConditions.visibilityOfElementLocated(
            By.xpath("//input[@placeholder='From'] | //input[@id='fromCity']")));
        fromInput.clear();
        fromInput.sendKeys(city);
        
        // Click first suggestion
        WebElement firstOption = wait.until(ExpectedConditions.elementToBeClickable(
            By.xpath("//ul[@role='listbox']//li[1]")));
        firstOption.click();
        
        System.out.println("From: " + city);
    }
    
    public void enterTo(String city) {
        // Click container to activate field
        WebElement toContainer = wait.until(ExpectedConditions.elementToBeClickable(
            By.xpath("//label[@for='toCity'] | //span[text()='To']")));
        toContainer.click();
        
        // Type in the input
        WebElement toInput = wait.until(ExpectedConditions.visibilityOfElementLocated(
            By.xpath("//input[@placeholder='To'] | //input[@id='toCity']")));
        toInput.clear();
        toInput.sendKeys(city);
        
        // Click first suggestion
        WebElement firstOption = wait.until(ExpectedConditions.elementToBeClickable(
            By.xpath("//ul[@role='listbox']//li[1]")));
        firstOption.click();
        
        System.out.println("To: " + city);
    }
    
    public void selectDate() {
        // Click date field
        WebElement dateLabel = wait.until(ExpectedConditions.presenceOfElementLocated(
            By.xpath("//span[text()='Departure'] | //label[contains(text(),'Departure')]")));
        js.executeScript("arguments[0].click();", dateLabel);
        
        // Select today's date
        WebElement today = wait.until(ExpectedConditions.presenceOfElementLocated(
            By.xpath("//div[contains(@class,'DayPicker-Day--today')]")));
        js.executeScript("arguments[0].click();", today);
        
        System.out.println("Date selected");
    }
    
    public void clickSearch() {
        WebElement searchBtn = wait.until(ExpectedConditions.elementToBeClickable(
            By.xpath("//p[@data-cy='submit']")));
        js.executeScript("arguments[0].scrollIntoView({block: 'center'});", searchBtn);
        js.executeScript("arguments[0].click();", searchBtn);
        System.out.println("Search clicked");
    }
    
    public boolean areResultsDisplayed() {
        return wait.until(ExpectedConditions.urlContains("flight"));
    }
}
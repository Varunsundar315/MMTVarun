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
import utils.WaitUtils;

public class TrainsPage {
    
    private WebDriver driver;
    private WebDriverWait wait;
    private JavascriptExecutor js;
    private WaitUtils waitUtils;
    
    @FindBy(xpath = "//input[@data-cy='fromCity']")
    private WebElement fromLabel;
    
    @FindBy(xpath = "//input[@placeholder='From']")
    private WebElement fromInput;
    
    @FindBy(xpath = "//input[@data-cy='toCity']")
    private WebElement toLabel;
    
    @FindBy(xpath = "//input[@placeholder='To']")
    private WebElement toInput;
    
    @FindBy(xpath = "//label[@for='travelDate']")
    private WebElement departureLabel;
    
    @FindBy(xpath = "//a[@data-cy='submit']")
    private WebElement searchBtn;
    
    public TrainsPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        this.js = (JavascriptExecutor) driver;
        this.waitUtils = new WaitUtils(driver);
        PageFactory.initElements(driver, this);
    }
    
    public void enterFrom(String station) {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(fromLabel));
            js.executeScript("arguments[0].click();", fromLabel);
            waitUtils.sleep(500);
            
            wait.until(ExpectedConditions.visibilityOf(fromInput));
            fromInput.clear();
            fromInput.sendKeys(station);
            waitUtils.sleep(1500);
            
            WebElement firstSuggestion = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//li//span[contains(text(),'" + station + "')]")));
            js.executeScript("arguments[0].click();", firstSuggestion);
            
            System.out.println("From station entered: " + station);
        } catch (Exception e) {
            System.out.println("Error entering from station: " + e.getMessage());
        }
    }
    
    public void enterTo(String station) {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(toLabel));
            js.executeScript("arguments[0].click();", toLabel);
            waitUtils.sleep(500);
            
            wait.until(ExpectedConditions.visibilityOf(toInput));
            toInput.clear();
            toInput.sendKeys(station);
            waitUtils.sleep(1500);
            
            WebElement correctStation = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//li//span[contains(text(),'" + station + "')]")));
            js.executeScript("arguments[0].click();", correctStation);
            
            System.out.println("To station entered: " + station);
        } catch (Exception e) {
            System.out.println("Error entering to station: " + e.getMessage());
        }
    }
    
    public void selectDepartureDate(String day) {
        try {
            if (day == null || day.isEmpty()) {
                return;
            }
            
            wait.until(ExpectedConditions.elementToBeClickable(departureLabel));
            js.executeScript("arguments[0].click();", departureLabel);
            waitUtils.sleep(500);
            
            WebElement date = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//div[contains(@class,'DayPicker-Day') and @aria-disabled='false' and text()='" + day + "']")));
            js.executeScript("arguments[0].click();", date);
            
            System.out.println("Departure date selected: " + day);
        } catch (Exception e) {
            System.out.println("Error selecting departure date: " + e.getMessage());
        }
    }
    
    public void clickSearch() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(searchBtn));
            js.executeScript("arguments[0].scrollIntoView(true);", searchBtn);
            waitUtils.sleep(500);
            js.executeScript("arguments[0].click();", searchBtn);
            System.out.println("Search button clicked");
            waitUtils.sleep(3000);
        } catch (Exception e) {
            System.out.println("Error clicking search: " + e.getMessage());
        }
    }
}
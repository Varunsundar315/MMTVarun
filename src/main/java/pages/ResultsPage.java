package pages;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ResultsPage {

    private WebDriver driver;
    private WebDriverWait wait;
    private JavascriptExecutor js;

    @FindBy(xpath = "//div[contains(@class,'fliListCard')]")
    private WebElement flightResults;

    @FindBy(xpath = "(//div[contains(@class,'fliListCard')])[1]")
    private WebElement firstFlight;

    @FindBy(xpath = "//div[contains(@class,'priceInfo')]")
    private WebElement fareDetails;

    public ResultsPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        this.js = (JavascriptExecutor) driver;
        PageFactory.initElements(driver, this);
    }

    public boolean isFlightResultsDisplayed() {
        try {
            wait.until(ExpectedConditions.visibilityOf(flightResults));
            return true;
        } catch (Exception e) {
            System.out.println("Flight results not visible: " + e.getMessage());
            return false;
        }
    }

    public void clickFirstFlight() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(firstFlight));
            firstFlight.click();
            System.out.println("First flight clicked");
        } catch (Exception e) {
            System.out.println("Error clicking first flight: " + e.getMessage());
        }
    }

    public boolean isFlightDetailsPageDisplayed() {
        try {
            wait.until(ExpectedConditions.urlContains("reviewDetails"));
            return true;
        } catch (Exception e) {
            System.out.println("Flight details page not loaded: " + e.getMessage());
            return false;
        }
    }

    public boolean isFareDisplayed() {
        try {
            wait.until(ExpectedConditions.visibilityOf(fareDetails));
            return true;
        } catch (Exception e) {
            System.out.println("Fare details not visible: " + e.getMessage());
            return false;
        }
    }

    public void applyPriceFilter() {
        try {
            // Wait for filters to be visible
            Thread.sleep(2000);
            
            // Try to find and click price filter checkbox/slider
            WebElement priceFilter = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//label[contains(text(),'Price')] | //span[contains(text(),'Price')]//following::input[1]")));
            js.executeScript("arguments[0].click();", priceFilter);
            
            System.out.println("Price filter applied");
            Thread.sleep(1000);
        } catch (Exception e) {
            System.out.println("Error applying price filter: " + e.getMessage());
        }
    }

    public void applyRatingFilter() {
        try {
            Thread.sleep(2000);
            
            // Click rating filter (usually star rating)
            WebElement ratingFilter = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//label[contains(text(),'Rating')] | //span[contains(@class,'rating')]//input[1]")));
            js.executeScript("arguments[0].click();", ratingFilter);
            
            System.out.println("Rating filter applied");
            Thread.sleep(1000);
        } catch (Exception e) {
            System.out.println("Error applying rating filter: " + e.getMessage());
        }
    }

    public void sortByPrice() {
        try {
            Thread.sleep(2000);
            
            // Find and click sort by price option
            WebElement sortPrice = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//span[contains(text(),'Price')] | //div[contains(text(),'Cheapest')]")));
            js.executeScript("arguments[0].click();", sortPrice);
            
            System.out.println("Sorted by price");
            Thread.sleep(2000); // Wait for results to re-sort
        } catch (Exception e) {
            System.out.println("Error sorting by price: " + e.getMessage());
        }
    }

    public void clearFilters() {
        try {
            Thread.sleep(1000);
            
            // Find and click clear all filters button
            WebElement clearBtn = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//span[contains(text(),'Clear')] | //button[contains(text(),'Clear')]")));
            js.executeScript("arguments[0].click();", clearBtn);
            
            System.out.println("All filters cleared");
            Thread.sleep(2000);
        } catch (Exception e) {
            System.out.println("Error clearing filters: " + e.getMessage());
        }
    }

    public boolean resultsDisplayed() {
        try {
            return wait.until(ExpectedConditions.or(
                ExpectedConditions.urlContains("flight"),
                ExpectedConditions.urlContains("hotel")
            ));
        } catch (Exception e) {
            System.out.println("Results page not loaded: " + e.getMessage());
            return false;
        }
    }
}
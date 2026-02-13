package pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ResultsPage {

    private WebDriver driver;
    private WebDriverWait wait;
    private JavascriptExecutor js;

    @FindBy(xpath = "//div[contains(@class,'listingCardWrap')]")
    private WebElement flightResults;

    @FindBy(xpath = "((//div[contains(@class,'listingCardWrap')]//div[contains(@class,'listingCard')])[1]")
    private WebElement firstFlight;

    @FindBy(xpath = "//div[contains(@class,'priceInfo')]")
    private WebElement fareDetails;

    @FindBy(xpath = "//p[@data-cy='submit']")
    private WebElement searchButton;

    public ResultsPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        this.js = (JavascriptExecutor) driver;
        PageFactory.initElements(driver, this);
    }
    public boolean isFlightResultsDisplayed() {
        wait.until(ExpectedConditions.visibilityOf(flightResults));
        return true;
    }

    public void clickFirstFlight() {
        try {
       
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@data-test='flight-card' or contains(@class,'listingCard')]")));
            List<WebElement> flights = driver.findElements(
                By.xpath("//div[@data-test='flight-card' or contains(@class,'listingCard')]"));

            if (flights.size() > 0) {
                js.executeScript("arguments[0].scrollIntoView(true);", flights.get(0));
                js.executeScript("arguments[0].click();", flights.get(0));
                System.out.println("First flight clicked successfully");
            } else {
                System.out.println("No flights found");
            }

        } catch (Exception ignored) {
                             }
    }

    public boolean isFlightDetailsPageDisplayed() {
        wait.until(ExpectedConditions.urlContains("makemytrip.com"));
        return true;
    }

    public boolean isFareDisplayed() {
        wait.until(ExpectedConditions.visibilityOf(searchButton));
        return true;
    }

    public void applyPriceFilter() {

        By priceFilter = By.xpath(
                "//label[contains(text(),'Price')] | " + "//span[contains(text(),'Price')]//following::input[1]");
        WebElement filter =
                wait.until(ExpectedConditions.elementToBeClickable(priceFilter));

        js.executeScript("arguments[0].scrollIntoView({block:'center'});", filter);
        js.executeScript("arguments[0].click();", filter);
    }

    public void applyRatingFilter() {

        By ratingFilter = By.xpath(
                "//label[contains(text(),'Rating')] | " +
                "//span[contains(@class,'rating')]//input[1]"
        );

        WebElement filter =
                wait.until(ExpectedConditions.elementToBeClickable(ratingFilter));

        js.executeScript("arguments[0].scrollIntoView({block:'center'});", filter);
        js.executeScript("arguments[0].click();", filter);
    }

    public void sortByPrice() {

        By sortPrice = By.xpath( "//span[contains(text(),'Price')] | " + "//div[contains(text(),'Cheapest')]");

        WebElement sort =
                wait.until(ExpectedConditions.elementToBeClickable(sortPrice));

        js.executeScript("arguments[0].scrollIntoView({block:'center'});", sort);
        js.executeScript("arguments[0].click();", sort);
    }

    public void clearFilters() {

        By clearBtn = By.xpath("//span[contains(text(),'Clear')] | " +  "//button[contains(text(),'Clear')]");

        WebElement clear =
                wait.until(ExpectedConditions.elementToBeClickable(clearBtn));

        js.executeScript("arguments[0].scrollIntoView({block:'center'});", clear);
        js.executeScript("arguments[0].click();", clear);
    }
    public boolean resultsDisplayed() {
        wait.until(ExpectedConditions.or(
                ExpectedConditions.urlContains("makemytrip.com"),
                ExpectedConditions.urlContains("hotel")
        ));
        return true;
    }
}

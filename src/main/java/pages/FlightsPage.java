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

    private By firstSuggestion =
            By.xpath("//ul[@role='listbox']//li[1]");

    public FlightsPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.js = (JavascriptExecutor) driver;
        PageFactory.initElements(driver, this);
    }

    public void enterFrom(String city) {

        wait.until(ExpectedConditions.elementToBeClickable(fromLabel));
        js.executeScript("arguments[0].click();", fromLabel);

        wait.until(ExpectedConditions.visibilityOf(fromInput));
        fromInput.clear();
        fromInput.sendKeys(city);

        WebElement suggestion =
                wait.until(ExpectedConditions.elementToBeClickable(firstSuggestion));
        js.executeScript("arguments[0].click();", suggestion);
    }

    public void enterTo(String city) {

        wait.until(ExpectedConditions.elementToBeClickable(toLabel));
        js.executeScript("arguments[0].click();", toLabel);

        wait.until(ExpectedConditions.visibilityOf(toInput));
        toInput.clear();
        toInput.sendKeys(city);

        WebElement suggestion =
                wait.until(ExpectedConditions.elementToBeClickable(firstSuggestion));
        js.executeScript("arguments[0].click();", suggestion);
    }

    public void selectDate() {

        wait.until(ExpectedConditions.elementToBeClickable(departureLabel));
        js.executeScript("arguments[0].click();", departureLabel);

        wait.until(ExpectedConditions.elementToBeClickable(todayDate));
        js.executeScript("arguments[0].click();", todayDate);
    }

    public void clickSearch() {

        wait.until(ExpectedConditions.elementToBeClickable(searchButton));
        js.executeScript("arguments[0].scrollIntoView({block:'center'});", searchButton);
        js.executeScript("arguments[0].click();", searchButton);

        wait.until(ExpectedConditions.urlContains("makemytrip.com"));
    }

    public boolean areResultsDisplayed() {
        return driver.getCurrentUrl().contains("makemytrip.com");
    }
}


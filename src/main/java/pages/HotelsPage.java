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
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.js = (JavascriptExecutor) driver;
        this.waitUtils = new WaitUtils(driver);
        PageFactory.initElements(driver, this);
    }

    public void enterCity(String city) {

        wait.until(ExpectedConditions.elementToBeClickable(cityLabel));
        js.executeScript("arguments[0].click();", cityLabel);
        wait.until(ExpectedConditions.visibilityOf(cityInput));
        cityInput.clear();
        cityInput.sendKeys(city);
        By suggestion =By.xpath("//ul[@role='listbox']//li[1]");
        WebElement firstSuggestion =wait.until(ExpectedConditions.elementToBeClickable(suggestion));
        js.executeScript("arguments[0].click();", firstSuggestion);
    }

    public void selectCheckIn(String day) {

        wait.until(ExpectedConditions.elementToBeClickable(checkin));
        js.executeScript("arguments[0].click();", checkin);

        selectDate(day);
    }

    public void selectCheckOut(String day) {
        selectDate(day);
    }

    public void selectDate(String day) {

        By dateLocator = By.xpath(
                "//div[contains(@class,'DayPicker-Day') and " +
                "@aria-disabled='false' and text()='" + day + "']");

        WebElement date =
                wait.until(ExpectedConditions.elementToBeClickable(dateLocator));

        js.executeScript("arguments[0].click();", date);
    }

    public void selectGuests(String rooms, String adults) {

        wait.until(ExpectedConditions.elementToBeClickable(guest));
        js.executeScript("arguments[0].click();", guest);
        wait.until(ExpectedConditions.elementToBeClickable(apply));
        js.executeScript("arguments[0].click();", apply);
    }

    public void clickSearch() {

        wait.until(ExpectedConditions.elementToBeClickable(searchButton));
        js.executeScript("arguments[0].scrollIntoView({block:'center'});", searchButton);
        js.executeScript("arguments[0].click();", searchButton);
        wait.until(ExpectedConditions.urlContains("hotel"));
    }

    public boolean isHotelResultsDisplayed() {
        return driver.getCurrentUrl().contains("hotel");
    }
}

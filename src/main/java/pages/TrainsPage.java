package pages;

import java.time.Duration;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
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
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.js = (JavascriptExecutor) driver;
        this.waitUtils = new WaitUtils(driver);
        PageFactory.initElements(driver, this);
    }

    public void enterFrom(String station) {

        wait.until(ExpectedConditions.elementToBeClickable(fromLabel));
        js.executeScript("arguments[0].click();", fromLabel);

        wait.until(ExpectedConditions.visibilityOf(fromInput));
        fromInput.clear();
        fromInput.sendKeys(station);

        By firstSuggestion =
                By.xpath("//ul[@role='listbox']//li[1]");

        WebElement suggestion =
                wait.until(ExpectedConditions.elementToBeClickable(firstSuggestion));

        js.executeScript("arguments[0].click();", suggestion);
    }

    public void enterTo(String station) {

        wait.until(ExpectedConditions.elementToBeClickable(toLabel));
        js.executeScript("arguments[0].click();", toLabel);

        wait.until(ExpectedConditions.visibilityOf(toInput));
        toInput.clear();
        toInput.sendKeys(station);

        By firstSuggestion =
                By.xpath("//ul[@role='listbox']//li[1]");

        WebElement suggestion =
                wait.until(ExpectedConditions.elementToBeClickable(firstSuggestion));

        js.executeScript("arguments[0].click();", suggestion);
    }

    public void selectDepartureDate(String day) {

        if (day == null || day.isEmpty()) {
            return;
        }

        wait.until(ExpectedConditions.elementToBeClickable(departureLabel));
        js.executeScript("arguments[0].click();", departureLabel);

        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.className("DayPicker")));

        By dateLocator = By.xpath(
                "//div[contains(@class,'DayPicker-Day') " +
                "and not(contains(@class,'DayPicker-Day--disabled')) " +
                "and normalize-space()='" + day + "']"
        );

        WebElement date =
                wait.until(ExpectedConditions.visibilityOfElementLocated(dateLocator));

        js.executeScript("arguments[0].scrollIntoView({block:'center'});", date);
        js.executeScript("arguments[0].click();", date);
    }

    public void clickSearch() {

        wait.until(ExpectedConditions.elementToBeClickable(searchBtn));
        js.executeScript("arguments[0].scrollIntoView({block:'center'});", searchBtn);
        js.executeScript("arguments[0].click();", searchBtn);
    }
}

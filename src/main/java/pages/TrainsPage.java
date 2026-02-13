package pages;

import java.time.Duration;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
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

    @FindBy(xpath = "//label[@for='fromCity']")
    private WebElement fromLabel;

    @FindBy(xpath = "//input[@placeholder='From']")
    private WebElement fromInput;

    @FindBy(xpath = "//label[@for='toCity']")
    private WebElement toLabel;

    @FindBy(xpath = "//input[@placeholder='To']")
    private WebElement toInput;

    @FindBy(xpath = "//span[text()='Travel Date']")
    private WebElement departureLabel;

    @FindBy(xpath = "//a[@data-cy='submit']")
    private WebElement searchBtn;
    
    @FindBy(xpath = "//div[contains(@class,'DayPicker-Day--today')]")
    private WebElement todayDate;


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

        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//ul[@role='listbox']")));

        new Actions(driver).pause(Duration.ofMillis(400)).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).perform();
    }

    public void enterTo(String station) {

        wait.until(ExpectedConditions.elementToBeClickable(toLabel));
        js.executeScript("arguments[0].click();", toLabel);

        wait.until(ExpectedConditions.visibilityOf(toInput));
        toInput.clear();
        toInput.sendKeys(station);

        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//ul[@role='listbox']")));

        new Actions(driver).pause(Duration.ofMillis(400)).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).perform();
    }

   
    public void selectDepartureDate(String day) {

    	wait.until(ExpectedConditions.elementToBeClickable(departureLabel));
        js.executeScript("arguments[0].click();", departureLabel);

        wait.until(ExpectedConditions.elementToBeClickable(todayDate));
        js.executeScript("arguments[0].click();", todayDate);
    }
   

    public void clickSearch() {

        wait.until(ExpectedConditions.elementToBeClickable(searchBtn));
        js.executeScript("arguments[0].scrollIntoView({block:'center'});", searchBtn);
        js.executeScript("arguments[0].click();", searchBtn);
    }
}
package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class BookingMainPage extends BasePage {

    public static final String SEARCH_RESULT_DROPDOWN_LOCATOR = "//span[contains(text(),'%s')]";

    @FindBy(css = "[data-placeholder = 'Check-in date']")
    private WebElement dataSkip;

    @FindBy(css = ".sb-searchbox__button")
    private WebElement buttonSearch;

    @FindBy(css = "input[type = 'search']")
    private WebElement searchField;

    public BookingMainPage(WebDriver driver) {
        super(driver);
    }

    public void inputHotelName(String searchString) {
        dataSkip.click();
        searchField.sendKeys(searchString);
        driver.findElement(By.xpath(String.format(SEARCH_RESULT_DROPDOWN_LOCATOR, searchString))).click();
    }

    public void clickSearch() {
        buttonSearch.click();
    }
}

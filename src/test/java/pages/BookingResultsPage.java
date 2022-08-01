package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class BookingResultsPage extends BasePage {

    public static final String HOTEL_RATING_LOCATOR = "//span[contains(text(),'%s')]//ancestor::div[contains(@class," +
            "'sr_property_block_main_row')]//div[@class = \"bui-review-score__badge\"]";




    @FindBy(xpath = "//h1[contains(text(),' properties found')]")
    private WebElement resultOfSearch;







    public String getRatingFor(String hotelName) {
        return driver.findElement(By.xpath(String.format(HOTEL_RATING_LOCATOR, hotelName))).getText();
    }
}

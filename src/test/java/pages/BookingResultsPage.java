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


    @FindBy(xpath = "//span[contains(@class,'sr-hotel__name')]")
    private List<WebElement> resultsHotels;

    @FindBy(xpath = "//h1[contains(text(),' properties found')]")
    private WebElement resultOfSearch;


    public BookingResultsPage(WebDriver driver) {
        super(driver);
    }

    public List<String> getResults() {
        List<String> list = resultsHotels.stream().map(result -> result.getAttribute("innerText"))
                .filter(result -> !result.isEmpty()).collect(Collectors.toList());
        List<String> strings = new ArrayList<>();
        for (String s : list) {
            String str = s.substring(0, s.length() - 1);
            strings.add(str);
        }
        return strings;

    }

    public boolean isPageOpened() {
        return resultOfSearch.isDisplayed();
    }

    public String getRatingFor(String hotelName) {
        return driver.findElement(By.xpath(String.format(HOTEL_RATING_LOCATOR, hotelName))).getText();
    }
}

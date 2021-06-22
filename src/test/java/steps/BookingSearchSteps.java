package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.BookingMainPage;
import pages.BookingResultsPage;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class BookingSearchSteps {

    private static final String BOOKING_URL = " https://www.booking.com/searchresults.en-gb.html";
    WebDriver driver;
    String searchString;

    @Before
    public void init() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @Given("I want to search for {string}")
    public void iWantToSearchFor(String hotelName) {
        searchString = hotelName;
    }

    @When("I do search")
    public void iDoSearch() {
        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
        driver.get(BOOKING_URL);
        BookingMainPage bookingMainPage = new BookingMainPage(driver);
        bookingMainPage.inputHotelName(searchString);
        bookingMainPage.clickSearch();
    }

    @Then("Results page should contain {string}")
    public void resultsPageShouldContain(String searchString) {
        BookingResultsPage page = new BookingResultsPage(driver);
        assertTrue(page.isPageOpened());
        List<String> hotels = page.getResults();
        assertTrue(hotels.contains(searchString));
    }

    @And("rating should be {string}")
    public void ratingShouldBe(String expectedRating) {
        BookingResultsPage page = new BookingResultsPage(driver);
        String rating = page.getRatingFor(searchString);
        assertEquals(rating, expectedRating);
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}

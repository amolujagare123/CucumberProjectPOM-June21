package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.BookingSearchResult;

import static stepdefinitions.SharedSD.getDriver;

public class BookingSD {

    BookingSearchResult bookingSearchResult = new BookingSearchResult();

    @Given("^I am on default locations search result screen$")
    public void i_am_on_default_locations_search_result_screen()
             {

                 Assert.assertEquals("this is not a darksky home page",
                         "Booking.com : Hotels in Mumbai . Book your hotel now!",
                         getDriver().getTitle());

    }

    @When("^I select property class (.+)$")
    public void i_select_property_class(String stars)
            {

                // stars --> 5 stars --> stars.split(" ")[0]

                bookingSearchResult.clickStarRatings(stars.split(" ")[0]);

    }

    @Then("^I verify system displays only (.+) hotels on search result$")
    public void i_verify_system_displays_only_hotels_on_search_result(String stars)
             {

    }


}

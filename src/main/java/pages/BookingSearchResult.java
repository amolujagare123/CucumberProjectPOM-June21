package pages;

import org.openqa.selenium.By;

import static stepdefinitions.SharedSD.getDriver;

public class BookingSearchResult extends Base{

    public void clickStarRatings(String starNumber)
    {
        getDriver().findElement(By.xpath("//div[@data-id='filter_class']//a[@data-id='class-"+starNumber+"']")).click();
    }
}

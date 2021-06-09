package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import pages.DarkSkyHomePage;

import java.util.ArrayList;
import java.util.Collections;

import static stepdefinitions.SharedSD.getDriver;

public class DarkskySD {

    DarkSkyHomePage darkSkyHomePage = new DarkSkyHomePage();

    @Given("^I am on Darksky Home Page$")
    public void i_am_on_darksky_home_page() throws Throwable {

        Assert.assertEquals("this is not a darksky home page",
    "Dark Sky - Sansad Marg, New Delhi, Delhi",
                getDriver().getTitle());

    }


    @Then("^I verify current temp is equal to Temperature from Daily Timeline$")
    public void i_verify_current_temp_is_equal_to_temperature_from_daily_timeline()
             {

                 int expected = darkSkyHomePage.getTemp();
                 int actual = darkSkyHomePage.getTimelineTemp();

                 System.out.println("expected="+expected);
                 System.out.println("actual="+actual);

                 Assert.assertEquals("Temperatures are not equal",
                         expected,actual);
    }

    @Then("^I verify timeline is displayed with two hours incremented$")
    public void i_verify_timeline_is_displayed_with_two_hours_incremented()
            {
                ArrayList<Integer> timelist = darkSkyHomePage.getTimeList();
                System.out.println(timelist);
                //[9, 11, 1, 3, 5, 7, 9, 11, 1, 3, 5] --> size is 11 (last index 10)
                ArrayList<Integer> timeDiffList = new ArrayList<>();

                for(int i=0;i<timelist.size()-1;i++)
                {
                    int time1 = timelist.get(i);
                    int time2 = timelist.get(i+1);

                    int timeDiff = 0;
                    if(time2>time1)
                      timeDiff = time2-time1;
                    if(time1>time2)
                        timeDiff = (time2+12) - time1;

                    timeDiffList.add(timeDiff);
                }
                System.out.println(timeDiffList);

                int size = timeDiffList.size();

                int occarance = Collections.frequency(timeDiffList,2);

                boolean result = (size == occarance);

                Assert.assertTrue("all differences are not 2",result);

    }


    @Then("^I verify today's lowest and highest temp is displayed correctly$")
    public void i_verify_todays_lowest_and_highest_temp_is_displayed_correctly()
    {
        darkSkyHomePage.clickTodayTemp();

        ArrayList<String> expected = darkSkyHomePage.getBarTempList();

        ArrayList<String> actual = darkSkyHomePage.timelineTempList();

        Assert.assertEquals("Temp List are different",expected,actual);

    }


}

package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import java.util.ArrayList;

import static stepdefinitions.SharedSD.getDriver;

public class DarkSkyHomePage extends Base{

    By tempRowText = By.xpath("//span[@class='summary swap']"); //99˚ Clear.
    By timelineTempRowText = By.xpath("//span[@class='first']//span"); // 99°
    By timeRowList = By.xpath("//span[@class='hour']/span");
    By todaysTemp = By.xpath("//a[@data-day='0']/span[@class='toggle']");

    By barMinTemp = By.xpath("//a[@class='day revealed']//span[@class='minTemp']");
    By barMaxTemp = By.xpath("//a[@class='day revealed']//span[@class='maxTemp']");

    By timelineMinTemp = By.xpath("//div[@class='dayDetails revealed']//span[@class='highTemp swip']//span[@class='temp']");
    By timelineMaxTemp = By.xpath("//div[@class='dayDetails revealed']//span[@class='lowTemp swap']//span[@class='temp']");

    By lnkDarkSkyAPI = By.xpath("//a[normalize-space()='Dark Sky API']");

    public void clickLnkDarkskyAPI()
    {
        clickOn(lnkDarkSkyAPI);
    }


    public ArrayList<String> getBarTempList()
    {
        String minTemp = getTextFromElement(barMinTemp).split("˚")[0]; // 93˚
        String maxTemp = getTextFromElement(barMaxTemp).split("˚")[0]; // 93˚

        ArrayList<String> tempList = new ArrayList<>();
        tempList.add(minTemp);
        tempList.add(maxTemp);
        System.out.println("Bar tempList="+tempList);
        return tempList;
    }

    public ArrayList<String> timelineTempList()
    {
        String minTemp = getTextFromElement(timelineMinTemp).split("˚")[0]; // 93˚
        String maxTemp = getTextFromElement(timelineMaxTemp).split("˚")[0]; // 93˚

        ArrayList<String> tempList = new ArrayList<>();
        tempList.add(minTemp);
        tempList.add(maxTemp);
        System.out.println("Timeline tempList="+tempList);
        return tempList;
    }


    public void clickTodayTemp()
    {
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("window.scrollBy(0,1000)");

        js.executeScript("arguments[0].click()",
        webAction(todaysTemp));
        //clickOn(todaysTemp);
    }



    public ArrayList<Integer> getTimeList()
    {
        ArrayList<String> timeList = getElementTextList(timeRowList);
        System.out.println(timeList);

        ArrayList<Integer> timeListInt = new ArrayList<>();
        for(int i=0;i<timeList.size();i++)
        {
            String timeStrRow = timeList.get(i); // 9pm

            int l = timeStrRow.length();

              String timeStr =  timeStrRow.substring(0,l-2);
              int time = Integer.parseInt(timeStr);

                timeListInt.add(time);
        }

        return timeListInt;
    }



    public int getTemp()
    {
        String tempRowStr =  getTextFromElement(tempRowText);
        //tempRowStr = "99˚ Clear." --> {"99"," Clear."}
        String tempStr = tempRowStr.split("˚")[0];

        return Integer.parseInt(tempStr);
    }

    public int getTimelineTemp()
    {
        String tempRowStr =  getTextFromElement(timelineTempRowText);
        //tempRowStr = "99°" --> {"99"}
        String tempStr = tempRowStr.split("°")[0];
        return Integer.parseInt(tempStr);
    }
}

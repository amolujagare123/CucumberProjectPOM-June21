package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import java.util.ArrayList;

import static stepdefinitions.SharedSD.getDriver;

public class DarkSkyHomePage extends Base{

    By tempRowText = By.xpath("//span[@class='summary swap']"); //99˚ Clear.
    By timelineTempRowText = By.xpath("//span[@class='first']//span"); // 99°
    By timeRowList = By.xpath("//span[@class='hour']/span");
    By todaysTemp = By.xpath("//a[@data-day='0']");

    public void clickTodayTemp()
    {
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("window.scrollBy(0,900)");

        clickOn(todaysTemp);
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

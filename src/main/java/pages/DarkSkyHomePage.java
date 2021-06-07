package pages;

import org.openqa.selenium.By;

public class DarkSkyHomePage extends Base{

    By tempRowText = By.xpath("//span[@class='summary swap']"); //99˚ Clear.
    By timelineTempRowText = By.xpath("//span[@class='first']//span"); // 99°

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

package pages;

import org.openqa.selenium.By;

public class DarkSkyAPIPAge extends  DarkSkyHomePage{

    By loginLnk = By.xpath("//a[@class='button']");


    public void clickLoginLnk()
    {
        clickOn(loginLnk);
    }
}

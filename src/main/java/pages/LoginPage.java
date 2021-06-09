package pages;

import org.openqa.selenium.By;

public class LoginPage extends DarkSkyAPIPAge{

    By loginBtn = By.xpath("//button[@type='submit']");

    public void clickLoginBtn()
    {
        clickOn(loginBtn);
    }

}

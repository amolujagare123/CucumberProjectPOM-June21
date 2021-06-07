package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;

import static utilities.ConfigReader.getUrl;

public class SharedSD {

    public static WebDriver driver;

    @Before
    public void openBrowser() throws IOException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(getUrl());

    }

    @After
    void closeBrowser()
    {
       // driver.close();
    }

    public static WebDriver getDriver()
    {
       /* WebElement element =  driver.findElement(By.id("xyz"));
        By elementLocator = By.id("xyz");
        WebElement element1 =  driver.findElement(elementLocator);*/

        return driver;





    }
}

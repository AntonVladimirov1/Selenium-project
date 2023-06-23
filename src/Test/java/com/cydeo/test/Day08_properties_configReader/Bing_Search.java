package com.cydeo.test.Day08_properties_configReader;

import com.cydeo.Utilities.ConfigReader;
import com.cydeo.Utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Bing_Search  {

   /* WebDriver driver;

    @BeforeClass
    public void setup() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    */

    @Test
    public void bingSearch() throws InterruptedException {
        Driver.getDriver().get(ConfigReader.getProperty("bingURL"));
        WebElement searchBox = Driver.getDriver().findElement(By.xpath("//textarea[@name='q']"));
        searchBox.click();
        searchBox.sendKeys("apple" + Keys.ENTER);
        Thread.sleep(2000);

        String actTitle = Driver.getDriver().getTitle();
        String expTitle = "apple - Search";
        System.out.println("expTitle = " + expTitle);
        System.out.println("actTitle = " + actTitle);
        Assert.assertEquals(actTitle,expTitle);



    }

}

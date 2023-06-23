package com.cydeo.test.Day09_Javafaker_DriverUtil;

import com.cydeo.Utilities.BrowserUtils;
import com.cydeo.Utilities.ConfigReader;
import com.cydeo.Utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Driver_Util_practice {

  /*  WebDriver driver;

    @BeforeClass
    public void setup() {
        driver = WebDriverFactory.getDriver(ConfigReader.getProperty("browser"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }  */

    @Test (priority = 1)
    public void bingSearch1(){

        Driver.getDriver().get(ConfigReader.getProperty("bingURL"));
        WebElement searchBox = Driver.getDriver().findElement(By.xpath("//textarea[@name='q']"));
        searchBox.click();
        searchBox.sendKeys("apple" + Keys.ENTER);
        BrowserUtils.sleep(5);

        String actTitle = Driver.getDriver().getTitle();
        String expTitle = ConfigReader.getProperty("searchValue")+" - Search";
        System.out.println("expTitle = " + expTitle);
        System.out.println("actTitle = " + actTitle);
        Assert.assertEquals(actTitle,expTitle);
    }

    @Test (priority = 2)
    public void bingSearch2(){

        Driver.getDriver().get(ConfigReader.getProperty("bingURL"));
        WebElement searchBox = Driver.getDriver().findElement(By.xpath("//textarea[@name='q']"));
        searchBox.click();
        searchBox.sendKeys("apple" + Keys.ENTER);
        BrowserUtils.sleep(5);

        String actTitle = Driver.getDriver().getTitle();
        String expTitle = ConfigReader.getProperty("searchValue")+" - Search";
        System.out.println("expTitle = " + expTitle);
        System.out.println("actTitle = " + actTitle);
        Assert.assertEquals(actTitle,expTitle);
    }

  //  @AfterMethod
   // public void tearDown(){
      //  Driver.closeDriver();
   // }

}

package com.cydeo.test.Day06_Alerts_Iframes_Windows;

import com.cydeo.Utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Windows {

    WebDriver driver;

    @BeforeClass
    public void setup(){
        driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @Test(priority = 1)
    public void multipleWindows() throws InterruptedException {
        driver.get("https://practice.cydeo.com/windows");

        String expTitle = "Windows";
        String actTitle = driver.getTitle();
        Assert.assertEquals(actTitle,expTitle);

        String mainHandle = driver.getWindowHandle();
        System.out.println("mainHandle = " + mainHandle);
        //System.out.println("driver.getTitle() = " + driver.getTitle());

        WebElement clickHere = driver.findElement(By.linkText("Click Here"));
        clickHere.click();
        //System.out.println("driver.getTitle() = " + driver.getTitle());
        clickHere.click();

        for (String each:driver.getWindowHandles() ) {
            driver.switchTo().window(each);
            System.out.println("Title while switching = " + driver.getTitle());
        }
        String expNewTitle = "New Window";
        actTitle = driver.getTitle();
        Assert.assertEquals(actTitle,expNewTitle);

        //if we have to go to the main page to continue our tet case,
        // we can use mainHandle to switch
        driver.switchTo().window(mainHandle);
        //code

    }

}

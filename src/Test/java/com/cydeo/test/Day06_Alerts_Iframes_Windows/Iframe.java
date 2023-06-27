package com.cydeo.test.Day06_Alerts_Iframes_Windows;

import com.cydeo.Utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Iframe {

    WebDriver driver;

    @BeforeClass
    public void setup(){
        driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @Test(priority = 1)
    public void informationAlert() throws InterruptedException {
        driver.get("https://practice.cydeo.com/iframe");

        driver.switchTo().frame("mce_0_ifr");  //* to Iframe - by value
        //driver.switchTo().frame(0); // by index
        //driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id='mce_0_ifr']"))); // by WebElement
        WebElement paragraphText = driver.findElement(By.xpath("//p[.='Your content goes here.']"));
        Assert.assertTrue(paragraphText.isDisplayed());

        driver.switchTo().parentFrame();  //* from Iframe (back to main HTML)/or .defaultContent
        //driver.switchTo().defaultContent(); // method to directly return to the main frame

        WebElement h3= driver.findElement(By.tagName("h3"));
        Assert.assertTrue(h3.isDisplayed());

    }

}

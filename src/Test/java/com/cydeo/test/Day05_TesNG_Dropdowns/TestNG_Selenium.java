package com.cydeo.test.Day05_TesNG_Dropdowns;

import com.cydeo.Utilities.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class TestNG_Selenium {

    WebDriver driver;

    @BeforeMethod
    public void setupMethod(){
        driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
    }

    @AfterMethod
    public void tearDown(){
        driver.close();
    }

    @Test (priority = 1)
    public void test1_cydeo_title(){

        driver.get("https://cydeo.com");

        String actualTitle = driver.getTitle();
        String expectedTitle = "Cydeo";
        Assert.assertEquals(actualTitle,expectedTitle);
    }
    @Test (priority = 2)
    public void test2_practice_title(){

        driver.get("https://practice.cydeo.com");

        String actualTitle = driver.getTitle();
        String expectedTitle = "Practice";
        Assert.assertEquals(actualTitle,expectedTitle);
    }
}

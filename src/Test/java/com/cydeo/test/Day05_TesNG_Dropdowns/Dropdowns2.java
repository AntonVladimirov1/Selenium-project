package com.cydeo.test.Day05_TesNG_Dropdowns;

import com.cydeo.Utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;



public class Dropdowns2 {
    WebDriver driver;

    @BeforeClass
    public void setup(){
        driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }


    @Test
    public void dropdownDate() throws InterruptedException {
        driver.get("https://practice.cydeo.com/dropdown");
        Select year = new Select(driver.findElement(By.xpath("//select[@id='year']")));
        Select month = new Select(driver.findElement(By.xpath("//select[@id='month']")));
        Select day = new Select(driver.findElement(By.xpath("//select[@id='day']")));

        Thread.sleep(1000);
        year.selectByVisibleText("1933");
        Thread.sleep(1000);
        month.selectByValue("11");
        Thread.sleep(1000);
        day.selectByIndex(3);

        String expYear="1933";
        String expMonth="December";
        String expDay="4";

        String actYear= year.getFirstSelectedOption().getText();
        String actMonth= month.getFirstSelectedOption().getText();
        String actDay= day.getFirstSelectedOption().getText();

        Assert.assertEquals(expYear,actYear);
        Assert.assertEquals(expMonth,actMonth);
        Assert.assertEquals(expDay,actDay);
    }

    @Test
    public void dropdownState() throws InterruptedException {

        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://practice.cydeo.com/dropdown");
        Select states = new Select(driver.findElement(By.xpath("//select[@id='state']")));


        Thread.sleep(1000);
        states.selectByVisibleText("Illinois");
        Thread.sleep(1000);
        states.selectByValue("VA");
        Thread.sleep(1000);
        states.selectByIndex(5);

        String expState="California";
        String actText=states.getFirstSelectedOption().getText();
        Assert.assertEquals(expState,actText,"Not as expected");
    }

}

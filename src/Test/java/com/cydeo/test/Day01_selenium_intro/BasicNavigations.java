package com.cydeo.test.Day01_selenium_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasicNavigations {

    public static void main(String[] args) throws InterruptedException {

        //* Every time we will need to setUp webDriver (Chrome)

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.movinghelp.com/login");                                                                                         // Login page
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//*[@id=\"Username\"]")).sendKeys("l.a.v7232@gmail.com");                          // Username
        driver.findElement(By.xpath("//*[@id=\"Password\"]")).sendKeys("Locerr11@@");                                   // Password
        driver.findElement(By.cssSelector("input[type='submit']")).click();                                                                     //Submit
        Thread.sleep(1000);
        //driver.findElement(By.xpath("//a[@href='https://www.movinghelp.com/']"));
        driver.navigate().to("https://www.movinghelp.com/");                                                                                //Home button
        driver.findElement(By.xpath("//*[@id=\"SearchModel_FirstLocation_ServiceAddress\"]")).sendKeys("12100 Northpointe Blvd Tomball, Texas 77377, United States");                                                                                                         // address
        driver.findElement(By.xpath("//*[@id=\"SearchModel_FirstLocation_JobDate\"]")).click();                                    //Date
        driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/table/tbody/tr[4]/td[5]/a")).click();                          // exact date
        driver.findElement(By.xpath("//*[@id=\"SearchModel_FirstLocation_JobTime_Mobile\"]")).sendKeys("Morning");      //time
        driver.findElement(By.cssSelector("#movinghelp > div > div:nth-child(2) > form > div:nth-child(7) > div > button")).click();            //Search
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"serviceProvidersColumn\"]/section/div[2]/div[2]/div[1]/h3/a")).click();      // specific provider click
        driver.findElement(By.xpath("//*[@id=\"DetailsOfMove\"]")).sendKeys("nothing");                                  // Details
        driver.findElement(By.xpath("//*[@id=\"submitButton\"]")).click();                                                          // Add to Cart
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"successModal\"]/div/a[2]")).click();                                                 // View Cart
/*
        // use navigation to go back
        driver.navigate().back();

        // keep execution frozen for 2 sec.
        Thread.sleep(2000);

        driver.navigate().forward();
        Thread.sleep(2000);
        driver.navigate().refresh();
        Thread.sleep(2000);

        // navigate to (same as get method)
        driver.navigate().to("https://google.com");

        driver.close(); // closes only current tab
        driver.quit(); // closes whole browser

 */
    }

}

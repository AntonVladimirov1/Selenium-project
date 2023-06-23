package com.cydeo.Antonio;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class MyWork {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        // Create an instance of browser
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.movinghelpd.com/login");                                                                                       //Login page
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//*[@id=\"Username\"]")).sendKeys("antoniopupkin1972@gmail.com");                 //Username
        driver.findElement(By.xpath("//*[@id=\"Password\"]")).sendKeys("Locerr11@@");                                  //Password
        driver.findElement(By.cssSelector("input[type='submit']")).click();                                                                    //Submit
        Thread.sleep(1000);

        driver.navigate().to("https://www.movinghelpd.com/");                                                                               //Home button
        driver.findElement(By.xpath("//*[@id=\"SearchModel_FirstLocation_ServiceAddress\"]")).sendKeys("12100 Northpointe Blvd Tomball, Texas 77377, United States");                                                                                                         //Address
        driver.findElement(By.xpath("//*[@id=\"SearchModel_FirstLocation_JobDate\"]")).click();                                    //Date
        driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/table/tbody/tr[4]/td[5]/a")).click();                          //Exact date
        driver.findElement(By.xpath("//*[@id=\"SearchModel_FirstLocation_JobTime_Mobile\"]")).sendKeys("Morning");      //Time
        driver.findElement(By.cssSelector("#movinghelp > div > div:nth-child(2) > form > div:nth-child(7) > div > button")).click();            //Search
        driver.navigate().refresh();
        Thread.sleep(1000);

        driver.findElement(By.xpath("//a[text()='TexasBest']")).click();                                                //Specific provider click
        driver.findElement(By.xpath("//*[@id=\"DetailsOfMove\"]")).sendKeys("dfgdfgdfg");                               //Details
        driver.findElement(By.xpath("//*[@id=\"submitButton\"]")).click();                                                         //Add to Cart
        Thread.sleep(3000);
        driver.findElement(By.xpath("//div[@id='successModal']//a[2]")).click();                                                   //View Cart

        // ==========================================>> Payment <<=======================================================================================

        driver.findElement(By.xpath("//input[@name='CreditCardNumber']")).sendKeys("4445222299990007");                 //Card
        driver.findElement(By.xpath("//*[@id='ExpirationMonth']")).sendKeys("12");                                      //Card
        driver.findElement(By.xpath("//*[@id='ExpirationYear']")).sendKeys("2025");                                     //Card
        driver.findElement(By.xpath("//*[@id='CardSecurityCode']")).sendKeys("222");                                    //Card
        driver.findElement(By.xpath("//*[@id='PreferredContactMethod']")).sendKeys("Email");                  //Contact method
        driver.findElement(By.xpath("(//input[@id='SendTextMessageUpdates'])[2]//..")).click();                          //Text message "NO"
        driver.findElement(By.xpath("(//input[@id='Agreement'])//..")).click();                                          //CheckBox Terms

        //==========================================>> Confirm Order <<==================================================================================

        //driver.findElement(By.xpath("//button[@class='button submit-button']")).click();                                       //Submit

    }
}

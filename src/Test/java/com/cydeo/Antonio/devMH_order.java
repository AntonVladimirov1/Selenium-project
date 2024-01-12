package com.cydeo.Antonio;

import com.cydeo.Utilities.ConfigReader;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class devMH_order {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        // Create an instance of browser
        WebDriver driver = new ChromeDriver();

        driver.get(ConfigReader.getProperty("devMHloginURL"));                                                                                       //Login page
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//*[@id=\"Username\"]")).sendKeys(ConfigReader.getProperty("devMHusername"));                 //Username
        driver.findElement(By.xpath("//*[@id=\"Password\"]")).sendKeys(ConfigReader.getProperty("devMHpassword"));                 //Password
        driver.findElement(By.cssSelector("input[type='submit']")).click();                                                                     //Submit
        //BrowserUtils.sleep(2);

        driver.navigate().to(ConfigReader.getProperty("devMHhomeURL"));                                                                         //Home button
        driver.findElement(By.xpath("//*[@id=\"SearchModel_FirstLocation_ServiceAddress\"]")).sendKeys("12100 Northpointe Blvd Tomball, Texas 77377, United States");                                                                                                         //Address
        driver.findElement(By.xpath("//*[@id=\"SearchModel_FirstLocation_JobDate\"]")).click();                                    //Date field
        driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/table/tbody/tr[4]/td[2]/a")).click();                          //Exact date
        driver.findElement(By.xpath("//*[@id=\"SearchModel_FirstLocation_JobTime_Mobile\"]")).sendKeys("Morning");      //Time
        driver.findElement(By.xpath("//button[.='Search']")).click();                                                               //Search
        //driver.navigate().refresh();
        //BrowserUtils.sleep(1);

        driver.findElement(By.xpath("//a[text()='TexasBest']")).click();                                                         //Provider choose
        driver.findElement(By.xpath("//*[@id=\"DetailsOfMove\"]")).sendKeys("dfgdfgdfg");                               //Details
        driver.findElement(By.xpath("//*[@id=\"submitButton\"]")).click();                                                         //Add to Cart
        //BrowserUtils.sleep(1);
        driver.findElement(By.xpath("//div[@id='successModal']//a[2]")).click();                                                   //View Cart

        // ==========================================>> Payment <<=======================================================================================

        driver.findElement(By.xpath("//input[@name='CreditCardNumber']")).sendKeys(ConfigReader.getProperty("devCC"));             //Card num
        driver.findElement(By.xpath("//*[@id='ExpirationMonth']")).sendKeys("12");                                      //Card
        driver.findElement(By.xpath("//*[@id='ExpirationYear']")).sendKeys("2025");                                     //Card
        driver.findElement(By.xpath("//*[@id='CardSecurityCode']")).sendKeys(ConfigReader.getProperty("devCSC"));                  //Card CSC
        driver.findElement(By.xpath("//*[@id='PreferredContactMethod']")).sendKeys("Email");                         //Contact method
        driver.findElement(By.xpath("(//input[@id='SendTextMessageUpdates'])[2]//..")).click();                                 //Text message "NO"
        driver.findElement(By.xpath("(//input[@id='Agreement'])//..")).click();                                                 //CheckBox Terms

        //==========================================>> Confirm Order <<==================================================================================

        //driver.findElement(By.xpath("//button[@class='button submit-button']")).click();                                       //Submit
    }
}

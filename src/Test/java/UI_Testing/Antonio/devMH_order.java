package UI_Testing.Antonio;

import UI_Testing.Utilities.BrowserUtils;
import UI_Testing.Utilities.CRM_Login;
import UI_Testing.Utilities.ConfigReader;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class devMH_order {

    public static String currentDate;
    public static String jobNumber;
    public static String orderNumber;


    public static void main(String[] args) throws IOException {

        //================================== Created variable CURRENT DATE (from DatePicker) ==================
        DateTimeFormatter df = DateTimeFormatter.ofPattern("d");
        LocalDate today = LocalDate.now();
        currentDate = df.format(today);

        //========================================= SetUp Headless mode (if needed) =============================
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        //=================================== Create an instance of Driver ======================================
        WebDriver driver = new ChromeDriver(options); //<<< insert ('options') for headless mode
        driver.manage().window().maximize();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));        // declare "wait" variable

        // ==========================================>> LogIn <<==========================================================================================
        devMHLoginPage.login(driver);                                                                                                         //Login page

        BrowserUtils.sleep(3);

        // ==========================================>> HomePage/Address/Date <<===========================================================================
        driver.navigate().to(ConfigReader.getProperty("devMHhomeURL"));                                                                       //Home button
        //driver.findElement(By.xpath("//div[@class='show-for-desktop sticky-container']//a[text()='Home']")).click();
        driver.findElement(By.xpath("//*[@id='SearchModel_FirstLocation_ServiceAddress']")).sendKeys(ConfigReader.getProperty("addressTX")); //Address
        driver.findElement(By.xpath("//*[@id='SearchModel_FirstLocation_JobDate']")).click();                                  //Date field
        //driver.findElement(By.xpath("//input[@id='SearchModel_FirstLocation_JobDate']")).sendKeys(currentDate);
        driver.findElement(By.xpath("//td[@data-handler='selectDay']/a[.='" + currentDate + "']")).click();                      //Current date
        driver.findElement(By.xpath("//*[@id='SearchModel_FirstLocation_JobTime_Mobile']")).sendKeys("Evening");    //Time
        driver.findElement(By.xpath("//button[.='Search']")).click();                                                            //Search
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='TexasBest']")));                         //wait

        // ============================================>> Provider select <<================================================================================
        driver.findElement(By.xpath("//a[text()='TexasBest']")).click();                                                      //Provider select

        //=============================================>> Safeload option <<================================================================================
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='safeloadModal']//a[@href='#']")));   //Wait
        driver.findElement(By.xpath("//div[@id='safeloadModal']//a[@href='#']")).click();                                  //SafeLoad modal close
        //driver.findElement(By.xpath("//input[@id='LoadUnload_Safeload_Enabled']/../span")).click();                        //SafeLoad checkmark
        //driver.findElement(By.xpath("//select[@id='LoadUnload_Safeload_SelectedInsuranceRateId']/option[2]")).click();     //SafeLoad option2

        // ============================================>> Service type select <<============================================================================
        //driver.findElement(By.xpath("(//input[@id='LoadUnload_Enabled'])//..")).click();                                 // Load/Unload (click if need to cancel)
        //driver.findElement(By.xpath("(//input[@id='PackOrUnPack_Enabled'])//..")).click();                                       // Pack/Unpack
        //driver.findElement(By.xpath("(//input[@id='MaidServicesOrHomeCleaning_Enabled'])//..")).click();                         // Cleaning
        //driver.findElement(By.xpath("(//input[@id='PianoMoving_Enabled'])//..")).click();                                        // Piano
        //driver.findElement(By.xpath("(//input[@id='SafeMoving_Enabled'])//..")).click();                                         // Gun Safe

        // ===============================================>> Details and Cart <<============================================================================
        driver.findElement(By.xpath("//*[@id='DetailsOfMove']")).sendKeys("dfgdfgdfg");                            //Details
        driver.findElement(By.xpath("//*[@id='submitButton']")).click();                                                       //Add to Cart
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='successModal']//div//a[.='View Cart']")));  //Wait
        driver.findElement(By.xpath("//div[@id='successModal']//div//a[.='View Cart']")).click();                                //View Cart

        // ==================================================>> Discount Employee <<=========================================================================
        //driver.findElement(By.xpath("//*[@id=\"CertificateCode\"]")).sendKeys(ConfigReader.getProperty("discountEmployee"));    //Employee discount
        //driver.findElement(By.xpath("//button[.='Apply']")).click();

        // ====================================================>> Payment Cert <<============================================================================
        //driver.findElement(By.xpath("//*[@id='CertificateCode']")).sendKeys(ConfigReader.getProperty("certVIP"));                //Cert num
        //driver.findElement(By.xpath("//button[.='Apply']")).click();                                                             //Apply

        // =====================================================>> Payment CC <<=============================================================================
        driver.findElement(By.xpath("//input[@name='CreditCardNumber']")).sendKeys(ConfigReader.getProperty("devCC"));           //Card num
        driver.findElement(By.xpath("//*[@id='ExpirationMonth']")).sendKeys("12");                                   //Card
        driver.findElement(By.xpath("//*[@id='ExpirationYear']")).sendKeys("2025");                                  //Card
        driver.findElement(By.xpath("//*[@id='CardSecurityCode']")).sendKeys(ConfigReader.getProperty("devCSC"));                //Card CSC

        // =====================================================>> Other Info Input <<=======================================================================
        driver.findElement(By.xpath("//*[@id='PreferredContactMethod']")).sendKeys("Email");                      //Contact method
        driver.findElement(By.xpath("(//input[@id='SendTextMessageUpdates'])[1]//..")).click();                               //Text message "YES"
        driver.findElement(By.xpath("(//input[@id='Agreement'])//..")).click();                                               //CheckBox Terms

        //====================================================>> Confirm Order <<=============================================================================
        driver.findElement(By.xpath("//button[@class='button submit-button']")).click();                                        //Submit
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='ComModal']/div[1]/div[2]/a")));
        driver.findElement(By.xpath("//*[@id='ComModal']/div[1]/div[2]/a")).click();                                        //Confirmation Modal close

        //========================================================>> Screenshot <<=====================================================================
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        String screenshotPath = "target/new_Order_" + today + ".png";
        FileUtils.copyFile(source, new File(screenshotPath));
        System.out.println("Screenshot in target folder");

        //====================================================>> Pull Job/Order number <<================================================================
        // driver.findElement(By.xpath("//div[@id='ComModal']//a[@href='#']//i")).click();
        jobNumber = driver.findElement(By.xpath("//table/tbody/tr[1]/td[3]")).getText();
        orderNumber = driver.findElement(By.xpath("//dl[@class='inline']//dd")).getText();
        System.out.println(jobNumber);
        System.out.println(orderNumber);

        //=====================================================>> Find Scheduled Job (recently created)<<=====================================================
       /* driver.navigate().to("https://www.movinghelpd.com/jobs");                                                                 //My Jobs

        //*[@id="jobdetailsID"]/a/h3/span[2]/text()
        driver.findElement(By.xpath("//*[@id='jobdetailsID']/a/h3/span[2]/text()='" + jobNumber + "')).click();
        //*[@id="primary"]/ul/li[2]/div/ul/li[1]/a
        //*[@id="primary"]/ul/li[2]/div[2]/ul/li[1]/a
        //*[@id='dynatraceJobNumber'][.='JB-3b6e7285']
        //*[@id="jobdetailsID"]/a/h3/span[2]/text()='Job Number: JB-3b6e7285'
        //html/body/div[3]/section/div[3]/div/div/table/tbody/tr[1]/td[3]/text()
        //html/body/div[3]/section/div[3]/div/div/table/tbody/tr[1]/td[3]/label

        //=======================================================>> Add Hours <<===================================================================
        driver.findElement(By.xpath("//a[text()='Edit']")).click();
        driver.findElement(By.xpath("//*[@id='add-hours-button']")).click();
        driver.findElement(By.xpath("//div[@id='modal-payment']//button[.='Pay Now']")).click();

        */

        //=======================================================>> Closing Browser <<====================================================================
        driver.quit();

    }
}
              //========================================================>> End <<=======================================================//
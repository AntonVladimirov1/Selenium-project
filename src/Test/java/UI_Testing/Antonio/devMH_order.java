package UI_Testing.Antonio;

import UI_Testing.Utilities.BrowserUtils;
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
    //public static String jobNumberLower;


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

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));  // <<<<<  declare "wait" variable

        // ==========================================>> LogIn <<==========================================================================================
        devMHPageMethods.login(driver);                                                                                                    //Login page

        // ==========================================>> HomePage/Address/Date <<===========================================================================
        wait.until(ExpectedConditions.titleContains("Current Jobs"));
        driver.navigate().to(ConfigReader.getProperty("devMHhomeURL"));                                                                 //Home button
        driver.findElement(By.xpath("//*[@id='SearchModel_FirstLocation_ServiceAddress']")).sendKeys(ConfigReader.getProperty("addressTX")); //Address
        driver.findElement(By.xpath("//*[@id='SearchModel_FirstLocation_JobDate']")).click();                                  //Date field
        //driver.findElement(By.xpath("//input[@id='SearchModel_FirstLocation_JobDate']")).sendKeys(currentDate);
        driver.findElement(By.xpath("//td[@data-handler='selectDay']/a[.='" + currentDate + "']")).click(); //                 //Current date
        //driver.findElement(By.xpath("//*[@id='SearchModel_FirstLocation_JobTime_Mobile']")).sendKeys("Evening");                  //Time old
        driver.findElement(By.xpath("//*[@id='SearchModel_FirstLocation_JobTime']")).sendKeys("Afternoon");          //Time (new)
        //driver.findElement(By.xpath("//button[.='Search']")).click();                                                            //Search old
        driver.findElement(By.xpath("//*[@id='findHelpersButton']")).click();                                                  //Search (new)


        // ============================================>> Provider select <<================================================================================
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='TexasBest']")));                   //wait
        driver.findElement(By.xpath("//a[text()='TexasBest']")).click();                                                  //Provider select

        //=============================================>> Safeload option <<================================================================================
        devMHPageMethods.safeload(driver);

        // ============================================>> Service type select <<============================================================================
        devMHPageMethods.serviceType(driver);

        // ===================================================>> Add/View Cart <<=========================================================================
        devMHPageMethods.addViewCart(driver);

        // ====================================================>> Discount Employee <<=====================================================================
        devMHPageMethods.discountEmployee(driver);

        // =====================================================>> Cert Info <<============================================================================
        devMHPageMethods.infoCertificate(driver);

        // =====================================================>> CC Info <<==============================================================================
        devMHPageMethods.infoCC(driver);

        // =====================================================>> Payment Submit <<=======================================================================
        devMHPageMethods.paymentSubmit(driver);

        //======================================================>> Screenshot <<===========================================================================
        devMHPageMethods.screenShot(driver);

        //====================================================>> Pull Job/Order number <<==================================================================
        // driver.findElement(By.xpath("//div[@id='ComModal']//a[@href='#']//i")).click();
        jobNumber = driver.findElement(By.xpath("//table/tbody/tr[1]/td[3]")).getText();
        orderNumber = driver.findElement(By.xpath("//dl[@class='inline']//dd")).getText();
        System.out.println(jobNumber);
        System.out.println(orderNumber);
        //BrowserUtils.sleep(5);

        //====================================>> Find Scheduled Job (recently created)========================================================================
         //String jobNumberSpecific = "1ea54dfa";
        //String jobNumberLower = jobNumber.toLowerCase().replace("job number:jb-", "");            //Convert to lowercase and remove prefix
        //String orderNumberLower = orderNumber.toLowerCase().replace("or-", "");                   //Convert to lowercase and remove prefix

        //=========================================================>> Edit > Add Hours <<=======================================================================
        devMHPageMethods.editAddHours(driver);

        //=========================================================>> Edit > Add Helpers <<=======================================================================
        devMHPageMethods.editAddHelpers(driver);

        //=======================================================>> Cancellation <<===========================================================================
        devMHPageMethods.cancellation(driver);

        //=======================================================>> Pay Helper <<==============================================================================
       /* String jobNumberSpecific = "80c4030a";
        driver.navigate().to("https://www.movinghelpd.com/jobs");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[.//span[contains(normalize-space(.),'" + jobNumberSpecific + "')]]"))); //Wait
        driver.findElement(By.xpath("//a[.//span[contains(normalize-space(.),'" + jobNumberSpecific + "')]]")).click();             //Select Job
        driver.findElement(By.xpath("((//button[contains(@data-jobguid,'" + jobNumberSpecific + "') and contains(@class,'button info fullWidth pay-job-modal-button')])[1])[1]")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("((//button[contains(@data-jobguid,'" + jobNumberSpecific + "') and contains(@class,'button pay-job submit-button')])[1])[1]")));
        driver.findElement(By.xpath("((//button[contains(@data-jobguid,'" + jobNumberSpecific + "') and contains(@class,'button pay-job submit-button')])[1])[1]")).click();
        wait.until(ExpectedConditions.titleContains("Review"));      //Wait
        System.out.println("Job Completed");

        //========================================================>> Review <<================================================================================
        driver.findElement(By.xpath("//*[@id='OutstandingCommunications']/..")).click();
        driver.findElement(By.xpath("//*[@id='OutstandingProfessionalism']/..")).click();                 // ALL 5 STARS
        driver.findElement(By.xpath("//*[@id='OutstandingServices']/..")).click();
        driver.findElement(By.xpath("//*[@id='OutstandingOverall']/..")).click();
        //=========================================================>> Tips <<=================================================================================
                                                    ??????????????????
        //========================================================>> Submit Review <<================================================================================
        driver.findElement(By.xpath("//button[.='Submit']")).click();
        System.out.println("Review Submitted");
*/

        //=======================================================>> Closing Browser <<========================================================================
        driver.quit();

    }
}
              //========================================================>> End <<=======================================================//
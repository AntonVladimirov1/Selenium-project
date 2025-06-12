package UI_Testing.Antonio;

import UI_Testing.Utilities.BrowserUtils;
import UI_Testing.Utilities.ConfigReader;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ProdMH_order {


    public static String currentDate;

    public static void main(String[] args) throws IOException {

        //================================== Created variable CURRENT DATE (from DatePicker) ==================
        DateTimeFormatter df = DateTimeFormatter.ofPattern("dd");
        LocalDate today = LocalDate.now();
        currentDate = df.format(today);

        //=================================== Create an instance of Driver ======================================
        WebDriverManager.chromedriver().setup();
        //========================================= SetUp Headless mode (if needed) =============================
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");

        WebDriver driver = new ChromeDriver(); //<<< need to insert in (options)
        driver.manage().window().maximize();

        // ==========================================>> LogIn <<=======================================================================================
        driver.get(ConfigReader.getProperty("prodMHhomeURL")+"login");                                                                           //Login page
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        //devMHLoginPage loginPage = new devMHLoginPage();
        //devMHLoginPage.login();
        driver.findElement(By.xpath("//*[@id=\"Username\"]")).sendKeys(ConfigReader.getProperty("prodMHusername"));               //Username
        driver.findElement(By.xpath("//*[@id=\"Password\"]")).sendKeys(ConfigReader.getProperty("prodMHpassword"));                //Password
        driver.findElement(By.cssSelector("input[type='submit']")).click();                                                                    //Submit

        BrowserUtils.sleep(3);

        // ==========================================>> HomePage/Address/Date <<===========================================================================
        driver.navigate().to(ConfigReader.getProperty("prodMHhomeURL"));                                                                        //Home button
        //driver.findElement(By.xpath("//div[@class='show-for-desktop sticky-container']//a[text()='Home']")).click();
        driver.findElement(By.xpath("//*[@id=\"SearchModel_FirstLocation_ServiceAddress\"]")).sendKeys(ConfigReader.getProperty("address"));                                                                                                                                                //Address
        driver.findElement(By.xpath("//*[@id=\"SearchModel_FirstLocation_JobDate\"]")).click();                                   //Date field
        //driver.findElement(By.xpath("//input[@id='SearchModel_FirstLocation_JobDate']")).sendKeys(currentDate);
        driver.findElement(By.xpath("//td[@data-handler='selectDay']/a[.='" + currentDate + "']")).click();                       //Current date
        driver.findElement(By.xpath("//*[@id=\"SearchModel_FirstLocation_JobTime_Mobile\"]")).sendKeys("Evening");    //Time
        driver.findElement(By.xpath("//button[.='Search']")).click();                                                             //Search
        //driver.navigate().refresh();
        BrowserUtils.sleep(2);

        // ============================================>> Provider select <<================================================================================
        driver.findElement(By.xpath("//a[text()='MH Test Account - DO NOT BOOK.']")).click();                                  //Provider select

        //=============================================>> SAFELOAD option <<================================================================================
        driver.findElement(By.xpath("//div[@id='safeloadModal']//a[@href='#']")).click();                                  //SafeLoad modal close
        driver.findElement(By.xpath("//input[@id=\"LoadUnload_Safeload_Enabled\"]/../span")).click();                      //SafeLoad checkmark
        driver.findElement(By.xpath("//select[@id='LoadUnload_Safeload_SelectedInsuranceRateId']/option[2]")).click();     //SafeLoad option2

        // ============================================>> Service type select <<============================================================================
        //driver.findElement(By.xpath("(//input[@id='LoadUnload_Enabled'])//..")).click();                                         // Load/Unload
        //driver.findElement(By.xpath("(//input[@id='PackOrUnPack_Enabled'])//..")).click();                                       // Pack/Unpack
        //driver.findElement(By.xpath("(//input[@id='MaidServicesOrHomeCleaning_Enabled'])//..")).click();                         // Cleaning help
        //driver.findElement(By.xpath("(//input[@id='PianoMoving_Enabled'])//..")).click();                                        // Piano fee
        //driver.findElement(By.xpath("(//input[@id='SafeMoving_Enabled'])//..")).click();                                         // Gun Safe fee

        // ===============================================>> Details and Cart <<============================================================================
        driver.findElement(By.xpath("//*[@id=\"DetailsOfMove\"]")).sendKeys("dfgdfgdfg");                            //Details
        driver.findElement(By.xpath("//*[@id=\"submitButton\"]")).click();                                                       //Add to Cart
        BrowserUtils.sleep(6);
        //BrowserUtils.waitVisibility(By.xpath("//div[@id='successModal']//div//a[.='View Cart']"));
        driver.findElement(By.xpath("//div[@id='successModal']//div//a[.='View Cart']")).click();                                //View Cart

        // ==================================================>> Discount Employee <<=========================================================================
        //driver.findElement(By.xpath("//*[@id=\"CertificateCode\"]")).sendKeys(ConfigReader.getProperty("discountEmployee"));    //Employee discount
        //driver.findElement(By.xpath("//button[.='Apply']")).click();

        // ====================================================>> Payment Cert <<============================================================================
        driver.findElement(By.xpath("//*[@id='CertificateCode']")).sendKeys(ConfigReader.getProperty("prodCert"));                //Certificate num
        driver.findElement(By.xpath("//button[.='Apply']")).click();                                                             //Apply

        // =====================================================>> Other Info Input <<=======================================================================
        driver.findElement(By.xpath("//*[@id='PreferredContactMethod']")).sendKeys("Email");                      //Contact method
        driver.findElement(By.xpath("(//input[@id='SendTextMessageUpdates'])[2]//..")).click();                               //Text message "NO"
        driver.findElement(By.xpath("(//input[@id='Agreement'])//..")).click();                                               //CheckBox Terms

        //====================================================>> Confirm Order <<=============================================================================
        driver.findElement(By.xpath("//button[@class='button submit-button']")).click();                                        //Submit
        BrowserUtils.sleep(4);
        driver.findElement(By.xpath("//*[@id='ComModal']/div[1]/div[2]/a")).click();                                //Confirmation Modal close


        //=======================================================>> Closing Browser <<==================================================================
        driver.quit();

    }
}

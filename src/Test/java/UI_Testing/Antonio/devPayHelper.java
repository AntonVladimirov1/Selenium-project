package UI_Testing.Antonio;

import UI_Testing.Utilities.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class devPayHelper {

    public static void main(String[] args) throws IOException {

        //========================================= SetUp Headless mode (if needed) =============================
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        //=================================== Create an instance of Driver ======================================
        WebDriver driver = new ChromeDriver(options); //<<< insert ('options') for headless mode
        driver.manage().window().maximize();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));  // <<<<<  declare "wait" variable

        // ==========================================>> LogIn <<==========================================================================================
        devMHPageMethods.login(driver);
        wait.until(ExpectedConditions.titleContains("Current Jobs"));

        //=======================================================>> Pay Helper <<==============================================================================
        String jobNumberSpecific = "744dc865";
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
        driver.findElement(By.xpath("//*[@id='OutstandingProfessionalism']/..")).click();            // ALL 5 STARS
        driver.findElement(By.xpath("//*[@id='OutstandingServices']/..")).click();
        driver.findElement(By.xpath("//*[@id='OutstandingOverall']/..")).click();
        //=========================================================>> Tips <<=================================================================================
                                                                // ??????????????????
        //========================================================>> Submit Review <<================================================================================
        driver.findElement(By.xpath("//button[.='Submit']")).click();
        System.out.println("Review Submitted");

        BrowserUtils.sleep(3);

        driver.quit();

        }

    }

package UI_Testing.Antonio;

import UI_Testing.Utilities.BrowserUtils;
import UI_Testing.Utilities.ConfigReader;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDate;

public class devMHPageMethods {

    public static void login(WebDriver driver) {
        driver.get(ConfigReader.getProperty("devMHhomeURL")+"login");

        String username = ConfigReader.getProperty("devMHusername1");
        String password = ConfigReader.getProperty("devMHpassword");

        WebElement usernameField = driver.findElement(By.xpath("//*[@id=\"Username\"]"));
        WebElement passwordField = driver.findElement(By.xpath("//*[@id=\"Password\"]"));
        WebElement submitButton = driver.findElement(By.cssSelector("input[type='submit']"));

        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
        submitButton.click();
    }

    public static void safeload (WebDriver driver){

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='safeloadModal']//a[@href='#']")));   //Wait
        driver.findElement(By.xpath("//div[@id='safeloadModal']//a[@href='#']")).click();                                  //SafeLoad modal close

        //driver.findElement(By.xpath("//input[@id='LoadUnload_Safeload_Enabled']/../span")).click();                        //SafeLoad checkmark
        //driver.findElement(By.xpath("//select[@id='LoadUnload_Safeload_SelectedInsuranceRateId']/option[2]")).click();     //SafeLoad option2
    }

    public static void serviceType (WebDriver driver){
        //driver.findElement(By.xpath("(//input[@id='LoadUnload_Enabled'])//..")).click();                        // Load/Unload (click if need to cancel)
        //driver.findElement(By.xpath("(//input[@id='PackOrUnPack_Enabled'])//..")).click();                                       // Pack/Unpack
        //driver.findElement(By.xpath("(//input[@id='MaidServicesOrHomeCleaning_Enabled'])//..")).click();                         // Cleaning
        //driver.findElement(By.xpath("(//input[@id='PianoMoving_Enabled'])//..")).click();                                        // Piano
        //driver.findElement(By.xpath("(//input[@id='SafeMoving_Enabled'])//..")).click();                                         // Gun Safe
    }

    public static void addViewCart (WebDriver driver){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        driver.findElement(By.xpath("//*[@id='DetailsOfMove']")).sendKeys("dfgdfgdfg");                            //Details
        driver.findElement(By.xpath("//*[@id='submitButton']")).click();                                                       //Add to Cart
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='successModal']//div//a[.='View Cart']")));  //Wait
        driver.findElement(By.xpath("//div[@id='successModal']//div//a[.='View Cart']")).click();                                //View Cart
    }

    public static void discountEmployee (WebDriver driver){
        //driver.findElement(By.xpath("//*[@id=\"CertificateCode\"]")).sendKeys(ConfigReader.getProperty("discountEmployee"));    //Employee discount
        //driver.findElement(By.xpath("//button[.='Apply']")).click();
    }

    public static void infoCertificate (WebDriver driver){
        //driver.findElement(By.xpath("//*[@id='CertificateCode']")).sendKeys(ConfigReader.getProperty("certVIP"));                //Cert num
        //driver.findElement(By.xpath("//button[.='Apply']")).click();                                                             //Apply
    }

    public static void infoCC (WebDriver driver){
        driver.findElement(By.xpath("//input[@name='CreditCardNumber']")).sendKeys(ConfigReader.getProperty("devCC"));           //Card num
        driver.findElement(By.xpath("//*[@id='ExpirationMonth']")).sendKeys("12");                                   //Card
        driver.findElement(By.xpath("//*[@id='ExpirationYear']")).sendKeys("2027");                                  //Card
        driver.findElement(By.xpath("//*[@id='CardSecurityCode']")).sendKeys(ConfigReader.getProperty("devCSC"));                //Card CSC
    }

    public static void paymentSubmit (WebDriver driver){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        // =====================================================>> Add Info Input <<=======================================================================
        driver.findElement(By.xpath("//*[@id='PreferredContactMethod']")).sendKeys("Email");                      //Contact method
        driver.findElement(By.xpath("(//input[@id='SendTextMessageUpdates'])[1]//..")).click();                             //Text message "YES"
        driver.findElement(By.xpath("(//input[@id='Agreement'])//..")).click();                                               //CheckBox Terms
        //====================================================>> Confirm Order <<=============================================================================
        driver.findElement(By.xpath("//button[@class='button submit-button']")).click();                                        //Submit
        //====================================================>> Conf modal close <<=============================================================================
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='ComModal']/div[1]/div[2]/a")));
        driver.findElement(By.xpath("//*[@id='ComModal']/div[1]/div[2]/a")).click();                                    //Confirmation Modal close
    }

    public static void screenShot (WebDriver driver) throws IOException {
        LocalDate today = LocalDate.now();
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        String screenshotPath = "target/new_Order_" + today + ".png";
        FileUtils.copyFile(source, new File(screenshotPath));
        System.out.println("Order booked (see screenshot)");
    }

    public static void editAddHours (WebDriver driver){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        String jobNumberLower = devMH_order.jobNumber.toLowerCase().replace("job number:jb-", "");
        //String orderNumberLower = devMH_order.orderNumber.toLowerCase().replace("or-", "");

        driver.navigate().to("https://www.movinghelpd.com/jobs");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[.//span[contains(normalize-space(.),'" + jobNumberLower + "')]]"))); //Wait
        driver.findElement(By.xpath("//a[.//span[contains(normalize-space(.),'" + jobNumberLower + "')]]")).click();             //Select Job

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(@href,'" + jobNumberLower + "') and text()='Edit']")));
        driver.findElement(By.xpath("//a[contains(@href,'" + jobNumberLower + "') and text()='Edit']")).click();           //Edit Job
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='add-hours-button']")));                // common wait
        driver.findElement(By.xpath("//select[@id='addHours']/option[1]")).click();                                // Add 2 hours (option up to 22)
        driver.findElement(By.xpath("//*[@id='add-hours-button']")).click();                                               // Confirm changes
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='modal-payment']//button[.='Pay Now']")));   // common wait
        driver.findElement(By.xpath("//*[@id='form2']/button")).click();
        System.out.println("Additional hours added");
        BrowserUtils.sleep(2);
    }

    public static void editAddHelpers (WebDriver driver){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        String jobNumberLower = devMH_order.jobNumber.toLowerCase().replace("job number:jb-", "");
        //String orderNumberLower = devMH_order.orderNumber.toLowerCase().replace("or-", "");

        driver.navigate().to("https://www.movinghelpd.com/jobs");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[.//span[contains(normalize-space(.),'" + jobNumberLower + "')]]"))); //Wait
        driver.findElement(By.xpath("//a[.//span[contains(normalize-space(.),'" + jobNumberLower + "')]]")).click();             //Select Job

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(@href,'" + jobNumberLower + "') and text()='Edit']")));
        driver.findElement(By.xpath("//a[contains(@href,'" + jobNumberLower + "') and text()='Edit']")).click();           //Edit Job
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='add-hours-button']")));                // common wait
        driver.findElement(By.xpath("//select[@id='addHelpersCount']/option[2]")).click();                                // Add 2 hours (option up to 22)
        driver.findElement(By.xpath("//*[@id='add-helpers-button']")).click();                                               // Confirm changes
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='modal-payment']//button[.='Pay Now']")));   // common wait
        driver.findElement(By.xpath("//*[@id='form2']/button")).click();
        System.out.println("Additional helper added");
        BrowserUtils.sleep(2);
    }

    public static void cancellation (WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        String jobNumberLower = devMH_order.jobNumber.toLowerCase().replace("job number:jb-", "");
        String orderNumberLower = devMH_order.orderNumber.toLowerCase().replace("or-", "");

        driver.navigate().to("https://www.movinghelpd.com/jobs");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[.//span[contains(normalize-space(.),'" + jobNumberLower + "')]]"))); //Wait
        driver.findElement(By.xpath("//a[.//span[contains(normalize-space(.),'" + jobNumberLower + "')]]")).click();             //Select Job

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(@href,'" + orderNumberLower + "') and text()='Cancel']")));
        driver.findElement(By.xpath("//a[contains(@href,'" + orderNumberLower + "') and text()='Cancel']")).click();         //Cancel
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CancellationCause']")));                 //common wait
        driver.findElement(By.xpath("//*[@id='CancellationCause']")).sendKeys("I am no longer moving.");         //Reason
        driver.findElement(By.xpath("//button[.='Confirm Cancellation']")).click();                                          //Submit
        System.out.println("Job Cancelled");
    }

}

package UI_Testing.Antonio;

import UI_Testing.Utilities.BrowserUtils;
import UI_Testing.Utilities.ConfigReader;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;

public class devHelperAccountCreation {

    public static void main(String[] args) throws IOException {

        //========================================= SetUp Headless mode (if needed) =============================
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        //=================================== Create an instance of Driver ======================================
        WebDriver driver = new ChromeDriver(); //<<< insert ('options') for headless mode
        driver.manage().window().maximize();

        Faker faker = new Faker();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        driver.navigate().to(ConfigReader.getProperty("devProviderRegister"));

        driver.findElement(By.xpath("//*[@id='FirstName']")).sendKeys(faker.name().firstName());
        driver.findElement(By.xpath("//*[@id='LastName']")).sendKeys(faker.name().lastName());
        driver.findElement(By.xpath("//*[@id='Email']")).sendKeys(faker.internet().emailAddress());
        driver.findElement(By.xpath("//*[@id='Phone']")).sendKeys(faker.phoneNumber().cellPhone());
        driver.findElement(By.xpath("//*[@id='EnrollPassword']")).sendKeys(ConfigReader.getProperty("providerPass"));
        driver.findElement(By.xpath("//*[@id='EnrollConfirmPassword']")).sendKeys(ConfigReader.getProperty("providerPass"));
        driver.findElement(By.xpath("//*[@id='hrefTermAndCondition']")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='modal-termAndCondition']/button")));
        driver.findElement(By.xpath("//*[@id='modal-termAndCondition']/button")).click();
        driver.findElement(By.xpath("//*[@id='TermsOfServiceAgreement']")).click();
        driver.findElement(By.xpath("//*[@id='register-button']")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div['row']/h2[.='Tell Us About Yourself']")));
        //BrowserUtils.sleep(4);
        driver.findElement(By.xpath("//*[@id='Address']")).sendKeys("2727 N Central ave");
        driver.findElement(By.xpath("//*[@id='City']")).sendKeys("Phoenix");
        driver.findElement(By.xpath("//*[@id='Zip']")).sendKeys("85004");
        driver.findElement(By.xpath("//select[@id='State']/option[4]")).click();
        driver.findElement(By.xpath("//*[@id='BusinessName']")).sendKeys("Best of the best");
        driver.findElement(By.xpath("//*[@id='businessdescriptionrte']")).sendKeys("Best of the best dfgdfg dfgdfgdfg dgfdffdg dfgdffdg fgdfgdfg ");
        driver.findElement(By.xpath("//label[@class='radio-DOTcheckN']")).click();
        driver.findElement(By.xpath("//select[@id='ddl1']/option[2]")).click();
        driver.findElement(By.xpath("//select[@id='HowDidYouHearAboutUsSelectedID']/option[8]")).click();
        driver.findElement(By.xpath("//div[12]/div/fieldset/ul/li[1]/label")).click();
        driver.findElement(By.xpath("//input[@id='IndependentProvider']/..")).click();
        driver.findElement(By.xpath("//button[.='Next']")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[.='Photo and Document Uploads']")));


        //driver.quit();
    }
}
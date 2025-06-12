package UI_Testing.test.Day06_Alerts_Iframes_Windows;

import UI_Testing.Utilities.BrowserUtils;
import UI_Testing.Utilities.WebDriverFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Set;

public class WindowHandle {

    WebDriver driver;

    @BeforeClass
    public void setup() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @Test(priority = 1)
    public void windowsHandling() throws InterruptedException {
        driver.get("https://amzon.com");
        ((JavascriptExecutor) driver).executeScript("window.open('https://google.com','_blank');");
        ((JavascriptExecutor) driver).executeScript("window.open('https://etsy.com','_blank');");
        ((JavascriptExecutor) driver).executeScript("window.open('https://facebook.com','_blank');");

        //Return and store all windows handles in a Set
        Set<String> allWindowHandles = driver.getWindowHandles();

        for (String each : allWindowHandles) {
            driver.switchTo().window(each);
            System.out.println("Current URL: " + driver.getCurrentUrl());
            if (driver.getCurrentUrl().contains("etsy")) {
                break;
            }
        }
        BrowserUtils.verifyTitleContains(driver,"Etsy");

    }

    @Test(priority = 2)
    public void windowsHandling2() throws InterruptedException {
        driver.get("https://amzon.com");
        ((JavascriptExecutor) driver).executeScript("window.open('https://google.com','_blank');");
        ((JavascriptExecutor) driver).executeScript("window.open('https://etsy.com','_blank');");
        ((JavascriptExecutor) driver).executeScript("window.open('https://facebook.com','_blank');");

        BrowserUtils.switchWindowAndVerify(driver,"etsy","Etsy");

    }
}


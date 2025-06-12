package UI_Testing.test.Day07_WebTables;

import UI_Testing.Utilities.BrowserUtils;
import UI_Testing.Utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Login {

    WebDriver driver;

    @BeforeClass
    public void setup() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void login(){
        driver.get("https://login1.nextbasecrm.com/");

        WebElement userName= driver.findElement(By.xpath("//input[@name='USER_LOGIN']"));
        userName.sendKeys("helpdesk1@cydeo.com");
        WebElement password= driver.findElement(By.xpath("//input[@name='USER_PASSWORD']"));
        password.sendKeys("UserUser");
        WebElement login= driver.findElement(By.xpath("//input[@type='submit']"));
        login.click();
        //driver.switchTo().alert().dismiss();
        driver.findElement(By.xpath("//a[@href='/']")).click();
        BrowserUtils.verifyTitle(driver,"Workgroups and projects");
        System.out.println("Title() = " + driver.getTitle());
    }

    /*@Test
    public void login2(){
        driver.get("https://login1.nextbasecrm.com/");

        CRM_Login.loginCRM(driver);
        BrowserUtils.verifyTitle(driver,"Workgroups and projects");
        System.out.println("Title() = " + driver.getTitle());
    }

    */

}

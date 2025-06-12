package UI_Testing.test.Day05_TesNG_Dropdowns;

import UI_Testing.Utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Dropdown {
    WebDriver driver;

    @BeforeClass
    public void setup(){
        driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
    }
   /* @AfterClass
    public void tearDown(){
        driver.quit();
    }
   */

    @Test
    public void dropdownTest1() {
        driver.get("https://practice.cydeo.com/dropdown");
        WebElement dropdown = driver.findElement(By.xpath("//select[@id='dropdown']"));
    Select select = new Select(dropdown);

    String expDefaultValue = "Please select an option";
    String actDefaultValue = select.getFirstSelectedOption().getText();
    Assert.assertEquals(expDefaultValue,actDefaultValue);
    }
    @Test
    public void dropdownTest2(){
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://practice.cydeo.com/dropdown");
        WebElement dropdown = driver.findElement(By.xpath("//select[@id='state']"));
        Select select = new Select(dropdown);

        String expDefaultValue = "Select a State";
        String actDefaultValue = select.getFirstSelectedOption().getText();
        Assert.assertEquals(expDefaultValue,actDefaultValue);
    }
}

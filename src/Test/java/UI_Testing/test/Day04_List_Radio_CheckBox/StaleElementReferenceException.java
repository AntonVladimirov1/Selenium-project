package UI_Testing.test.Day04_List_Radio_CheckBox;

import UI_Testing.Utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;

public class StaleElementReferenceException {
    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://practice.cydeo.com/abtest");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        WebElement cydeoLink = driver.findElement(By.xpath("//a[.='CYDEO']"));
        System.out.println("cydeoLink.isDisplayed() = " + cydeoLink.isDisplayed());

        driver.navigate().refresh();
        System.out.println("Refreshing page");

        cydeoLink = driver.findElement(By.xpath("//a[.='CYDEO']"));
        System.out.println("cydeoLink.isDisplayed() = " + cydeoLink.isDisplayed());

        driver.close();

    }
}

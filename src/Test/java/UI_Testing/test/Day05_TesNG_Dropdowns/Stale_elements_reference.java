package UI_Testing.test.Day05_TesNG_Dropdowns;

import UI_Testing.Utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;

public class Stale_elements_reference {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://practice.cydeo.com/add_remove_elements/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        WebElement addElementButton = driver.findElement(By.xpath("//button[.='Add Element']"));
        addElementButton.click();

        WebElement deleteButton = driver.findElement(By.xpath("//button[.='Delete']"));
        System.out.println("deleteButton.isDisplayed() = " + deleteButton.isDisplayed());
        Thread.sleep(1000);
        deleteButton.click(); // deleting web element from the page

        //using try/catch to handle exception and verify

        try {
            System.out.println("deleteButton.isDisplayed() = " + deleteButton.isDisplayed());
        } catch (StaleElementReferenceException e) {
            System.out.println("StaleElementReferenceException happened due to element being deleted from the page.");
            System.out.println("Test - PASSED");
            System.out.println("deleteButton.isDisplayed() = False");
        }
    }
}

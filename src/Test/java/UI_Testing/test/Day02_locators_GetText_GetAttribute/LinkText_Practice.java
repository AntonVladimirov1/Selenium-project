package UI_Testing.test.Day02_locators_GetText_GetAttribute;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LinkText_Practice {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        //driver.manage().window().maximize();

        driver.get("https://practice.cydeo.com");
       // driver.findElement(By.linkText("A/B Testing")).click(); // to find link by text
           //* alternative way to find and click element vvvvvvvvvvvv
        WebElement abTesting = driver.findElement(By.linkText("A/B Testing"));
        abTesting.click();

        String expectedTitle = "No A/B Test"; // Verifying correct title
        String actualTitle = driver.getTitle();
        if (actualTitle.equals(expectedTitle)){
            System.out.println("title - PASSED");
        }else {
            System.err.println("title - \"FAILED\"");
        }
        driver.navigate().back(); // click back

        expectedTitle = "Practice"; // verifying correct title - reassigning variables from above
        actualTitle = driver.getTitle();
        if (actualTitle.equals(expectedTitle)){
            System.out.println("title - PASSED");
        }else {
            System.err.println("title - \"FAILED\"");
        }


    }
}

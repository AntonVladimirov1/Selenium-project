package UI_Testing.test.Day02_locators_GetText_GetAttribute;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleSearch {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        //driver.manage().window().maximize();
        driver.get("https://google.com");

        WebElement googleSearchBox = driver.findElement(By.name("q"));
        googleSearchBox.sendKeys("apple"+Keys.ENTER);  //* pressing buttons on the keyboard!!!
       // googleSearchBox.sendKeys(Keys.ENTER); //* pressing buttons on the keyboard!!!

        String expectedInTitle = "apple";
        String actualTitle = driver.getTitle();
        if (actualTitle.startsWith(expectedInTitle)){
            System.out.println("title PASSED");
        }else {
            System.err.println("title FAILED");
        }

    }
}

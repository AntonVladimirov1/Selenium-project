package UI_Testing.test.Day02_locators_GetText_GetAttribute;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocatorsBy_ {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        //driver.manage().window().maximize();
        driver.get("https://library2.cybertekschool.com/login.html");

        WebElement usernameInput = driver.findElement(By.className("form-control"));  //* by Class name
        usernameInput.sendKeys("jhjhjhg@jhgjh.com");

        WebElement passwordInput = driver.findElement(By.id("inputPassword"));  //* by ID's
        passwordInput.sendKeys("Hernya123");

        WebElement signIn = driver.findElement(By.tagName("button"));  //* by Tag name
        signIn.click();


    }
}

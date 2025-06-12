package UI_Testing.test.Day01_selenium_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumTest {

    public static void main(String[] args) {

        // setting up web driver manager
        WebDriverManager.chromedriver().setup();

        // creat the instance of Chrome browser driver
        WebDriver driver = new ChromeDriver();

        // Test if driver works
        driver.get("https://practice.cydeo.com");


    }
}

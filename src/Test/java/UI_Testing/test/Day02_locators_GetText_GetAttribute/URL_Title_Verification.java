package UI_Testing.test.Day02_locators_GetText_GetAttribute;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class URL_Title_Verification {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();

        // Create an instance of browser
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.movinghelper.com/#login");
        driver.manage().window().maximize(); //* <--- to open full screen

        //verify - URL contains movinghelper
        String expectedInURL = "movinghelper";
        String actualURL = driver.getCurrentUrl();
        if (actualURL.contains(expectedInURL)){
            System.out.println("URL - PASSED");
        }else {
            System.err.println("URL verification - FAILED");
        }
        // Verify - Title is "Log in or Sign up"
        String expectedTitle = "Log in or Sign up | Moving Helper®";
        String actualTitle = driver.getTitle();
        if (actualTitle.equals(expectedTitle)){
            System.out.println("Title - PASSED");
        }else {
            System.err.println("Title - FAILED");
        }

        driver.close();

    }
}

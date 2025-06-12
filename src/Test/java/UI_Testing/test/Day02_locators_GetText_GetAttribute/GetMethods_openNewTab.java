package UI_Testing.test.Day02_locators_GetText_GetAttribute;

import UI_Testing.Utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;

import java.time.Duration;

public class GetMethods_openNewTab {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        driver.get("https://etsy.com");
        driver.switchTo().newWindow(WindowType.TAB);   //* How to open new TAB
        driver.get("https://amazon.com");
        //Thread.sleep(1000);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2)); // Wait until page fully loaded
        //===========================================
        driver.findElement(By.cssSelector("#twotabsearchtextbox")).sendKeys("selenium");// + Keys.ENTER); // Search box - input:"selenium"
        driver.findElement(By.id("nav-search-submit-button")).click();
        //===========================================
        String expTitle = "Amazon.com : selenium";
        String actTitle = driver.getTitle();
        if (actTitle.equals(expTitle)){
            System.out.println("Title - PASSED");
        }else {
            System.out.println("Title - FAILED");
        }
        //===========================================
        String actURL = driver.getCurrentUrl();
        if (actURL.contains("selenium")){
            System.out.println("URL - PASSES");
        }else {
            System.out.println("URL - FAILED");
        }
    }
}

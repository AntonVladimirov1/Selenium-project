package UI_Testing.test.Day05_TesNG_Dropdowns;

import UI_Testing.Utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;
import java.util.List;

public class ListRadioButtons {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://practice.cydeo.com/radio_buttons");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        List<WebElement> radioButtons = driver.findElements(By.xpath("//input[@name='sport']"));

        for (WebElement each : radioButtons) {
            String actualID = each.getAttribute("id");
            System.out.println("actualID = " + actualID);
            if (actualID.equals("hockey")){
                each.click();
                System.out.println(actualID+ " is selected: " +each.isSelected());
                break;
            }
        }


    }

}

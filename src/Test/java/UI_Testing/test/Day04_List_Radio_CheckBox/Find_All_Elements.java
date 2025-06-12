package UI_Testing.test.Day04_List_Radio_CheckBox;

import UI_Testing.Utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;
import java.util.List;

public class Find_All_Elements {
    public static void main(String[] args) {

        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        driver.get("https://practice.cydeo.com/abtest");

        // locate all the links on the page
        List<WebElement> listOfLinks= driver.findElements(By.tagName("a"));
        // print quantity of the links on the page
        System.out.println("listOfLinks.size() = " + listOfLinks.size());

        // Loop and print out the text of the links and HREF values
        for (WebElement each : listOfLinks) {
            System.out.println("Link text: "+each.getText());
            System.out.println("HREF values: "+ each.getAttribute("href"));

        }

    }

}

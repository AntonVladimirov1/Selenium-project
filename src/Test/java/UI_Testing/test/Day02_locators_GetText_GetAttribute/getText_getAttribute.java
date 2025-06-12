package UI_Testing.test.Day02_locators_GetText_GetAttribute;

import UI_Testing.Utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class getText_getAttribute {
    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        //driver.manage().window().maximize();
        //assert driver != null;
        driver.get("https://practice.cydeo.com/registration_form");

        //WebElement header = driver.findElement(By.tagName("h2")); // can be written in one line under String - actualHeader
        String expectedHeaderText ="Registration form";
        String actualHeader = driver.findElement(By.tagName("h2")).getText();

        if (actualHeader.equals(expectedHeaderText)){
            System.out.println("Header text - PASSED");
        }else {
            System.err.println("Header text - FAILED");
        }

        WebElement firstName = driver.findElement(By.className("form-control"));
        String expectedPlaceHolder = "first name";
        String actualPlaceHold = firstName.getAttribute("placeholder");
        if (actualPlaceHold.equals(expectedPlaceHolder)){
            System.out.println("\""+actualPlaceHold+"\""+" - PASSED");
        }else {
            System.out.println("Failed - " +actualPlaceHold);
        }


    }
}

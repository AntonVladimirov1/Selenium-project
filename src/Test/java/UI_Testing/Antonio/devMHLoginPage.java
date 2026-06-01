package UI_Testing.Antonio;

import UI_Testing.Utilities.ConfigReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class devMHLoginPage {

    public static void login(WebDriver driver) {
        driver.get(ConfigReader.getProperty("devMHhomeURL")+"login");


        String username = ConfigReader.getProperty("devMHusername1");
        String password = ConfigReader.getProperty("devMHpassword");

        WebElement usernameField = driver.findElement(By.xpath("//*[@id=\"Username\"]"));
        WebElement passwordField = driver.findElement(By.xpath("//*[@id=\"Password\"]"));
        WebElement submitButton = driver.findElement(By.cssSelector("input[type='submit']"));


        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
        submitButton.click();
    }

}

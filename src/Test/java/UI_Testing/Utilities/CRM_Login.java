package UI_Testing.Utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CRM_Login {

    public static void loginCRM(WebDriver driver){
        WebElement userName= driver.findElement(By.xpath("//input[@name='USER_LOGIN']"));
        userName.sendKeys("hr1@cybertekschool.com");
        WebElement password= driver.findElement(By.xpath("//input[@name='USER_PASSWORD']"));
        password.sendKeys("UserUser");
        WebElement login= driver.findElement(By.xpath("//input[@type='submit']"));
        login.click();
    }

    public static void loginCRM(WebDriver driver,String username,String password){
            WebElement userName= driver.findElement(By.xpath("//input[@name='USER_LOGIN']"));
            userName.sendKeys(username);
            WebElement inputPassword= driver.findElement(By.xpath("//input[@name='USER_PASSWORD']"));
            inputPassword.sendKeys(password);
            WebElement login= driver.findElement(By.xpath("//input[@type='submit']"));
            login.click();
        }

}

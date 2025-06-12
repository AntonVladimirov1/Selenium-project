package UI_Testing.test.Day03_locators;

import UI_Testing.Utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TextVerifying {
    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://login1.nextbasecrm.com");

        String expectedRememberMe = "Remember me on this computer";
        String actualRememberMe = driver.findElement(By.className("login-item-checkbox-label")).getText();
        if (actualRememberMe.equals(expectedRememberMe)){
            System.out.println("Remember me - PASSED");
        }else {
            System.err.println("Remember me - FAILED");
        }
        String expForgotPasswordText = "FORGOT YOUR PASSWORD?";
        String actForgotPasswordText = driver.findElement(By.className("login-link-forgot-pass")).getText();
        if (actForgotPasswordText.equals(expForgotPasswordText)){
            System.out.println("Forgot password - PASSED");
        }else {
           // System.out.println(expForgotPasswordText);
           // System.out.println(actForgotPasswordText);
            System.out.println("Forgot password - FAILED");
        }
        String expInHREF = "forgot_password=yes";
        String actInHREF = driver.findElement(By.className("login-link-forgot-pass")).getAttribute("href");
        if (actInHREF.contains(expInHREF)){
            System.out.println("href - PASSED");
        }else {
            System.out.println("href - FAILED");
        }


    }
}

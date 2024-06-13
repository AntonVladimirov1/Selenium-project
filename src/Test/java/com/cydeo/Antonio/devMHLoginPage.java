package com.cydeo.Antonio;

import com.cydeo.Utilities.ConfigReader;
import com.cydeo.Utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class devMHLoginPage {

    /*public devMHLoginPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "input[type='text']")
    public WebElement usernameField;
    @FindBy(xpath = "input[type='password']")
    public WebElement passwordField;
    @FindBy(xpath = "input[type='submit']")
    public WebElement submitButton;

    WebElement usernameField = Driver.getDriver().findElement(By.xpath("//*[@id=\"Username\"]"));
    WebElement passwordField = Driver.getDriver().findElement(By.xpath("//*[@id=\"Password\"]"));
    WebElement submitButton = Driver.getDriver().findElement(By.cssSelector("input[type='submit']"));

     */

    public static void login() {

        WebElement usernameField = Driver.getDriver().findElement(By.xpath("//*[@id=\"Username\"]"));
        WebElement passwordField = Driver.getDriver().findElement(By.xpath("//*[@id=\"Password\"]"));
        WebElement submitButton = Driver.getDriver().findElement(By.cssSelector("input[type='submit']"));

        String username = ConfigReader.getProperty("devMHusername");
        String password = ConfigReader.getProperty("devMHpassword");
        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
        submitButton.click();
    }


}

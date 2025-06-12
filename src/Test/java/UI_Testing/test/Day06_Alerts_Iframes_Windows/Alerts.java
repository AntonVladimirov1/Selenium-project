package UI_Testing.test.Day06_Alerts_Iframes_Windows;

import UI_Testing.Utilities.BrowserUtils;
import UI_Testing.Base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Alerts extends TestBase {


    @Test (priority = 1)
    public void informationAlert() throws InterruptedException {
        driver.get("https://practice.cydeo.com/javascript_alerts");
        WebElement jsAlert = driver.findElement(By.xpath("//button[.='Click for JS Alert']"));
        Thread.sleep(1000);
        jsAlert.click();
        Thread.sleep(1000);
        System.out.println("alert Text() = " + driver.switchTo().alert().getText());
        driver.switchTo().alert().accept();

        WebElement alertText = driver.findElement(By.xpath("//p[@id='result']"));
        Assert.assertTrue(alertText.isDisplayed(),"No text there");
        String expText = "You successfully clicked an alert";
        String actText = alertText.getText();
        System.out.println("Text after click= " + alertText.getText());
        Assert.assertEquals(expText,actText,"Text doesn't match");
    }

    @Test (priority = 2)
    public void confirmationAlert() throws InterruptedException {
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://practice.cydeo.com/javascript_alerts");
        WebElement jsAlert = driver.findElement(By.xpath("//button[.='Click for JS Confirm']"));
        BrowserUtils.sleep(1);
        //Thread.sleep(1000);
        jsAlert.click();
        Thread.sleep(1000);
        System.out.println("alert Text() = " + driver.switchTo().alert().getText());
        driver.switchTo().alert().accept();

        WebElement alertText = driver.findElement(By.xpath("//p[@id='result']"));
        Assert.assertTrue(alertText.isDisplayed(),"No text there");
        String expText = "You clicked: Ok";
        String actText = alertText.getText();
        System.out.println("Text after click= " + alertText.getText());
        Assert.assertEquals(expText,actText,"Text doesn't match");
    }

    @Test (priority = 3)
    public void promptAlert() throws InterruptedException {
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://practice.cydeo.com/javascript_alerts");
        WebElement jsAlert = driver.findElement(By.xpath("//button[.='Click for JS Prompt']"));
        Thread.sleep(1000);
        jsAlert.click();
        Thread.sleep(1000);
        driver.switchTo().alert().sendKeys("hello");
        Thread.sleep(1000);
        System.out.println("alert Text() = " + driver.switchTo().alert().getText());
        driver.switchTo().alert().accept();


        WebElement alertText = driver.findElement(By.xpath("//p[@id='result']"));
        Assert.assertTrue(alertText.isDisplayed(),"No text there");
        String expText = "You entered: hello";
        String actText = alertText.getText();
        System.out.println("Text after click= " + alertText.getText());
        Assert.assertEquals(expText,actText,"Text doesn't match");
    }
}

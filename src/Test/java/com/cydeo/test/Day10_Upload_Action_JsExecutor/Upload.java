package com.cydeo.test.Day10_Upload_Action_JsExecutor;

import com.cydeo.Utilities.BrowserUtils;
import com.cydeo.Utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Upload {

    @Test
    public void uploadTest1(){

        Driver.getDriver().get("https://practice.cydeo.com/upload");

        WebElement chooseFileButton = Driver.getDriver().findElement(By.xpath("//input[@id='file-upload']"));
        chooseFileButton.sendKeys("C://Users/1326160/Desktop/ScreenShots/Screenshot 2022-10-27 110554.png");
        BrowserUtils.sleep(2);
        Driver.getDriver().findElement(By.xpath("//input[@id='file-submit']")).click();
        WebElement happyUploaded = Driver.getDriver().findElement(By.xpath("//div[@class='example']/h3"));

        System.out.println("Uploaded.Text() = " + happyUploaded.getText());
        Assert.assertTrue(happyUploaded.isDisplayed(),"NOT Uploaded");

    }

}

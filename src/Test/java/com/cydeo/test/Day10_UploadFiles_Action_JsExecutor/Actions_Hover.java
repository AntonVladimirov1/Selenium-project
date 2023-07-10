package com.cydeo.test.Day10_UploadFiles_Action_JsExecutor;

import com.cydeo.Utilities.BrowserUtils;
import com.cydeo.Utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Actions_Hover {

    @Test
    public void actionTest1(){

        Driver.getDriver().get("https://practice.cydeo.com/hovers");

        WebElement img1 = Driver.getDriver().findElement(By.xpath("(//img)[1]"));
        WebElement img2 = Driver.getDriver().findElement(By.xpath("(//img)[2]"));
        WebElement img3 = Driver.getDriver().findElement(By.xpath("(//img)[3]"));

        WebElement user1 = Driver.getDriver().findElement(By.xpath("(//h5)[1]"));
        WebElement user2 = Driver.getDriver().findElement(By.xpath("(//h5)[2]"));
        WebElement user3 = Driver.getDriver().findElement(By.xpath("(//h5)[3]"));

        Actions actions = new Actions(Driver.getDriver());

        BrowserUtils.sleep(1);
        actions.moveToElement(img1).perform();
        Assert.assertTrue(user1.isDisplayed());

        BrowserUtils.sleep(1);
        actions.moveToElement(img2).perform();
        Assert.assertTrue(user2.isDisplayed());

        BrowserUtils.sleep(1);
        actions.moveToElement(img3).perform();
        Assert.assertTrue(user3.isDisplayed());

    }

}

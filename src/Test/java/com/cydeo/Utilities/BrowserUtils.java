package com.cydeo.Utilities;

/*
This Class stored utility methods that can be used across the project
 */

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.Set;

public class BrowserUtils {

    public static void sleep(int second){
        second*= 1000;
        try{
            Thread.sleep(second);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    public static void switchWindowAndVerify(WebDriver driver,String expectedInURL,String expectedTitle){
        Set<String> allWindowHandles = driver.getWindowHandles();

        for (String each : allWindowHandles) {
            driver.switchTo().window(each);
            System.out.println("Current URL: "+ driver.getCurrentUrl());
            if (driver.getCurrentUrl().contains(expectedInURL)){
                break;
            }
        }
        String actTitle = driver.getTitle();
        Assert.assertTrue(actTitle.contains(expectedTitle));
    }

    public static void verifyTitle(WebDriver driver,String expectedTitle){
        Assert.assertEquals(driver.getTitle(),expectedTitle);
    }

    public static void verifyTitleContains(WebDriver driver,String expectedInTitle){
        Assert.assertTrue(driver.getTitle().contains(expectedInTitle));
    }

    public static void explicitWait(WebElement target){
        WebDriverWait wait=new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.invisibilityOf(target));
    }

    public static void explicitWait(String title) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.titleContains(title));
    }
}

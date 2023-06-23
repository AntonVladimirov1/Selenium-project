package com.cydeo.test.Day11_pom_explicitWaits;

import com.cydeo.Pages.DynamicLoad7Page;
import com.cydeo.Utilities.Driver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Explicit_Wait {

    @BeforeClass
    public void setUp(){
        Driver.getDriver().get("https://practice.cydeo.com/dynamic_loading/7");

    }

    @Test
    public void test1_wait_until_title(){
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.titleIs("Dynamic title"));
        DynamicLoad7Page dynamicLoad7Page = new DynamicLoad7Page();
        Assert.assertTrue(dynamicLoad7Page.doneMessage.isDisplayed());
        Assert.assertTrue(dynamicLoad7Page.image.isDisplayed());
    }

}

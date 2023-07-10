package com.cydeo.test.Day10_UploadFiles_Action_JsExecutor;

import com.cydeo.Utilities.BrowserUtils;
import com.cydeo.Utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class Actions_Scroll {

    @Test
    public void scrollTest1(){

        Driver.getDriver().get("https://practice.cydeo.com/");

       WebElement cydeoLink= Driver.getDriver().findElement(By.linkText("CYDEO"));

        Actions actions = new Actions(Driver.getDriver());

        actions.scrollToElement(cydeoLink).perform();
        BrowserUtils.sleep(1);
        actions.sendKeys(Keys.PAGE_UP,Keys.PAGE_UP,Keys.PAGE_UP,Keys.ARROW_DOWN,Keys.ARROW_UP).perform();

    }

}

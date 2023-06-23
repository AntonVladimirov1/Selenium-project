package com.cydeo.test.Day10_Upload_Action_JsExecutor;

import com.cydeo.Utilities.BrowserUtils;
import com.cydeo.Utilities.Driver;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

public class JS_Executor {

    @Test
    public void js_executor(){

        Driver.getDriver().get("https://practice.cydeo.com/infinite_scroll");

        // ((JavascriptExecutor) driver).executeScript("window.open('https://google.com','_blank');"); // example
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();

        for (int i = 0; i < 10; i++) {
            BrowserUtils.sleep(1);
            js.executeScript("window.scrollBy(0,750)");
        }
        for (int i = 0; i < 10; i++) {
            BrowserUtils.sleep(1);
            js.executeScript("window.scrollBy(0,-750)");
        }

    }

}

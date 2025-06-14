package UI_Testing.test.Day10_UploadFiles_Action_JsExecutor;

import UI_Testing.Utilities.BrowserUtils;
import UI_Testing.Utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class JS_Executor2 {

    @Test
    public void scroll(){

        Driver.getDriver().get("https://practice.cydeo.com/large");

        WebElement cydeoLink = Driver.getDriver().findElement(By.linkText("CYDEO"));
        WebElement homeLink = Driver.getDriver().findElement(By.linkText("Home"));

        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        BrowserUtils.sleep(2);
        js.executeScript("arguments[0].scrollIntoView(true)",cydeoLink);

        BrowserUtils.sleep(2);
        js.executeScript("arguments[1].scrollIntoView(true)",cydeoLink,homeLink);


    }

}

package com.cydeo.test.Day12_review;

import com.cydeo.Pages.W3page;
import com.cydeo.Utilities.Driver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Double_click {

    @BeforeClass
    public void setUp(){
        Driver.getDriver().get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_ev_ondblclick2");
    }

    @Test
    public void double_click(){
        Driver.getDriver().switchTo().frame("iframeResult");
        W3page w3page = new W3page();

        Actions actions= new Actions(Driver.getDriver());
        actions.doubleClick(w3page.redText).perform();
        String actStyleAttributeValue = w3page.redText.getAttribute("style");
        String expAttribute = "red";
        Assert.assertTrue(actStyleAttributeValue.contains(expAttribute));
    }

}

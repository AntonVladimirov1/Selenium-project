package com.cydeo.test.Day07_WebTables;

import com.cydeo.Utilities.WebDriverFactory;
import com.cydeo.Utilities.WebTableUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class WebTable_OrderVerify {

    WebDriver driver;

    @BeforeClass
    public void setup() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @Test
    public void order_verify_name_test(){
        driver.get("https://practice.cydeo.com/web-tables");
        // //table[@class='SampleTable']//td[.='Bob Martin']

        WebElement bobCell= driver.findElement(By.xpath("//table[@class='SampleTable']//td[.='Bob Martin']"));
        System.out.println("bobCell text= " + bobCell.getText());
        String expName="Bob Martin";
        String actName= bobCell.getText();
        Assert.assertEquals(actName,expName);

        WebElement bobOrderDate= driver.findElement(By.xpath("//table[@class='SampleTable']//td[.='Bob Martin']/following-sibling::td[3]"));
        System.out.println("bobOrderDate = " + bobOrderDate.getText());
        String expDate="12/31/2021";
        String actDate= bobOrderDate.getText();
        Assert.assertEquals(actDate,expDate);
    }

    @Test
    public void order_verify_name_test2(){
        driver.get("https://practice.cydeo.com/web-tables");

        String johnDoe=WebTableUtils.returnOrderDate(driver,"John Doe");
        System.out.println("johnDoe = " + johnDoe);
        String stewartDawidson=WebTableUtils.returnOrderDate(driver,"Stewart Dawidson");
        System.out.println("stewartDawidson = " + stewartDawidson);
    }

    @Test
    public void order_verify_name_test3(){
        driver.get("https://practice.cydeo.com/web-tables");
        WebTableUtils.OrderDateVerify(driver,"Bart Fisher","01/16/2021");
    }

}

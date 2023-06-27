package com.cydeo.test.Day07_WebTables;

import com.cydeo.Utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

public class WebTable_practice {

    @Test
    public void test1(){

        Driver.getDriver().get("https://practice.cydeo.com/tables");

        WebElement table1= Driver.getDriver().findElement(By.id("table1"));
        System.out.println("table1.Text = " + table1.getText());

        List<WebElement> columnNames = Driver.getDriver().findElements(By.xpath("//table[@id='table1']/thead/tr/th"));
        for (WebElement each : columnNames) {
            System.out.println("each.Text = " + each.getText());
        }
        List<WebElement> allItem = Driver.getDriver().findElements(By.xpath("//table[@id='table1']/tbody/tr/td"));
        for (WebElement eachMan : allItem) {
            System.out.println("eachMan.Row = " + eachMan.getText());
        }

    }
}

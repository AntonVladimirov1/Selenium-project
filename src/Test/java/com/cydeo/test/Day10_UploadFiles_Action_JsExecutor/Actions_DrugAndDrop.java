package com.cydeo.test.Day10_UploadFiles_Action_JsExecutor;

import com.cydeo.Utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class Actions_DrugAndDrop {

    @BeforeClass
    public void setUp(){
        Driver.getDriver().get("https://practice.cydeo.com/drag_and_drop_circles");
    }

    @Test
    public void test1(){

        WebElement bigCircle = Driver.getDriver().findElement(By.id("droptarget"));

        String expText = "Drag the small circle here.";
        String actText = bigCircle.getText();
        System.out.println("bigCircleText(1) = " + bigCircle.getText());
        assertTrue(actText.equals(expText));
    }
    @Test
    public void test2_drag_and_drop_2targets(){

        WebElement bigCircle = Driver.getDriver().findElement(By.id("droptarget"));
        WebElement smallCircle = Driver.getDriver().findElement(By.id("draggable"));

        Actions actions = new Actions(Driver.getDriver());
        actions.dragAndDrop(smallCircle,bigCircle).perform();

        String expText = "You did great!";
        String actText = bigCircle.getText();
        System.out.println("bigCircleText(2) = " + bigCircle.getText());
        assertTrue(actText.equals(expText));
    }
    @Test
    public void test3_click_and_hold(){

        WebElement bigCircle = Driver.getDriver().findElement(By.id("droptarget"));
        WebElement smallCircle = Driver.getDriver().findElement(By.id("draggable"));

        Actions actions=new Actions(Driver.getDriver());
        actions.clickAndHold(smallCircle).pause(1000).moveToElement(bigCircle).pause(1000).release().perform();

        String expText = "You did great!";
        String actText = bigCircle.getText();
        System.out.println("bigCircleText(3) = " + bigCircle.getText());
        assertTrue(actText.equals(expText));


    }
    @Test
    public void test4(){

        WebElement bigCircle = Driver.getDriver().findElement(By.id("droptarget"));
        WebElement smallCircle = Driver.getDriver().findElement(By.id("draggable"));

        Actions actions=new Actions(Driver.getDriver());
        actions.clickAndHold(smallCircle).pause(1000).moveToElement(bigCircle).pause(1000).perform();

        String expText = "Now drop...";
        String actText = bigCircle.getText();
        System.out.println("bigCircleText(4) = " + bigCircle.getText());
        assertTrue(actText.equals(expText));

    }
    @Test
    public void test5(){

        WebElement bigCircle = Driver.getDriver().findElement(By.id("droptarget"));
        WebElement smallCircle = Driver.getDriver().findElement(By.id("draggable"));

        Actions actions=new Actions(Driver.getDriver());
        actions.clickAndHold(smallCircle).pause(1000).moveToElement(Driver.getDriver().findElement(By.linkText("CYDEO"))).perform();

        String expText = "Drop here.";
        String actText = bigCircle.getText();
        System.out.println("bigCircleText(5) = " + bigCircle.getText());
        assertTrue(actText.equals(expText));


    }
    @Test
    public void test6(){

        WebElement bigCircle = Driver.getDriver().findElement(By.id("droptarget"));
        WebElement smallCircle = Driver.getDriver().findElement(By.id("draggable"));

        Actions actions=new Actions(Driver.getDriver());
        actions.clickAndHold(smallCircle).pause(1000).moveToElement(Driver.getDriver().findElement(By.linkText("CYDEO"))).release().perform();

        String expText = "Try again!";
        String actText = bigCircle.getText();
        System.out.println("bigCircleText(5) = " + bigCircle.getText());
        assertTrue(actText.equals(expText));


    }

}

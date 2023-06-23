package com.cydeo.test.Day10_Upload_Action_JsExecutor;

import com.cydeo.Utilities.Driver;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Registration_form {

    @Test
    public void registration1(){

        Driver.getDriver().get("https://practice.cydeo.com/registration_form");

        Faker faker=new Faker();
        Driver.getDriver().findElement(By.xpath("//input[@name='firstname']")).sendKeys(faker.name().firstName());
        Driver.getDriver().findElement(By.xpath("//input[@name='lastname']")).sendKeys(faker.name().lastName());
        Driver.getDriver().findElement(By.xpath("//input[@name='username']")).sendKeys("Gjhjhguytuy");
        Driver.getDriver().findElement(By.xpath("//input[@name='email']")).sendKeys(faker.internet().emailAddress());
        Driver.getDriver().findElement(By.xpath("//input[@name='password']")).sendKeys(faker.internet().password());
        Driver.getDriver().findElement(By.xpath("//input[@name='phone']")).sendKeys(faker.numerify("###-###-####"));
        Driver.getDriver().findElement(By.xpath("//input[@value='male']")).click();
        Driver.getDriver().findElement(By.xpath("//input[@name='birthday']")).sendKeys("03/03/1985");
        Driver.getDriver().findElement(By.xpath("//select[@name='department']/option[2]")).click();
        Driver.getDriver().findElement(By.xpath("//select[@name='job_title']/option[3]")).click();
        Driver.getDriver().findElement(By.xpath("//input[@value='java']")).click();
        Driver.getDriver().findElement(By.xpath("//button[@id='wooden_spoon']")).click();
        WebElement message = Driver.getDriver().findElement(By.xpath("//div[@role='alert']/p"));

        System.out.println("message Text = " + message.getText());
        Assert.assertTrue(message.isDisplayed());

    }

}

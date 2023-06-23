package com.cydeo.test.Day05_TesNG_Dropdowns;

import org.testng.Assert;
import org.testng.annotations.*;

public class TestNG_intro {

    @BeforeClass
    public void setupClass(){
        System.out.println("--> Before class running");
    }
    @AfterClass
    public void tearDownClass(){
        System.out.println("--> After class running");
    }
    @BeforeMethod
    public void setupMethod(){
        System.out.println(">> Before method is running...");
    }
    @AfterMethod
    public void tearDownMethod(){
        System.out.println("> After method is running...");
    }
    @Test (priority = 2)
    public void test1(){
        System.out.println("test 1 is running...");
        String actual="apple";
        String expected="apple";
        Assert.assertEquals(actual,expected);
    }
    @Test (priority = 1)
    public void test2(){
        System.out.println("test 2 is running...");
        String actual= "white";
        String expected= "white";
        Assert.assertTrue(actual.equals(expected));
    }
}

package com.cydeo.test.Day03_locators;

import com.cydeo.Utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class cssSelector_Xpath {
    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://login1.nextbasecrm.com");
        driver.manage().window().maximize();

        //* CSS Selector structure: tagName[attribute="value']
        //Find and click "Log In"
        driver.findElement(By.cssSelector("input[type='submit']")).click();

        //* Relative Xpath starts with // :
        //*            //tagName[@attributeName='value']
        //*            //tagName[contains(@attribute,'value')]
        //*            //tagName[starts-with(@attribute,'value')]
        //*            //tagName[ends-with(@attribute,'value')]
        //*            //tagName[text()='textOfWebElement'] or //tagName[.='text']
        //*            //*[@attribute='value']- not a good way
        //*            //tagName.classValue - for class only
        //*            //tagName#idValue - for id only
        //* sibling    //tagName[@attributeName='value']/preceding-sibling::tagName[index] --> will go to previous sibling
        //* sibling    //tagName[@attributeName='value']/following-sibling::tagName[index] --> will go to after sibling
        //*                        TABLES...................................................
        //*     //table[@id='table1']//td[.='Frank']/..//td[.='$51.00']  or
        //*     //table[@id='table1']//td[.='Frank']/following-sibling::td[2]
        //*               //div[normalize-space(text())='xxxxxx']  -  if text concluded white spaces


    }
}

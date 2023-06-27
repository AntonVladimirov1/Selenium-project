package com.cydeo.Pages;

import com.cydeo.Utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DynamicControl_page {

    public DynamicControl_page(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//button[text()='Remove']")
    public WebElement removeButton;

    @FindBy(id = "loading")
    public WebElement loadingBar;

    @FindBy(xpath = "//input[@type='checkbox']")
      //@FindBy(css = "input[type='checkbox']")   - find by css
    public WebElement checkBox;

    @FindBy(id = "message")
    public WebElement goneMessage;

    @FindBy(xpath = "//input[@type='text']")
    public WebElement inputBox;

    @FindBy(xpath = "//button[.='Enable']")
    public WebElement enableButton;
}

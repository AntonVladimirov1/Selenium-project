package UI_Testing.Pages;

import UI_Testing.Utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPagePOM {

    public LoginPagePOM(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//button[.='Sign in']")
    public WebElement signInButton;

    @FindBy(xpath = "//div[.='This field is required.']/div")
    public WebElement requiredErrorMessage;

    @FindBy(id = "inputEmail")
    public WebElement emailField;

    @FindBy(xpath = "//div[.='Please enter a valid email address.']/div")
    public WebElement emailErrorMessage;

    @FindBy(id = "inputPassword")
    public WebElement passwordField;

    @FindBy(xpath = "//div[.='Sorry, Wrong Email or Password']")
    public WebElement sorryMessage;

}

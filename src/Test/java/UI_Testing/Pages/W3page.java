package UI_Testing.Pages;

import UI_Testing.Utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class W3page {


    public W3page(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id = "demo")
    public WebElement redText;
}

package UI_Testing.test.Day11_pom_explicitWaits;

import UI_Testing.Pages.LoginPagePOM;
import UI_Testing.Utilities.BrowserUtils;
import UI_Testing.Utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class POM_Practice {

    LoginPagePOM loginPage1;

    @BeforeClass
    public void setUp(){
        Driver.getDriver().get("https://library1.cydeo.com");
        loginPage1 = new LoginPagePOM();
    }

    @Test
    public void test1_required_error_message(){

        loginPage1.signInButton.click();
        Assert.assertTrue(loginPage1.requiredErrorMessage.isDisplayed());
        BrowserUtils.sleep(1);
        Driver.getDriver().navigate().refresh();
    }

    @Test
    public void test2_email_error_message(){

        loginPage1.emailField.sendKeys("jhfjhgfjhgf");
        loginPage1.signInButton.click();
        Assert.assertTrue(loginPage1.emailErrorMessage.isDisplayed());
        BrowserUtils.sleep(1);
        Driver.getDriver().navigate().refresh();

    }

    @Test
    public void test3_email_password_error_message(){

        loginPage1.emailField.sendKeys("hgfhgf@jhg.jhg");
        loginPage1.passwordField.sendKeys("jhgjhgjhgjh");
        loginPage1.signInButton.click();
        Assert.assertTrue(loginPage1.sorryMessage.isDisplayed());
        BrowserUtils.sleep(1);
        Driver.getDriver().navigate().refresh();
    }

}

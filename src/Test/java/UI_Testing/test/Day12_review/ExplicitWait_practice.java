package UI_Testing.test.Day12_review;

import UI_Testing.Pages.DynamicControl_page;
import UI_Testing.Utilities.BrowserUtils;
import UI_Testing.Utilities.Driver;
import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ExplicitWait_practice {

    @BeforeMethod
    public void setUp(){
        Driver.getDriver().get("https://practice.cydeo.com/dynamic_controls");
    }

    @Test(priority = 1)
    public void remove_checkbox(){
        DynamicControl_page dynamicControlPage=new DynamicControl_page();
        dynamicControlPage.removeButton.click();

       // WebDriverWait wait=new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
       // wait.until(ExpectedConditions.invisibilityOf(dynamicControlPage.loadingBar));
        BrowserUtils.explicitWait(dynamicControlPage.loadingBar);
        // Verifying that element NOT displaying
        try{
            Assert.assertFalse(dynamicControlPage.checkBox.isDisplayed());
        }catch (NoSuchElementException n){
            System.out.println("NoSuchElementException is thrown. Checkbox is not on the page - as intended");
            Assert.assertTrue(true);
        }
        Assert.assertTrue(dynamicControlPage.goneMessage.isDisplayed());
        System.out.println(dynamicControlPage.goneMessage.getText());
        //Driver.getDriver().navigate().refresh();
    }
        @Test(priority = 2)
        public void enable(){

        DynamicControl_page dynamicControlPage=new DynamicControl_page();

        dynamicControlPage.enableButton.click();
        //wait.until(ExpectedConditions.invisibilityOf(dynamicControlPage.loadingBar));
        BrowserUtils.explicitWait(dynamicControlPage.loadingBar);//- created util method for wait

        Assert.assertTrue(dynamicControlPage.goneMessage.isDisplayed());
        System.out.println(dynamicControlPage.goneMessage.getText());
        Assert.assertTrue(dynamicControlPage.inputBox.isEnabled());

    }
    @AfterMethod
    public void close(){
        Driver.closeDriver();
    }

}

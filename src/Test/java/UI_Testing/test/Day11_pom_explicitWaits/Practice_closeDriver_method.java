package UI_Testing.test.Day11_pom_explicitWaits;

import UI_Testing.Utilities.Driver;
import org.openqa.selenium.WindowType;
import org.testng.annotations.Test;

public class Practice_closeDriver_method {

    @Test
    public void test1(){
        Driver.getDriver().get("https://google.com");
        Driver.closeDriver();
    }

    @Test
    public void test2(){
        Driver.getDriver().switchTo().newWindow(WindowType.TAB);
        Driver.getDriver().get("https://google.com");
        Driver.closeDriver();
    }

    @Test
    public void test3(){
        Driver.getDriver().get("https://google.com");
        Driver.closeDriver();
    }

}

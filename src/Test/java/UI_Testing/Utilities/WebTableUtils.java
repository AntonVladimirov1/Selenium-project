package UI_Testing.Utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class WebTableUtils {

    public static String returnOrderDate(WebDriver driver,String customerName){

        String locator= "//td[.='"+customerName+"']/following-sibling::td[3]";
        WebElement customerOrderDate = driver.findElement(By.xpath(locator));
        return customerOrderDate.getText();
                     //* or shorter like this:
      //  return driver.findElement(By.xpath("//td[.='"+customerName+"']/following-sibling::td[3]")).getText();
    }

    public static void OrderDateVerify(WebDriver driver,String customerName,String expectedOrderDate){

        String locator= "//td[.='"+customerName+"']/following-sibling::td[3]";
        WebElement customerOrderDate = driver.findElement(By.xpath(locator));
        String actOrderDate = customerOrderDate.getText();
        Assert.assertEquals(actOrderDate,expectedOrderDate);
    }

}

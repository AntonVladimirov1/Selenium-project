package UI_Testing.Utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;
import java.util.List;

public class RadioButtonsUtilityMethod {

    private static void clickAndVerifyRadioButton(WebDriver driver, String nameAttribute, String expectedID){

        //List<WebElement> radioButtons = driver.findElements(By.xpath("//input[@name='"+nameAttribute+"']"));  // or ....
        List<WebElement> radioButtons = driver.findElements(By.name(nameAttribute));

        for (WebElement each : radioButtons) {
            String actualID = each.getAttribute("id");
            System.out.println("actualID = " + actualID);
            if (actualID.equals(expectedID)){
                each.click();
                System.out.println(actualID+ " is selected: " +each.isSelected());
                break;
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://practice.cydeo.com/radio_buttons");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        clickAndVerifyRadioButton(driver,"sport","football");
        System.out.println("================================================");
        Thread.sleep(1000);
        clickAndVerifyRadioButton(driver,"sport","hockey");
        System.out.println("================================================");
        Thread.sleep(1000);
        clickAndVerifyRadioButton(driver,"color","red");
    }
}

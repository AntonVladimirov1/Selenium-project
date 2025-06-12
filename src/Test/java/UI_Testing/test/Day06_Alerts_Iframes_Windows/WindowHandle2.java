package UI_Testing.test.Day06_Alerts_Iframes_Windows;

import UI_Testing.Base.TestBase;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.util.Set;

public class WindowHandle2 extends TestBase {

    @Test
    public void multiple_windows_handling(){
        driver.get("https://demoqa.com/browser-windows");

        driver.findElement(By.id("tabButton")).click();
        driver.findElement(By.id("windowButton")).click();
        driver.findElement(By.id("messageWindowButton")).click();

        String parentWindowHandle = driver.getWindowHandle();

        Set<String> allWindowHandles = driver.getWindowHandles();
        System.out.println("allWindowHandles.size() = " + allWindowHandles.size());

        for (String each : allWindowHandles) {
            System.out.println("each window= " + each);
            driver.switchTo().window(each);
            System.out.println("each Title() = " + driver.getTitle());
        }
    }
}

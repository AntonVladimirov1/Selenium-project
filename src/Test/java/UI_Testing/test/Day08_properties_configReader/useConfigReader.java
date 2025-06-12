package UI_Testing.test.Day08_properties_configReader;

import UI_Testing.Utilities.BrowserUtils;
import UI_Testing.Utilities.ConfigReader;
import UI_Testing.Utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class useConfigReader {

    WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = WebDriverFactory.getDriver(ConfigReader.getProperty("browser"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

    }

    @Test
    public void google_search_test(){

        driver.get(ConfigReader.getProperty("googleURL"));
        WebElement searchBox = driver.findElement(By.xpath("//textarea[@name='q']"));
        searchBox.sendKeys(ConfigReader.getProperty("searchValue") + Keys.ENTER);
        String expTitle = ConfigReader.getProperty("searchValue")+" - Google Search";
        BrowserUtils.sleep(2);
        String actTitle = driver.getTitle();
        Assert.assertEquals(actTitle,expTitle);

    }

}

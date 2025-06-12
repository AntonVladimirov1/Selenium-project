package UI_Testing.Utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverFactory {
    
    public static WebDriver getDriver(String browserType){

        if (browserType.equalsIgnoreCase("chrome")){
            WebDriverManager.chromedriver().setup();
            return new ChromeDriver();
        } else if (browserType.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            return new FirefoxDriver();
        }else if (browserType.equalsIgnoreCase("edge")){
            WebDriverManager.edgedriver().setup();
            return new EdgeDriver();
        }else {
            System.err.println("Not supported browser name!");
            return null;
        }
    }
}

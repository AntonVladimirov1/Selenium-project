package UI_Testing.Antonio;

import UI_Testing.Utilities.ConfigReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class devMHLoginPage {
    static WebDriver driver = new ChromeDriver();

  /*  public devMHLoginPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "input[type='text']")
    public WebElement usernameField;
    @FindBy(xpath = "input[type='password']")
    public WebElement passwordField;
    @FindBy(xpath = "input[type='submit']")
    public WebElement submitButton;

         */

   // WebElement usernameField = Driver.getDriver().findElement(By.xpath("//*[@id=\"Username\"]"));
   // WebElement passwordField = Driver.getDriver().findElement(By.xpath("//*[@id=\"Password\"]"));
   // WebElement submitButton = Driver.getDriver().findElement(By.cssSelector("input[type='submit']"));



    public static void login() {
        driver.get(ConfigReader.getProperty("devMHhomeURL")+"login");

        //WebElement usernameField = Driver.getDriver().findElement(By.xpath("//*[@id=\"Username\"]"));
        //WebElement passwordField = Driver.getDriver().findElement(By.xpath("//*[@id=\"Password\"]"));
        //WebElement submitButton = Driver.getDriver().findElement(By.cssSelector("input[type='submit']"));
        WebElement usernameField = driver.findElement(By.xpath("//*[@id=\"Username\"]"));
        WebElement passwordField = driver.findElement(By.xpath("//*[@id=\"Password\"]"));
        WebElement submitButton = driver.findElement(By.cssSelector("input[type='submit']"));

        String username = ConfigReader.getProperty("devMHusername");
        String password = ConfigReader.getProperty("devMHpassword");
        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
        submitButton.click();
    }

}

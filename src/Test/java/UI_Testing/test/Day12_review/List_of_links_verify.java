package UI_Testing.test.Day12_review;

import UI_Testing.Utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class List_of_links_verify {

    @BeforeClass
    public void setup(){
        Driver.getDriver().get("https://vytrack.com/");
    }
    @Test
    public void linksVerifying(){

        List<WebElement> allLinks = Driver.getDriver().findElements(By.xpath("//ul[@id='top-menu']/li/a"));
        for (WebElement each : allLinks) {
            System.out.println("eachLink = " + each.getText());
        }

        // checking if all Header links are corresponds to expected result
        List<String > actLinks=new ArrayList<>();
        for (WebElement eachLink : allLinks) {
            actLinks.add(eachLink.getText());
        }
        List<String> expLinks=new ArrayList<>(Arrays.asList("Home","About us","Our Approach","Products and Services","Contact","LOGIN"));

        Assert.assertEquals(actLinks,expLinks);
    }
}

package com.cydeo.LinksChecker;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class BrokenLinkChecker {

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        //driver.manage().window().maximize();

        // Open the webpage
        driver.get("https://www.movinghelpd.com/");

        // Find all links on the webpage
        List<WebElement> links = driver.findElements(By.tagName("a"));
        // Count links
        int linkCount = links.size();
        System.out.println("linkCount = " + linkCount);

        // Iterate over each link
        for (WebElement link : links) {
            // Get the URL of the link
            String url = link.getAttribute("href");

            // Check if URL is null or empty
            if (url != null && !url.isEmpty()) {
                try {
                    // Create a URL object
                    URL linkUrl = new URL(url);

                    // Open HTTP connection
                    HttpURLConnection connection = (HttpURLConnection) linkUrl.openConnection();

                    // Set request method
                    connection.setRequestMethod("GET");

                    // Connect to the URL
                    connection.connect();

                    // Get the response code
                    int responseCode = connection.getResponseCode();

                    // Check if response code indicates a broken link
                    if (responseCode >= 400) {
                        System.out.println("Broken Link: " + url + " (Response Code: " + responseCode + ")");
                    } else {
                        System.out.println("Valid Link: " + url);
                    }
                } catch (IOException e) {
                    System.out.println("Error connecting to URL: " + url);
                    e.printStackTrace();
                }
            }
        }
        // Close the WebDriver
        driver.quit();

    }

}

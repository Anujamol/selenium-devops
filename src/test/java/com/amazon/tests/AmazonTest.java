
package com.amazon.tests;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

public class AmazonTest {

    public static void main(String[] args) throws MalformedURLException, InterruptedException {

        // Connect to Selenium Grid
        ChromeOptions options = new ChromeOptions();

        WebDriver driver = new RemoteWebDriver(
                new URL("http://localhost:4444"),
                options
        );

        // Open Amazon laptop search page
        driver.get("https://www.amazon.in/s?k=laptop");

        System.out.println("Amazon search page opened");
        System.out.println("Page Title: " + driver.getTitle());

        // Check whether products are displayed
        boolean productFound = driver.findElements(
                By.cssSelector("[data-component-type='s-search-result']")
        ).size() > 0;

        if (productFound) {
            System.out.println("PASS: Amazon products are displayed");
        } else {
            System.out.println("FAIL: No products found");
        }

        Thread.sleep(5000);

        // Close browser
        driver.quit();
    }
}


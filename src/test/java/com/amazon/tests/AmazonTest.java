package com.amazon.tests;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class AmazonTest {

	@Test
	public void amazonTest() throws InterruptedException {
		// TODO Auto-generated method stub


		WebDriver driver = new EdgeDriver();
	        driver.get("https://www.amazon.in/s?k=laptop");

	        System.out.println("Amazon search page opened");

	        System.out.println("Page Title: " + driver.getTitle());
	        
	        boolean productFound = driver.findElements(By.cssSelector("[data-component-type='s-search-result']")).size() > 0;

	        if (productFound) {
	            System.out.println("PASS: Amazon products are displayed");
	        } else {
	            System.out.println("FAIL: No products found");
	        }

	        Thread.sleep(5000);

	        driver.quit();
		
		
	}

}

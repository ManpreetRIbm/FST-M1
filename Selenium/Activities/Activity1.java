package com.ibm.selenium.FST_Selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Activity1 {

	public static void main(String[] args) {
	    
        // Create a new instance of the Chrome driver
		System.setProperty("webdriver.chrome.driver", "./chromedriver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
		
        // Open the browser
        driver.get("https://www.training-support.net");
		
        // Close the browser
        driver.close();
    }
}

package com.ibm.selenium.FST_Selenium;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Activity11_2 {
	
	public static void main(String[] args) throws InterruptedException {
		// Create a new instance of the Chrome driver
		System.setProperty("webdriver.chrome.driver", "./chromedriver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
 
        //Open browser
        driver.get("https://www.training-support.net/selenium/javascript-alerts");
 
        //Click the button to open a simple alert
        driver.findElement(By.cssSelector("button#confirm")).click();
 
        //Switch to alert window
        Alert confirmAlert = driver.switchTo().alert();
 
        //Get text in the alert box and print it
        String alertText = confirmAlert.getText();
        System.out.println("Alert text is: " + alertText);
 
        //Close the alert with OK
        confirmAlert.accept();
 
        //Close the browser with Cancel
        //confirmAlert.dismiss();
 
        //Close the Browser
        driver.close();
    }

}

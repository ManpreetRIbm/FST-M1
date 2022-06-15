package com.ibm.selenium.FST_Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Activity3 {
	
	public static void main(String[] args) {
		 
		// Create a new instance of the Chrome driver
		System.setProperty("webdriver.chrome.driver", "./chromedriver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
    
        //Open the browser
        driver.get("https://www.training-support.net/selenium/simple-form");
        
        //Find the page title and print it
        String pageTitle = driver.getTitle();
        System.out.println(pageTitle);
        
        //Find the input fields
        WebElement firstName = driver.findElement(By.id("firstName"));
        WebElement lastName = driver.findElement(By.id("lastName"));
        //Enter text
        firstName.sendKeys("Manpreet");
        lastName.sendKeys("Raj");
        
        //Enter the email
        driver.findElement(By.id("email")).sendKeys("testmanu@example.com");
        
        //Enter the contact number
        driver.findElement(By.id("number")).sendKeys("1234567890");
        
        //Click Submit
        driver.findElement(By.cssSelector(".ui.green.button")).click();
    
        //Close the browser
        driver.close();
    }

}

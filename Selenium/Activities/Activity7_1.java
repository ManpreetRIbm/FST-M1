package com.ibm.selenium.FST_Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Activity7_1 {

	public static void main(String[] args) {
		// Create a new instance of the Chrome driver
		System.setProperty("webdriver.chrome.driver", "./chromedriver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
        
        //Open browser
        driver.get("https://training-support.net/selenium/dynamic-attributes");
        
        //Find username and password fields
        WebElement userName = driver.findElement(By.xpath("//input[starts-with(@class, 'username')]"));
        WebElement password = driver.findElement(By.xpath("//input[contains(@class, 'password')]"));
        //Type credentials
        userName.sendKeys("admin");
        password.sendKeys("password");
        //Click Log in
        driver.findElement(By.xpath("//button[contains(text(), 'Log in')]")).click();
        
        //Print login message
        String loginMessage = driver.findElement(By.id("action-confirmation")).getText();
        System.out.println("Login message: " + loginMessage);
        
        //Close browser
        driver.close();
 
    }
}

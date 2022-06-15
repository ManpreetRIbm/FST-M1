package com.ibm.selenium.FST_Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Activity7_2 {
	
	public static void main(String[] args) {
		// Create a new instance of the Chrome driver
		System.setProperty("webdriver.chrome.driver", "./chromedriver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
        
        //Open browser
        driver.get("https://www.training-support.net/selenium/dynamic-attributes");
        
        //Find username and password fields
        WebElement userName = driver.findElement(By.xpath("//input[contains(@class, '-username')]"));
        WebElement password = driver.findElement(By.xpath("//input[contains(@class, '-password')]"));
        WebElement confirmPassword = driver.findElement(By.xpath("//label[text()='Confirm Password']//following-sibling::input"));
        WebElement email = driver.findElement(By.xpath("//label[contains(text(), 'mail')]/following-sibling::input"));
        
        //Type credentials
        userName.sendKeys("Manpreet");
        password.sendKeys("manu123");
        confirmPassword.sendKeys("manu123");
        email.sendKeys("manu123@xyz.com");
        //Click Sign Up
        driver.findElement(By.xpath("//button[contains(text(), 'Sign Up')]")).click();
        
        //Print login message
        String loginMessage = driver.findElement(By.id("action-confirmation")).getText();
        System.out.println("Login message: " + loginMessage);
        
        //Close browser
        driver.close();
	}

}

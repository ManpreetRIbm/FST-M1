package com.ibm.selenium.FST_Selenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Activity6_2 {
	
	public static void main(String[] args) {
		// Create a new instance of the Chrome driver
		System.setProperty("webdriver.chrome.driver", "./chromedriver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
 
        //Open browser
        driver.get("https://training-support.net/selenium/ajax");
 
        //Find and click the button
        driver.findElement(By.xpath("//button[contains(@class, 'violet')]")).click();
 
        //Wait for text to load
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.id("ajax-content"), "HELLO!"));
 
        //getText() and print it
        String ajaxText = driver.findElement(By.id("ajax-content")).getText();
        System.out.println(ajaxText);
        
        //Wait for late text
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.id("ajax-content"), "I'm late!"));
        
        //Get late text and print it
        String lateText = driver.findElement(By.id("ajax-content")).getText();
        System.out.println(lateText);
 
        //Close browser
        driver.close();
    }

}

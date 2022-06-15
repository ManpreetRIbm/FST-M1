package com.ibm.selenium.FST_Selenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Activity6_1 {
	
	public static void main(String[] args) {
		// Create a new instance of the Chrome driver
		System.setProperty("webdriver.chrome.driver", "./chromedriver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        
        //Open browser
        driver.get("https://training-support.net/selenium/dynamic-controls");
 
        //Find checkbox and toggle button
        WebElement checkbox = driver.findElement(By.xpath("//div[@id='dynamicCheckbox']/input"));
        WebElement toggleCheckboxButton = driver.findElement(By.xpath("//button[@id='toggleCheckbox']"));
        
        //Click the toggle button
        toggleCheckboxButton.click();
        
        //Wait for checkbox to disappear
        wait.until(ExpectedConditions.invisibilityOf(checkbox));
        
        //Click toggle button again
        toggleCheckboxButton.click();
        
        //Wait for checkbox to appear
        wait.until(ExpectedConditions.visibilityOf(checkbox));
        checkbox.click();
        
        //Close browser
        driver.close();
    }

}

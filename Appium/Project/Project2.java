package com.ibm.appium.IBMAppium;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class Project2 {

	AndroidDriver<MobileElement> driver;
    WebDriverWait wait;
 
    @BeforeClass
    public void beforeClass() throws MalformedURLException {
        // Set the Desired Capabilities
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceName", "PixelEmulator");
        caps.setCapability("platformName", "android");
        caps.setCapability("automationName", "UiAutomator2");
        caps.setCapability("appPackage", "com.google.android.keep");
        caps.setCapability("appActivity", ".activities.BrowseActivity");
        caps.setCapability("noReset", true);

     // Instantiate Appium Driver
        URL appServer = new URL("http://0.0.0.0:4723/wd/hub");
        driver = new AndroidDriver<>(appServer, caps);
        wait = new WebDriverWait(driver, 5);
    }
    
    @Test
    public void GoogleKeep() throws InterruptedException
    {
		
		  //Click the Create New Note button to add a new Note. Thread.sleep(5000);
		  driver.findElementByAccessibilityId("New text note").click();
		  
		  Thread.sleep(2000);
		  driver.findElementById("editable_title").sendKeys("Title");
		  
		  Thread.sleep(1000); driver.findElementById("edit_note_text").
		  sendKeys("Entering google keep notes");
		  
		  Thread.sleep(1000);
		  driver.findElementByAccessibilityId("Open navigation drawer").click();
		 
    	
    	Thread.sleep(2000);
    	String note = driver.findElementById("index_note_text_description").getText();
    	Assert.assertEquals(note, "Entering google keep notes");
    	
    }
}

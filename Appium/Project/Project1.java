package com.ibm.appium.IBMAppium;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class Project1 {
	
	AndroidDriver<MobileElement> driver;
    WebDriverWait wait;
 
    @BeforeClass
    public void beforeClass() throws MalformedURLException {
        // Set the Desired Capabilities
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceName", "PixelEmulator");
        caps.setCapability("platformName", "android");
        caps.setCapability("automationName", "UiAutomator2");
        caps.setCapability("appPackage", "com.google.android.apps.tasks");
        caps.setCapability("appActivity", ".ui.TaskListsActivity");
        caps.setCapability("noReset", true);

     // Instantiate Appium Driver
        URL appServer = new URL("http://0.0.0.0:4723/wd/hub");
        driver = new AndroidDriver<>(appServer, caps);
        wait = new WebDriverWait(driver, 5);
 
        
    }
    
    @Test
    public void GoogleTask() throws InterruptedException
    {
		
		  //Click the button to add a new task.
		  driver.findElementByAccessibilityId("Create new task").click();
		  
		  Thread.sleep(5000);
		  
		  //Add the following tasks: //Complete Activity with Google Tasks
		  driver.findElementById("add_task_title").
		  sendKeys("Complete Activity with Google Tasks"); 
		  //After each task is added,the Save button should be clicked.
		  driver.findElementById("add_task_done").click();
		  
		  Thread.sleep(5000);
		  
		  //Complete Activity with Google Keep
		  driver.findElementByAccessibilityId("Create new task").click();
		  Thread.sleep(5000); driver.findElementById("add_task_title").
		  sendKeys("Complete Activity with Google Keep"); 
		  //After each task is added,the Save button should be clicked.
		  driver.findElementById("add_task_done").click();
		  
		  //Complete the second Activity Google Keep
		  driver.findElementByAccessibilityId("Create new task").click();
		  Thread.sleep(5000); driver.findElementById("add_task_title").
		  sendKeys("Complete the second Activity Google Keep"); 
		  //After each task is added, the Save button should be clicked.
		  driver.findElementById("add_task_done").click();
		 
    	Thread.sleep(5000);
    	
    	//Write an assertion to ensure all three tasks have been added to the list.
    	String task1 = driver.findElement(MobileBy.AndroidUIAutomator("resourceId(\"com.google.android.apps.tasks:id/task_name\")")).getText();    	
    	Assert.assertEquals(task1, "Complete the second Activity Google Keep");
    	
    	Thread.sleep(1000);
    	
    	String task2 = driver.findElement(MobileBy.xpath("//android.widget.FrameLayout[@content-desc=\"Complete Activity with Google Keep\"]/android.view.ViewGroup/android.widget.TextView")).getText();    	
    	Assert.assertEquals(task2, "Complete Activity with Google Keep");
    	
    	Thread.sleep(1000);
    	
    	String task3 = driver.findElement(MobileBy.xpath("(//android.widget.FrameLayout[@content-desc=\"Complete Activity with Google Tasks\"])[1]/android.view.ViewGroup/android.widget.TextView")).getText();    	
    	Assert.assertEquals(task3, "Complete Activity with Google Tasks");
    	

    }
    
    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}

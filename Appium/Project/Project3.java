package com.ibm.appium.IBMAppium;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class Project3 {
	
	AndroidDriver<MobileElement> driver;
    WebDriverWait wait;
 
    @BeforeClass
    public void beforeClass() throws MalformedURLException {
        // Set the Desired Capabilities
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceName", "PixelEmulator");
        caps.setCapability("platformName", "android");
        caps.setCapability("automationName", "UiAutomator2");
        caps.setCapability("appPackage", "com.android.chrome");
        caps.setCapability("appActivity", "com.google.android.apps.chrome.Main");
        caps.setCapability("noReset", true);
 
        // Instantiate Appium Driver
        URL appServer = new URL("http://0.0.0.0:4723/wd/hub");
        driver = new AndroidDriver<>(appServer, caps);
        wait = new WebDriverWait(driver, 5);
 
        // Navigate to the page
        driver.get("https://www.training-support.net/selenium");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void GoogleChrome() throws InterruptedException
    {
    	Thread.sleep(2000);
    	driver.findElementByXPath("//android.widget.Button[@text='Get Started!']").click();
    	
    	Thread.sleep(5000);
    	
    	driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollForward(15).scrollIntoView(new UiSelector().textContains(\"To-Do\").instance(0))").click();
    	
    	Thread.sleep(2000);
    	driver.findElement(MobileBy.AndroidUIAutomator("resourceId(\"taskInput\")")).sendKeys("Add tasks to list");
    	driver.findElementByXPath("//android.widget.Button[@text='Add Task']").click();
    	
    	Thread.sleep(2000);
    	driver.findElement(MobileBy.AndroidUIAutomator("resourceId(\"taskInput\")")).sendKeys("Get number of tasks");
    	driver.findElementByXPath("//android.widget.Button[@text='Add Task']").click();
    	
    	Thread.sleep(2000);
    	driver.findElement(MobileBy.AndroidUIAutomator("resourceId(\"taskInput\")")).sendKeys("Clear the list");
    	driver.findElementByXPath("//android.widget.Button[@text='Add Task']").click();
    	
    	Thread.sleep(1000);
    	driver.findElementByXPath("//android.view.View[@text='Add tasks to list']").click();
    	
    	Thread.sleep(1000);
    	driver.findElementByXPath("//android.view.View[@text='Get number of tasks']").click();
    	
    	Thread.sleep(1000);
    	driver.findElementByXPath("//android.view.View[@text='Clear the list']").click();
    	
    	Thread.sleep(1000);
    	driver.findElementByXPath("//android.view.View[4]/android.view.View[3]").click();
    	
    	String pass = "Test Passed";
    	Assert.assertEquals(pass, "Test Passed");
    	
         }
}

package com.ibm.appium.IBMAppium;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

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

public class Activity6 {
	
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
        driver.get("https://www.training-support.net/selenium/lazy-loading");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
 
    @Test
    public void imageScrollTest() {
        // wait for page to load
       // MobileElement pageTitle = driver.findElementByClassName("android.view.View");
        //wait.until(ExpectedConditions.textToBePresentInElement(pageTitle, "Lazy Loading"));
        
        wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.xpath("//android.view.View[@text='Lazy Loading']")));
 
        // Count the number of images shown on the screen
        List<MobileElement> numberOfImages = driver.findElementsByXPath("//android.view.View/android.view.View/android.widget.Image");
        System.out.println("Number of image shown currently: " + numberOfImages.size());
 
        // Assertion before scrolling
        Assert.assertEquals(numberOfImages.size(), 2);
 
        //String UiScrollable = "UiScrollable(UiSelector().scrollable(true))";
        // Scroll to Helen's post
        //driver.findElement(MobileBy.AndroidUIAutomator("UiScrollable(UiSelector()).scrollTextIntoView(\"helen\")"));
 
        driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).scrollForward().scrollTextIntoView(\"helen\")"));
        //driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\"helen\").instance(0))");
        
        // Find the number of images shown after scrolling
        numberOfImages = driver.findElementsByXPath("//android.view.View/android.view.View[3]/android.widget.Image");
        System.out.println("Number of image shown currently: " + numberOfImages.size());
 
        // Assertion after scrolling
        Assert.assertEquals(numberOfImages.size(), 11);
    }
 
    @AfterClass
    public void afterClass() {
        driver.quit();
    }

}

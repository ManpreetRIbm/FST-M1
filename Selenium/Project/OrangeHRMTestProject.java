package com.ibm.selenium.FST_Selenium;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class OrangeHRMTestProject {

	WebDriver driver;

	@BeforeMethod
	public void openBrowser() {
		// Create a new instance of the Chrome driver
		System.setProperty("webdriver.chrome.driver", "./chromedriver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// Navigate to ‘http://alchemy.hguy.co/orangehrm’
		driver.get("http://alchemy.hguy.co/orangehrm");
	}

	@Test(priority=1)
	public void verifyWebsiteTitle() {
		// Get the title of the website.
		String title = driver.getTitle();

		// Print the title of the page
		System.out.println("Title of the page is : " + title);

		// Assertion for page title
		Assert.assertEquals("OrangeHRM", title);

	}

	@Test(priority=2)
	public void getURLofHeaderImage() {
		// Get the url of the header image
		WebElement we = driver.findElement(By.xpath("//div[@id='divLogo']/img"));
		System.out.println(we.getAttribute("src"));

	}

	@Test(priority=3)
	public void logginIntoSite() {
		// Find and select the username and password fields
		WebElement username = driver.findElement(By.id("txtUsername"));
		WebElement password = driver.findElement(By.id("txtPassword"));

		// Enter login credentials into the respective fields
		username.sendKeys("orange");
		password.sendKeys("orangepassword123");

		// Click login
		driver.findElement(By.id("btnLogin")).click();

		// Verify that the homepage has opened.
		String text = driver.findElement(By.id("menu_dashboard_index")).getText();
		System.out.println(text);
		Assert.assertEquals("Dashboard", text);
	}

	@Test(priority = 4)
	public void addNewEmployee() {
		
		//Login with credentials provided
		logginIntoSite();
		// Find the PIM option in the menu and click it.
		driver.findElement(By.id("menu_pim_viewPimModule")).click();

		// Click the Add button to add a new Employee.
		driver.findElement(By.id("btnAdd")).click();

		// Fill in the required fields and click Save
		driver.findElement(By.id("firstName")).sendKeys("Manpreet");
		driver.findElement(By.id("lastName")).sendKeys("Raj");

		// Capture the id String idtext =
		String idtext = driver.findElement(By.id("employeeId")).getAttribute("value");
		System.out.println("Id : " + idtext);

		driver.findElement(By.id("btnSave")).click();

		// Navigate back to the PIM page (Employee List tab) and verify the creation of
		// your employee.
		driver.findElement(By.id("menu_pim_viewPimModule")).click();

		driver.findElement(By.id("empsearch_employee_name_empName")).sendKeys("Manpreet");
		driver.findElement(By.id("searchBtn")).click();

		if ((driver.findElement(By.xpath("//*[@id='resultTable']/tbody/tr[1]/td[2]"))).equals(idtext)) {
			System.out.println("Employee " +idtext+ " found");
		}

	}
	
	@Test(priority=5)
	public void editUserInfo()
	{
		//Login with credentials provided
		logginIntoSite();
		//Find the “My Info” menu item and click it.
		driver.findElement(By.id("menu_pim_viewMyDetails")).click();
		
		//On the new page, click the Edit button.
		driver.findElement(By.id("btnSave")).click();
		
		//Fill in the Name, Gender, Nationality, and the DOB fields.
		
		//Firstname lastname
		WebElement fname = driver.findElement(By.id("personal_txtEmpFirstName"));
		fname.clear();
		fname.sendKeys("John");
		
		WebElement lname = driver.findElement(By.id("personal_txtEmpLastName"));
		lname.clear();
		lname.sendKeys("Doe");
		
		//Gender
		driver.findElement(By.id("personal_optGender_1")).click();
		
		//Nationality
		Select s = new Select(driver.findElement(By.id("personal_cmbNation")));
		s.selectByVisibleText("Afghan");
		
		//DOB
		WebElement dob = driver.findElement(By.id("personal_DOB"));
		dob.clear();
		dob.sendKeys("1996-05-07");
		
		//Click Save.
		driver.findElement(By.id("btnSave")).click();
	}
	
	@Test(priority=6)
	public void verifyDirectory()
	{
		//Login with credentials provided
		logginIntoSite();
		//Locate the navigation menu.
		WebElement menu = driver.findElement(By.className("menu"));
		System.out.println(menu.getText());
		
		//Verify that the “Directory” menu item is visible and clickable.
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("menu_directory_viewDirectory")));
		wait.until(ExpectedConditions.elementToBeClickable(By.id("menu_directory_viewDirectory")));
		
		//If clickable, click on the menu item
		driver.findElement(By.id("menu_directory_viewDirectory")).click();
		
		//Verify that the heading of the page matches “Search Directory”.
		String heading = driver.findElement(By.className("head")).getText();
		Assert.assertEquals("Search Directory", heading);
		

	}
	
	@Test(priority=7)
	public void addQualifications()
	{
		//Login with credentials provided
		logginIntoSite();
		//Find the “My Info” menu item and click it.
		driver.findElement(By.id("menu_pim_viewMyDetails")).click();
		
		//On the new page, find the Qualification option on the left side menu and click it.
		driver.findElement(By.xpath("//ul[@id='sidenav']//a[contains(text(),'Qualifications')]")).click();
		
		//Add Work Experience and click Save.
		driver.findElement(By.id("addWorkExperience")).click();
		driver.findElement(By.id("experience_employer")).sendKeys("ibm");
		driver.findElement(By.id("experience_jobtitle")).sendKeys("Sofware Engineer");
		driver.findElement(By.id("btnWorkExpSave")).click();
	
	}
	
	@Test(priority=8)
	public void applyLeave()
	{
		//Login with credentials provided
		logginIntoSite();
		
		//Navigate to the Dashboard page and click on the Apply Leave option.
		driver.findElement(By.id("menu_dashboard_index")).click();
		driver.findElement(By.xpath("//span[contains(text(),'Apply Leave')]")).click();
		
		//Select leave type and duration of the leave
		Select s = new Select(driver.findElement(By.id("applyleave_txtLeaveType")));
		s.selectByValue("1");
		
		String fromdate = "2022-06-20";
		String todate = "2022-06-25";
		
		WebElement fromD = driver.findElement(By.id("applyleave_txtFromDate"));
		fromD.clear();
		fromD.sendKeys(fromdate);
		
		WebElement toD = driver.findElement(By.id("applyleave_txtToDate"));
		toD.clear();
		toD.sendKeys(todate);

		//Entering unique comment
		String cmnt = "Applying leave for Manpreet";
		
		driver.findElement(By.id("applyleave_txtComment")).sendKeys(cmnt);
		
		//Click Apply.
		driver.findElement(By.id("applyBtn")).click();
		
		//Navigate to the My Leave page to check the status of the leave application
		//Click on MyLeave
		driver.findElement(By.id("menu_leave_viewMyLeaveList")).click();
		
		//Enter from and to date and click on search
		WebElement from = driver.findElement(By.id("calFromDate"));
		from.clear();
		from.sendKeys(fromdate);
		
		WebElement to = driver.findElement(By.id("calToDate"));
		to.clear();
		to.sendKeys(todate);
		
		driver.findElement(By.id("btnSearch")).click();
		
		//Check status of leave application
		
		//Iterate to find my comment added and then check status of leave as there is no other unique field to find my applied leave.
		
		int rowCount = driver.findElements(By.xpath("//table[@id='resultTable']/tbody/tr")).size();
		
		for(int i=1;i<=rowCount;i++)
		{
			String comment = driver.findElement(By.xpath("//table[@id='resultTable']/tbody/tr["+i+"]/td[7]")).getText();
			if (comment.equals(cmnt))
			{
				String status = driver.findElement(By.xpath("//table[@id='resultTable']/tbody/tr["+i+"]/td[6]")).getText();
				System.out.println("Status of leave application is : "+status);
			}
			
		}
		

	}

	@Test(priority=9)
	public void retrieveEmergencyContacts()
	{
		//Login with credentials provided
		logginIntoSite();
		
		//Find the “My Info” menu item and click it.
		driver.findElement(By.id("menu_pim_viewMyDetails")).click();
		
		//Locate the left hand menu.
		driver.findElement(By.id("sidenav"));
		
		//Click on the “Emergency Contacts” menu item
		driver.findElement(By.xpath("//ul[@id='sidenav']//a[contains(text(),'Emergency Contacts')]")).click();
		
		//Retrieve information about all the contacts listed in the table
		
		int rowCount = driver.findElements(By.xpath("//table[@id='emgcontact_list']/tbody/tr")).size();
		int colCount = driver.findElements(By.xpath("//table[@id='emgcontact_list']/tbody/tr[1]/td")).size();
		
		for(int i =1;i<=rowCount;i++)
		{
			System.out.println("Printing details of row : "+i);
			for(int j=2;j<=colCount;j++)
			{
				
				String text = driver.findElement(By.xpath("//table[@id='emgcontact_list']/tbody/tr["+i+"]/td["+j+"]")).getText();
				if(j==2)
				{
					System.out.println("Name : "+text);
				}
				else if(j==3)
				{
					System.out.println("Relationship : "+text);
				}
				else if(j==4)
				{
					System.out.println("Home Telephone : "+text);
				}
				else if(j==5)
				{
					System.out.println("Mobile : "+text);
				}
				else if(j==6)
				{
					System.out.println("Work Telephone : "+text);
				}
				
			}
		}

		
	}
	
	@AfterMethod
	public void afterMethod() {
		// Close the browser
		driver.quit();
	}

}

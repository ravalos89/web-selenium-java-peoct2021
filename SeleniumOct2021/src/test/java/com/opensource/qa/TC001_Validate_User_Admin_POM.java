package com.opensource.qa;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.opensource.admin.Login;
import com.opensource.admin.UserManagement;
import com.opensource.base.Base;
import com.opensource.base.GlobalVariables;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class TC001_Validate_User_Admin_POM {

	WebDriver driver;
	Base base;
	UserManagement um;
	Login login;
	
	String username, pwd;
	
	ExtentReports reports;
	ExtentTest extentTest;

	@BeforeTest
	public void beforeTest(){
		base = new Base(driver);
		driver = base.chromeDriverConnection();
		login = new Login(driver);
		um = new UserManagement(driver);
		
		// Create Folder for evidences
		File file=new File(GlobalVariables.PATH_SCREENSHOTS+this.getClass().getSimpleName()+"/");
		base.initializeFolderEvidence(file);
		
		
//		// JSON handling 
//		this.username = base.getJSONData("Credentials", "username");
//		this.pwd = base.getJSONData("Credentials", "password");
		
		// Excel data handling
		this.username = base.getCellData("Credentials", 1, 0);
		this.pwd = base.getCellData("Credentials", 1, 1);
		
		reports = new ExtentReports(GlobalVariables.PATH_SCREENSHOTS+"/ExtentReport.html");
		extentTest = reports.startTest(this.getClass().getSimpleName());
	}

	@Test
	public void tc001() {
		
		// Step 1
		base.launchBrowser(GlobalVariables.QA_URL);
		extentTest.log(LogStatus.PASS, "Open Browser Orange App" + extentTest.addScreenCapture(base.takeScreenshot("LaunchOrange")));
		
		// Step 2, 3, 4
		login.loginOrange(username, pwd);
		extentTest.log(LogStatus.PASS, "Login Oragen Successfully" + extentTest.addScreenCapture(base.takeScreenshot("LoginOrange")));
		
		// Step 5, 6, 7
		um.searchUsername(username);
		extentTest.log(LogStatus.PASS, "SearchUsername" + extentTest.addScreenCapture(base.takeScreenshot("UserName")));
		
		// Step 8
		um.validateUsernameTable(username);
		extentTest.log(LogStatus.PASS, "Validate User in table" + extentTest.addScreenCapture(base.takeScreenshot("userTable")));

	}

	@AfterTest
	public void afterTest() {
		driver.close();
		
		// Extent Report ended
		reports.endTest(extentTest);
		reports.flush();
	}

}

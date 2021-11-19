package com.opensource.qa;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.opensource.admin.Login;
import com.opensource.admin.UserManagement;
import com.opensource.base.Base;
import com.opensource.base.GlobalVariables;

public class TC001_Validate_User_Admin_POM {

	WebDriver driver;
	Base base;
	UserManagement um;
	Login login;

	@BeforeTest
	public void beforeTest() {
		base = new Base(driver);
		driver = base.chromeDriverConnection();
		login = new Login(driver);
		um = new UserManagement(driver);
	}

	@Test
	public void tc001() {
		
		// Step 1
		base.launchBrowser(GlobalVariables.QA_URL);
		
		// Step 2, 3, 4
		login.loginOrange("Admin", "admin123");
		
		// Step 5, 6, 7
		um.searchUsername("Admin");
		
		// Step 8
		um.validateUsernameTable("Admin");

	}

	@AfterTest
	public void afterTest() {
		driver.close();
	}

}

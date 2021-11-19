package com.opensource.qa;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.opensource.admin.Login;
import com.opensource.admin.UserManagement;
import com.opensource.base.Base;
import com.opensource.base.GlobalVariables;

public class TC002_Validate_Invalid_Password {

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
	public void tc002() {
		
		// Step 1
		base.launchBrowser(GlobalVariables.QA_URL);
		
		// Step 2, 3
		login.loginOrange("Admin", "admon12345", false);
		
		// Step 4
		login.validateLoginFailed("Invalid credentials");

	}

	@AfterTest
	public void afterTest() {
		driver.close();
	}

}

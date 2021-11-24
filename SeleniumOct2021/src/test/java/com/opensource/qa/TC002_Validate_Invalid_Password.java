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
	
	String username, pwd, msgFailed;

	@BeforeTest
	public void beforeTest() {
		base = new Base(driver);
		driver = base.chromeDriverConnection();
		login = new Login(driver);
		um = new UserManagement(driver);
		
//		// JSON files
//		this.username = base.getJSONData("Credentials", "username");
//		this.pwd = base.getJSONData("Credentials", "passwordFailed");
//		this.msgFailed = base.getJSONData(this.getClass().getSimpleName(), "failedMsg");
		
		// Excel data handling
		this.username = base.getCellData("Credentials", 1, 0);
		this.pwd = base.getCellData("Credentials", 1, 2);
		this.msgFailed = base.getCellData(this.getClass().getSimpleName(), 1, 0);
	}

	@Test
	public void tc002() {
		
		// Step 1
		base.launchBrowser(GlobalVariables.QA_URL);
		
		// Step 2, 3
		login.loginOrange(username, pwd, false);
		
		// Step 4
		login.validateLoginFailed(msgFailed);

	}

	@AfterTest
	public void afterTest() {
		driver.close();
	}

}

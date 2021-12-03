package com.opensource.admin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.opensource.base.Base;

public class Login extends Base{
	
	By txtUsername = By.id("txtUsername");
	By txtPassword = By.id("txtPassword");
	By btnLogin = By.id("btnLogin");
	By btnWelcome = By.id("welcome");
	By lblInvalidMsg = By.id("spanMessage");

	public Login(WebDriver driver) {
		super(driver);
	}
	
//	public void loginOrange(String username, String pwd) {
//		reporter("Login Successfully");
//		type(txtUsername, username);
//		type(txtPassword, pwd);
//		click(btnLogin);
//		waitForElementPresent(btnWelcome);
//	}
	
	public void loginOrange(String username, String pwd, boolean isLogged) {
		reporter("Login Successfully");
		type(txtUsername, username);
		type(txtPassword, pwd);
//		takeScreenshot("EnteredUserPassword");
		click(btnLogin);
//		takeScreenshot("ClickedLogin");
		if(isLogged) {
			waitForElementPresent(btnWelcome);
//			takeScreenshot("ValidatedLogged");
		}
	}
	
	public void loginOrange(String username, String pwd) {
		loginOrange(username, pwd, true);
	}
	
//	public void loginFailedOrange(String username, String pwd) {
//		reporter("Login Failed Orange");
//		type(txtUsername, username);
//		type(txtPassword, pwd);
//		click(btnLogin);
//	}
	
	public void validateLoginFailed(String expectedMsg) {
		reporter("Validate Invalid Password message");
		waitForElementPresent(lblInvalidMsg);
		String actualInvalidMsg = getText(lblInvalidMsg);
		assertEquals(actualInvalidMsg, expectedMsg);
		highlightObject(lblInvalidMsg);
//		takeScreenshot("InavalidMessage");
	}

}

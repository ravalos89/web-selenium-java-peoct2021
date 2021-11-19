package com.opensource.admin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.opensource.base.Base;

public class Login extends Base{
	
	By txtUsername = By.id("txtUsername");
	By txtPassword = By.id("txtPassword");
	By btnLogin = By.id("btnLogin");
	By btnWelcome = By.id("welcome");

	public Login(WebDriver driver) {
		super(driver);
	}
	
	public void loginOrange(String username, String pwd) {
		type(txtUsername, username);
		type(txtPassword, pwd);
		click(btnLogin);
		waitForElementPresent(btnWelcome);
	}

}

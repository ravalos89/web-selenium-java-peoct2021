package com.opensource.admin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.opensource.base.Base;

public class UserManagement extends Base{
	// Objetos
	// Metodos customizados
	
	By lnkAdmin = By.id("menu_admin_viewAdminModule");
	By txtUsername = By.id("searchSystemUser_userName");
	By btnSearch = By.id("searchBtn");
	By tblUsername = By.xpath("//tbody/tr[1]/td[2]");
	
	public UserManagement(WebDriver driver) {
		super(driver);
	}
	
	public void searchUsername(String username) {
		reporter("Search username..."+username);
		type(txtUsername, username);
		implicitWait();
	}
	
	

}

package com.opensource.qa;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TC001_Validate_User_Admin {

	public static WebDriver driver;

	@Test
	public void tc001() {

		// Step 1 Launch browser
		Reporter.log("Step 1 Launch browser");
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/drivers/chrome/chromedriver");
		driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com");
		driver.manage().window().maximize();

		// Step 2 Enter username and password
		Reporter.log("Step 2 Enter username and password");
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.id("txtPassword")).sendKeys("admin123");

		// Step 3 Click Login
		Reporter.log("Step 3 Click Login");
		driver.findElement(By.id("btnLogin")).click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		// Step 4 Verify user is logged successfully
		Reporter.log("Step 4 Verify user is logged successfully");
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("welcome")));

		// Step 5 Click Admin
		Reporter.log("Step 5 Click Admin");
		driver.findElement(By.id("menu_admin_viewAdminModule")).click();

		// Step 6 Enter 'Admin' username text box
		Reporter.log("Step 6 Enter 'Admin' username text box");
		driver.findElement(By.id("searchSystemUser_userName")).sendKeys("Admin");

		// Step 7 Click search button
		Reporter.log("Step 7 Click search button");
		driver.findElement(By.id("searchBtn")).click();

		// Step 8 Validate 'Admin' exist in result table
		Reporter.log("Step 8 Validate 'Admin' exist in result table");
		String actualValue = driver.findElement(By.xpath("//tbody/tr[1]/td[2]")).getText();
		Assert.assertEquals(actualValue, "Admin");

		driver.close();

	}

	@Test
	public void tc002() {

		// Step 1 Launch browser
		Reporter.log("Step 1 Launch browser");
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/drivers/chrome/chromedriver");
		driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com");
		driver.manage().window().maximize();

		// Step 2 Enter username and invalid password
		Reporter.log("Step 2 Enter username and invalid password");
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.id("txtPassword")).sendKeys("admin1234");

		// Step 3 Click Login
		Reporter.log("Step 3 Click Login");
		driver.findElement(By.id("btnLogin")).click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		// Step 4 Verify error message when enter invalid password
		Reporter.log("Verify error message when enter invalid password");
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("spanMessage")));
		String mensaje = driver.findElement(By.id("spanMessage")).getText();
		Assert.assertEquals(mensaje, "Invalid credentials");
		driver.close();

	}

	@BeforeTest
	public void beforeTest() {
	}

	@AfterTest
	public void afterTest() {
	}

}

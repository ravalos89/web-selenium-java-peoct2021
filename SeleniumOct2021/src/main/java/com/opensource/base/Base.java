package com.opensource.base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

public class Base {
	
	private WebDriver driver;
	
	/*
	 * Constructor
	 */
	public Base(WebDriver driver) {
		this.driver = driver;
	}
	
	/*
	 * Chrome driver connection
	 * @autor: ricardo.avalos
	 * @param:
	 * @return:
	 */
	public WebDriver chromeDriverConnection() {
		System.setProperty(GlobalVariables.KEY_CHROME_DRIVER, GlobalVariables.PATH_CHROME_DRIVER);
		driver = new ChromeDriver();
		return driver;
	}
	
	/*
	 * Launch browser
	 */
	public void launchBrowser(String url) {
		try {
			reporter("Launch Browser... "+ url);
			driver.get(url);
			driver.manage().window().maximize();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	/*
	 * Reporter log
	 */
	
	public void reporter(String log) {
		Reporter.log(log);
	}
	
	/*
	 * type text
	 */
	public void type(By locator, String inputText) {
		driver.findElement(locator).sendKeys(inputText);
	}
	
	/*
	 * Click object
	 */
	public void click(By locator) {
		try {
			driver.findElement(locator).click();
		}catch(NoSuchElementException e) {
			e.printStackTrace();
		}
		
	}
	
	/*
	 * Implicit wait
	 */
	public void implicitWait(int seg) {
		driver.manage().timeouts().implicitlyWait(seg, TimeUnit.SECONDS);
	}
	
	/*
	 * Implicit wait (Overloading)
	 */
	public void implicitWait() {
		driver.manage().timeouts().implicitlyWait(GlobalVariables.GENERAL_IMPLICIT_TIMEOUT, TimeUnit.SECONDS);
	}
	
	/*
	 * Explicit wait
	 */
	public void waitForElementPresent(By locator) {
		WebDriverWait wait = new WebDriverWait(driver, GlobalVariables.GENERAL_TIMEOUT);
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	
	/*
	 * Get Text
	 */
	public String getText(By locator) {
		try {
			return driver.findElement(locator).getText();
		}catch(NoSuchElementException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/*
	 * Assert 
	 */
	public void assertEquals(String actual, String expected) {
		Assert.assertEquals(actual, expected);
	}
}

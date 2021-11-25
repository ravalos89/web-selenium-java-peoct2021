package com.opensource.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;

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
	
	/**
	 * Get Data from JSON file (Directly)
	 * 
	 * @author Ricardo Avalos
	 * @param jsonFile, jsonKey
	 * @return jsonValue
	 * @throws FileNotFoundException
	 */
	public String getJSONData(String jsonFileObj, String jsonKey){
		try {

			// JSON Data
			InputStream inputStream = new FileInputStream(GlobalVariables.PATH_JSON_DATA + jsonFileObj + ".json");
			JSONObject jsonObject = new JSONObject(new JSONTokener(inputStream));

			// Get Data
			String jsonValue = (String) jsonObject.get(jsonKey);
			return jsonValue;

		} catch (FileNotFoundException e) {
			Assert.fail("JSON file is not found");
			return null;
		}
	}
	
	/*
	 * Get Value from Excel
	 * @author Ricardo Avalos 
	 * @date 02/18/2019
	 */
	public String getCellData(String excelName, int row, int column) {
		try {
			// Reading Data
			FileInputStream fis = new FileInputStream(GlobalVariables.PATH_EXCEL_DATA+excelName+".xlsx");
			// Constructs an XSSFWorkbook object
			@SuppressWarnings("resource")
			Workbook wb = new XSSFWorkbook(fis);
			Sheet sheet = wb.getSheetAt(0);
			Row rowObj = sheet.getRow(row);
			Cell cell = rowObj.getCell(column);
			String value = cell.getStringCellValue();
			return value;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return null;
		} catch (IOException e1) {
			e1.printStackTrace();
			return null;
		}
		
		
	}
	
	/*
	 * Take screenshot
	 * 
	 * @author Ricardo Avalos
	 * @throws IOException
	 */
	public String takeScreenshot(String fileName){
		try {
			String pathFileName= GlobalVariables.PATH_SCREENSHOTS + fileName + ".png";
			Screenshot screenshot = new AShot().takeScreenshot(driver);
			ImageIO.write(screenshot.getImage(), "PNG", new File(pathFileName));
			return pathFileName;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}

	}

}

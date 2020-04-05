package com.automation.utility;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

public class BaseClass {
	public WebDriver driver;
	public ExcelDataProvier excel;
	public ConfigDataProvider config;

	@BeforeSuite
	public void setupSuite() {
		excel = new ExcelDataProvier();
		config = new ConfigDataProvider();
	}

	@BeforeClass
	public void setup() {
		driver = BrowserFactory.startApplication(driver, config.getBrowserName(), config.getQAURL());
	}

	@AfterClass
	public void tearDown() {
		BrowserFactory.quitBrrowser(driver);
	}

	@AfterMethod
	public void tearDownMethod(ITestResult result) {
		if (result.getStatus() == ITestResult.FAILURE) {
			Helper.captureScreenshot(driver);
		}
	}
}

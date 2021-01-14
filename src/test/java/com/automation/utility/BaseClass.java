package com.automation.utility;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class BaseClass {

	public WebDriver driver;
	public ExcelDataProvier excel;
	public ConfigDataProvider config;
	public ExtentReports report;
	public ExtentTest logger;

	/**
	 * setupSuite(); initializes the following: Excel Configuration Files Extent
	 * Reports Is setup before the test suit is started.
	 */
	@BeforeSuite
	public void setupSuite() {
		Reporter.log("Setting up reports and Test is getting ready.", true);
		excel = new ExcelDataProvier();
		config = new ConfigDataProvider();

		ExtentHtmlReporter extent = new ExtentHtmlReporter(
				new File(System.getProperty("user.dir") + "/Reports/Report_" + Helper.getCurrentDateTime() + ".html"));
		report = new ExtentReports();
		report.attachReporter(extent);
		Reporter.log("Setting is Done - Test can be started", true);
	}

	/**
	 * setup(browser,url) Starts the browser and navigates to the URL and Maximizes
	 * the browser. Is setup before the test steps are executed
	 * 
	 * @param browser
	 * @param qaURL
	 */
	@Parameters({ "browser", "qaURL" })
	@BeforeClass
	public void setup(String browser, String qaURL) {
		Reporter.log("Starting the Browser and setting the URL", true);

		driver = BrowserFactory.startApplication(driver, browser, qaURL);

		Reporter.log("Browser started and URl is set..", true);
	}

	/**
	 * tearDown()- quits the browser after test is completed. Is executed after a
	 * Test is completed.
	 */
	@AfterClass
	public void tearDown() {
		BrowserFactory.quitBrrowser(driver);
	}

	/**
	 * tearDownMethod(ITestResult result) Screenshots are captured based on the
	 * final test results: 1. On Test Failure Result 2. On Test Pass Result 3. On
	 * Test Skipped Result
	 * 
	 * @param result
	 * @throws IOException
	 */
	@AfterMethod
	public void tearDownMethod(ITestResult result) throws IOException {

		Reporter.log("Test is about to Complete >>>> Reports is getting Generated next", true);

		if (result.getStatus() == ITestResult.FAILURE) {
			logger.fail("Test Failed",
					MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build());
		} else if (result.getStatus() == ITestResult.SUCCESS) {
			logger.pass("Test Passed",
					MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build());
		} else if (result.getStatus() == ITestResult.SKIP) {
			logger.skip("Test Skipped",
					MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build());
		}
		report.flush();

		Reporter.log("Test Completed >>>> Reports Generation Completed", true);
	}
}

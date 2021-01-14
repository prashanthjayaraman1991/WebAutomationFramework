package com.automation.testCases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.automation.pages.LoginPage;
import com.automation.utility.BaseClass;

public class LoginTestCase extends BaseClass {

	@Test
	public void testLogin() {

		logger = report.createTest("Login into Testing Web Application");

		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);

		logger.info("Starting Application");

		loginPage.loginIntoApplication(excel.getStringData("Login", 0, 0), excel.getStringData("Login", 0, 1));

		logger.pass("Login Successful");

		System.out.println("Current title after login is: " + driver.getTitle());

	}
}

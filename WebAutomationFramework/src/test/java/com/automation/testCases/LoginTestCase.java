package com.automation.testCases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.automation.pages.LoginPage;
import com.automation.utility.BaseClass;

public class LoginTestCase extends BaseClass {

	@Test
	public void testLogin() {
		
		
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);

		loginPage.loginIntoApplication(excel.getStringData("Login", 0, 0), excel.getStringData("Login", 0, 1));
		
		System.out.println("Current title after login is: " +driver.getTitle());
	

	}
}

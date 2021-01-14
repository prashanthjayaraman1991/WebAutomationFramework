package com.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
	WebDriver driver;

	public LoginPage(WebDriver ldriver) {
		this.driver = ldriver;
	}

	@FindBy(id = "userID")
	WebElement userID;

	@FindBy(id = "pwd")
	WebElement pwd;

	@FindBy(xpath = "//*[@name='loginButton']")
	WebElement loginButton;

	/**
	 * This method is used to login into the application using the following
	 * parameters:
	 * 
	 * @param username
	 * @param password
	 * @author prashanth.jayaraman
	 */
	public void loginIntoApplication(String username, String password) {
		userID.sendKeys(username);
		pwd.sendKeys(password);
		loginButton.click();

	}
}

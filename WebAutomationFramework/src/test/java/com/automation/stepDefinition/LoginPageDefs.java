package com.automation.stepDefinition;

import com.automation.pages.LoginPage;
import com.automation.utility.BaseClass;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageDefs extends BaseClass {

	LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
	
	@Given("^Open browser and start applcation$")
	public void open_browser_and_start_applcation() throws Throwable {
		String qaURL = config.getDataFromConfig("qaURL");
		driver.get(qaURL);
	}

	@When("^I enter valid \"([^\"]*)\" and \"([^\"]*)\"$")
	public void i_enter_valid_and(String username, String password) throws Throwable {
		loginPage.loginIntoApplication(username, password);
	}

	@Then("^user should be able to login succesfully$")
	public void user_should_be_able_to_login_succesfully() throws Throwable {
		System.out.println(driver.getTitle());
	}
}

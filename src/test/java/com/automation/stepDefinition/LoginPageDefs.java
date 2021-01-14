package com.automation.stepDefinition;

import org.openqa.selenium.support.PageFactory;

import com.automation.pages.LoginPage;
import com.automation.utility.BaseClass;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

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

	@Given("^Open the browser and start application$")
	public void open_the_browser_and_start_application() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
	}

	@When("^I enter username and password$")
	public void i_enter_username_and_password(DataTable arg1) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		// For automatic transformation, change DataTable to one of
		// List<YourType>, List<List<E>>, List<Map<K,V>> or Map<K,V>.
		// E,K,V must be a scalar (String, Integer, Date, enum etc)
	}

	@When("^click on login$")
	public void click_on_login() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
	}
}

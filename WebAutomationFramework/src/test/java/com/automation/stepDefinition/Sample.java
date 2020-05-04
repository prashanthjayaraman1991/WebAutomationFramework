package com.automation.stepDefinition;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Sample {

	@Given("^Open browser and start applcation$")
	public void open_browser_and_start_applcation() throws Throwable {
	    System.out.println("Starting");
	}

	@When("^I enter valid \"([^\"]*)\" and \"([^\"]*)\"$")
	public void i_enter_valid_and(String username, String password) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    System.out.println("Username passed "+username);
	    System.out.println("Password passed "+password);
	}

	@Then("^user should be able to login succesfully$")
	public void user_should_be_able_to_login_succesfully() throws Throwable {
		 System.out.println("Finishing");
	}
}

package org.hellofresh.stepdefs;

import org.hellofresh.actions.CreateAccountPageActions;
import org.hellofresh.actions.LoginPageActions;
import org.hellofresh.resources.PrePostSteps;

import cucumber.api.Scenario;
import cucumber.api.java.en.*;
import junit.framework.Assert;

public class CreateAccount 
{
	private PrePostSteps prePostSteps;
	public Scenario scenario;
//	public CreateTestReport testReport;
	
	public CreateAccount (PrePostSteps prePostSteps){
		this.prePostSteps = prePostSteps;
	}
	
	@When("^User enters his email and click on submit$")
	public void click_contact_link()
	{
		CreateAccountPageActions account = new CreateAccountPageActions(prePostSteps);
		Assert.assertTrue("Email address is already used",account.enterEmail());
	}
	
	@And("^User enter Firstname as \"([^\"]*)\", lastname as \"([^\"]*)\" and password as \"([^\"]*)\"$")
	public void enter_user_details(String Firstname, String Lastname, String Password)
	{
		CreateAccountPageActions account = new CreateAccountPageActions(prePostSteps);
		Assert.assertTrue("Unable to enter user details",account.enterCustomerDetails(Firstname, Lastname, Password));
	}
	
	@And("^User enter contact details as \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\"$")
	public void enter_contact_details(String Company, String Address1, String Address2, String City, String State, 
			String PostCode, String Phone, String Mobile, String Alias)
	{
		CreateAccountPageActions account = new CreateAccountPageActions(prePostSteps);
		Assert.assertTrue("Unable to enter user details",account.enterContactDetails(Company, Address1, Address2, City, State, PostCode, Phone, Mobile, Alias));
	}
	
	@Then("^User account should be created successfully with name as \"([^\"]*)\" \"([^\"]*)\"$")
	public void validate_account(String Firstname, String Lastname)
	{
		CreateAccountPageActions account = new CreateAccountPageActions(prePostSteps);
		Assert.assertTrue("Unable to create account",account.validateAccountPage(Firstname + " " + Lastname));
	}
	
}

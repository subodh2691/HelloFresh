package org.hellofresh.stepdefs;

import org.hellofresh.actions.LoginPageActions;
import org.hellofresh.resources.PrePostSteps;

import cucumber.api.Scenario;
import cucumber.api.java.en.*;
import junit.framework.Assert;

public class Login 
{
	private PrePostSteps prePostSteps;
	public Scenario scenario;
//	public CreateTestReport testReport;
	
	public Login (PrePostSteps prePostSteps){
		this.prePostSteps = prePostSteps;
	}
	
	@When("^User clicks on login button in home page$")
	public void click_contact_link()
	{
		LoginPageActions login = new LoginPageActions(prePostSteps);
		Assert.assertTrue("User unable to click on contact link",login.click_login());
	}
	
	@And("^User enter username as \"([^\"]*)\" and password as \"([^\"]*)\"$")
	public void enter_user_credentials(String Username, String Password)
	{
		LoginPageActions login = new LoginPageActions(prePostSteps);
		Assert.assertTrue("Unable to enter user credentials",login.enter_credentials(Username, Password));
	}
	
	@Then("^User should be successfully logged in as \"([^\"]*)\"$")
	public void validate_login_page(String fullName)
	{
		LoginPageActions login = new LoginPageActions(prePostSteps);
		Assert.assertTrue("Unable to enter user credentials",login.validate_login(fullName));
	}
	
	@And("^User clicks on logout$")
	public void click_logout()
	{
		LoginPageActions login = new LoginPageActions(prePostSteps);
		Assert.assertTrue("Unable to logout",login.click_logout());
	}
}

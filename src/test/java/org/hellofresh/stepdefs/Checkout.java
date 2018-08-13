package org.hellofresh.stepdefs;

import org.hellofresh.actions.CheckoutPageActions;
import org.hellofresh.actions.CreateAccountPageActions;
import org.hellofresh.actions.LoginPageActions;
import org.hellofresh.resources.PrePostSteps;

import cucumber.api.Scenario;
import cucumber.api.java.en.*;
import junit.framework.Assert;

public class Checkout 
{
	private PrePostSteps prePostSteps;
	public Scenario scenario;
//	public CreateTestReport testReport;
	
	public Checkout (PrePostSteps prePostSteps){
		this.prePostSteps = prePostSteps;
	}
	
	@Given("^Wait for (\\d+) milli-seconds$")
	public void wait_app(int milliSec)
	{

		try {
			Thread.sleep(milliSec);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@When("^User selects \"([^\"]*)\" category$")
	public void user_select_category(String category)
	{
		CheckoutPageActions checkout = new CheckoutPageActions(prePostSteps);
		Assert.assertTrue("Unable to select mentioned category or it doesn't exist",checkout.select_category(category));
	}
	
	@When("^User selects product \"([^\"]*)\" with size as \"([^\"]*)\", quantity as \"([^\"]*)\" and colour as \"([^\"]*)\"$")
	public void user_select_product(String Product, String size, String qty, String colour)
	{
		CheckoutPageActions checkout = new CheckoutPageActions(prePostSteps);
		Assert.assertTrue("Unable to select mentioned product",checkout.select_product(Product, size, qty, colour));
	}
	
	@When("^User initiates the checkout$")
	public void user_checkout()
	{
		CheckoutPageActions checkout = new CheckoutPageActions(prePostSteps);
		Assert.assertTrue("Unable to proceed to checkout due to an issue",checkout.checkout_order());
	}
	
	@Then("^Order should be successfully placed$")
	public void verify_order()
	{
		CheckoutPageActions checkout = new CheckoutPageActions(prePostSteps);
		Assert.assertTrue("Order is not placed",checkout.validate_order());
	}
	
}

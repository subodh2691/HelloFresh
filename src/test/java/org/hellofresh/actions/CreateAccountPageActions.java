package org.hellofresh.actions;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.Date;

import org.hellofresh.objectrepo.CreateAccountObjects;
import org.hellofresh.resources.PrePostSteps;
import org.hellofresh.resources.Reporter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class CreateAccountPageActions {
	
	
	private PrePostSteps prePostSteps;
	private WebDriver driver;
	private WebDriverWait wait;	
	
	public CreateAccountPageActions(PrePostSteps obj)
	{
		prePostSteps=obj;
		driver=obj.driver;
		wait=obj.wait;
//		this.test=testReport.test;
	}
/**
 * 
* 
	Created By: subodha
	Method Name: verify_page
	Return Type: ContactPageActions
	Date Created: 13-Aug-2018
*
 */
	public boolean verify_page() {
		CreateAccountObjects objAccount = new CreateAccountObjects(driver);
		wait.until(ExpectedConditions.visibilityOf(objAccount.lnkLogin));
		if(objAccount.lnkLogin.isDisplayed()) {
			objAccount.lnkLogin.click();
			Reporter.addStepLog("Login link is shown");
			return true;
		}
		else {
			return false;
		}
		
	}
	
	public boolean enterEmail() {
		CreateAccountObjects objAccount = new CreateAccountObjects(driver);
		String timestamp = String.valueOf(new Date().getTime());
        String email = "hf_challenge_" + timestamp + "@hf" + timestamp.substring(7) + ".com";
        if (objAccount.createEmail.isDisplayed()) {
	        objAccount.createEmail.sendKeys(email);
	        objAccount.btnSubmitCreate.click();
			return true;
        }
        else {return false;}
        
	}
	
	public boolean enterCustomerDetails(String Firstname, String Lastname, String Password)
	{
		CreateAccountObjects objAccount = new CreateAccountObjects(driver);
		try {
			wait.until(ExpectedConditions.visibilityOf(objAccount.gender)).click();
			
			objAccount.txtcustomer_firstname.sendKeys(Firstname);
			objAccount.txtcustomer_lastname.sendKeys(Lastname);
			objAccount.txtpassword.sendKeys(Password);
			
			Select select = new Select(objAccount.slctDays);
	        select.selectByValue("1");
	        select = new Select(objAccount.slctMonths);
	        select.selectByValue("1");
	        select = new Select(objAccount.slctYear);
	        select.selectByValue("2000");
			return true;
		}
		catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	public boolean enterContactDetails(String Company, String Address1, String Address2, String City, String State, 
			String PostCode, String Phone, String Mobile, String Alias) 
	{
		CreateAccountObjects objAccount = new CreateAccountObjects(driver);
		try {
			objAccount.txtCompany.sendKeys(Company);
			objAccount.txtAddress1.sendKeys(Address1);
			objAccount.txtAddress2.sendKeys(Address2);
			objAccount.txtCity.sendKeys(City);
			
			Select select = new Select(objAccount.slctState);
	        select.selectByVisibleText("Colorado");
	        
	        objAccount.txtPostCode.sendKeys(PostCode);
	        objAccount.txtPhone.sendKeys(Phone);
	        objAccount.txtPhoneMobile.sendKeys(Mobile);
	        objAccount.txtalias.sendKeys(Alias);
	        objAccount.btnSubmit.click();
			return true;
		}
		catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean validateAccountPage(String Name) {
		
		CreateAccountObjects objAccount = new CreateAccountObjects(driver);
		try {
			WebElement heading = wait.until(ExpectedConditions.visibilityOf(objAccount.titleAccount));
			assertEquals(heading.getText(), "MY ACCOUNT");
	        assertEquals(objAccount.lblAccountName.getText(), Name);
	        assertTrue(objAccount.lblAccountInfo.getText().contains("Welcome to your account."));
	        assertTrue(objAccount.lnkLogout.isDisplayed());
	        assertTrue(driver.getCurrentUrl().contains("controller=my-account"));
	        return true;
		}
		catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}
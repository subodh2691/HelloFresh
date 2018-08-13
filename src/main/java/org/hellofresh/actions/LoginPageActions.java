package org.hellofresh.actions;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.hellofresh.objectrepo.CreateAccountObjects;
import org.hellofresh.objectrepo.LoginPageObjects;
import org.hellofresh.resources.PrePostSteps;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class LoginPageActions {

	private PrePostSteps prePostSteps;
	private WebDriver driver;
	private WebDriverWait wait;

	public LoginPageActions(PrePostSteps obj) {
		prePostSteps = obj;
		driver = obj.driver;
		wait = obj.wait;
		// this.test=testReport.test;
	}

	public boolean click_login() {
		
		CreateAccountObjects objAccount = new CreateAccountObjects(driver);
		try {
			wait.until(ExpectedConditions.visibilityOf(objAccount.lnkLogin)).click();
			return true;
		}
		catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	
	public boolean enter_credentials(String Username, String Password) {
		
		LoginPageObjects objLogin = new LoginPageObjects(driver);
		try {
			wait.until(ExpectedConditions.visibilityOf(objLogin.inputEmail)).sendKeys(Username);
			objLogin.inputPassword.sendKeys(Password);
			objLogin.btnSubmit.click();
			return true;
		}
		catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean validate_login(String fullName) {
		
		CreateAccountObjects objAccount = new CreateAccountObjects(driver);
		try {
			WebElement heading = wait.until(ExpectedConditions.visibilityOf(objAccount.titleAccount));
			assertEquals(heading.getText(), "MY ACCOUNT");
	        assertEquals(fullName, objAccount.lblAccountName.getText());
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
	
	public boolean click_logout() {
		
		CreateAccountObjects objAccount = new CreateAccountObjects(driver);
		try {
			wait.until(ExpectedConditions.visibilityOf(objAccount.lnkLogout)).click();
			return true;
		}
		catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		
	}
}

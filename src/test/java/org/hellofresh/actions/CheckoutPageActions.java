package org.hellofresh.actions;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.hellofresh.objectrepo.CheckoutPageObjects;
import org.hellofresh.objectrepo.CreateAccountObjects;
import org.hellofresh.objectrepo.LoginPageObjects;
import org.hellofresh.resources.PrePostSteps;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class CheckoutPageActions {

	private PrePostSteps prePostSteps;
	private WebDriver driver;
	private WebDriverWait wait;

	public CheckoutPageActions(PrePostSteps obj) {
		prePostSteps = obj;
		driver = obj.driver;
		wait = obj.wait;
		// this.test=testReport.test;
	}

	public boolean select_category(String category) {
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(category))).click();
			return true;
		}
		catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean select_product(String Product, String size, String qty, String colour) {
		
		CheckoutPageObjects objCheckout = new CheckoutPageObjects(driver);
		try {
			wait.until(ExpectedConditions.visibilityOf(objCheckout.ProductName(Product))).click();
//			wait.until(ExpectedConditions.visibilityOf(objCheckout.lnkTshirts)).click();
			wait.until(ExpectedConditions.visibilityOf(objCheckout.txtQuantity)).clear();
			objCheckout.txtQuantity.sendKeys(qty);
			Select Sizes = new Select(objCheckout.slctSize);
			Sizes.selectByVisibleText(size);
			
			objCheckout.optColour(colour).click();
			wait.until(ExpectedConditions.visibilityOf(objCheckout.btnSubmit)).click();
			
	        return true;
		}
		
		catch(Exception e) {
			e.printStackTrace();
			return false;
		}	
	}
	
	public boolean checkout_order() {
		CheckoutPageObjects objCheckout = new CheckoutPageObjects(driver);
		try {
			wait.until(ExpectedConditions.visibilityOf(objCheckout.btnCheckout)).click();
	        wait.until(ExpectedConditions.visibilityOf(objCheckout.btnProceedCheckout)).click();
	        wait.until(ExpectedConditions.visibilityOf(objCheckout.btnprocessAddress)).click();
	        wait.until(ExpectedConditions.visibilityOf(objCheckout.lnkAcceptTerms)).click();
	        objCheckout.btnProcessCheckout.click();
	        wait.until(ExpectedConditions.visibilityOf(objCheckout.lnkPayByBankWire)).click();
	        wait.until(ExpectedConditions.visibilityOf(objCheckout.btnConfirmOrder)).click();
	        
	        return true;
		}
		catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean validate_order() {
		CheckoutPageObjects objCheckout = new CheckoutPageObjects(driver);
		CreateAccountObjects objAccount = new CreateAccountObjects(driver);
		try {
			WebElement heading = wait.until(ExpectedConditions.visibilityOf(objAccount.titleAccount));
			assertEquals(heading.getText(), "ORDER CONFIRMATION");
			objCheckout.lblStep4.isDisplayed();
			objCheckout.lblStep5.isDisplayed();
			objCheckout.lblOrderDoneMsg.getText().contains("Your order on My Store is complete.");
			driver.getCurrentUrl().contains("controller=order-confirmation");
			return true;
		}
		catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		
	}
}

package org.hellofresh.objectrepo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class CreateAccountObjects {

	WebDriver driver;
	
	public CreateAccountObjects (WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
			
	@FindBy(id="email_create")
	public WebElement createEmail;
	
	@FindBy(id="SubmitCreate")
	public WebElement btnSubmitCreate;
	
	@FindBy(id="id_gender2")
	public WebElement gender;
	
	@FindBy(id="customer_firstname")
	public WebElement txtcustomer_firstname;
	
	@FindBy(id="customer_lastname")
	public WebElement txtcustomer_lastname;
	
	@FindBy(id="passwd")
	public WebElement txtpassword;
	
	@FindBy(id="days")
	public WebElement slctDays;
	
	@FindBy(id="months")
	public WebElement slctMonths;
	
	@FindBy(id="years")
	public WebElement slctYear;
	
	@FindBy(id="company")
	public WebElement txtCompany;

	@FindBy(id="address1")
	public WebElement txtAddress1;
	
	@FindBy(id="address2")
	public WebElement txtAddress2;
	
	@FindBy(id="city")
	public WebElement txtCity;
	
	@FindBy(id="id_state")
	public WebElement slctState;
	
	@FindBy(id="postcode")
	public WebElement txtPostCode;
	
	@FindBy(id="other")
	public WebElement txtOthers;
	
	@FindBy(id="phone")
	public WebElement txtPhone;
	
	@FindBy(id="phone_mobile")
	public WebElement txtPhoneMobile;
	
	@FindBy(id="alias")
	public WebElement txtalias;
	
	@FindBy(id="submitAccount")
	public WebElement btnSubmit;
	
	@FindBy(className="account")
	public WebElement lblAccountName;
	
	@FindBy(className="info-account")
	public WebElement lblAccountInfo;
	
	@FindBy(className="logout")
	public WebElement lnkLogout;
	
	@FindBy(className="login")
	public WebElement lnkLogin;
	
	@FindBy(css="h1")
	public WebElement titleAccount;
	
	
}

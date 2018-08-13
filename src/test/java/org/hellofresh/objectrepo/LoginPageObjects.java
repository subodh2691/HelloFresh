package org.hellofresh.objectrepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LoginPageObjects {

	WebDriver driver;
	
	public LoginPageObjects (WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="email")
	public WebElement inputEmail;
	
	@FindBy(id="passwd")
	public WebElement inputPassword;
	
	@FindBy(id="SubmitLogin")
	public WebElement btnSubmit	;

}

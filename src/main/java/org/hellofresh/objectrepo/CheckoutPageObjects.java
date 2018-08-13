package org.hellofresh.objectrepo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class CheckoutPageObjects {

	WebDriver driver;
	
	public CheckoutPageObjects (WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText="Women")
	public WebElement catWomen;
	
	@FindBy(xpath="//a[@title='Faded Short Sleeve T-shirts']/ancestor::li")
	public WebElement lnkTshirts;
	
	@FindBy(name="Submit")
	public WebElement btnSubmit	;
	
	@FindBy(id="quantity_wanted")
	public WebElement txtQuantity;
	
	@FindBy(id="group_1")
	public WebElement slctSize;
	
	String elemColour="//a[@name='Colour']"	;
	public WebElement optColour(String Colour) {
        return driver.findElement(By.xpath(elemColour.replace("Colour", Colour)));
	}
	
	String elemProduct="//a[@title='ProductName'][@class='product-name']";
	public WebElement ProductName(String Product) {
        return driver.findElement(By.xpath(elemProduct.replace("ProductName", Product)));
	}
	
	@FindBy(xpath="//*[@id='layer_cart']//a[@class and @title='Proceed to checkout']")
	public WebElement btnCheckout;
	
	@FindBy(xpath="//*[contains(@class,'cart_navigation')]/a[@title='Proceed to checkout']")
	public WebElement btnProceedCheckout;
	
	@FindBy(name="processAddress")
	public WebElement btnprocessAddress;
	
	@FindBy(id="uniform-cgv")
	public WebElement lnkAcceptTerms;
	
	@FindBy(name="processCarrier")
	public WebElement btnProcessCheckout;
	
	@FindBy(className="bankwire")
	public WebElement lnkPayByBankWire;
	
	@FindBy(xpath="//*[@id='cart_navigation']/button")
	public WebElement btnConfirmOrder;
	
	@FindBy(xpath="//li[@class='step_done step_done_last four']")
	public WebElement lblStep4;
	
	@FindBy(xpath="//li[@id='step_end' and @class='step_current last']")
	public WebElement lblStep5;
	
	@FindBy(xpath="//*[@class='cheque-indent']/strong")
	public WebElement lblOrderDoneMsg;

}

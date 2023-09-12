package pom_scripts.web.Header;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import pom_scripts.BasePage;

public class Login extends BasePage{

	public Login(WebDriver driver) {
		super(driver);
	}
	//Login/Register
	@FindBy(xpath="//h1[contains(text(),'Login/Register')]")
	private WebElement LoginRegister;
	public WebElement getLoginRegister() {
		return LoginRegister;
	}
	//Mobile_Number_textfield
	@FindBy(xpath="//input[@placeholder='Mobile Number']")
	private WebElement Mobile_Number_textfield;
	public WebElement getMobile_Number_textfield() {
		return Mobile_Number_textfield;
	}
	//Start_Shopping_button
	@FindBy(xpath="//span[text()='Start Shopping']")
	private WebElement Start_Shopping_button;
	public WebElement getStart_Shopping_button() {
		return Start_Shopping_button;
	}
	//ordersImage_image
	@FindBy(xpath="//img[contains(@class,\"order_image\")]")
	private WebElement ordersImage_image;
	public WebElement getordersImage_image() {
		return ordersImage_image;
	}
	//getOtp
	@FindBy(xpath="//span[contains(text(),'Get OTP')]")
	private WebElement GET_OTP_button;
	public WebElement getGET_OTP_button() {
		return GET_OTP_button;
	}
	//
	//OTP_textfeild
		@FindBy(xpath="//input[@type='password']")
		private WebElement OTP_textfeild;
		public WebElement getOTP_textfeild() {
			return OTP_textfeild;
		}
	
	
}

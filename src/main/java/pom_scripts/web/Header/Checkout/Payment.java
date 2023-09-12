package pom_scripts.web.Header.Checkout;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import pom_scripts.BasePage;

public class Payment extends BasePage {
	String temp = "";

	public Payment(WebDriver driver) {
		super(driver);
	}
	

	// PaytmProceedtoPay_button
	@FindBy(xpath = "//div[contains(@class,'PayWithPayTM')]//button[text()='Proceed to pay']")
	private WebElement PaytmProceedtoPay_button;

	public WebElement getPaytmProceedtoPay_button() {
		return PaytmProceedtoPay_button;
	}
	//Pay_with_Paytm_Wallet_Saved_Cards
	@FindBy(xpath = "//*[contains(@class,'PaymentOption_pay-tab-active__2IXkr')]/SPAN[text()='Pay with']")
	private WebElement Pay_with_Paytm_Wallet_Saved_Cards;

	public WebElement getPay_with_Paytm_Wallet_Saved_Cards() {
		return Pay_with_Paytm_Wallet_Saved_Cards;
	}
	//paytm_PG_text
	@FindBy(xpath = "//div[@class=\"ptm-hedrlogo \"]")
	private WebElement paytm_PG_text;

	public WebElement getpaytm_PG_text() {
		return paytm_PG_text;
	}
	

	//Back_arrow_button
	@FindBy(xpath = "//button[contains(@class,'ptm-go-back-btn')]")
	private WebElement Back_arrow_button;

	public WebElement getBack_arrow_button() {
		return Back_arrow_button;
	}
	//Skip_Feedback_button
	@FindBy(xpath = "//button[text()='Skip Feedback']")
	private WebElement Skip_Feedback_button;
	public WebElement getSkip_Feedback_button() {
		return Skip_Feedback_button;
	}
	
}

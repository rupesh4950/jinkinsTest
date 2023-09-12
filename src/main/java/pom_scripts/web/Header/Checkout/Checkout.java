package pom_scripts.web.Header.Checkout;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import pom_scripts.BasePage;

public class Checkout extends BasePage {
	String temp = "";

	public Checkout(WebDriver driver) {
		super(driver);
	}
	

	// Checkout_text
	@FindBy(xpath = "//h2[contains(@class,'checkout')]")
	private WebElement Checkout_text;
	public WebElement getCheckout_text() {
		return Checkout_text;
	}
	

	//PROCEED_TO_PAY_button
	@FindBy(xpath = "//h3[contains(text(),'Summary')]/..//span[text()='PROCEED TO PAY']")
	private WebElement PROCEED_TO_PAY_button;
	public WebElement getPROCEED_TO_PAY_button() {
		return PROCEED_TO_PAY_button;
	}
}


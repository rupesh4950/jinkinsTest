package pom_scripts.web.Header;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import pom_scripts.BasePage;

public class My_Account extends BasePage{

	public My_Account(WebDriver driver) {
		super(driver);
	}
	//LOGOUT_button
	@FindBy(xpath="//div[contains(@class,'accountMenuHolder')]//li[contains(text(),'LOG OUT')]")
	private WebElement LOGOUT_button;
	public WebElement getLOGOUT_button() {
		return LOGOUT_button;
	}
}

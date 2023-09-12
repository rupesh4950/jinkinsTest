package pom_scripts.My_Account;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import pom_scripts.BasePage;

public class My_Orders extends BasePage{

	public My_Orders(WebDriver driver) {
		super(driver);
	}

	// MY_ORDERS_Button
	@FindBy(xpath = "//div[contains(@class,'Menu')]//span[text()='MY ORDERS']")
	private WebElement MY_ORDERS_Button;
	public WebElement getMY_ORDERS_Button() {
		return MY_ORDERS_Button;
	}
	//My_Orders_text
	@FindBy(xpath = "//div[contains(@class,'Menu')]//span[text()='MY ORDERS']")
	private WebElement My_Orders_text;
	public WebElement getMy_Orders_text() {
		return My_Orders_text;
	}
	//Online_Orders_radiobutton
	@FindBy(xpath = "//span[text()='Online Orders']/..//input[@type='radio' and @value='0']")
	private WebElement Online_Orders_radiobutton;
	public WebElement getOnline_Orders_radiobutton() {
		return Online_Orders_radiobutton;
	}
	//VIEW_DETAILS_button
	@FindBy(xpath = "//button[text()='VIEW DETAILS']")
	private WebElement VIEW_DETAILS_button;
	public WebElement getVIEW_DETAILS_button() {
		return VIEW_DETAILS_button;
	}
	//Order_No_text
	@FindBy(xpath = "//div[text()='Order No']")
	private WebElement Order_No_text;
	public WebElement getOrder_No_text() {
		return Order_No_text;
	}
	//product_order_number_text
	@FindBy(xpath = "//div[text()='Order No']/..//div[contains(@class,'right-header')]")
	private WebElement product_order_number_text;
	public WebElement getproduct_order_number_text() {
		return product_order_number_text;
	}
	

	//Ordered_Product_image
	@FindBy(xpath = "//img[contains(normalize-space(@class),'order_image')]")
	private WebElement Ordered_Product_image;
	public WebElement getOrdered_Product_image() {
		return Ordered_Product_image;
	}
}

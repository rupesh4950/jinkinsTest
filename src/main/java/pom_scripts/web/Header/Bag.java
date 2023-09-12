package pom_scripts.web.Header;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import pom_scripts.BasePage;

public class Bag extends BasePage {
	String temp = "";

	public Bag(WebDriver driver) {
		super(driver);
	}

	// My_Bag_Page_text
	@FindBy(xpath = "//span[contains(text(),'My Bag')]")
	private WebElement My_Bag_Page_text;

	public WebElement getMy_Bag_Page_text() {
		return My_Bag_Page_text;
	}
	

	//MyBagBagPopUp_text
	@FindBy(xpath = "//div[contains(@class,'mini-cart-bag')]")
	private WebElement MyBagBagPopUp_text;

	public WebElement getMyBagBagPopUp_text() {
		return MyBagBagPopUp_text;
	}

	// ProductName_Bag_text
	@FindBy(xpath = "//div[contains(@class,'Cart_name')]")
	private WebElement ProductName_Bag_text;

	public WebElement getProductName_Bag_text() {
		return ProductName_Bag_text;
	}

	// Product_Actual_Price_text
	//div[contains(@class,"Cart_price") and contains(text(),'₹')]
	@FindBy(xpath = "//div[contains(@class,\"Cart_price\") and contains(text(),'₹')]")
	private WebElement Product_Actual_Price_text;

	public WebElement getProduct_Actual_Price_text() {
		return Product_Actual_Price_text;
	}
	// Product_Name_text

	@FindBy(xpath = "//div[contains(@class,\"Cart_name\")]")
	private WebElement Product_Name_text;

	public WebElement getProduct_Name_text() {
		return Product_Name_text;
	}

	// Product_Brand_text
	@FindBy(xpath = "//div[contains(@class,'Cart_details')]//div[contains(@class,'Cart_brand')]")
	private WebElement Product_Brand_text;

	public WebElement getProduct_Brand_text() {
		return Product_Brand_text;
	}

	// APPLY_COUPON_link
	@FindBy(xpath = "//div[contains(@class,'Cart_coupon-selector')]")
	private WebElement APPLY_COUPON_link;

	public WebElement getAPPLY_COUPON_link() {
		return APPLY_COUPON_link;
	}

	// APPLY_COUPON_text
	@FindBy(xpath = "//div[contains(@class,\"Coupon_header\")]//div[text()='APPLY COUPON']")
	private WebElement APPLY_COUPON_text;

	public WebElement getAPPLY_COUPON_text() {
		return APPLY_COUPON_text;
	}

	// Enter_Coupon_Code_textfield
	@FindBy(xpath = "//input[@placeholder='Enter Coupon Code']")
	private WebElement Enter_Coupon_Code_textfield;

	public WebElement getEnter_Coupon_Code_textfield() {
		return Enter_Coupon_Code_textfield;
	}

	// Size_text
	@FindBy(xpath = "//div[@class=\"size-selector\"]//div[contains(@class,\"MuiInput-root\")]")
	private WebElement Size_text;

	public WebElement getSize_text() {
		return Size_text;
	}

	// Quantity_Count_dropdown
	@FindBy(xpath = "//div[contains(@class,\"product-quantity\")]//select")
	private WebElement Quantity_Count_dropdown;

	public WebElement getQuantity_Count_dropdown() {
		return Quantity_Count_dropdown;
	}

	// OFF_Bag_text
	@FindBy(xpath = "//div[contains(@class,'Cart_discounted-price')]/span")
	private WebElement OFF_Bag_text;

	public WebElement getOFF_Bag_text() {
		return OFF_Bag_text;
	}

	// Product_Striked_Price_text
	@FindBy(xpath = "//div[contains(@class,'Cart_discounted-price')]/s")
	private WebElement Product_Striked_Price_text;

	public WebElement getProduct_Striked_Price_text() {
		return Product_Striked_Price_text;
	}

	// CHECKOUT_button
	@FindBy(xpath = "//button[text()='CHECKOUT']")
	private WebElement CHECKOUT_button;

	public WebElement getCHECKOUT_button() {
		return CHECKOUT_button;
	}

	// Sorry__this_coupon_code_is_not_valid_text
	@FindBy(xpath = "//div[contains(@class,\"Coupon_header\")]//div[text()='APPLY COUPON']")
	private WebElement Sorry__this_coupon_code_is_not_valid_text;

	public WebElement getSorry__this_coupon_code_is_not_valid_text() {
		return Sorry__this_coupon_code_is_not_valid_text;
	}

	// Order_Summary_text
	@FindBy(xpath = "//div[contains(text(),'Order Summary')]")
	private WebElement Order_Summary_text;

	public WebElement getOrder_Summary_text() {
		return Order_Summary_text;
	}
	@FindBy(xpath = "//div[contains(@class,\"Cart_price\") and not(contains(@class,\"Cart_discounted-price\"))]")
	private WebElement Product_Price_text;
	public WebElement getProduct_Price_text() {
		return Product_Price_text;
		
	}
	@FindBy(xpath = "//div[contains(@class,\"Cart_discounted-price\")]//s")
	private WebElement ActualPriceText;
	public WebElement getActualPriceText() {
	
		return ActualPriceText;
	}

}

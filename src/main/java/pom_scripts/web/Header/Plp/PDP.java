package pom_scripts.web.Header.Plp;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import pom_scripts.BasePage;

public class PDP  extends BasePage{

	public PDP(WebDriver driver) {
		super(driver);
	}
	//PDP_ProductName_Text
	@FindBy(xpath="//div[contains(@class,\"pdp_sectionDetails\")]//div[contains(@class,\"pdp_name\")]")
	private WebElement PDP_ProductName_Text;
	public WebElement getPDP_ProductName_Text() {
		return PDP_ProductName_Text;
	}
	//Product_Name_text
	
	@FindBy(xpath="//div[contains(@class,\"pdp_name\")]")
	private WebElement Product_Name_text;
	public WebElement getProduct_Name_text() {
		return Product_Name_text;
	}
	//ADD_TO_BAG_button
	@FindBy(xpath="//span[text()='ADD TO BAG']")
	private WebElement ADD_TO_BAG_button;
	public WebElement getADD_TO_BAG_button() {
		return ADD_TO_BAG_button;
	}
	//Cancel_button
	@FindBy(xpath="//*[contains(@class,\"minicart_mini-cart-bag-close-icon\")]")
	private WebElement Cancel_button;
	public WebElement getCancel_button() {
		return Cancel_button;
	}
	//Product_Brand_text
	
	@FindBy(xpath="//div[contains(@class,'pdp_brand')]")
	private WebElement Product_Brand_text;
	public WebElement getProduct_Brand_text() {
		return Product_Brand_text;
	}
	//Product_Price_text
	
	@FindBy(xpath="//div[@class=\"pdp-price\"]")
	private WebElement Product_Price_text;
	public WebElement getProduct_Price_text() {
		return Product_Price_text;
	}
	

	//Product_Discouted_Price_text
	@FindBy(xpath="//div[contains(@class,'pdp-price')]/b")
	private WebElement getProduct_Discouted_Price_text;
	public WebElement getProduct_Discouted_Price_text() {
		return Product_Price_text;
	}
	//Selected_Size_button
	
	@FindBy(xpath="//div[@class='size size-web selected']")
	private WebElement Selected_Size_button;
	public WebElement getSelected_Size_button() {
		return Selected_Size_button;
	}
	//Select_Size_button
	//div[contains(@class,"size size-web") and not(contains(@class,"not-available"))]/span
	@FindBy(xpath="//div[contains(@class,\"size size-web\") and not(contains(@class,\"not-available\"))]/span")
	private WebElement Select_Size_button;
	public WebElement getSelect_Size_button() {
		return Select_Size_button;
	}
	//QUANTITY_text
	@FindBy(xpath="//div[contains(@class,'quantity-input')]//input")
	private WebElement QUANTITY_text;
	public WebElement getQUANTITY_text() {
		return QUANTITY_text;
	}
	//ADD_TO_WISHLIST_button
	@FindBy(xpath="//button[@aria-label=\"add to favorites\"]")
	private WebElement ADD_TO_WISHLIST_button;
	public WebElement getADD_TO_WISHLIST_button() {
		return ADD_TO_WISHLIST_button;
	}
	//REMOVE_FROM_WISHLIST_text
	@FindBy(xpath="//span[text()='REMOVE FROM WISHLIST']")
	private WebElement REMOVE_FROM_WISHLIST_text;
	public WebElement getREMOVE_FROM_WISHLIST_text() {
		return REMOVE_FROM_WISHLIST_text;
	}
	
	//Product_Actual_Amount_text
	@FindBy(xpath="//div[@class=\"pdp-price\"]/span/s")
	private WebElement Product_Actual_Amount_text;
	public WebElement getProduct_Actual_Amount_text() {
		return Product_Actual_Amount_text;
	}
	//OFF_PDP_text
	@FindBy(xpath="//span[@class=\"discount discountHighlight pdpnodealpage\"]")
	private WebElement OFF_PDP_text;
	public WebElement getOFF_PDP_text() {
		return OFF_PDP_text;
	}
	
	//SELECT_SIZE_text
	//div[text()='SELECT SIZE']
	@FindBy(xpath="//div[text()='SELECT SIZE']")
	private WebElement SELECT_SIZE_text;
	public WebElement getSELECT_SIZE_text() {
		return SELECT_SIZE_text;
	}
	
	//SELECT_AVAILABLE_SIZE_button
	@FindBy(xpath="//div[contains(@class,\"size size-web\") and not(contains(@class,\"not-available\"))]/span")
	private WebElement SELECT_AVAILABLE_SIZE_button;
	public WebElement getSELECT_AVAILABLE_SIZE_button() {
		return SELECT_AVAILABLE_SIZE_button;
	}
	//VIEW_BAG_button
	@FindBy(xpath="//span[contains(text(),'View Bag')]")
	private WebElement VIEW_BAG_button;
	public WebElement getVIEW_BAG_button() {
		return VIEW_BAG_button;
	}
	@FindBy(xpath = "//img[@alt='share']")
	private WebElement ShareImage;
	public WebElement getShareImage() {
		return ShareImage;		
	}
	@FindBy(xpath = "//div[(contains(@class,\"not-available\"))]/span")
	private WebElement unavailable_Size_text;
	public WebElement getunavailable_Size_text() {// TODO Auto-generated method stub
		return unavailable_Size_text;
	}
	@FindBy(xpath="//div[@class=\"pdp-price\"]//s")
	private WebElement ActualPrice;
	public WebElement getActualPrice() {
	
		return ActualPrice;
	}
	
	@FindBy(xpath = "//div[@class='pdp-price']/b")
	private WebElement price_text;
	public WebElement getprice_Text() {
		return price_text;
	}
	
	
}

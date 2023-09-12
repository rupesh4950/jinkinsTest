package pom_scripts.web.Header;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import pom_scripts.BasePage;

public class Wishlist extends BasePage {

	public Wishlist(WebDriver driver) {
		super(driver);

	}

	/// Sorry_message_Text
	@FindBy(xpath = "//div[contains(@class,\"Search_search-no-result-text\")]")
	private WebElement Sorry_message_Text;

	public WebElement getSorry_message_Text() {
		return Sorry_message_Text;
	}

	// My_Wishlist_text
	@FindBy(xpath = "//h3[text()='My Wishlist']")
	private WebElement My_Wishlist_text;

	public WebElement getMy_Wishlist_text() {
		return My_Wishlist_text;
	}

	// Product_Brand_text
	@FindBy(xpath = "//div[contains(@class,'wishlist_wishlist-product-item')]//div[contains(@class,'my-wishlist-content')]//*[contains(@class,'subtitle2')]")
	private WebElement Product_Brand_text;
	public WebElement getProduct_Brand_text() {
		return Product_Brand_text;
	}
	//Product_Name_text 
	@FindBy(xpath = "//div[contains(@class,'wishlist_wishlist-product-item')]//div[contains(@class,'my-wishlist-content')]//p")
	private WebElement Product_Name_text;
	public WebElement getProduct_Name_text() {
		return Product_Name_text;
	}
	//Product_Price_text
	@FindBy(xpath="//div[contains(@class,\"wishlist_product-price\")]")
	private WebElement Product_Price_text;
	public WebElement getProduct_Price_text() {
		return Product_Price_text;
	}
	@FindBy(xpath = "//div[@class='wishlist_my-wishlist-image__3xro8']//span")
	private WebElement First_product_image_image;
	public WebElement getFirst_product_image_image() {
		return First_product_image_image;
		
	}
	@FindBy(xpath = "//div[contains(text(),'No Wishlisted Items')]")
	private WebElement No_Wishlisted_Items_text;
	public WebElement getNo_Wishlisted_Items_text() {
		return No_Wishlisted_Items_text;
		
	}
	

}

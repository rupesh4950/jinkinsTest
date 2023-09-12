package pom_scripts.web.Header;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import pom_scripts.BasePage;

public class Header extends BasePage {
	String temp = "";

	public Header(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//img[@title='Pantaloons']")
	private WebElement Pantaloons;

	public WebElement getPantaloons() {
		return Pantaloons;
	}

	// Women_Category

	private WebElement Women_Category;

	public WebElement getWomen_Category(String s) {
		temp = "//span[normalize-space()='WOMEN']//following::a[normalize-space()='" + s + "']";
		Women_Category = driver.findElement(By.xpath(temp));
		return Women_Category;

	}

	//// Men Category

	private WebElement Men_Category;

	public WebElement getMen_Category(String s) {
		temp = "//span[normalize-space()='MEN']//following::a[normalize-space()='" + s + "']";
		Men_Category = driver.findElement(By.xpath(temp));
		return Men_Category;
	}

	// Kids_Category
	private WebElement Kids_Category;

	public WebElement getKids_Category(String s) {
		temp = "//span[normalize-space()='KIDS']//following::a[normalize-space()='" + s + "']";
		Men_Category = driver.findElement(By.xpath(temp));
		return Men_Category;
	}

	// Home_category
	//// span[normalize-space()='HOME']//following::a[normalize-space()='{Dynamic
	// Val1}']
	private WebElement Home_category;

	public WebElement getHome_category(String s) {
		temp = "//span[normalize-space()='HOME']//following::a[normalize-space()='" + s + "']";
		Home_category = driver.findElement(By.xpath(temp));
		return Home_category;
	}

	/// Accessories_Category
	private WebElement Accessories_Category;

	public WebElement getAccessories_Category(String s) {

		temp = "//span[normalize-space()='ACCESSORIES']//following::a[normalize-space()='" + s + "']";
		Accessories_Category = driver.findElement(By.xpath(temp));
		return Accessories_Category;
	}

	// Sub_Catgeory_Link
	//
	private WebElement Sub_Catgeory_Link;

	public WebElement getSub_Catgeory_Link(String s) {
		String n = "//div[@class=\"subcategory-title\"]/..//../..//a[contains(text(),'" + s + "')]";
		Sub_Catgeory_Link = driver.findElement(By.xpath(n));
		return Sub_Catgeory_Link;
	}

	// Search_for_products_and_more_textfield
	@FindBy(xpath = "//input[@placeholder='Search for products and more...']")
	private WebElement Search_for_products_and_more_textfield;

	public WebElement getSearch_for_products_and_more_textfield() {
		return Search_for_products_and_more_textfield;
	}

	// Search_icon
	@FindBy(xpath = "//div[@class=\"search-bar-content-textSearch-icon\"]")
	private WebElement Search_icon;

	public WebElement getSearch_icon() {
		return Search_icon;
	}
	// Wishlist_icon

	@FindBy(xpath = "//div[@class=\"nav-header-wishlist-icon\"]//a[@title='Wishlist']")
	private WebElement Wishlist_icon;

	public WebElement getWishlist_icon() {
		return Wishlist_icon;
	}
	// Bag_icon

	@FindBy(xpath = "//div[@class='header-content']//div[@class='cart-icon']//a[@title='Cart']")
	private WebElement Bag_icon;

	public WebElement getBag_icon() {
		return Bag_icon;
	}
	//Men_Sub_Category
	private WebElement Men_Sub_Category;
	public WebElement getMen_Sub_Category(String s) {
		String n = "(//div[@class=\"subcategory-title\"]/..//a[contains(text(),'"+s+"')])[1]";
		Men_Sub_Category=	driver.findElement(By.xpath(n));
		return Men_Sub_Category;
	}
	

	

}

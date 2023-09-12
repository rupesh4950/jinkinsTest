package pom_scripts.web;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import pom_scripts.BasePage;

public class Home extends BasePage {

	public Home(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//button[@class='No thanks']")
	private WebElement Illdothislater;
	public WebElement getIlldothislater() {
		return Illdothislater;
	}

	// My Account
	@FindBy(xpath = "//div[contains(@class,'header')]//a[@title='My Account']")
	private WebElement My_Account;

	public WebElement getMy_Account() {
		return My_Account;
	}

	// Pantaloons Logo
	@FindBy(xpath = "//img[@title='Pantaloons']")
	private WebElement Pantaloons_Logo;

	public WebElement getPantaloons_Logo() {
		return Pantaloons_Logo;
	}

	/// category

	private WebElement category;

	public WebElement getcategory(String s) {
		String n = "//div[@class='nav-header-container']//a[@title='" + s + "']";
		// System.out.println(n);
		category = driver.findElement(By.xpath(n));
		return category;
	}

	/// Brands_in_Focus
	private WebElement Brands_in_Focus;

	public WebElement getBrands_in_Focus() {
		String n = "//h3[text()='Brands in Focus']";
		Brands_in_Focus = driver.findElement(By.xpath(n));
		return Brands_in_Focus;
	}

	// Banner link
	@FindBy(xpath = "//img[@class=\"banner-img\"]")
	private WebElement BannerLik;

	public WebElement getBanner() {
		return BannerLik;
	}

	// swiper_bullet
	private WebElement swiper_bullet;

	public WebElement getswiper_bullet(String s) {
		String n = "//div[@class='swiper-pagination swiper-pagination-clickable swiper-pagination-bullets']/.//span[contains(@aria-label,'"
				+ s + "')]";
		swiper_bullet = driver.findElement(By.xpath(n));
		return swiper_bullet;
	}

	// Banner_Image
	private WebElement Banner_Image;

	public WebElement getBanner_Image(String s) {
		String n = "(//img[@class=\"banner-img\"])[" + s + "]";
		Banner_Image = driver.findElement(By.xpath(n));
		return Banner_Image;
	}

	// banners_Image
	private WebElement banners_Image;

	public WebElement getbanners_Image(String s) {
		String n = "(//div[@class='shimmer banner-img-wrapper']//img[@class='banner-img'])[" + s + "]";
		banners_Image = driver.findElement(By.xpath(n));
		return banners_Image;
	}

	// Trending_Now_text
	@FindBy(xpath = "//h3[contains(text(),'Trending')]")
	private WebElement Trending_Now_text;

	public WebElement getTrending_Now_text() {
		return Trending_Now_text;
	}

	// Deals_Of_The_Day_Slider_Button
	private WebElement Deals_Of_The_Day_Slider_Button;

	public WebElement getDeals_Of_The_Day_Slider_Button(String s) {
		String n = "//h3[contains(text(),'" + s + "')]/../..//div[@class='swiper-button-next']";
		Deals_Of_The_Day_Slider_Button = driver.findElement(By.xpath(n));
		return Deals_Of_The_Day_Slider_Button;
	}

	// trendingNow_firstProduct_Image
	@FindBy(xpath = "//h3[contains(text(),'Trending')]/../..//div[@class='MuiCardContent-root card-content-area']")
	private WebElement trendingNow_firstProduct_Image;

	public WebElement gettrendingNow_firstProduct_Image() {
		return trendingNow_firstProduct_Image;
	}
	//Pantaloons_image
	@FindBy(xpath = "//img[@title='Pantaloons']")
	private WebElement Pantaloons_image;

	public WebElement getPantaloons_image() {
		return Pantaloons_image;
	}

	// My_Account_icon
	//
	@FindBy(xpath = "//a[@title=\"My Account\"]")
	private WebElement My_Account_icon;

	public WebElement getMy_Account_icon() {
		return My_Account_icon;
	}
	//ProductBrandName_Bag_text
	@FindBy(xpath = "//div[contains(@class,'Cart_brand')]")
	private WebElement ProductBrandName_Bag_text;

	public WebElement getProductBrandName_Bag_text() {
		return ProductBrandName_Bag_text;
	}
	//ProductBrandName_PDP_text
	@FindBy(xpath = "//div[contains(@class,'pdp_brand')]/div")
	private WebElement ProductBrandName_PDP_text;
	public WebElement getProductBrandName_PDP_text() {
		return ProductBrandName_PDP_text;
	}

	//Checkout_page_text
	@FindBy(xpath = "//a[@href=\"/cart\"]")
	private WebElement Checkout_page_text;
	public WebElement getCheckout_page_text() {
		return Checkout_page_text;
	}
	

	//Checkout_text
	@FindBy(xpath = "//a[contains(@href,\"/cart\")]/..")
	private WebElement Checkout_text;
	public WebElement getCheckout_text() {
		return Checkout_text;
	}
	public WebElement getDeals_Of_The_Day_Slider_button(String DynamicVale) {
		String s1="//h3[contains(text(),'"+DynamicVale+"')]/../..//div[contains(@class,'swiper-button-next')]";
		String s="//h3[contains(text(),'"+DynamicVale+"')]/../..//div[@class='swiper-button-next']";
		return driver.findElement(By.xpath(s1));
	}
	public WebElement getDeals_of_the_Day_previous_slider_button(String DynamicValue) {
		String s1="//h3[contains(text(),'"+DynamicValue+"')]/../..//div[contains(@class,'swiper-button-prev swiper-button')]";
		String s="//h3[contains(text(),'"+DynamicValue+"')]/../..//div[@class=\"swiper-button-prev\"]";
		return driver.findElement(By.xpath(s1));
	}
	//
	@FindBy(xpath = "//img[@title='loader']")
	private WebElement Page_reload_Image;
	public WebElement getPage_reload_Image() {
		return Page_reload_Image;
		
	}

}

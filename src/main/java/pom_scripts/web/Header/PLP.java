package pom_scripts.web.Header;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import pom_scripts.BasePage;

public class PLP extends BasePage {
	public PLP(WebDriver driver) {
		super(driver);
	}

	/// BreadcrumbTwo_Text
	@FindBy(xpath = "//a[contains(@class,'breadcrumb lastIndex')]")
	private WebElement BreadcrumbTwo_Text;

	public WebElement getBreadcrumbTwo_Text() {
		return BreadcrumbTwo_Text;
	}

	// Breadcrumb_text
	@FindBy(xpath = "//a[@class='breadcrumb']/ancestor::nav")
	private WebElement Breadcrumb_text;

	public WebElement getBreadcrumb_text() {
		return Breadcrumb_text;
	}

	////
	// First_Product_Image
	@FindBy(xpath = "//div[contains(@class,'PlpWeb_product-card-content')]")
	private WebElement First_Product_Image;

	public WebElement getFirst_Product_Image() {
		return First_Product_Image;
	}

	// HEADING_TITLE_PLP_Text
	@FindBy(xpath = "//h1[contains(@class,'PlpWeb_plp-title')]")
	private WebElement HEADING_TITLE_PLP_Text;

	public WebElement getHEADING_TITLE_PLP_Text() {
		return HEADING_TITLE_PLP_Text;
	}

	// Product_Name_text
	@FindBy(xpath = "//div[contains(@class,\"PlpWeb_product-name\")]")
	private WebElement Product_Name_text;

	public WebElement getProduct_Name_text() {
		return Product_Name_text;
	}

	// PLP_Category_Page_text
	private WebElement PLP_Category_Page_text;

	public WebElement getPLP_Category_Page_text(String s) {
		String n = "(//h1[contains(text(),'" + s + "')])";
		PLP_Category_Page_text = driver.findElement(By.xpath(n));
		return PLP_Category_Page_text;
	}

	// PLP_Category_Page_text
	private WebElement PLP_Category_Page_text2;

	public WebElement getPLP_Category_Page_text2(String s) {
		String n = "(//h1[contains(text(),'" + s + "')])[2]";
		// System.out.println(n);
		PLP_Category_Page_text2 = driver.findElement(By.xpath(n));
		return PLP_Category_Page_text2;
	}

	// Product_Count_text
	@FindBy(xpath = "//div[contains(@class,'PlpWeb_products-count_')]")
	private WebElement Product_Count_text;

	public WebElement getProduct_Count_text() {
		return Product_Count_text;
	}

	// FILTER_BY_text
	@FindBy(xpath = "//div[contains(@class,'MuiGrid-root PlpWeb_filter-section-header')]")
	private WebElement FILTER_BY_text;

	public WebElement getFILTER_BY_text() {
		return FILTER_BY_text;
	}

	// BRAND_dropdown
	@FindBy(xpath = "//p[text()='Brand']")
	private WebElement BRAND_dropdown;

	public WebElement getBRAND_dropdown() {
		return BRAND_dropdown;
	}

	// SORT_BY_dropdown
	@FindBy(xpath = "//a[@class='breadcrumb']/../..")
	private WebElement SORT_BY_dropdown;

	public WebElement getSORT_BY_dropdown() {
		return SORT_BY_dropdown;
	}

	// Brand_filter_value_radiobutton
	@FindBy(xpath = "//p[text()=\"Brand\"]/../../..//div[contains(@class,\"PlpWeb_filter-value-text\")]")
	private WebElement Brand_filter_value_radiobutton;

	public WebElement getBrand_filter_value_radiobutton() {
		return Brand_filter_value_radiobutton;
	}

	// Applied_brand_filter_text
	@FindBy(xpath = "//li[contains(@class,\"PlpWeb_filter-selected\")]//span")
	private WebElement Applied_brand_filter_text;

	public WebElement getApplied_brand_filter_text() {
		return Applied_brand_filter_text;
	}

	// Select_Sort_By_text
	private WebElement Select_Sort_By_text;

	public WebElement getSelect_Sort_By_text(String s) {
		String n = "//option[contains(text(),'" + s + "')]";
		Select_Sort_By_text = driver.findElement(By.xpath(n));
		return Select_Sort_By_text;
	}

	// QUICK_VIEW_button
	@FindBy(xpath = "//div[contains(@class,'PlpWeb_product-quickview-button')]")
	private WebElement QUICK_VIEW_button;

	public WebElement getQUICK_VIEW_button() {
		return QUICK_VIEW_button;
	}

	// Quick_view_main_image
	@FindBy(xpath = "//div[contains(@class,'main-image')]")
	private WebElement Quick_view_main_image;

	public WebElement getQuick_view_main_image() {
		return Quick_view_main_image;
	}

	// Product_Brand_text
	@FindBy(xpath = "//div[contains(@class,'PlpWeb_product-brand')]")
	private WebElement Product_Brand_text;

	public WebElement getProduct_Brand_text() {
		return Product_Brand_text;
	}

	// Product_Price_text
	@FindBy(xpath = "//div[contains(@class,'PlpWeb_product-price')]")
	private WebElement Product_Price_text;

	public WebElement getProduct_Price_text() {
		return Product_Price_text;
	}
	// getWishlist_icon
	@FindBy(xpath = "//div[contains(@class,'PlpWeb_product-image')]/../..//button[@type='button']")
	private WebElement Wishlist_icon;
	public WebElement getWishlist_icon() {
		return Wishlist_icon;
	}
	//Added_to_your_wishlist_text
	@FindBy(xpath = "//div[text()='Added to your wishlist']")
	private WebElement Added_to_your_wishlist_text;
	public WebElement getAdded_to_your_wishlist_text() {
		return Added_to_your_wishlist_text;
	}
	//BreadcrumbOne_text
	@FindBy(xpath = "//a[@class=\"breadcrumb \"]")
	private WebElement BreadcrumbOne_text;
	public WebElement getBreadcrumbOne_text() {
		return BreadcrumbOne_text;
	}
	//Actual_Price_text
	@FindBy(xpath = "//s[@class='actual-price']")
	private WebElement Actual_Price_text;
	public WebElement getActual_Price_text() {
		return Actual_Price_text;
	}
	//OFF_Percentage_text
	@FindBy(xpath = "//span[@class='discount discountHighlight']")
	private WebElement OFF_Percentage_text;
	public WebElement getOFF_Percentage_text() {
		return OFF_Percentage_text;
	}
	//Quick_view_popup
	@FindBy(xpath = "//div[contains(@class,'MuiGrid-root QuickView__quickview-container')]")
	private WebElement Quick_view_popup;
	public WebElement getQuick_view_popup() {
		return Quick_view_popup;
	}
	

	//paytm_logo
	@FindBy(xpath = "//div[@class=\"ptm-hedrlogo \"]")
	private WebElement paytm_logo;
	public WebElement getpaytm_logo() {
		return paytm_logo;
	}
	//div[contains(@class,'PlpWeb_sorting')]//select
	@FindBy(xpath = "//div[contains(@class,'PlpWeb_sorting')]//select")
	private WebElement SORT_BY_dropdown1;
	public WebElement SORT_BY_dropdown() {
		return SORT_BY_dropdown1;
		
	}
	
}

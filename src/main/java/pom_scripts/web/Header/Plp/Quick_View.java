package pom_scripts.web.Header.Plp;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import pom_scripts.BasePage;

public class Quick_View extends BasePage {
	String temp = "";

	public Quick_View(WebDriver driver) {
		super(driver);
	}
	//Product_image
	@FindBy(xpath = "//div[contains(@class,'QuickView__main-image')]")
	private WebElement Product_image;

	public WebElement getProduct_image() {
		return Product_image;
	}
	//Product_Name_text
	@FindBy(xpath = "//div[contains(@class,\"QuickView__name\")]")
	private WebElement Product_Name_text;

	public WebElement getProduct_Name_text() {
		return Product_Name_text;
	}
	//Product_Brand_text
	@FindBy(xpath = "//div[contains(@class,'QuickView__brand')]/span")
	private WebElement Product_Brand_text;

	public WebElement getProduct_Brand_text() {
		return Product_Brand_text;
	}
	//Select_Size_button
	
	@FindBy(xpath = "//div[contains(@class,\"QuickView__size\") and not(contains(@class,'not-available'))]/span")
	private WebElement Select_Size_button;

	public WebElement getSelect_Size_button() {
		return Select_Size_button;
	}
	//Product_Price_text
	@FindBy(xpath = "//div[contains(@class,\"QuickView__price\")]/b")
	private WebElement Product_Price_text;

	public WebElement getProduct_Price_text() {
		return Product_Price_text;
	}
	//Available_Size_button
	@FindBy(xpath = "//div[contains(@class,\"QuickView__size\") and not(contains(@class,'not-available'))]/span")
	private WebElement Available_Size_button;

	public WebElement getAvailable_Size_button() {
		return Available_Size_button;
	}
	//ADD_TO_BAG_button
	@FindBy(xpath = "//button[contains(@class,'add-to-bag-button')]")
	private WebElement ADD_TO_BAG_button;

	public WebElement getADD_TO_BAG_button() {
		return ADD_TO_BAG_button;
	}
	//Quick_View_Close_icon
	
	@FindBy(xpath = "//div[contains(@class,\"QuickView__close-icon\")]")
	private WebElement Quick_View_Close_icon;
	public WebElement getQuick_View_Close_icon() {
		return Quick_View_Close_icon;
	}
	//GO_TO_BAG_button
	@FindBy(xpath = "//span[text()='GO TO BAG']")
	private WebElement GO_TO_BAG_button;

	public WebElement getGO_TO_BAG_button() {
		return GO_TO_BAG_button;
	}
	//Quick_view_popup
	@FindBy(xpath = "//div[contains(@class,'MuiGrid-root QuickView__quickview-container')]")
	private WebElement Quick_view_popup;
	public WebElement getQuick_view_popup() {
		return Quick_view_popup;
	}
	
}

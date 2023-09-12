package pom_scripts.web.Header.Checkout;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import pom_scripts.BasePage;

public class Address extends BasePage {
	String temp = "";

	public Address(WebDriver driver) {
		super(driver);
	}

	// Plus_icon
	@FindBy(xpath = "//p[contains(text(),'Address')]/../..//span[@class='MuiIconButton-label']")
	private WebElement Plus_icon;
	public WebElement getPlus_icon() {
		return Plus_icon;
	}
	

	//ADD_NEW_ADDRESS_button
	@FindBy(xpath = "//p[(text()='Add new address')]")
	private WebElement ADD_NEW_ADDRESS_button;
	public WebElement getADD_NEW_ADDRESS_button() {
		return ADD_NEW_ADDRESS_button;
	}
	
	//First_Name_textfield
	@FindBy(xpath = "//input[@name='fname']")
	private WebElement First_Name_textfield;
	public WebElement getFirst_Name_textfield() {
		return First_Name_textfield;
	}

	//Add_new_address_text
	@FindBy(xpath = "//h4[text()='Add new address']")
	private WebElement Add_new_address_text;
	public WebElement getAdd_new_address_text() {
		return Add_new_address_text;
	}
	

	//Last_Name_textfield
	@FindBy(xpath = "//input[@name=\"lname\"]")
	private WebElement Last_Name_textfield;
	public WebElement getLast_Name_textfield() {
		return Last_Name_textfield;
	}
	

	//Use_Current_Location_link
	@FindBy(xpath = "//div[contains(@class,'googlemap')]//span[text()='Use Current Location']")
	private WebElement Use_Current_Location_link;
	public WebElement getUse_Current_Location_link() {
		return Use_Current_Location_link;
	}
	//Mobile_Number_textfield
	@FindBy(xpath = "//input[@name='phone']")
	private WebElement Mobile_Number_textfield;
	public WebElement getMobile_Number_textfield() {
		return Mobile_Number_textfield;
	}
	//PINCODE_textfield
	@FindBy(xpath = "//input[@name=\"postcode\"]")
	private WebElement PINCODE_textfield;
	public WebElement getPINCODE_textfield() {
		return PINCODE_textfield;
	}
	//House_no__Building_name_textfield
	@FindBy(xpath = "//input[@name=\"building\"]")
	private WebElement House_no__Building_name_textfield;
	public WebElement getHouse_no__Building_name_textfield() {
		return House_no__Building_name_textfield;
	}
	//Pin_code*_text
	@FindBy(xpath = "//input[@name=\"building\"]")
	private WebElement Pin_code_star_text;
	public WebElement getPin_code_star_text() {
		return Pin_code_star_text;
	}
	

	//street_textfield
	@FindBy(xpath = "//input[@id='street']")
	private WebElement street_textfield;
	public WebElement getstreet_textfield() {
		return street_textfield;
	}
	//area_textfield
	@FindBy(xpath = "//input[@name='area']")
	private WebElement area_textfield;
	public WebElement getarea_textfield() {
		return area_textfield;
	}
	//landmark_textfield
	@FindBy(xpath = "//input[@id='landmark']")
	private WebElement landmark_textfield;
	public WebElement getlandmark_textfield() {
		return landmark_textfield;
	}
	

	//Address_Type_text
	@FindBy(xpath = "//p[text()='Address Type']")
	private WebElement Address_Type_text;
	public WebElement getAddress_Type_text() {
		return Address_Type_text;
	}
	

	//Office_button
	@FindBy(xpath = "//span[text()='Office']")
	private WebElement Office_button;
	public WebElement getOffice_button() {
		return Office_button;
	}
	

	//Add_address_button
	@FindBy(xpath = "//span[contains(text(),'Add address')]")
	private WebElement Add_address_button;
	public WebElement getAdd_address_button() {
		return Add_address_button;
	}
	

	//Office_Address_Type_text
	@FindBy(xpath = "//p[contains(text(),'Address')]/../../..//h5[text()='Office']")
	private WebElement Office_Address_Type_text;
	public WebElement getOffice_Address_Type_text() {
		return Office_Address_Type_text;
	}
	

	//Specific_Address_text
	private WebElement Specific_Address_text;
	public WebElement getSpecific_Address_text(String s) {
		String n="//div[@class=\"MuiGrid-root MuiGrid-item\"]//p[contains(text(),'"+s+"')]";
		Specific_Address_text=driver.findElement(By.xpath(n));
		return Specific_Address_text;
	}
	public List<WebElement> getAllDeleteIcons() {
		 return driver.findElements(By.xpath("//div[contains(@class,'address_app-checkout-address')]"
		 		+ "//div[contains(@class,'address_app-checkout-address')]//img"));
	}
//	@FindBy(xpath="//div[contains(@class,'address_app-checkout-address')]//span[contains(text(),'Default Address')]//../../..//.././/h5[2]")
	@FindBy(xpath = "(//span[contains(text(),'Default Address')]//../..//p)")
	private WebElement DefaultAddressName;
	public WebElement getDefaultAddressName() {
		return DefaultAddressName;
	}
	//@FindBy(xpath = "//div[contains(@class,'address_app-checkout-address')]//span[contains(text(),'Default Address')]//../..//img")
	@FindBy(xpath = "//span[contains(text(),'Default Address')]//..//img")
	private WebElement DefaultAddressDeleteIcon;
	public WebElement getDefaultAddressDeleteIcon() {
		
		return DefaultAddressDeleteIcon;
	}
	@FindBy(xpath = "//span[text()='DELETE']/../..//button[contains(@class,'MuiButton-contained MuiButton-containedPrimary')]")
	private WebElement DeleteButton;
	public WebElement getDeleteButton() {
		return DeleteButton;
		
	}
	@FindBy (xpath = "//span[contains(text(),'Make this as default address')]")
	private WebElement button;
	public WebElement getMake_this_as_default_address() {
		return button;
	}
	
	
	
	

}

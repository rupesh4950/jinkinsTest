package test_Scripts.Checkout_web;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import static extentReporter.ExtentLogger.*;

import java.security.Key;

import generic.Base_Test;
import generic.StepGroups;
import generic.Utility;
import pom_scripts.web.Home;
import pom_scripts.web.Header.Bag;
import pom_scripts.web.Header.Header;
import pom_scripts.web.Header.PLP;
import pom_scripts.web.Header.Wishlist;
import pom_scripts.web.Header.Checkout.Address;
import pom_scripts.web.Header.Plp.PDP;
import pom_scripts.web.Header.Plp.Quick_View;

public class CO046 extends Base_Test {

	@Test
	public void main() throws Exception {
		className="CO046";
		Utility u=new Utility();
		if(deurgerMode) {
			u.BrowserInDeburger();
		}
		else {
			u.OpenBrowser();
		}
		Address address=new Address(driver);
		Home home = new Home(driver);
		new Header(driver);
		PLP plp = new PLP(driver);
		js = (JavascriptExecutor) driver;
		new PDP(driver);
		//System.out.println("before");
		StepGroups sg = new StepGroups(driver);
		new Wishlist(driver);
		new WebDriverWait(driver, 1);
		new Quick_View(driver);
		new Bag(driver);
		
		
	//	wait.until(ExpectedConditions.elementToBeClickable(home.getIlldothislater()));
	//	home.getIlldothislater().click();
		//llogb
		if(!deurgerMode)
			sg.Login_to_Pantaloons();
		//Delete Multiple Products From Bag
		sg.Delete_Multiple_Products_From_Bag();
		
		//Navigate to PLP Page - Copy
		sg.Navigate_to_PLP_Page("WOMEN", "Skirts");
		
		//Move mouse pointer on Pantaloons Logo image in Home page
		WebElement ele = home.getPantaloons_Logo();
		action.moveToElement(ele).perform();
		u.moveToElementMessage("pantaloons logo ");
		
		//Move mouse pointer on First Product image in PLP page
		ele=plp.getFirst_Product_Image();
		action.moveToElement(ele).perform();
		u.moveToElementMessage("First product image");
		
		//Verify if QUICK VIEW button is displayed in PLP page
		boolean b = plp.getQUICK_VIEW_button().isDisplayed();
		u.checkIsDisplayed(b, "QUICK VIEW button");
		Assert.assertEquals(b,true);
		
		//Click on QUICK VIEW button in PLP page
		plp.getQUICK_VIEW_button().click();
		u.isClicked("QUICK VIEW button");
		
		//Wait till presence of element with xpath //div[contains(@class,'MuiGrid-root QuickView__quickview-container')]
		String path="//div[contains(@class,'MuiGrid-root QuickView__quickview-container')]";
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(path)));
		
		//Verify if Quick_view_popup is displayed in PLP page
		b=plp.getQuick_view_popup().isDisplayed();
		u.checkIsDisplayed(b, "Quick_view_popup");
		Assert.assertEquals(b,true);
		
		//Naviagte To Checkout With FIlled Address
		sg.Naviagte_To_Checkout_With_FIlled_Address();
		
		
		
		//Verify if Office_button is displayed in Address page
		b=address.getOffice_button().isDisplayed();
		u.checkIsDisplayed(b, "Office_button ");
		Assert.assertEquals(b,true);
		
		//Verify if Office button in Address page is clickable
		wait.until(ExpectedConditions.elementToBeClickable(address.getOffice_button()));
		
		//address.getOffice_button().getText();
		//Click on Office button in Address page
		address.getOffice_button().click();
		u.isClicked("Office button");
		
		//Scroll page vertically until visibility of Office button in Address page
		js.executeScript("arguments[0].scrollIntoView(true);", address.getOffice_button());
		
		//Verify if Add_address_button is displayed in Address page
		b=address.getAdd_address_button().isDisplayed();
		u.checkIsDisplayed(b, "Add_address_button");
		Assert.assertEquals(b,true);
		
		//Verify if Add address button in Address page is clickable
		wait.until(ExpectedConditions.elementToBeClickable(address.getAdd_address_button()));
		
		//Move mouse pointer on Add address button in Address page
		action.moveToElement(address.getAdd_address_button()).perform();
		u.moveToElementMessage(" Add address button");
		
		//Click on current cursor point
		action.click().perform();
		pass("clicked  on Add Address button");
		
		//Wait till Office_Address_Type_text in Address page is visible
//	action.sendKeys(Keys.PAGE_DOWN);
//	action.sendKeys(Keys.PAGE_DOWN);
		sg.Load_current_page_completely();
		//driver.navigate().refresh();
		wait.until(ExpectedConditions.visibilityOf(address.getOffice_Address_Type_text()));
		//Verify if Specific_Address_text is displayed in Address page
		sg.checkLast();
		sg.removeAddress();
		bool=true;
		
	}

}

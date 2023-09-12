package test_Scripts.PLP_Web;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import generic.Base_Test;
import generic.StepGroups;
import generic.Utility;
import pom_scripts.web.Home;
import pom_scripts.web.Header.Header;
import pom_scripts.web.Header.PLP;
import pom_scripts.web.Header.Wishlist;
import pom_scripts.web.Header.Plp.PDP;
import static extentReporter.ExtentLogger.*;
public class PLP060 extends Base_Test {
	@Test
	public void main() throws Exception {
		className = "PLP060";
		Utility u=new Utility();
	//	
		if(deurgerMode) {
			u.BrowserInDeburger();
		}
		else {
			u.OpenBrowser();
		}
		
		Home home = new Home(driver);
		Header header = new Header(driver);
		PLP plp = new PLP(driver);
		js = (JavascriptExecutor) driver;
		new PDP(driver);
		StepGroups sg = new StepGroups(driver);
		Wishlist wishlist = new Wishlist(driver);
		new WebDriverWait(driver, 1);
//		wait.until(ExpectedConditions.elementToBeClickable(home.getIlldothislater()));
//		home.getIlldothislater().click();
		try {
			boolean b = header.getPantaloons().isDisplayed();
			u.checkIsDisplayed(b, " Pantaloons logo");
			Assert.assertEquals(b, true);
//			// image verifcation completed
//			String mobileNUmber = "";
			if(!deurgerMode) {
			sg.Login_to_Pantaloons();
			}
			sg.Remove_Multiple_Products_From_Wishlist();
			// Move mouse pointer on category link in Home page
			String category = "WOMEN";
			action.moveToElement(home.getcategory(category)).perform();
			u.moveToElementMessage("category "+category);

			// Wait till Sub Catgeory link in Header page is visible
			String subCategory = "Casual Shoes";
			wait.until(ExpectedConditions.visibilityOf(header.getSub_Catgeory_Link(subCategory)));
			// Click on Sub Catgeory link in Header page
			header.getSub_Catgeory_Link(subCategory).click();
			u.isClicked("sub categroy "+ subCategory);
			// Move mouse pointer on Pantaloons Logo image in Home page
			action.moveToElement(home.getPantaloons_Logo()).perform();
			u.moveToElementMessage("Pantallons logo");
			// Press PAGE_DOWN key
			action.sendKeys(Keys.ARROW_DOWN).perform();
			// Verify if First Product image is displayed in PLP page
			b = plp.getFirst_Product_Image().isDisplayed();
			u.checkIsDisplayed(b, "First product image");
			Assert.assertEquals(b, true);
			// Step Group Description
			// Get Product Details In PLP - Copy
			sg.Get_Product_Details_In_PLP_Copy();
			// Click on Wishlist icon in PLP page
			wait.until(ExpectedConditions.visibilityOf(plp.getWishlist_icon()));
			wait.until(ExpectedConditions.elementToBeClickable(plp.getWishlist_icon()));
			action.moveToElement(plp.getWishlist_icon()).perform();
			plp.getWishlist_icon().click();
			u.isClicked("Wishlist icon");
			// Wait till Added to your wishlist text in PLP page is visible
			wait.until(ExpectedConditions.visibilityOf(plp.getAdded_to_your_wishlist_text()));
			pass("waited till Added_to_your_wishlist_text");
			// Click on Wishlist icon in Header page using javascript executor
			js.executeScript("arguments[0].click();", header.getWishlist_icon());
			u.isClicked("Wislist icon");
			// Verify if My Wishlist text is displayed in Wishlist page
			b = wishlist.getMy_Wishlist_text().isDisplayed();
			u.checkIsDisplayed(b, "My Wishlist text");
			Assert.assertEquals(b, true);
			// Get Product Details in Wishlist
			sg.Get_Product_Details_in_Wishlist();
			sg.Verify_PLP_and_Wishlist_Product_are_same();
			bool = true;
		} catch (Exception e) {
			System.out.println(e);
		}

	}
}

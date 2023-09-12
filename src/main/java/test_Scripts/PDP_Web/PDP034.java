package test_Scripts.PDP_Web;
import static extentReporter.ExtentLogger.*;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import generic.Base_Test;
import generic.StepGroups;
import generic.Utility;
import pom_scripts.web.Header.Header;
import pom_scripts.web.Header.PLP;
import pom_scripts.web.Header.Wishlist;
import pom_scripts.web.Header.Plp.PDP;
public class PDP034 extends Base_Test{
	@Test
	public void main() throws Exception {
		className="PDP034";
		Utility u=new Utility();
		if(deurgerMode) {
			u.BrowserInDeburger();
		}
		else {
			u.OpenBrowser();
		}
		Header header = new Header(driver);
		new PLP(driver);
		js = (JavascriptExecutor) driver;
		PDP pdp = new PDP(driver);
		StepGroups sg = new StepGroups(driver);
		new Wishlist(driver);
		new WebDriverWait(driver, 1);
		try {
			//	wait.until(ExpectedConditions.elementToBeClickable(home.getIlldothislater()));
			//home.getIlldothislater().click();
			boolean b = header.getPantaloons().isDisplayed();
			u.checkIsDisplayed(b, "Pantaloons logo");
			Assert.assertEquals(b, true);
			// image verifcation completed
			//login to pantaloons
			if(!deurgerMode)
				sg.Login_to_Pantaloons();
			sg.Remove_Multiple_Products_From_Wishlist();
			
			sg.Navigate_to_PLP_Page("WOMEN","Kurtas");
			
			//Press PAGE_DOWN key
			//action.sendKeys(Keys.PAGE_DOWN).perform();
			
			sg.Get_Product_Details_In_PLP_Copy();
			//System.out.println("pdp");
			sg.Get_Product_Details_In_PDP();
			//System.out.println("pdp completed");
			sg.Verify_PLP_and_PDP_Products_are_same();
			///Scroll page vertically until visibility of QUANTITY text in PDP page
			//////////////////////////////////////////
			js.executeScript("arguments[0].scrollIntoView(true);", pdp.getQUANTITY_text());
			pass("scrolled to till quantity text is visible");
			////////////////////////////////
			//System.out.println("pdp product are same");
			//Press PAGE_DOWN key
			//action.sendKeys(Keys.PAGE_DOWN).perform();
			//Wait till ADD TO WISHLIST button in PDP page is visible
			wait.until(ExpectedConditions.elementToBeClickable(pdp.getADD_TO_WISHLIST_button()));
			pass("waited till add to wishislist button is clickable");
			
			//Click on ADD TO WISHLIST button in PDP page
			//System.out.println("add produucts to wishlist");
			
			pdp.getADD_TO_WISHLIST_button().click();
			u.isClicked("ADD_TO_WISHLIST_button");
			///Wait till Wishlist icon in Header page is clickable
			
//			wait.until(ExpectedConditions.elementToBeClickable(header.getWishlist_icon()));
//			pass("waited till eishlist icon in header page is clcikable");
			
			//Wait till REMOVE FROM WISHLIST text in PDP page is visible
			wait.until(ExpectedConditions.visibilityOf(pdp.getREMOVE_FROM_WISHLIST_text()));
			//Wait till Wishlist icon in Header page is clickable
			wait.until(ExpectedConditions.elementToBeClickable(header.getWishlist_icon()));
			pass("waited till eishlist icon in header page is clcikable");
			//Click on Wishlist icon in Header page using javascript executor
			js.executeScript("arguments[0].click();", header.getWishlist_icon());
			u.isClicked("Wishlist_icon");
			
			///Wait till My Wishlist text in Wishlist page is visible
			Wishlist wishlist=new Wishlist(driver);
			wait.until(ExpectedConditions.visibilityOf(	wishlist.getMy_Wishlist_text()));
			pass("waited till the visibilty of wishlist icon is visible ");
			sg.Get_Product_Details_in_Wishlist();
		//Verify if string productBrandWishlist matches string ProductBrandPDP
			sg.verfiyforPDP034();
			
			
			
			
			
			
			
			
			///Click on First_product_image_image in Wishlist page
			wishlist.getFirst_product_image_image().click();
			u.isClicked("First_product_image_image");
			//Wait till Share image in PDP page is visible
			wait.until(ExpectedConditions.visibilityOf(pdp.getShareImage()));
			u.isWaited("share image ","visible");
			///Scroll page vertically until visibility of QUANTITY text in PDP page
			js.executeScript("arguments[0].scrollIntoView(true);", pdp.getQUANTITY_text());
			pass("scrolled to till quantity text is visible");
			
			///Click on REMOVE FROM WISHLIST text in PDP page
			pdp.getREMOVE_FROM_WISHLIST_text().click();
			u.isClicked("REMOVE FROM WISHLIST text");
			
			//Verify if ADD TO WISHLIST button is displayed in PDP page
			b=pdp.getADD_TO_WISHLIST_button().isDisplayed();
			u.checkIsDisplayed(b, "ADD TO WISHLIST button ");
			
			//Navigate to URL wishlistURL

			String wishlistURL = "https://www.pantaloons.com/myaccount/saveditems";
			
			driver.navigate().to(wishlistURL);
			pass("navigate to wishlist url");
			//Wait till My Wishlist text in Wishlist page is visible
			wait.until(ExpectedConditions.visibilityOf(wishlist.getMy_Wishlist_text()));
			
			//Verify if No Wishlisted Items text is displayed in Wishlist page
			b=wishlist.getNo_Wishlisted_Items_text().isDisplayed();
			u.checkIsDisplayed(b, "No_Wishlisted_Items_text");
			
			
			bool=true;
		} catch (Exception e) {
			System.out.println(e);

		}}}


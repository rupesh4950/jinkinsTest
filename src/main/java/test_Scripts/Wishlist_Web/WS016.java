package test_Scripts.Wishlist_Web;
import static extentReporter.ExtentLogger.*;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import generic.Base_Test;
import generic.StepGroups;
import generic.Utility;
import pom_scripts.web.Home;
import pom_scripts.web.Header.Bag;
import pom_scripts.web.Header.Header;
import pom_scripts.web.Header.Login;
import pom_scripts.web.Header.PLP;
import pom_scripts.web.Header.Wishlist;
import pom_scripts.web.Header.Plp.PDP;
import pom_scripts.web.Header.Plp.Quick_View;

public class WS016 extends Base_Test {
	@Test(priority = 1)
	public void main() throws Exception, Exception {
		className="WS016";
		Utility u=new Utility();
		u.OpenBrowser();
		Home home = new Home(driver);
		Header header = new Header(driver);
		PLP plp = new PLP(driver);
		js = (JavascriptExecutor) driver;
		Login login = new Login(driver);
		PDP pdp = new PDP(driver);
		StepGroups sg = new StepGroups(driver);
		Wishlist wishlist = new Wishlist(driver);
		Quick_View quickView = new Quick_View(driver);
		Bag bag = new Bag(driver);
		WebDriverWait w = new WebDriverWait(driver, 1);
		
		
		boolean b = header.getPantaloons().isDisplayed();
		u.checkIsDisplayed(b, "Pantaloons logo");
		Assert.assertEquals(b, true);
		//login in to pan taloons
		sg.Login_to_Pantaloons();
		//Remove Multiple Products From Wishlist
		sg.Remove_Multiple_Products_From_Wishlist();
		sg.Logout_from_Pantaloons();
		// image verifcation completed
		sg.Navigate_to_PLP_Page("WOMEN", "WESTERN WEAR");
		//Get text from Product Name text in PLP page
		String productNamePlp = plp.getProduct_Name_text().getText();
		pass("productNamePlp : "+productNamePlp);
		//Wait till Wishlist icon in PLP page is clickable
		wait.until(ExpectedConditions.visibilityOf(plp.getWishlist_icon()));
		//Click on Wishlist icon in PLP page using javascript executor
		js.executeScript("arguments[0].click();", plp.getWishlist_icon());
		u.isClicked("Wishlit icon");
		//Wait till Login/Register text in Login page is visible
		wait.until(ExpectedConditions.visibilityOf(login.getLoginRegister()));
		b=login.getLoginRegister().isDisplayed();
		u.checkIsDisplayed(b, "Login Register text");
		Assert.assertEquals(b, true);
		sg.Login_through_POP_UP();
		//Wait till First Product image in PLP page is visible
		wait.until(ExpectedConditions.visibilityOf(plp.getFirst_Product_Image()));
		//Verify if First Product image is displayed in PLP page
		b=plp.getFirst_Product_Image().isDisplayed();
		u.checkIsDisplayed(b, "First_Product_Image");
		Assert.assertEquals(b, true);
		//Move mouse pointer on Wishlist icon in Header page
		action.moveToElement(header.getWishlist_icon()).perform();
		u.moveToElementMessage("Wishlist icon");
		//Click on current cursor point
		action.click().perform();
		u.isClicked("Wishllist icon");
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h3[text()='My Wishlist']")));
		//Get text from Product Name text in Wishlist page
		String productNameWishlist = wishlist.getProduct_Name_text().getText();
		pass(productNameWishlist+" productNameWishlist");
		bool=true;
		}

}

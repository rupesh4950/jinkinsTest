package test_Scripts.PLP_Web;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import generic.Base_Test;
import generic.Utility;
import pom_scripts.web.Home;
import pom_scripts.web.Header.Header;
import pom_scripts.web.Header.PLP;
import pom_scripts.web.Header.Wishlist;
import pom_scripts.web.Header.Plp.PDP;
import static extentReporter.ExtentLogger.*;
public class PLP020 extends Base_Test {
	@Test
	public void main() throws Exception {
		className="PLP020";
		Utility u=new Utility();
		u.OpenBrowser();
		Home home = new Home(driver);
		Header header = new Header(driver);
		PLP plp = new PLP(driver);
		js = (JavascriptExecutor) driver;
		PDP pdp = new PDP(driver);
		String product = "Kurta";
		Wishlist wishlist = new Wishlist(driver);
		WebDriverWait w = new WebDriverWait(driver, 1);
		
		boolean b = header.getPantaloons().isDisplayed();
		u.checkIsDisplayed(b, "Pantaloons logo ");
		Assert.assertEquals(b, true);
		// image verifcation completed
		// 3 Move mouse pointer on category link in Home page
		String catagory = "WOMEN";
		WebElement ele = home.getcategory(catagory);
		// Move mouse pointer on category link in Home page
		action.moveToElement(ele).perform();
		u.moveToElementMessage("category link "+catagory);
		// 4 Wait till Sub Catgeory link in Header page is visible
		String subCategory = "Kurtas";
		wait.until(ExpectedConditions.visibilityOf(header.getSub_Catgeory_Link(subCategory)));
		// Click on Sub Catgeory link in Header page
		header.getSub_Catgeory_Link(subCategory).click();
		u.isClicked("Sub Catgeory link "+ subCategory);
		// Verify if PLP Category Page text is displayed in PLP page
		b = plp.getPLP_Category_Page_text2(subCategory).isDisplayed();
		u.checkIsDisplayed(b, "Category Page text");
		Assert.assertEquals(b, true);
		// Verify if Product Count text is displayed in PLP page
		b = plp.getProduct_Count_text().isDisplayed();
		u.checkIsDisplayed(b, "Product Count text");
		Assert.assertEquals(b, true);
		action.moveToElement(plp.getFILTER_BY_text()).perform();
		u.moveToElementMessage("FILTER_BY_text");
		// Wait till BRAND dropdown in PLP page is clickable
		wait.until(ExpectedConditions.elementToBeClickable(plp.getBRAND_dropdown()));
		// Click on BRAND dropdown in PLP page
		plp.getBRAND_dropdown().click();
		u.isClicked("BRAND_dropdown");
		// Wait till Brand filter value radiobutton in PLP page is visible
		wait.until(ExpectedConditions.elementToBeClickable(plp.getBrand_filter_value_radiobutton()));
		// 13 Get only Alpahbet in Mob_Scenario page
		String brandFilter = plp.getBrand_filter_value_radiobutton().getText();
		pass("brandFilter "+brandFilter);
		// Click on Brand filter value radiobutton in PLP page
		plp.getBrand_filter_value_radiobutton().click();
		u.isClicked("Brand_filter_value_radiobutton");
		System.out.println(brandFilter);
		// Wait till Applied brand filter text in PLP page is visible
		wait.until(ExpectedConditions.elementToBeClickable(plp.getApplied_brand_filter_text()));
		// Get text from Applied brand filter text in PLP page
		String filterValue = plp.getApplied_brand_filter_text().getText();
		pass("filterValue "+filterValue);
		System.out.println(filterValue);
		b = plp.getFirst_Product_Image().isDisplayed();
		u.checkIsDisplayed(b, "First_Product_Image");
		Assert.assertEquals(b, true);
		b = brandFilter.contains(filterValue);
		u.isContains(b, brandFilter, filterValue);
		Assert.assertEquals(b, true);
		bool=true;
	}
}

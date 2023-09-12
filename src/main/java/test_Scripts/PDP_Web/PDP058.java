package test_Scripts.PDP_Web;

import org.openqa.selenium.By;
import static extentReporter.ExtentLogger.*;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import generic.Base_Test;
import generic.StepGroups;
import generic.Utility;
import pom_scripts.web.Home;
import pom_scripts.web.Header.Bag;
import pom_scripts.web.Header.Header;
import pom_scripts.web.Header.PLP;
import pom_scripts.web.Header.Wishlist;
import pom_scripts.web.Header.Plp.PDP;
import pom_scripts.web.Header.Plp.Quick_View;

public class PDP058 extends Base_Test {

	@Test
	public void main() throws Exception {
		className = "PDP058";
		Utility u = new Utility();
		u.OpenBrowser();
		Home home = new Home(driver);
		Header header = new Header(driver);
		PLP plp = new PLP(driver);
		js = (JavascriptExecutor) driver;
		PDP pdp = new PDP(driver);
		StepGroups sg = new StepGroups(driver);
		new Wishlist(driver);
		new WebDriverWait(driver, 1);
		Quick_View quickView = new Quick_View(driver);
		Bag bag = new Bag(driver);

		boolean b = header.getPantaloons().isDisplayed();
		u.checkIsDisplayed(b, "Pantaloons logo");
		Assert.assertEquals(b, true);

		// image verifcation completed
		sg.Delete_Multiple_Products_From_Bag();
		sg.Navigate_to_PLP_Page("WOMEN", "Tees & Tops");

		// Move mouse pointer on Pantaloons image in Home page
		action.moveToElement(home.getPantaloons_image()).perform();
		u.moveToElementMessage("Pantaloons logo");

		// Verify if Breadcrumb text is displayed in PLP page
		b = plp.getBreadcrumb_text().isDisplayed();
		if (b) {
			pass("Breadcrumb text" + "is displayed", true);
		} else {
			fail("Breadcrumb text" + "   is not displayed");
			Assert.assertEquals(b, true);
		}
		Assert.assertEquals(b, true);
		int index = 2;
		// Select option from SORT BY dropdown in PLP page whose index is 2
		Select select = new Select(plp.SORT_BY_dropdown());
		// plp.SORT_BY_dropdown().click();
		select.selectByIndex(index);
		// Thread.sleep(10000);
		// Actions a=new Actions(driver);
		// a.sendKeys(Keys.ARROW_DOWN).perform();
		//pass("Selected by index"+index);
		plp.getFILTER_BY_text().click();
		Actions a = new Actions(driver);
		a.sendKeys(Keys.ARROW_DOWN).perform();
		pass("selected index " + index, true);
		try {
			// Thread.sleep(5000);
			wait.until(ExpectedConditions.invisibilityOf(home.getPage_reload_Image()));
			pass("waited till invisibility of home.getPage_reload_Image", true);
		} catch (Exception e) {

		}

		sg.Navigate_to_PDP_Page();

		// Wait till Product Price text in PDP page is visible
		wait.until(ExpectedConditions.visibilityOf(pdp.getProduct_Price_text()));
		pass("waited till visibility of pdp.getProduct_Price_text");
		// pdp.getProduct_Price_text();

		// Get text from Product Price text in PDP page

		String ProductPricePDP = pdp.getProduct_Price_text().getText();
		System.out.println(ProductPricePDP);
		sg.WEB_RemoveSpaceFromWords("ProductPricePDP");
		pass("ProductPricePDP " + ProductPricePDP);

		// WEB_Wait_Untill_Element_is_Visible_and_Displayed in WEB_Scenario page
		b = sg.WEB_Wait_Untill_Element_is_Visible_and_Displayed(pdp.getActualPrice());
		String ActualPrice = null;

		if (b) {
			pass("waited till visibility of Actual price");
			// Get text from ActualPrice text in PDP page
			ActualPrice = pdp.getActualPrice().getText();
			// WEB_RemoveSpaceFromWords in WEB_Scenario page
			ActualPrice = sg.WEB_RemoveSpaceFromWords(ActualPrice);
		}

		wait.until(ExpectedConditions.visibilityOf(pdp.getQUANTITY_text()));
		Utility ut = new Utility();
		ut.isWaited("quantity ", "visibile");

		// Scroll page vertically until visibility of FILTER BY text in PLP page
		// js.executeScript("arguments[0].scrollIntoView(true);",
		// plp.getFILTER_BY_text());
		// sg.Navigate_to_PDP_Page();

		// Scroll page vertically until visibility of QUANTITY text in PDP page
		js.executeScript("arguments[0].scrollIntoView(true);", pdp.getQUANTITY_text());

		// Wait till ADD TO BAG button in PDP page is clickable
		wait.until(ExpectedConditions.elementToBeClickable(pdp.getADD_TO_BAG_button()));

		// Move mouse pointer on ADD TO BAG button in PDP page
		try {
			action.moveToElement(pdp.getADD_TO_BAG_button()).perform();
		} catch (Exception e) {
			action.moveToElement(pdp.getADD_TO_BAG_button()).perform();
		}
		u.moveToElementMessage("ADD TO BAG button ");

		// Click on current cursor point
		try {
			action.click().perform();
			wait.until(ExpectedConditions
					.presenceOfElementLocated(By.xpath("//*[contains(@class,\"minicart_mini-cart-bag-close-icon\")]")));
		} catch (Exception e) {
			action.click().perform();
			wait.until(ExpectedConditions
					.presenceOfElementLocated(By.xpath("//*[contains(@class,\"minicart_mini-cart-bag-close-icon\")]")));
		}
		u.isClicked(" ADD TO BAG button");
///////  passed till here
		//Click on Cancel button in PDP page
		pdp.getCancel_button().click();
		u.isClicked(" Cancel button in quick view Of My Bag");

		// Wait till GO TO BAG button in Quick View page is clickable
		wait.until(ExpectedConditions.elementToBeClickable(quickView.getGO_TO_BAG_button()));
		quickView.getGO_TO_BAG_button().click();
		u.isClicked("GO_TO_BAG_button");

		// Verify if My Bag Page text is displayed in Bag page
		b = bag.getMy_Bag_Page_text().isDisplayed();
		u.checkIsDisplayed(b, "My Bag Page text");
		Assert.assertEquals(b, true);

		// Get text from Product_Brand_text in Bag page
		String productbrand = bag.getProduct_Brand_text().getText();
		pass(productbrand + " productbrand");
//		System.out.println("in main");
		// Get text from Product_Name_text in Bag page
		String productname = bag.getProduct_Name_text().getText();
		pass(productname + " productname");

		// Get text from Product Price text in Bag page

		String productPriceBag = bag.getProduct_Price_text().getText();
		productPriceBag = sg.WEB_RemoveSpaceFromWords(productPriceBag);
		pass("productPriceBag " + productPriceBag);
		// WEB_Wait_Untill_Element_is_Visible_and_Displayed in WEB_Scenario page
		b = sg.WEB_Wait_Untill_Element_is_Visible_and_Displayed(bag.getActualPriceText());

		String productActualPriceBag = null;
		pass("WEB_Wait_Untill_Element_is_Visible_and_Displayed", true);
		if (b) {
			// Get text from Actual Price text in Bag page
			productActualPriceBag = bag.getActualPriceText().getText();
			// Verify if string productActualPriceBag matches string ProductActualPricePDP
			b = sg.fromSriptProductActualPricePDP(productActualPriceBag);
			if (!b) {
				fail("not matches ");
				Assert.fail();
			}
		}
		// Verify if string productbrand matches string ProductBrandPDP
		b = sg.fromSriptProductBrandPDP(productbrand);
		if (!b) {
			fail("not matches ");
			Assert.fail();
		}
		// Verify if string productname matches string productNamePDP
		b = sg.fromSriptproductNamePDP(productname);
		if (!b) {
			fail("not matches ");
			Assert.fail();
		}

		// Verify if string productPriceBag contains string ProductPricePDP
		b = sg.fromSriptProductPricePDP(productPriceBag);

		// productbrand.matches(ProductBrandPDP);
//		System.out.println(productbrand);
//		System.out.println(productname);
		// sg.checkValues(productbrand,productname);
		bool = true;

	}
}

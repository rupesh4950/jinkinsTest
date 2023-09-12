package test_Scripts;

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

public class SE002 extends Base_Test {
	@Test(priority = 1)
	public void main() throws Exception, Exception {
		className = "SE002";
		Utility u = new Utility();
		u.OpenBrowser();
		new Home(driver);
		
		Header header = new Header(driver);
		PLP plp = new PLP(driver);
		js = (JavascriptExecutor) driver;
		new PDP(driver);
		String product = "Kurta";
		Wishlist wishlist = new Wishlist(driver);
		new WebDriverWait(driver, 1);

		WebElement ele = header.getSearch_for_products_and_more_textfield();
		// 4 Enter product into Search for products and more textfield
		ele.sendKeys(product);
		pass(product + " is entered into the search for products and more textfeild");
		// 5 Click on Search icon
		header.getSearch_icon().click();
		u.isClicked("Search icon");
		
		// Wait till First Product image in PLP page is visible
		wait.until(ExpectedConditions.visibilityOf(plp.getFirst_Product_Image()));
		boolean b = plp.getFirst_Product_Image().isDisplayed();
		u.checkIsDisplayed(b, "First Product imgage in plp page");
		Assert.assertEquals(b, true);
		// Get text from Product Name text in PLP page
		String productNamePLP = plp.getProduct_Name_text().getText();
		pass(productNamePLP+" is fetched succesfully");
		System.out.println(productNamePLP);
		// Verify if string productNamePLP contains string product
		b = productNamePLP.contains(product);
		if(b) {
			pass(productNamePLP+" is contains "+product);
		}
		else {pass(productNamePLP+" is not contains "+product);
		}
		Assert.assertEquals(b, true);
		// Click on Search for products and more textfield in Header page using submit
		// function
		ele = header.getSearch_for_products_and_more_textfield();
		ele.click();
		// Enter invalid into Search for products and more textfield in Header page
		String invalid = "gkjbcmwdbjkc";
		ele.sendKeys(invalid);
		pass(invalid+" entered into the Search for product and more textfield");
		// Click on Search icon in Header page
		header.getSearch_icon().click();
		u.isClicked("Search icon in Header page");
		// Wait till Sorry message text in Wishlist page is visible
		wait.until(ExpectedConditions.visibilityOf(wishlist.getSorry_message_Text()));
		pass(" waited till visibility of sorry message");
		// Verify if Sorry message text is displayed in Wishlist page
		b = wishlist.getSorry_message_Text().isDisplayed();
	u.checkIsDisplayed(b, "Sorry message text ");
		Assert.assertEquals(b, true);
		bool = b;
	}
}

package test_Scripts.PLP_Web;
import static extentReporter.ExtentLogger.*;
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

public class PLP050 extends Base_Test {
	@Test
	public void main() throws Exception {
		className="PLP050";
		Utility u=new Utility();
		u.OpenBrowser();
		Home home = new Home(driver);
		Header header = new Header(driver);
		PLP plp = new PLP(driver);
		js = (JavascriptExecutor) driver;
		PDP pdp = new PDP(driver);
		String product = "Kurta";
		String category = "WOMEN";
		String subCategory = "Kurtas";
		Wishlist wishlist = new Wishlist(driver);
		WebDriverWait w = new WebDriverWait(driver, 1);
		
		boolean b = header.getPantaloons().isDisplayed();
		u.checkIsDisplayed(b, "Pantaloons logo");
		Assert.assertEquals(b, true);
		// image verifcation completed
		/// Navigate to PLP Page step grop start
		WebElement ele = home.getcategory(category);
		// Move mouse pointer on category link in Home page
		action.moveToElement(ele).perform();
		u.moveToElementMessage("category "+category);
		// 4 Wait till Sub Catgeory link in Header page is visible
		wait.until(ExpectedConditions.visibilityOf(header.getSub_Catgeory_Link(subCategory)));
		// Click on Sub Catgeory link in Header page
		header.getSub_Catgeory_Link(subCategory).click();
		u.moveToElementMessage("sub category "+ subCategory);
		// Verify if First Product image is displayed
		wait.until(ExpectedConditions.visibilityOf(plp.getFirst_Product_Image()));
		b = plp.getFirst_Product_Image().isDisplayed();
		u.checkIsDisplayed(b, "First product image");
		Assert.assertEquals(b, true);
		// end

		// Move mouse pointer on Pantaloons image in Home page
		ele = home.getPantaloons_Logo();
		action.moveToElement(ele).perform();
		u.moveToElementMessage("Pantaloon logo");
		// Verify if Breadcrumb text is displayed in PLP page
		b = plp.getBreadcrumb_text().isDisplayed();
		u.checkIsDisplayed(b, "Breadcrumb text");
		Assert.assertEquals(b, true);
		// Wait till SORT BY dropdown in PLP page is clickable
		wait.until(ExpectedConditions.elementToBeClickable(plp.getSORT_BY_dropdown()));
		// Click on SORT BY dropdown in PLP page
		plp.getSORT_BY_dropdown().click();
		u.isClicked("SORT BY dropdown");
		// Wait till Select Sort By text in PLP page is clickable
		String highToLow = "Price - High to Low";
		wait.until(ExpectedConditions.elementToBeClickable(plp.getSelect_Sort_By_text(highToLow)));
		// Click on Select Sort By text in PLP page
		plp.getSelect_Sort_By_text(highToLow).click();
		u.isClicked("Select Sort By: " +highToLow);
		// Verify if Select Sort By text is displayed in PLP page
		plp.getSelect_Sort_By_text(highToLow).isDisplayed();
		u.checkIsDisplayed(b, "Select Sort By: " +highToLow);
		Assert.assertEquals(b, true);
		bool=true;

	}
}

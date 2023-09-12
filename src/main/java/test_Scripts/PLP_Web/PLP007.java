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

public class PLP007 extends Base_Test{
	@Test
	public void main() throws Exception {
		className="PLP007";
		Utility u=new Utility();
		u.OpenBrowser();
		Home home = new Home(driver);
		Header header = new Header(driver);
		PLP plp = new PLP(driver);
		js = (JavascriptExecutor) driver;
		new PDP(driver);
		new Wishlist(driver);
		new WebDriverWait(driver, 1);
		
		boolean b = header.getPantaloons().isDisplayed();
		u.checkIsDisplayed(b, "Pantaloons logo");
		Assert.assertEquals(b, true);
		//image verifcation completed
		WebElement ele = home.getcategory("WOMEN");
		action.moveToElement(ele).perform();
		u.moveToElementMessage("category Women");
		// Wait till Sub Catgeory link in Header page is visible
		String subCategory="Kurtis & Tunics";
		ele = header.getSub_Catgeory_Link(subCategory);
		
		ele.click();
		u.isClicked("Sub_Catgeory_Link"+subCategory);
		// Verify if First Product image is displayed in PLP page
		 b = plp.getFirst_Product_Image().isDisplayed();
		 u.checkIsDisplayed(b, "First Product image");
		Assert.assertEquals(b, true);
		//Get text from BreadcrumbTwo text in PLP page
		String breadcrumbSubCatagory = plp.getBreadcrumbTwo_Text().getText();
		pass(breadcrumbSubCatagory+" breadcrumbSubCatagory");
		//Verify if string breadcrumbSubCatagory contains string subCategory
		b=breadcrumbSubCatagory.contains(subCategory);
		u.isContains(b, breadcrumbSubCatagory, subCategory);
		Assert.assertEquals(b, true);
		//Verify if PLP Category Page text is displayed in PLP page
		//Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOf(plp.getPLP_Category_Page_text2(subCategory)));
		b=plp.getPLP_Category_Page_text2(subCategory).isDisplayed();
		u.checkIsDisplayed(b, "PLP_Category_Page_text2 "+subCategory);
		System.out.println(b);
		Assert.assertEquals(b, true);
		//Verify if First Product image is displayed in PLP page
		b=plp.getFirst_Product_Image().isDisplayed();
		u.checkIsDisplayed(b, "First Product image");
		Assert.assertEquals(b, true);
		
		bool=true;
	}
}

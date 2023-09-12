package test_Scripts.PDP_Web;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;

import static extentReporter.ExtentLogger.*;

import java.util.ArrayList;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import generic.Base_Test;
import pom_scripts.web.Home;
import pom_scripts.web.Header.Header;
import pom_scripts.web.Header.PLP;
import pom_scripts.web.Header.Wishlist;
import pom_scripts.web.Header.Plp.PDP;
import generic.StepGroups;
import generic.Utility;

public class PDP045
		extends Base_Test {
	@Test
	public void main() throws Exception {
		className="PDP045";
		Utility u=new Utility();
		u.OpenBrowser();
		Home home = new Home(driver);
		Header header = new Header(driver);
		js = (JavascriptExecutor) driver;
		PDP pdp = new PDP(driver);
		PLP plp =new PLP(driver);
		StepGroups sg=new StepGroups(driver);
				
		boolean b = header.getPantaloons().isDisplayed();
		u.checkIsDisplayed(b, "Pantaloons logo");
		Assert.assertEquals(b, true);
		
		// image verifcation completed
		b = home.getMy_Account_icon().isDisplayed();
		u.checkIsDisplayed(b, "My Account icon");
		Assert.assertEquals(b, true);
		String category = "WOMEN";
		String subCategory = "WESTERN WEAR";
		int count;
		//Navigate to PLP Page
		sg.Navigate_to_PLP_Page(category, subCategory);
		
//		//Move mouse pointer on Pantaloons image in Home page
//		WebElement ele = home.getPantaloons_Logo();
//		action.moveToElement(ele).perform();
//		u.moveToElementMessage("Pantaloons logo");
		
		 String productNamePLP = plp.getProduct_Name_text().getText();
		 action.sendKeys(Keys.ARROW_DOWN).perform();
		 action.sendKeys(Keys.ARROW_DOWN).perform();
		 
		 pass("productNamePLP",true);
		//Click on First Product image in PLP page
		
		plp.getFirst_Product_Image().click();
		///Wait till Share image in PDP page is visible
		wait.until(ExpectedConditions.visibilityOf(pdp.getShareImage()));
		pass("waited till Share image in PDP page is visible ");
		//Get text from PDP ProductName text in PDP page
		 String productNamePDP = pdp.getPDP_ProductName_Text().getText();
		 pass("productNamePDP :"+ productNamePDP);
		
		
		//Verify_if_actualString_contains_expectedString in Mob_Scenario page
		b= sg.String1ContaisStrins2(productNamePDP,productNamePLP);
		// b=productNamePDP.contains((CharSequence) productNamePLP);
		u.isContains(b, productNamePDP, productNamePLP);
		
		try {
			wait.until(ExpectedConditions.visibilityOf(pdp.getSELECT_AVAILABLE_SIZE_button()));
			b=pdp.getSELECT_AVAILABLE_SIZE_button().isDisplayed();
		} catch (Exception e) {
			try {
				b=pdp.getSELECT_AVAILABLE_SIZE_button().isDisplayed();
				b=true;
			} catch (Exception e2) {
				b=false;
			}
		}
		ArrayList<String> sizeSelected = null ;
		u.checkIsDisplayed(b, "SELECT AVAILABLE SIZE");
		if(b) {
			//Verify if SELECT AVAILABLE SIZE button is displayed in PDP page
			b=pdp.getSELECT_AVAILABLE_SIZE_button().isDisplayed();
			u.checkIsDisplayed(b, "SELECT AVAILABLE SIZE");
			count=	driver.findElements(By.xpath("//div[contains(@class,\"size size-web\") and not(contains(@class,\"not-available\"))]/span")).size();
			pass("count of elements :"+count);
			//Click on SELECT AVAILABLE SIZE button in PDP page
			pdp.getSELECT_AVAILABLE_SIZE_button().click();
			u.isClicked("SELECT_AVAILABLE_SIZE_button");
			 sizeSelected = sg.WEB_GetTextFromListOfWebElement("//div[@class=\"size size-web selected\"]");
		
		}
		
		try {
			wait.until(ExpectedConditions.visibilityOf(pdp.getunavailable_Size_text()));
			b=pdp.getunavailable_Size_text().isDisplayed();
			pass("unavailable_Size_text is  displayed");
		} catch (Exception e) {
			try {b=pdp.getunavailable_Size_text().isDisplayed();
			pass("unavailable_Size_text is  displayed");
				
			} catch (Exception e2) {
				b=false;
				pass("unavailable_Size_text is not displayed");
			}
		}
		
		ArrayList<String> unavailablesizeinPDP;
		if(b) {
			b=pdp.getunavailable_Size_text().isDisplayed();
			u.checkIsDisplayed(b, "unavailable_Size_text");
			Assert.assertEquals(b, true);
			//web_countListofWebElements in WEB_Scenario page
			int countUnavailable = driver.findElements(By.xpath("//div[(contains(@class,\"not-available\"))]/span")).size();
			pass("countUnavailable "+countUnavailable );
			//WEB_GetTextFromListOfWebElement in WEB_Scenario page
			
			 unavailablesizeinPDP = sg.WEB_GetTextFromListOfWebElement("//div[(contains(@class,\"not-available\"))]/span");
			pass("WEB_GetTextFromListOfWebElement is "+arr );
		//	pass("unavailablesizeinPDP  "+unavailablesizeinPDP);
			//Verify is element is not Selected in Mob_Scenario page
			b=pdp.getunavailable_Size_text().isSelected();
			if(b) {
				fail("unavailable_Size_text is selected");
				Assert.fail();
			}
			else {
				pass("unavailable_Size_text is not selected");
			}

			//VerifyList1DoesNotContainsList2 in CommonProgramElement page
			
			sg.VerifyList1DoesNotContainsList2(sizeSelected,unavailablesizeinPDP);
			
		}
		
		
		
		
		
		
		
//		
//		
//		
//		
//		
//		//Navigate to PDP Page
//		sg.Navigate_to_PDP_Page();
//		
//		//Get text from Selected Size button in PDP page
//		String selectedSize = pdp.getSelected_Size_button().getText();
//		pass("selectedSize "+ selectedSize);
//		
//		//Print Value of selectedSize
//		System.out.println(selectedSize);
//		
//		//Verify if Selected Size button in PDP page is selected
//		b=pdp.getSelected_Size_button().getAttribute("class").contains("selected");
//		u.isContains(b, pdp.getSelected_Size_button().getAttribute("class"), "selected");
//		Assert.assertEquals(b, true);
//		bool=true;
	}
}

package test_Scripts.PDP_Web;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import generic.Base_Test;
import generic.StepGroups;
import generic.Utility;
import static extentReporter.ExtentLogger.*;

import pom_scripts.web.Home;
import pom_scripts.web.Header.Header;
import pom_scripts.web.Header.PLP;
import pom_scripts.web.Header.Wishlist;
import pom_scripts.web.Header.Plp.PDP;

public class PDP005 extends Base_Test {
	@Test
	public void main() throws Exception {
		className="PDP005";
		Utility u=new Utility();
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
		new Wishlist(driver);
		new WebDriverWait(driver, 1);
		//wait.until(ExpectedConditions.elementToBeClickable(home.getIlldothislater()));
		//home.getIlldothislater().click();
		boolean b = header.getPantaloons().isDisplayed();
		u.checkIsDisplayed(b, "Pantaloons logo");
		Assert.assertEquals(b, true);
		// image verifcation completed
		//number
		if(!deurgerMode)
			sg.Login_to_Pantaloons();
		//Move mouse pointer on category link in Home page
		action.moveToElement(home.getcategory("MEN")).perform();
		u.moveToElementMessage("Categoy men ");
		//Get text from category link in Home page
		String categoryName = home.getcategory("MEN").getText();
		pass(categoryName+" fetched form category");
		//Wait till Men_Sub_Category link in Header page is visible
		wait.until(ExpectedConditions.visibilityOf(header.getMen_Sub_Category("Pyjamas & Salwar")));
		//Get text from Men Sub-Category link in Header page
		String subcategoryName = header.getMen_Sub_Category("Pyjamas & Salwar").getText();
		pass(subcategoryName+" subcategoryName");
		header.getMen_Sub_Category("Pyjamas & Salwar").click();
		u.isClicked("subcategoryName Pyjamas & Salwar");
		//Move mouse pointer on Pantaloons Logo image in Home page
		action.moveToElement(home.getPantaloons_Logo()).perform();
		u.moveToElementMessage("Pantaloons logo");
		//Verify if Breadcrumb text is displayed in PLP page
		b=plp.getBreadcrumb_text().isDisplayed();
		u.checkIsDisplayed(b, "Breadcrumb text");
		Assert.assertEquals(b, true);
		//Get text from BreadcrumbOne_text in PLP page
		String breadcrumbOne = plp.getBreadcrumbOne_text().getText();
		pass(breadcrumbOne+" breadcrumbOne");
		//Get text from BreadcrumbTwo text in PLP page
		String breadcrumbTwo = plp.getBreadcrumbTwo_Text().getText();
		pass(breadcrumbTwo+" breadcrumbTwo");
	//	Verify if string breadcrumbOne matches string categoryName
		b=breadcrumbOne.equalsIgnoreCase(categoryName);
		u.isContains(b, breadcrumbOne, categoryName);
		System.out.println(breadcrumbOne);
		System.out.println(categoryName);
		Assert.assertEquals(b, true);
		//Verify if string breadcrumbTwo matches string subcategoryName
		b=breadcrumbTwo.matches(subcategoryName);
		u.isContains(b, breadcrumbTwo, subcategoryName);
		Assert.assertEquals(b, true);
		sg.Get_Product_Details_In_PLP_Copy();
		sg.Get_Product_Details_In_PDP();
		sg.Verify_PLP_and_PDP_Products_are_same();
		bool=true;
	}
}

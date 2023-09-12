package test_Scripts;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import static extentReporter.ExtentLogger.*;

import com.aventstack.extentreports.Status;

import generic.Base_Test;
import generic.Utility;
import pom_scripts.web.Home;
import pom_scripts.web.Header.Header;
import pom_scripts.web.Header.Login;

public class HM001 extends Base_Test {
	@Test(priority = 1)
	public void VerifyTheFunctionalityOfCategoriesForNonLoggedInUser() throws Exception {

		Utility utility = new Utility();
		utility.OpenBrowser();
		Login login = new Login(driver);

		try {
			className = "HM001";
			// ExtentConfig.createTest(className);
			Home home = new Home(driver);
			Header header = new Header(driver);
			// Verify if Pantaloons image is displayed in Header page
			boolean b = header.getPantaloons().isDisplayed();
			if (b) {
				utility.checkAssert(b, "Pantaloons logo is displayed");
			} else {
				utility.checkAssert(b, "Pantaloons logo is not displayed");
			}
			Assert.assertEquals(b, true);

			// Verify if My Account icon is displayed in Home page
			b = home.getMy_Account().isDisplayed();
			if (b) {
				utility.checkAssert(b, "My_Account icon is displayed");
			} else {
				utility.checkAssert(b, "My_Account icon not displayed");
				// assertSame(home, header);
				Assert.assertEquals(b, true);
			}

			// Click on My Account icon in Home page
			home.getMy_Account().click();
			pass(" My Account icon in Home page is clciked");
			// Login login=new Login(driver);
			// Verify if Login/Register text is displayed in Login page
			b = login.getLoginRegister().isDisplayed();
			if (b) {
				utility.checkAssert(b, "Login/Register text is displayed");
			} else {
				utility.checkAssert(b, "Login/Register text not displayed");
				// assertSame(home, header);
				Assert.assertEquals(b, true);
			}

			// Click on Pantaloons Logo image in Home page using javascript executor
			home.getPantaloons_Logo().click();
			pass("clicked on Pantaloons Logo image in Home page");
			// women clicked
			// Verify if category link is displayed in Home page
			b = home.getcategory("WOMEN").isDisplayed();
			if (b) {
				utility.checkAssert(b, "category link is(WOMEN) displayed in Home page");
			} else {
				utility.checkAssert(b, "category link(WOMEN) is not  displayed in Home page");
				// assertSame(home, header);
				Assert.assertEquals(b, true);
			}
			// Move mouse pointer on category link in Home page
			action.moveToElement(home.getcategory("WOMEN")).build().perform();
			pass("Mouse pointer moved on  category link(WOMEN) in home page");
			// Verify if Women Category link is displayed in Header page
			b = header.getWomen_Category("WESTERN WEAR").isDisplayed();
			if (b) {
				utility.checkAssert(b, " Women Category link is displayed in Header page");
			} else {
				utility.checkAssert(b, " Women Category link not displayed in Header page");
				Assert.assertEquals(b, true);
			}
			// Verify if category link is displayed in Home page
			action.moveToElement(header.getWomen_Category("WESTERN WEAR")).build().perform();
			pass("mouse moved to the element WESTEN WERE");
			// men move
			header.getPantaloons().click();
			pass("Clecked on pantaloons logo");
			// home=new Home(driver);
			WebElement ele = home.getcategory("MEN");
			b = ele.isDisplayed();
			if (b) {
				utility.checkAssert(b, " men Category link is displayed in Header page");
			} else {
				utility.checkAssert(b, " nem Category link not displayed in Header page");
				Assert.assertEquals(b, true);
			}
			action.moveToElement(ele).build().perform();
			pass("mouse moved on MEN");
			b = header.getMen_Category("Formal Shirts").isDisplayed();
			utility.checkIsDisplayed(b, "Formal Shitrs");
			// kids clicked
			header.getPantaloons().click();
			pass("clicked on pantallons logo");
			ele = home.getcategory("KIDS");
			b = ele.isDisplayed();

			utility.checkIsDisplayed(b, "KIDS category");
			action.moveToElement(ele).build().perform();
			pass("mouse moved to KIDS");
			b = header.getKids_Category("BOYS").isDisplayed();
			utility.checkIsDisplayed(b, "BOYS");
			// home
			header.getPantaloons().click();
			pass("clicked on pantallons logo");
			ele = home.getcategory("HOME");
			b = ele.isDisplayed();
			utility.checkIsDisplayed(b, " category HOME ");
			action.moveToElement(ele).build().perform();
			pass("mouse moved ont category HOME");
			b = header.getHome_category("DECOR").isDisplayed();
			utility.checkIsDisplayed(b, "DECOR ");
			// ACCESSORIES category
			header.getPantaloons().click();
			pass("Clicked on pantaloons logo");
			ele = home.getcategory("ACCESSORIES");
			b = ele.isDisplayed();
			utility.checkIsDisplayed(b, " ACCESSORIES category");
			action.moveToElement(ele).build().perform();
			pass("mouse moved on  ACCESSORIES category");
			b = header.getAccessories_Category("BAGS").isDisplayed();
			utility.checkIsDisplayed(b, "BAG");
			/// BRANDS
			ele = home.getcategory("BRANDS");
			b = ele.isDisplayed();
			utility.checkIsDisplayed(b, "BRANDS");
			ele.click();
			pass("Clicked on BRANDS");
			b = home.getBrands_in_Focus().isDisplayed();
			utility.checkIsDisplayed(b, "Brands_in_Focus");
			bool = true;
		} catch (Exception e) {
			System.out.println(e);
			test.log(Status.FAIL, e.toString());
		}

	}

}

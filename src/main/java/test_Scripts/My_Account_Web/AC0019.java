package test_Scripts.My_Account_Web;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import generic.Base_Test;
import generic.StepGroups;
import generic.Utility;
import pom_scripts.My_Account.My_Orders;
import pom_scripts.web.Home;
import pom_scripts.web.Header.Bag;
import pom_scripts.web.Header.Header;
import pom_scripts.web.Header.PLP;
import pom_scripts.web.Header.Wishlist;
import pom_scripts.web.Header.Checkout.Address;
import pom_scripts.web.Header.Checkout.Checkout;
import pom_scripts.web.Header.Checkout.Payment;
import pom_scripts.web.Header.Plp.PDP;
import pom_scripts.web.Header.Plp.Quick_View;

public class AC0019 extends Base_Test {

	@Test
	public void main() throws Exception {
		Utility utility = new Utility();
		if (deurgerMode) {
			utility.BrowserInDeburger();
		}
		else {
			utility.OpenBrowser();
		}
		className = "AC0019";
		new Address(driver);
		Home home = new Home(driver);
		My_Orders myOrder = new My_Orders(driver);
		Header header = new Header(driver);
		PLP plp = new PLP(driver);
		js = (JavascriptExecutor) driver;
		new PDP(driver);
		Payment payment = new Payment(driver);
		Checkout checkout = new Checkout(driver);
		System.out.println("before");
		StepGroups sg = new StepGroups(driver);
		new Wishlist(driver);
		new WebDriverWait(driver, 1);
		new Quick_View(driver);
		Bag bag = new Bag(driver);
//		wait.until(ExpectedConditions.elementToBeClickable(home.getIlldothislater()));
//		home.getIlldothislater().click();
//		// image verified
//		// Login to Pantaloons
		if(!deurgerMode)
			sg.Login_to_Pantaloons();
		// Delete Multiple Products From Bag
		sg.Delete_Multiple_Products_From_Bag();
		// Navigate to PLP Page - Copy
		sg.Navigate_to_PLP_Page("WOMEN", "Kurtas");
		// Move mouse pointer on Pantaloons Logo image in Home page
		action.moveToElement(home.getPantaloons_Logo()).perform();
		// Move mouse pointer on First Product image in PLP page
		wait.until(ExpectedConditions.elementToBeClickable(plp.getFirst_Product_Image()));
		action.moveToElement(plp.getFirst_Product_Image()).perform();
		utility.moveToElementMessage("First_Product_Image");
		// Verify if QUICK VIEW button is displayed in PLP page
		boolean b = plp.getQUICK_VIEW_button().isDisplayed();
		utility.checkIsDisplayed(b, "QUICK VIEW button");
		Assert.assertEquals(b, true);
		// Click on QUICK VIEW button in PLP page
		plp.getQUICK_VIEW_button().click();
		utility.isClicked("QUICK VIEW button");
		// Verify if Quick view popup is displayed in PLP page
		b = plp.getQuick_view_popup().isDisplayed();
		utility.checkIsDisplayed(b, "Quick view popup ");
		Assert.assertEquals(b, true);
		// Add product to Bag from Quick View
		sg.Add_product_to_Bag_from_Quick_View();
//		/Verify if My Bag text is displayed in Bag page
		b = bag.getMy_Bag_Page_text().isDisplayed();
		utility.checkIsDisplayed(b, "My Bag text");
		Assert.assertEquals(b, true);
		// Scroll page vertically until visibility of Order Summary text in Bag page
		js.executeScript("arguments[0].scrollIntoView(true);", bag.getOrder_Summary_text());
		utility.moveToElementMessage("Order Summary text ");
		// Wait till CHECKOUT button in Bag page is clickable
		wait.until(ExpectedConditions.elementToBeClickable(bag.getCHECKOUT_button()));
		// Click on CHECKOUT button in Bag page
		bag.getCHECKOUT_button().click();
		utility.isClicked("CHECKOUT button");
		// Verify if Checkout_text is displayed in Home page
		b = home.getCheckout_text().isDisplayed();
		utility.checkIsDisplayed(b, "Checkout_text");
		Assert.assertEquals(b, true);
		// Click on PROCEED TO PAY button in Checkout page
		checkout.getPROCEED_TO_PAY_button().click();
		utility.isClicked("PROCEED TO PAY button");
		// Wait till Pay with Paytm Wallet/Saved Cards button in Paytm page is visible
		wait.until(ExpectedConditions.visibilityOf(payment.getPay_with_Paytm_Wallet_Saved_Cards()));
		// Wait till Pay with Paytm Wallet/Saved Cards button in Paytm page is clickable
		wait.until(ExpectedConditions.elementToBeClickable(payment.getPay_with_Paytm_Wallet_Saved_Cards()));
		// Click on Pay with Paytm Wallet/Saved Cards button in Paytm page
		payment.getPay_with_Paytm_Wallet_Saved_Cards().click();
		utility.isClicked(" Paytm Wallet/Saved Cards button");
		// Click on PaytmProceedtoPay button in Payment page
		payment.getPaytmProceedtoPay_button().click();
		utility.isClicked("PaytmProceedtoPay button");
		// Wait till paytm_PG_text in Paytm page is visible
		Thread.sleep(1000);
		// wait.until(ExpectedConditions.visibilityOf(payment.getpaytm_PG_text()));
		// Verify if paytm PG text is displayed in Paytm page
		b = payment.getpaytm_PG_text().isDisplayed();
		utility.checkIsDisplayed(b, "paytm PG text");
		Assert.assertEquals(b, true);
		// Click on Back_arrow_button in Payment page
		payment.getBack_arrow_button().click();
		utility.isClicked("Back_arrow_button ");
		// Click on Skip_Feedback_button in Paytm page
		payment.getSkip_Feedback_button().click();
		utility.isClicked("Skip_Feedback_button");
		// Wait till Pantaloons image in Header page is clickable
		wait.until(ExpectedConditions.visibilityOf(header.getPantaloons()));
		wait.until(ExpectedConditions.elementToBeClickable(header.getPantaloons()));
		// Click on Pantaloons image in Header page
		header.getPantaloons().click();
		utility.isClicked("Pantaloons image");
		
		// Click on My Account icon in Home page
		home.getMy_Account_icon().click();
		utility.isClicked("My Account icon");
		// Verify if MY_ORDERS_button is displayed in My Orders page
		b = myOrder.getMY_ORDERS_Button().isDisplayed();
		utility.checkIsDisplayed(b, "MY_ORDERS_button");
		Assert.assertEquals(b, true);
		// Wait till MY ORDERS button in My Orders page is clickable
		wait.until(ExpectedConditions.elementToBeClickable(myOrder.getMY_ORDERS_Button()));
		// Click on MY ORDERS button in My Orders page
		myOrder.getMY_ORDERS_Button().click();
		utility.isClicked("MY_ORDERS_button");
		// Wait till My Orders text in My Orders page is visible
		wait.until(ExpectedConditions.visibilityOfAllElements(myOrder.getMy_Orders_text()));
		// Verify if My Orders text is displayed in My Orders page
		b = myOrder.getMy_Orders_text().isDisplayed();
		utility.checkIsDisplayed(b, "My Orders text");
		Assert.assertEquals(b, true);
		// Verify if Ordered_Product_image is displayed in My Orders page
		b = myOrder.getOrdered_Product_image().isDisplayed();
		utility.checkIsDisplayed(b, "Ordered_Product_image");
		Assert.assertEquals(b, true);
		bool = true;
	}

}

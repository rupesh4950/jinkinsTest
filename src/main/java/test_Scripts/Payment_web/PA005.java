package test_Scripts.Payment_web;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import generic.Base_Test;
import generic.StepGroups;
import generic.Utility;
import pom_scripts.web.Home;
import pom_scripts.web.Header.Bag;
import pom_scripts.web.Header.PLP;
import pom_scripts.web.Header.Checkout.Checkout;
import pom_scripts.web.Header.Checkout.Payment;

public class PA005 extends Base_Test {

	@Test
	public void main() throws Exception {
		className="PA005";
		Utility utility=new Utility();
		if(deurgerMode) {
			utility.BrowserInDeburger();
		}
		else {
			utility.OpenBrowser();
		}
		
		Home home = new Home(driver);
		
		PLP plp = new PLP(driver);
		js = (JavascriptExecutor) driver;
		
		Payment payment=new Payment(driver);
		Checkout checkout=new Checkout(driver);
		StepGroups sg = new StepGroups(driver);
		
		Bag bag = new Bag(driver);
//		wait.until(ExpectedConditions.elementToBeClickable(home.getIlldothislater()));
//		home.getIlldothislater().click();
		//image verified
		//Login to Pantaloons
	
		if((!deurgerMode))
			sg.Login_to_Pantaloons();
		//Navigate to PLP Page - Copy
		sg.Navigate_to_PLP_Page("WOMEN", "Winter Kurta");
		//Move mouse pointer on First Product image in PLP page
		WebElement ele = plp.getFirst_Product_Image();
		action.moveToElement(ele).perform();
		utility.moveToElementMessage(" First Product image");
		//Click on QUICK VIEW button in PLP page
		plp.getQUICK_VIEW_button().click();
		utility.isClicked("QUICK VIEW button");
		//Wait till presence of element with xpath 
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(@class,'MuiGrid-root QuickView__quickview-container')]")));
		//Verify if Quick view popup is displayed in PLP page
		boolean b = plp.getQuick_view_popup().isDisplayed();
		utility.checkIsDisplayed(b, "Quick view popup ");
		Assert.assertEquals(true, b);
		//Add product to Bag from Quick View
		sg.Add_product_to_Bag_from_Quick_View();
		//Scroll page vertically until visibility of Order_Summary_text in Bag page
		js.executeScript("arguments[0].scrollIntoView(true);", bag.getOrder_Summary_text());;
		//Wait till CHECKOUT button in Bag page is clickable
		wait.until(ExpectedConditions.elementToBeClickable(bag.getCHECKOUT_button()));
		//Click on CHECKOUT button in Bag page using javascript executor
		js.executeScript("arguments[0].click();", bag.getCHECKOUT_button());
		utility.isClicked("CHECKOUT button");
		//Wait till Checkout_page_text in Home page is visible
		wait.until(ExpectedConditions.visibilityOf(home.getCheckout_page_text()));
		//Click on PROCEED TO PAY button in Checkout page using javascript executor
		js.executeScript("arguments[0].click();", checkout.getPROCEED_TO_PAY_button());
		utility.isClicked("PROCEED TO PAY");
		//Wait till presence of element with xpath //div[@id="panel3d-header"]//p[text()='Payment']
		//wait.until(ExpectedConditions.presenceOfElementLocated(By.className("//div[@id=\"panel3d-header\"]//p[text()='Payment']")));
		//Click on PaytmProceedtoPay_button in Payment page
		Thread.sleep(1000);
		js.executeScript("arguments[0].click();", payment.getPaytmProceedtoPay_button());
		utility.isClicked("PaytmProceedtoPay_button");
		//Wait till paytm logo image is visible
		wait.until(ExpectedConditions.visibilityOf(plp.getpaytm_logo()));
		//Verify if paytm logo image is displayed in PLP page
		b=plp.getpaytm_logo().isDisplayed();
		utility.checkIsDisplayed(b, " paytm logo image");
		Assert.assertEquals(true, b);
		bool=true;
	}

}

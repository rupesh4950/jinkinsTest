package test_Scripts.My_Orders_Web;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import generic.Base_Test;
import generic.StepGroups;
import generic.Utility;
import pom_scripts.My_Account.My_Orders;
import pom_scripts.web.Home;
import pom_scripts.web.Header.Header;
import pom_scripts.web.Header.Login;

public class MO012 extends Base_Test {
	@Test(priority = 1)
	public void main() throws Exception, Exception {
		className="MO012";
		Utility utility=new Utility();
		if(deurgerMode) {
			utility.BrowserInDeburger();
		}
		else {
			utility.OpenBrowser();
		}
		
		Home home = new Home(driver);
		Header header = new Header(driver);
		js = (JavascriptExecutor) driver;
		Login login = new Login(driver);
		My_Orders myOrder=new My_Orders(driver);
		StepGroups sg = new StepGroups(driver);
//		wait.until(ExpectedConditions.elementToBeClickable(home.getIlldothislater()));
//		home.getIlldothislater().click();
		boolean b = header.getPantaloons().isDisplayed();
		utility.checkIsDisplayed(b, "Pantaloons logo");
		Assert.assertEquals(b, true);
		
		// image verifcation completed
		//mobile number should be enaterd
		if(!deurgerMode)
			sg.Login_to_Pantaloons();
		//Click on My Account icon in Home page
		home.getMy_Account_icon().click();
		utility.isClicked("My Account icon");
		//Wait till MY ORDERS button in My Orders page is clickable
		wait.until(ExpectedConditions.elementToBeClickable(myOrder.getMY_ORDERS_Button()));
		//Click on MY ORDERS button in My Orders page
		myOrder.getMY_ORDERS_Button().click();
		utility.isClicked("MY ORDERS button");
		
		//Verify if My Orders text is displayed in My Orders page
		b=myOrder.getMy_Orders_text().isDisplayed();
		utility.checkIsDisplayed(b, "My Orders text ");
		Assert.assertEquals(b, true);
	//	wait.until(ExpectedConditions.visibilityOf(myOrder.getOnline_Orders_radiobutton()));
		//Verify if Online Orders radiobutton is displayed in My Orders page
//		myOrder=new My_Orders(driver);
//		Thread.sleep(50000);
//		myOrder.getOnline_Orders_radiobutton().click();
//		b=myOrder.getOnline_Orders_radiobutton().isDisplayed();
//		Assert.assertEquals(b, true);
//		//Verify if VIEW_DETAILS_button is displayed in My Orders page
		b=myOrder.getVIEW_DETAILS_button().isDisplayed();
		utility.checkIsDisplayed(b, "VIEW_DETAILS_button");
		Assert.assertEquals(b, true);
		//Verify if VIEW_DETAILS_button in My Orders page is clickable
		wait.until(ExpectedConditions.elementToBeClickable(myOrder.getMY_ORDERS_Button()));
		//Click on VIEW DETAILS button in My Orders page
		myOrder.getVIEW_DETAILS_button().click();
		utility.isClicked("VIEW DETAILS button");
		//Wait till ordersImage image in Login page is visible
		wait.until(ExpectedConditions.visibilityOf(login.getordersImage_image()));
		//Verify if ordersImage image is displayed in Login page
		b=login.getordersImage_image().isDisplayed();
		utility.checkIsDisplayed(b, "ordersImage image ");
		Assert.assertEquals(b, true);
		List<WebElement> l = driver.findElements(By.xpath("//div[contains(@class,'order_image')]//img[contains(@class,'order_image')]"));
		l.size();
		Thread.sleep(2000);
		//Verify if product order number text is displayed in My Orders page
	//	System.out.println(driver.findElement(By.xpath("//div[contains(@class,'order_order-summary-header')]")).isDisplayed());
		b=myOrder.getproduct_order_number_text().isDisplayed();
		utility.checkIsDisplayed(b, "product order number text");
		Assert.assertEquals(b, true);
		bool=true;
	}

}

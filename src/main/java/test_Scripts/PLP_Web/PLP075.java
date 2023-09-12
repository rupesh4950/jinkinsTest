package test_Scripts.PLP_Web;

import java.time.Duration;
import java.util.List;
import static extentReporter.ExtentLogger.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
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

public class PLP075 extends Base_Test {
	@Test
	public void main() throws Exception {
		className="PLP075";
		Utility u=new Utility();
		u.OpenBrowser();
		Home home = new Home(driver);
		Header header = new Header(driver);
		PLP plp = new PLP(driver);
		js = (JavascriptExecutor) driver;
		new PDP(driver);
		String category = "WOMEN";
		String subCategory = "Kurtas";
		new Wishlist(driver);
		new WebDriverWait(driver, 1);
		
		boolean b = header.getPantaloons().isDisplayed();
		u.checkIsDisplayed(b, "Pantaloons logo");
		Assert.assertEquals(b, true);
		// image verifcation completed
		// Move mouse pointer on category link in Home page
		action.moveToElement(home.getcategory(category)).perform();
		u.moveToElementMessage("category "+ category);
		// 4 Wait till Sub Catgeory link in Header page is visible
		wait.until(ExpectedConditions.visibilityOf(header.getSub_Catgeory_Link(subCategory)));
		// Click on Sub Catgeory link in Header page
		header.getSub_Catgeory_Link(subCategory).click();
		u.isClicked("sub categroy "+ subCategory);
		// Scroll page vertically until visibility of FILTER BY text in PLP page
		action.moveToElement(plp.getFILTER_BY_text()).perform();
		u.moveToElementMessage(" FILTER BY text");
		// Wait till First Product image in PLP page is visible
		wait.until(ExpectedConditions.visibilityOf(plp.getFirst_Product_Image()));
		// Move mouse pointer on First Product image in PLP page
		action.moveToElement(plp.getFirst_Product_Image()).perform();
		u.moveToElementMessage("First_Product_Image");
		// Wait till QUICK VIEW button in PLP page is visible
		wait.until(ExpectedConditions.visibilityOf(plp.getQUICK_VIEW_button()));
		// Wait till QUICK VIEW button in PLP page is clickable
		wait.until(ExpectedConditions.elementToBeClickable(plp.getQUICK_VIEW_button()));
		// Click on QUICK VIEW button in PLP page
		// js.executeScript("arguments[0].scrollIntoView(true);",
		// plp.getQUICK_VIEW_button());
		wait.until(ExpectedConditions.elementToBeClickable(plp.getQUICK_VIEW_button()));
		plp.getQUICK_VIEW_button();
		// action.moveByOffset(ele.getLocation().x+ele.getSize().width/2,
		// ele.getLocation().y+ele.getSize().height/2).click().perform();;
		// action.moveToElement(ele).pause(Duration.ofSeconds(2)).perform();
		// action.moveToElement(plp.getFirst_Product_Image()).perform();
		// action.moveToElement(driver.findElement(By.xpath("//div[@id=\"products-wrapper\"]//button[@aria-label=\"add
		// to favorites\"]/../..//div/following-sibling::img"))).build().perform();
		plp.getQUICK_VIEW_button().click();
		u.isClicked("QUICK_VIEW_button");
		wait.until(
				ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(@class,'quickview-container')]")));
		// Verify if Quick view main image is displayed in Quick View page
		b = plp.getQuick_view_main_image().isDisplayed();
		u.checkIsDisplayed(b, "Quick view");
		// System.out.println(b);
		Assert.assertEquals(b, true);
		// count list of web elements
		List<WebElement> l = driver.findElements(By.xpath("//div[contains(@class,'QuickView__thumbnail-image')]"));
		System.out.println(l.size());
		pass(l.size()+" ");
		bool=true;
	}

}

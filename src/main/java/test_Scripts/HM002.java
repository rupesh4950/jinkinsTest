package test_Scripts;
import static extentReporter.ExtentLogger.*;
import static org.testng.Assert.expectThrows;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
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

public class HM002 extends Base_Test {
	@Test(priority = 1)
	public void main() {
		
		className="HM002";
		Utility utility=new Utility();
		utility.OpenBrowser();
		Home home = new Home(driver);
		Header header = new Header(driver);
		PLP plp = new PLP(driver);
		js = (JavascriptExecutor) driver;

		boolean b = header.getPantaloons().isDisplayed();
		utility.checkIsDisplayed(b, "Pantaloons");
		Assert.assertEquals(b, true);
		// 4 Verify if Banner link is displayed in Home page
		b = home.getBanner().isDisplayed();
		
		utility.checkIsDisplayed(b, "Banner");
		System.out.println(URL);
		Assert.assertEquals(b, true);
		int n=driver.findElements(By.xpath("//span[contains(@aria-label,'Go to slide')]")).size();
		  ArrayList<WebElement> hrefs = (ArrayList<WebElement>) driver.findElements(By.xpath("//a[@title=\"Click to view\"]"));
		for (int i =1;i<=n;i++) {
			WebElement ele = home.getswiper_bullet(i+"");
			js.executeScript("arguments[0].click();", ele);
			String link = driver.findElement(By.xpath("//div[contains(@aria-label,'"+i+" / "+n+"')]/a")).getAttribute("href");
			//String link=hrefs.get(i).getAttribute("href");
			
			pass("Clicked on swiper bullet");
			ele = home.getBanner_Image(i+"");
			js.executeScript("arguments[0].click();", ele);
			pass("Clicked on image");
			String curl = driver.getCurrentUrl();
			if(curl.contains(link)) {
				System.out.println(true);
			utility.isContains(true, curl, link);
			}
			else {
				utility.isContains(false, curl, link);
				Assert.fail();
			}
			driver.navigate().to(URL);
		}
//		// 5 Click on swiper bullet button in Home page using js
//		WebElement ele = home.getswiper_bullet("1");
//		js.executeScript("arguments[0].click();", ele);
//		pass("Clecked on swiper bullet");
//
//		// 6 Get title attribute value of Banner image
//		ele = home.getBanner_Image("2");
//		String bannerTit = ele.getAttribute("title");
//		pass(bannerTit+" is fetched");
//		// 7 Click on banners image in Home page using javascript executor
//		ele = home.getbanners_Image("2");
//		js.executeScript("arguments[0].click();", ele);
//		pass("clicked on Banner image");
//		// ele.click();
//
//		/// change in script verify sub banner//
//		// 8Get text from BreadcrumbTwo text in PLP page
//		try {
//			String isDisplayed = plp.getBreadcrumbTwo_Text().getText();
//			//System.out.println(isDisplayed);
//			// 9Verify if First Product image is displayed in PLP page
//			b = plp.getFirst_Product_Image().isDisplayed();
//			utility.checkIsDisplayed(b, "First Product image");
//			Assert.assertEquals(b, true);
//		} catch (Exception e) {
//			b = driver.findElement(By.xpath("//div[@class='SubBanner_sub-banner-double__KzWC8']")).isDisplayed();
//			utility.checkIsDisplayed(b, "//div[@class='SubBanner_sub-banner-double__KzWC8']");
//		}
//
//		// 11 click on pantalons logo
//		home.getPantaloons_Logo().click();
//		
//		utility.isClicked("Pantallons logo");
//		
//		// 12 Click on swiper bullet button in Home page using javascript executor
//		ele = home.getswiper_bullet("3");
//		js.executeScript("arguments[0].click();", ele);
//		utility.isClicked("Swiper bullet button in home page");
//
//		// 13 Click on banners image in Home page using javascript executor
//		ele = home.getbanners_Image("3");
//		js.executeScript("arguments[0].click();", ele);
//		utility.isClicked("banners_Image in home page");
//		
//		
//		try {
//			WebDriverWait wait1 = new WebDriverWait(driver, 5);
//			Thread.sleep(5);
//			String isDisplayed = plp.getBreadcrumbTwo_Text().getText();
//			//System.out.println(isDisplayed);
//			b = plp.getFirst_Product_Image().isDisplayed();
//			utility.checkIsDisplayed(b, "First product ");
//			Assert.assertEquals(b, true);
//		} catch (Exception e) {
//			b = driver.findElement(By.xpath("//div[@class='SubBanner_sub-banner-double__KzWC8']")).isDisplayed();
//			Assert.assertEquals(b, true);
//			utility.checkIsDisplayed(b, "//div[@class='SubBanner_sub-banner-double__KzWC8']");
//		}
//		// 14Navigate to previous page in browser window
//		driver.navigate().back();
//		pass("Navigate back successfully");
//		// 17 Click on swiper bullet button in Home page
//		ele = home.getswiper_bullet("4");
//		js.executeScript("arguments[0].click();", ele);
//		utility.isClicked("Swiper bullet button in home page");
//		//18Get title attribute value of Banner image in Home page
//		WebElement bannerTitle = home.getBanner_Image("4");
//		//19Click on Banner image in Home page
//		home.getBanner_Image("4").click();
//		utility.isClicked("Banner image in Home page");
//		try {
//			Thread.sleep(5);
//			String isDisplayed = plp.getBreadcrumbTwo_Text().getText();
//			//System.out.println(isDisplayed);
//			b = plp.getFirst_Product_Image().isDisplayed();
//			utility.checkIsDisplayed(b, "First prouct image");
//			Assert.assertEquals(b, true);
//		} catch (Exception e) {
//			b = driver.findElement(By.xpath("//div[@class='SubBanner_sub-banner-double__KzWC8']")).isDisplayed();
//			utility.checkIsDisplayed(b, "//div[@class='SubBanner_sub-banner-double__KzWC8']\"");
//			Assert.assertEquals(b, true);
//		}
//	
//		/////
//		// 22Navigate to previous page in browser window
//		driver.navigate().back();
//		pass("Navigated back successfully");
//		// 23 Click on swiper bullet button in Home page
//		ele = home.getswiper_bullet("5");
//		js.executeScript("arguments[0].click();", ele);
//		utility.isClicked("Swiper bullet button in home page");
//		//24Get title attribute value of Banner image in Home page
//		 bannerTitle = home.getBanner_Image("5");
//		//25Click on Banner image in Home page
//		home.getBanner_Image("5").click();
//		utility.isClicked("Banner image in Home page");
//		try {
//			Thread.sleep(5);
//			String isDisplayed = plp.getBreadcrumbTwo_Text().getText();
//			//System.out.println(isDisplayed);
//			b = plp.getFirst_Product_Image().isDisplayed();
//			utility.checkIsDisplayed(b, "BreadcrumTwo text");
//			Assert.assertEquals(b, true);
//		} catch (Exception e) {
//			b = driver.findElement(By.xpath("//div[@class='SubBanner_sub-banner-double__KzWC8']")).isDisplayed();
//			utility.checkIsDisplayed(b, "//div[@class='SubBanner_sub-banner-double__KzWC8']");
//			Assert.assertEquals(b, true);
//		}
//		////////////////////////
//		// 29 Navigate to previous page in browser window
//				driver.navigate().back();
//				pass("Navigated back");
//				// 31 Click on swiper bullet button in Home page
//				ele = home.getswiper_bullet("6");
//				js.executeScript("arguments[0].click();", ele);
//				utility.isClicked("Swiper bullet button in home page");
//
//				//32 Get title attribute value of Banner image in Home page
//				 bannerTitle = home.getBanner_Image("6");
//				 pass(bannerTitle+" is fetched");
//				//33 Click on Banner image in Home page
//				home.getBanner_Image("6").click();
//				utility.isClicked("Banner image ");
//				try {
//					Thread.sleep(5);
//					String isDisplayed = plp.getBreadcrumbTwo_Text().getText();
//					////System.out.println(isDisplayed);
//					b = plp.getFirst_Product_Image().isDisplayed();
//					utility.checkIsDisplayed(b, "First product image ");
//					Assert.assertEquals(b, true);
//				} catch (Exception e) {
//					b = driver.findElement(By.xpath("//div[@class='SubBanner_sub-banner-double__KzWC8']")).isDisplayed();
//					utility.checkIsDisplayed(b, "//div[@class='SubBanner_sub-banner-double__KzWC8']");
//					Assert.assertEquals(b, true);
//				}
				System.out.println("all completed");
				bool=true;
}}

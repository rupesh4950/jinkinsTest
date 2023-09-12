package test_Scripts;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import generic.Base_Test;
import generic.StepGroups;
import generic.Utility;
import pom_scripts.web.Home;
import pom_scripts.web.Header.Plp.PDP;
import static extentReporter.ExtentLogger.*;
public class HM022 extends Base_Test {
	@Test(priority = 1)
	public void main() {
		className="HM022";
		Utility utility = new Utility();
		utility.OpenBrowser();
		pass("Browser opened");
	//	ExtentConfig.createTest(className);
		boolean b=false;
		Home home = new Home(driver);
		js = (JavascriptExecutor) driver;
		PDP pdp=new PDP(driver);
		StepGroups sg=new StepGroups(driver);
		WebDriverWait w=new WebDriverWait(driver, 1);
		
		//Load current page completely
		sg.Load_current_page_completely();
		//Scroll page vertically until visibility of Trending Now text in Home page
		action.moveToElement(home.getTrending_Now_text()).perform();;
		utility.moveToElementMessage("Trending Now text");
		//6 Verify if Trending Now text is displayed in Home page
		b=home.getTrending_Now_text().isDisplayed();
		utility.checkIsDisplayed(b, "Trending Now text");
		Assert.assertEquals(b, true);
		//action.sendKeys(Keys.ARROW_DOWN).perform();
		//7Verify if Deals Of The Day Slider button in Home page is clickable
		wait.until(ExpectedConditions.elementToBeClickable(home.getDeals_of_the_Day_previous_slider_button("Trending Now")));
		/////////////////////////////////////////////
		WebElement ele=home.getDeals_of_the_Day_previous_slider_button("Trending Now");
		for(int i=0;i<4;i++) {
			ele.click();
		}
		 ele = home.getDeals_Of_The_Day_Slider_button("Trending Now");
		for(int i=0;i<4;i++) {
			ele.click();
		}
		ele=home.getDeals_of_the_Day_previous_slider_button("Trending Now");
		for(int i=0;i<4;i++) {
			ele.click();
		}
		
		w.until(ExpectedConditions.elementToBeClickable(ele));
		pass("The Day Slider button in Home page is clickable");
		//Verify if trendingNow firstProduct image in Home page is clickable
		
		ele=home.gettrendingNow_firstProduct_Image();
	//	w.until(ExpectedConditions.elementToBeClickable(ele));
		pass("trendingNow firstProduct image in Home page is clickable");
		//9Click on trendingNow firstProduct image in Home page
		js.executeScript("arguments[0].click();", ele);
	//	ele.click();
		utility.isClicked("trendingNow firstProduct image in Home page");
		//11 Verify if PDP ProductName text is displayed in PDP page
		b=pdp.getPDP_ProductName_Text().isDisplayed();
		utility.checkIsDisplayed(b, "PDP ProductName text");
		Assert.assertEquals(b, true);
		bool=b;
	}
}

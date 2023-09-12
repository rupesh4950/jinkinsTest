package test_Scripts;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import static extentReporter.ExtentLogger.*;
import generic.Base_Test;
import generic.ReadExcel;
import generic.StepGroups;
import generic.Utility;
import pom_scripts.web.Home;
import pom_scripts.web.Header.Header;
import pom_scripts.web.Header.PLP;
import pom_scripts.web.Header.Plp.PDP;

public class HM055 extends Base_Test {
	@Test(priority = 1)
	public void main() throws Exception, Exception {
		Utility u=new Utility();
		u.OpenBrowser();
		className="HM055";
		new Home(driver);
		Header header = new Header(driver);
		new PLP(driver);
		js = (JavascriptExecutor) driver;
		new PDP(driver);
		new WebDriverWait(driver, 1);
		
		boolean b = header.getPantaloons().isDisplayed();
		Assert.assertEquals(b, true);
		Object[][] values = ReadExcel.getMultipleData("./TestData/Men_Category.xlsx", "TOP WEAR", 1, 2);
		for (int i = 0; i < values.length; i++) {
			for (int j = 0; j < values[0].length; j++) {
				// System.out.println(i+" "+j+" "+values[i][j]);
				String val = values[i][j].toString();
				startIteration(val);
			}
			// System.out.println();
		}

	}
	private void startIteration(String val) {
		Home home = new Home(driver);
		PLP plp = new PLP(driver);
		StepGroups sg=new StepGroups(driver);
		new Header(driver);
		sg.Navigate_to_PLP_Page("MEN",val);
		WebElement ele = home.getcategory("MEN");
		action.moveToElement(ele).perform();
		Utility u=new Utility();
		// 5 Verify if HEADING TITLE PLP text is displayed in PLP page
		boolean b = plp.getHEADING_TITLE_PLP_Text().isDisplayed();
		u.checkIsDisplayed(b, "Heading title plp text");
		Assert.assertEquals(b, true);
		// Get text from BreadcrumbTwo text in PLP page
		String breadcrumbSubCatagory = plp.getBreadcrumbTwo_Text().getText();
		pass(breadcrumbSubCatagory+" text is fetched suceessfully");
		// Print Value of breadcrumbSubCatagory
		System.out.println(breadcrumbSubCatagory);
		// Verify if string breadcrumbSubCatagory contains string Men Category:TOP WEAR
		b = (val.equalsIgnoreCase(breadcrumbSubCatagory));
		if(b) {
			pass(val+" is matches with "+breadcrumbSubCatagory);
		}
		else {
			pass(val+" is not  matches with "+breadcrumbSubCatagory);
		}
		Assert.assertEquals(b, true);
		bool=true;

	}

}

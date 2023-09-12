package test_Scripts.Login_Web;

import org.openqa.selenium.JavascriptExecutor;
import static extentReporter.ExtentLogger.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import generic.Base_Test;
import generic.StepGroups;
import generic.Utility;
import pom_scripts.web.Home;
import pom_scripts.web.Header.Header;
import pom_scripts.web.Header.PLP;
import pom_scripts.web.Header.Wishlist;
import pom_scripts.web.Header.Plp.PDP;

public class LO002_Verify_user_is_able_to_login_to_application extends Base_Test {
	@Test
	public void main() throws Exception {
		className="LO002";
		Utility utility = new Utility();
		utility.OpenBrowser();
		new Home(driver);
		Header header = new Header(driver);
		new PLP(driver);
		js = (JavascriptExecutor) driver;
		new PDP(driver);
		StepGroups sg = new StepGroups(driver);
		new Wishlist(driver);
		new WebDriverWait(driver, 1);
//		wait.until(ExpectedConditions.elementToBeClickable(home.getIlldothislater()));
//		home.getIlldothislater().click();
		boolean b = header.getPantaloons().isDisplayed();
		utility.checkIsDisplayed(b, "Pantallons logo");
		Assert.assertEquals(b, true);
		// image verifcation completed
		//String mobileNUmber = "8147996288";
		sg.Login_to_Pantaloons();
		bool=true;
		
	}
}

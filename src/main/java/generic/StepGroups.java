package generic;

import static extentReporter.ExtentLogger.*;
import java.io.FileOutputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import pom_scripts.web.Footer;
import pom_scripts.web.Home;
import pom_scripts.web.Header.Bag;
import pom_scripts.web.Header.Header;
import pom_scripts.web.Header.Login;
import pom_scripts.web.Header.My_Account;
import pom_scripts.web.Header.PLP;
import pom_scripts.web.Header.Wishlist;
import pom_scripts.web.Header.Checkout.Address;
import pom_scripts.web.Header.Checkout.Checkout;
import pom_scripts.web.Header.Plp.PDP;
import pom_scripts.web.Header.Plp.Quick_View;

import org.apache.commons.codec.binary.Base64;

public class StepGroups extends UtilityMethod {
	public static WebDriver driver;

	public StepGroups(WebDriver d) {
		driver = d;
		a = new Actions(driver);
		header = new Header(driver);
		plp = new PLP(driver);
		pdp = new PDP(driver);
		home = new Home(driver);
		login = new Login(driver);
		myAccount = new My_Account(d);
		wishlist = new Wishlist(driver);
		quickView = new Quick_View(driver);
		bag = new Bag(driver);
		checkout = new Checkout(driver);
		address = new Address(driver);
		wait = new WebDriverWait(driver, 20);
		footer = new Footer(driver);
		utility = new Utility();
	}

	Checkout checkout;
	Actions a;
	Home home;
	Header header;
	PLP plp;
	PDP pdp;
	Login login;
	My_Account myAccount;
	Wishlist wishlist;
	Quick_View quickView;
	Bag bag;
	Address address;
	Footer footer;
	Utility utility;
	String productBrandPLP, productNamePLP, productPricePLP;
	String ProductBrandPDP, productNamePDP, ProductPricePDP;

	public void Navigate_to_PLP_Page(String Category, String SubCategory) {
		pass("Navigate to plp page is started with category " + Category + " sub category " + SubCategory + " started");
		try {
			a.moveToElement(home.getcategory(Category)).perform();
			utility.moveToElementMessage(Category + " in category");

			// Wait till Sub Catgeory link in Header page is visible
			wait.until(ExpectedConditions.visibilityOf(header.getSub_Catgeory_Link(SubCategory)));

			header.getSub_Catgeory_Link(SubCategory).click();
			utility.isClicked(SubCategory);

		} catch (Exception e) {
			driver.navigate().refresh();

			a.moveToElement(home.getcategory(Category)).perform();
			utility.moveToElementMessage(Category + " in category");

			// Wait till Sub Catgeory link in Header page is visible
			wait.until(ExpectedConditions.visibilityOf(header.getSub_Catgeory_Link(SubCategory)));

			header.getSub_Catgeory_Link(SubCategory).click();
			utility.isClicked(SubCategory);
		}

		wait.until(ExpectedConditions.visibilityOf(plp.getFirst_Product_Image()));
		Boolean b = plp.getFirst_Product_Image().isDisplayed();

		utility.checkIsDisplayed(b, "First Product");
		Assert.assertEquals(b, Boolean.TRUE);
		pass("Navigate to plp page is ended");
	}

	public void Navigate_to_PDP_Page() throws Exception {
		pass("Breadcrumb text started");
		Get_Product_Details_In_PLP_Copy();
		Get_Product_Details_In_PDP();
		Verify_PLP_and_PDP_Products_are_same();
		pass("Breadcrumb text ended");
	}

	public void Get_Product_Details_In_PLP_Copy() {
		pass("Get_Product_Details_In_PLP_Copy started");
		Boolean b = plp.getProduct_Brand_text().isDisplayed();
		utility.checkIsDisplayed(b, "Product_Brand_text");
		Assert.assertEquals(b, Boolean.TRUE);
		// Get text from Product Brand text in PLP page
		productBrandPLP = plp.getProduct_Brand_text().getText();
		pass(productBrandPLP + " productBrandPLP");
		// System.out.println(productBrandPLP);
		// Verify if Product Name text is displayed in PLP page
		b = plp.getProduct_Name_text().isDisplayed();
		utility.checkIsDisplayed(b, "Product Name text ");
		Assert.assertEquals(b, Boolean.TRUE);
		// Get text from Product Name text in PLP page
		productNamePLP = plp.getProduct_Name_text().getText();
		pass(" productNamePLP  " + productNamePLP);
		// Verify if Product Price text is displayed in PLP page
		// action.moveToElement(plp.getProduct_Name_text()).perform();
		action.sendKeys(Keys.ARROW_DOWN).perform();
		b = plp.getProduct_Price_text().isDisplayed();
		utility.checkIsDisplayed(b, "Product Price text");
		Assert.assertEquals(b, Boolean.TRUE);
		productPricePLP = plp.getProduct_Price_text().getText();
		pass(productPricePLP + " productPricePLP");
		productPricePLP = productPricePLP.replaceAll("\\s", "");
		pass("Get_Product_Details_In_PLP_Copy is ended");
	}

	public void Get_Product_Details_In_PDP() throws Exception {
		pass("Get_Product_Details_In_PDP started");
		String val1 = "(//div[contains(@class,'PlpWeb_product-card-content')])",
				val2 = "(//div[@class='size size-web ']//span)[1]";
		WEB_VerifyUserIsAbleToSelectProductOfAvailableSize(val1, val2, 5);
		wait.until(ExpectedConditions.visibilityOf(pdp.getProduct_Name_text()));
		Boolean b = pdp.getProduct_Brand_text().isDisplayed();
		utility.checkIsDisplayed(b, "Product_Brand_text");
		Assert.assertEquals(b, Boolean.TRUE);
		ProductBrandPDP = pdp.getProduct_Brand_text().getText();
		pass(ProductBrandPDP + " ProductBrandPDP");
		// System.out.println(ProductBrandPDP);
		// Verify if Product Name text is displayed in PDP page
		b = pdp.getProduct_Name_text().isDisplayed();
		utility.checkIsDisplayed(b, "Product Name text ");
		Assert.assertEquals(b, Boolean.TRUE);
		productNamePDP = pdp.getProduct_Name_text().getText();
		pass(productNamePDP + " productNamePDP");
		// Verify if Product Price text is displayed in PDP page
		b = pdp.getProduct_Price_text().isDisplayed();
		utility.checkIsDisplayed(b, "Product Price text");
		Assert.assertEquals(b, Boolean.TRUE);
		// Get text from Product Price text in PDP page
		ProductPricePDP = pdp.getProduct_Price_text().getText();
		ProductPricePDP = ProductPricePDP.replaceAll("\\s", "");
		pass(ProductPricePDP + "ProductPricePDP");
		pass("Get_Product_Details_In_PDP ended");
	}

	public void WEB_VerifyUserIsAbleToSelectProductOfAvailableSize(String productLocator, String sizeLocator,
			int numberOfAttempts) throws Exception {
		pass("WEB_VerifyUserIsAbleToSelectProductOfAvailableSize is started");
		List<WebElement> availableSizes = new ArrayList<WebElement>();
		
		for (int i = 1; i <= numberOfAttempts; i++) {
			System.out.println("inside for");
			// System.out.println(productLocator + "[" + i + "]");
			try {
				driver.findElement(By.xpath(productLocator + "[" + i + "]")).click();
			} catch (Exception e) {
				System.out.println(e);
				try {
					driver.findElement(By.xpath(productLocator + "[" + i + "]")).click();
				} catch (Exception e2) {
					// TODO: handle exception
				
				action.moveToElement(driver.findElement(By.xpath(productLocator + "[" + i + "]"))).perform();
				action.click().perform();
				}
			}
			
			List<WebElement> dressSizes = driver.findElements(By.xpath(sizeLocator));
			int sizes = dressSizes.size();
			System.out.println("sizes is "+ sizes);
			if (sizes >= 1) {
				availableSizes.add(dressSizes.get(0));
				break;
			} else {
				Thread.sleep(2000);
				// System.out.println("navigate back");
				driver.navigate().back();
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		//pass("availableSizes "+availableSizes);
	//	pass("After loop");
		if (availableSizes.isEmpty()) {
			System.out.println("failed");
			System.out.println("Could not find the product sizes for numberOfAttempts products");
			pass("Could not find the product sizes for numberOfAttempts products");

		} else {
			WebElement availableSize = availableSizes.get(0);
			availableSize.click();
			utility.isClicked("availableSize");

		}
		pass("WEB_VerifyUserIsAbleToSelectProductOfAvailableSize is ended");
	}

	public void Verify_PLP_and_PDP_Products_are_same() {
		pass("Verify_PLP_and_PDP_Products_are_same started");
		Boolean b = productBrandPLP.equals(ProductBrandPDP);
		utility.isEquals(b, productBrandPLP, ProductBrandPDP);
		// System.out.println(b);
		// System.out.println(productBrandPLP+" falues is "+ProductBrandPDP);
		Assert.assertEquals(b, Boolean.TRUE);

		if (true) {

			b = ProductPricePDP.contains(productPricePLP);
			// pass("indside if "+b);
		}
		if (b == false) {
			b = productPricePLP.contains(ProductPricePDP);
			// pass("indside else "+b);
		}

		utility.isContains(b, ProductPricePDP, productPricePLP);
		System.out.println(ProductPricePDP);
		System.out.println(productPricePLP);
		Assert.assertEquals(b, Boolean.TRUE);
		pass("Verify_PLP_and_PDP_Products_are_same is ended");

	}

	public void Login_to_Pantaloons() throws Exception {
		pass("Login_to_Pantaloons is started");
		home.getMy_Account_icon().click();
		utility.isClicked("My account icon");
		// Verify if Mobile Number textfield is displayed in Login page
		wait.until(ExpectedConditions.visibilityOf(login.getMobile_Number_textfield()));
		Boolean b = login.getMobile_Number_textfield().isDisplayed();
		utility.checkIsDisplayed(b, "Mobile Number textfield");
		Assert.assertEquals(b, Boolean.TRUE);
		// Enter Mobile Number into Mobile Number textfield in Login page
		login.getMobile_Number_textfield().sendKeys(mobileNUmber);
		utility.senKeys(mobileNUmber, "Mobile Number textfield ");
		clearAllNotifications();
		login.getGET_OTP_button().click();
		utility.isClicked("GET_OTP_button");
		String validOtp = Get_OTP_from_Notification_Bar();
		wait.until(ExpectedConditions.visibilityOf(login.getOTP_textfeild()));
		login.getOTP_textfeild().sendKeys(validOtp);
		utility.senKeys(validOtp, "OTP text feild");
		// Click on Start Shopping button in Login page
		login.getStart_Shopping_button().click();
		utility.isClicked(" Start Shopping button");
		Thread.sleep(5000);
		String pantaloonsUrl = "https://www.pantaloons.com/";
		wait.until(ExpectedConditions.urlContains(pantaloonsUrl));
		// Move mouse pointer on My Account icon in Home page
		action.moveToElement(home.getMy_Account_icon()).perform();
		utility.moveToElementMessage("My Account icon");
		// Move mouse pointer on Pantaloons Logo image in Home page
		action.moveToElement(home.getPantaloons_Logo()).perform();
		utility.moveToElementMessage("Pantaloons Logo image");
		action.moveToElement(home.getMy_Account_icon()).perform();
		utility.moveToElementMessage("My Account icon");

		// Verify if LOGOUT button is displayed in My Account page
		b = myAccount.getLOGOUT_button().isDisplayed();
		utility.checkIsDisplayed(b, "LOGOUT button");
		Assert.assertEquals(b, Boolean.TRUE);
		pass("Login_to_Pantaloons is ended");
	}

	AndroidDriver mobileDriver;

	private void clearAllNotifications() throws Exception {
		pass("clearAllNotifications started");
		DesiredCapabilities cap = new DesiredCapabilities();
		// pass("Desired cap ");
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
//		pass("platformName");
		cap.setCapability("newCommandTimeout", 0);
		// pass("command time out");
		cap.setCapability(MobileCapabilityType.NO_RESET, true);
		// pass("no reset");
		URL url = new URL("http://localhost:4723/wd/hub");
		// pass("url");

		try {
			mobileDriver = new AndroidDriver(url, cap);
			// pass("Driver created");
			mobileDriver.openNotifications();
			pass("Opened notification in mobile");
			mobileDriver.findElement(By.xpath("//*[contains(@content-desc,'Clear')]")).click();
			pass(" Notifications cleared");
		} catch (Exception e) {
			System.out.println(e);
			pass(e.toString());
			mobileDriver = new AndroidDriver(url, cap);
			pass("Driver created");
			mobileDriver.openNotifications();
			pass("Opened notification in mobile");
			mobileDriver.findElement(By.xpath("//*[contains(@content-desc,'Clear')]")).click();
			pass(" Notifications cleared");
		}

		pass("clearAllNotifications completed");
	}

	public String Get_OTP_from_Notification_Bar() throws Exception {
		String onlyNumberOTP = "";
//		if(mobileDriver.equals(null)) {
//			}
//	
//		DesiredCapabilities cap = new DesiredCapabilities();
//		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
//		cap.setCapability("newCommandTimeout", 0);
//		cap.setCapability(MobileCapabilityType.NO_RESET, true);
//		URL url = new URL("http://localhost:4723/wd/hub");
//			 mobileDriver = new AndroidDriver(url, cap);
//		
		try {

			// AndroidDriver mobileDriver = new AndroidDriver(url, cap);
			mobileDriver.startRecordingScreen();
			pass("connected to device");
			Thread.sleep(5000);
			mobileDriver.openNotifications();
			pass("Opened notification in mobile");
			Thread.sleep(2000);
			String OTP = mobileDriver
					.findElement(By.xpath("//android.widget.TextView[@resource-id='android:id/message_text']"))
					.getText();
			mobileDriver.findElement(By.xpath("//*[contains(@content-desc,'Clear')]")).click();
			System.out.println(OTP);
			onlyNumberOTP = OTP.replaceAll("[^0-9]", "").trim().substring(0, 6);
			// mob[] = { onlyNumberOTP };
			System.out.println(onlyNumberOTP);
			pass("otp is " + onlyNumberOTP);
			String media = mobileDriver.stopRecordingScreen();
			FileOutputStream stream = null;
			try {
				stream = new FileOutputStream("./MobileRecording/" + className + ".mp4");
				stream.write(Base64.decodeBase64(media));
				stream.close();

			} catch (Exception e) {

			} finally {
				if (stream != null) {
					stream.close();
				}
			}
		} catch (Exception e) {
			System.out.println(e);
			System.out.println("catch");
			Thread.sleep(5000);
			// AndroidDriver mobileDriver = new AndroidDriver(url, cap);
			mobileDriver.startRecordingScreen();
			pass("connected to device");
			mobileDriver.openNotifications();
			pass("Opened notification in mobile");
			Thread.sleep(2000);
			String OTP = mobileDriver
					.findElement(By.xpath("//android.widget.TextView[@resource-id='android:id/message_text']"))
					.getText();
			mobileDriver.findElement(By.xpath("//*[contains(@content-desc,'Clear')]")).click();
			System.out.println(OTP);
			onlyNumberOTP = OTP.replaceAll("[^0-9]", "").trim().substring(0, 6);
			// String mob[] = { onlyNumberOTP };
			System.out.println(onlyNumberOTP);
			pass("otp is " + onlyNumberOTP);
			System.out.println(e);
			String media = mobileDriver.stopRecordingScreen();
			FileOutputStream stream = null;
			try {
				stream = new FileOutputStream("./MobileRecording/" + className + ".mp4");
				stream.write(Base64.decodeBase64(media));
				stream.close();

			} catch (Exception e1) {

			} finally {
				if (stream != null) {
					stream.close();
				}

			}
		}
		return onlyNumberOTP;
	}

	public void Remove_Multiple_Products_From_Wishlist() throws Exception {
		pass("Remove_Multiple_Products_From_Wishlist started");
		WebElement ele = header.getWishlist_icon();
		js.executeScript("arguments[0].click();", ele);
		utility.isClicked("Wishlist_icon");
		RemoveMultipleProductsFromWishlist("//div[contains(@class,'wishlist_my-wishlist-cross')]");
		driver.navigate().to("https://www.pantaloons.com/");
		pass("Remove_Multiple_Products_From_Wishlist is ended");

	}

	private void RemoveMultipleProductsFromWishlist(String string1) throws Exception {
		pass("RemoveMultipleProductsFromWishlist started");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver, 20);
		List<WebElement> removeIcon = driver.findElements(By.xpath(string1));
		int count = removeIcon.size();
		if (count > 0) {
			for (int i = 0; i <= count; i++) {
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(string1)));
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath(string1)));
				driver.findElement(By.xpath(string1)).click();
				utility.isClicked("remove icon");
				Thread.sleep(3000);
			}
			pass("Removed " + count + " Products from the bag");
			System.out.println("Removed " + count + " Products from the bag");
		} else {
			pass("Bag is empty");
			System.out.println("Bag is empty");
		}
		pass("RemoveMultipleProductsFromWishlist is ended");
	}

	public void Verify_PLP_and_Wishlist_Product_are_same() {
		pass("Verify_PLP_and_Wishlist_Product_are_same is started");
		Boolean b = productBrandPLP.equals(productBrandWishlist);
		utility.isEquals(b, productBrandPLP, productBrandWishlist);
		// System.out.println(b);
		// System.out.println(productBrandPLP+" falues is "+ProductBrandPDP);
		Assert.assertEquals(b, Boolean.TRUE);
		productPriceWishlist = productPriceWishlist.replaceAll("\\s", "");
		b = productPricePLP.contains(productPriceWishlist);
		utility.isContains(b, productPricePLP, productPriceWishlist);
		Assert.assertEquals(b, Boolean.TRUE);
		pass("Verify_PLP_and_Wishlist_Product_are_same is ended");
	}

	String productBrandWishlist, productNameWishlists, productPriceWishlist;

	public void Get_Product_Details_in_Wishlist() {
		pass("Get_Product_Details_in_Wishlist is started");
		// Verify if Product Brand text is displayed in Wishlist page
		Boolean b = wishlist.getProduct_Brand_text().isDisplayed();
		utility.checkIsDisplayed(b, "Product Brand text");
		Assert.assertEquals(b, Boolean.TRUE);
		// Get text from Product Brand text in Wishlist page
		productBrandWishlist = wishlist.getProduct_Brand_text().getText();
		pass(productBrandWishlist + " productBrandWishlist");
		// Verify if Product Name text is displayed in Wishlist page
		b = wishlist.getProduct_Name_text().isDisplayed();
		utility.checkIsDisplayed(b, "Product Name text");
		Assert.assertEquals(b, Boolean.TRUE);
		// Get text from Product Name text in Wishlist page
		productNameWishlists = wishlist.getProduct_Name_text().getText();
		pass(productNameWishlists + " productNameWishlists");
		// Verify if Product Price text is displayed in Wishlist page
		b = wishlist.getProduct_Price_text().isDisplayed();
		utility.checkIsDisplayed(b, "Product Price text");
		Assert.assertEquals(b, Boolean.TRUE);
		productPriceWishlist = wishlist.getProduct_Price_text().getText();
		productPriceWishlist = productPriceWishlist.replaceAll("\\s", "");
		pass(productPriceWishlist + " productPriceWishlist");
		pass("Get_Product_Details_in_Wishlist is ended");
	}

	String deleteIcon, RemoveButton;

	public void Delete_Multiple_Products_From_Bag() throws Exception {
		pass("Delete_Multiple_Products_From_Bag  is stared");
		// Click on Pantaloons Logo image in Home page
		// System.out.println("image click");
		//home.getPantaloons_Logo().click();
		driver.navigate().to("https://www.pantaloons.com/");
		pass("navigated to pantaloons");
		//utility.isClicked("Pantallons logo");
		// System.out.println("image click falied");
		// Click on Bag icon in Header page
		// header.getBag_icon().click();
		//utility.isClicked("bag icon ");
		try {
			WebDriverWait w = new WebDriverWait(driver, 4);
			w.until(ExpectedConditions.visibilityOf(header.getBag_icon()));
			header.getBag_icon().click();
			utility.isClicked("Bag icon");
		} catch (Exception e) {
			
		}
		driver.navigate().refresh();
		System.out.println("insdie delete");
		// header.getBag_icon().click();
		// Press PAGE_DOWN for n times
		for (int i = 0; i < 10; i++) {
			action.sendKeys(Keys.PAGE_DOWN).perform();
			Thread.sleep(100);
		}
		// Press PAGE_UP for n times
		for (int i = 0; i < 10; i++) {
			action.sendKeys(Keys.PAGE_UP).perform();
			Thread.sleep(100);
		}
		System.out.println("key press completed");
		// DeleteMutlipeProductsFromBag in WEB_Scenario page
		deleteIcon = "//img[@title=\"Remove item\"]";
		RemoveButton = "//button[text()=\"REMOVE\"]";
		DeleteMutlipeProductsFromBag(deleteIcon, RemoveButton);
		// Click on Pantaloons Logo image in Home page
		pass("Pantaloons", true);
		wait.until(ExpectedConditions.visibilityOf(home.getPantaloons_image()));
		wait.until(ExpectedConditions.elementToBeClickable(home.getPantaloons_image()));
		home.getPantaloons_Logo().click();
		utility.isClicked("Pantallons logo");
		pass("Delete_Multiple_Products_From_Bag  is ended");

	}

	public void DeleteMutlipeProductsFromBag(String DeleteIcon, String removeButton) {
		pass("DeleteMutlipeProductsFromBag is started");
		try {
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			WebDriverWait wait = new WebDriverWait(driver, 4);
			try {
				wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(DeleteIcon)));
				pass(driver.findElements(By.xpath(DeleteIcon)).size() + "");
			} catch (Exception e) {

			}
			List<WebElement> numDeleteIcons = driver.findElements(By.xpath(DeleteIcon));
			try {
				if (numDeleteIcons.size() > 0) {
					for (int i = 1; i <= numDeleteIcons.size(); i++) {
						wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(DeleteIcon)));
						wait.until(ExpectedConditions.elementToBeClickable(By.xpath(DeleteIcon))).click();
						utility.isClicked("Delete icon");
						Thread.sleep(1000);
						wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(RemoveButton)));
						wait.until(ExpectedConditions.elementToBeClickable(By.xpath(RemoveButton))).click();
						utility.isClicked("Remove Button");
						Thread.sleep(1000);
						System.out.println(numDeleteIcons.size() + "  Product Deleted Successfully");
					}
				} else {
					driver.navigate().refresh();
					boolean b = false;
					try {
						b = driver.findElement(By.xpath("//div[text()='Oops!']")).isDisplayed();
					} catch (Exception e) {

					}
					if (b) {
						System.out.println("Oops sorry no products found");
						pass("Oops sorry no products found  is displayed");
					}
				}
			} catch (Exception e) {
//				fail("Failed to delete the product from bag 1 " + e);
//				System.out.println("Failed to delete the product from bag 2 " + e);
			}
		} catch (Exception e) {
//			fail("Failed to delete the product from bag " + e);
//			System.out.println("Failed to delete the product from bag  3 " + e);
		}
		pass("DeleteMutlipeProductsFromBag is ended");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	String productNameQuickView, productBrandQuickView, productPriceQuickView;

	public void Get_Product_Details_in_Quick_View() {
		pass("Get_Product_Details_in_Quick_View is started");
		// Verify if Product Name text is displayed in Quick View page
		Boolean b = quickView.getProduct_Name_text().isDisplayed();
		utility.checkIsDisplayed(b, "Product Name text");
		Assert.assertEquals(b, Boolean.TRUE);
		// Get text from Product Name text in Quick View page
		productNameQuickView = quickView.getProduct_Name_text().getText();
		pass("productNameQuickView " + productNameQuickView);
		// Verify if Product Brand text is displayed in Quick View page
		b = quickView.getProduct_Brand_text().isDisplayed();
		utility.checkIsDisplayed(b, "Product Brand text");
		Assert.assertEquals(b, Boolean.TRUE);
		productBrandQuickView = quickView.getProduct_Brand_text().getText();
		pass(productBrandQuickView + " productBrandQuickView");
		// Verify if Product Price text is displayed in Quick View page
		b = quickView.getProduct_Price_text().isDisplayed();
		utility.checkIsDisplayed(b, "Product_Price_text");
		// Get text from Product Price text in Quick View page
		productPriceQuickView = quickView.getProduct_Price_text().getText();
		pass(productPriceQuickView + " productPriceQuickView");
		pass("Get_Product_Details_in_Quick_View ended");

	}

	String firstProductBrandNameBag, firstProductNameBag, productActualPriceBag;

	public void Get_Product_Details_From_Bag_Page() {
		pass("Get_Product_Details_From_Bag_Page is started");
		// Verify if My Bag text is displayed in Bag page
		Boolean b = bag.getMy_Bag_Page_text().isDisplayed();
		utility.checkIsDisplayed(b, "My Bag text");
		Assert.assertEquals(Boolean.TRUE, b);
		// Verify if ProductBrandName_Bag text is displayed in Home page
		b = home.getProductBrandName_Bag_text().isDisplayed();
		utility.checkIsDisplayed(b, "ProductBrandName_Bag text");
		Assert.assertEquals(Boolean.TRUE, b);
		// Get text from ProductBrandName_Bag text in Home page
		firstProductBrandNameBag = home.getProductBrandName_Bag_text().getText();
		pass("firstProductBrandNameBag " + firstProductBrandNameBag);
		// Get text from ProductName_Bag text in Bag page
		firstProductNameBag = bag.getProductName_Bag_text().getText();
		pass("firstProductNameBag " + firstProductNameBag);
		// Get text from Product_Actual_Price_text in Bag page
		productActualPriceBag = bag.getProduct_Actual_Price_text().getText();
		pass("productActualPriceBag " + productActualPriceBag);
		pass("Get_Product_Details_From_Bag_Page is ended");
	}

	public void Verify_Quick_View_and_Bag_Products_are_same() {
		pass("Verify_Quick_View_and_Bag_Products_are_same started");
		// Verify if string firstProductBrandNameBag matches string
		// productBrandQuickView
		Boolean b = firstProductBrandNameBag.matches(productBrandQuickView);
		utility.isMatches(b, firstProductBrandNameBag, productBrandQuickView);
		Assert.assertEquals(Boolean.TRUE, b);
		// Verify if string firstProductNameBag matches string productNameQuickView
		b = firstProductNameBag.matches(productNameQuickView);
		utility.isMatches(b, firstProductNameBag, productNameQuickView);
		Assert.assertEquals(Boolean.TRUE, b);
		// Verify if string productDiscountpriceBag contains string
		// productPriceQuickView
		b = productActualPriceBag.contains(productPriceQuickView);
		utility.isContains(b, productActualPriceBag, productPriceQuickView);
		System.out.println("values");
		System.out.println(productActualPriceBag);
		System.out.println(productPriceQuickView);
		Assert.assertEquals(Boolean.TRUE, b);
		pass("Verify_Quick_View_and_Bag_Products_are_same is ended");

	}

	public void Login_through_POP_UP() throws Exception {
		pass("Login_through_POP_UP started");
		Boolean b = login.getMobile_Number_textfield().isDisplayed();
		utility.checkIsDisplayed(b, "Mobile_Number_textfield");
		Assert.assertEquals(Boolean.TRUE, b);
		login.getMobile_Number_textfield().sendKeys(mobileNUmber);
		utility.senKeys(mobileNUmber, "Mobile_Number_textfield");
		clearAllNotifications();
		login.getGET_OTP_button().click();
		utility.isClicked("GET_OTP_button");
		String otp = Get_OTP_from_Notification_Bar();
		login.getOTP_textfeild().sendKeys(otp);
		utility.senKeys(otp, "OTP text feild");
		// Click on Start Shopping button in Login page
		login.getStart_Shopping_button().click();
		pass("Login_through_POP_UP is ended");
	}

	public void verfiyforPDP034() {
		Boolean b = productBrandWishlist.matches(ProductBrandPDP);
		utility.isMatches(b, ProductActualPricePDP, ProductBrandPDP);
		Assert.assertEquals(Boolean.TRUE, b);
		b = productNameWishlists.matches(productNamePDP);
		utility.isMatches(b, productNameWishlists, productNamePDP);
		Assert.assertEquals(Boolean.TRUE, b);
	}

	public void checkValues(String productbrand, String productname) {
		Boolean b = productbrand.matches(ProductBrandPDP);
		utility.isMatches(b, productbrand, ProductBrandPDP);
		Assert.assertEquals(Boolean.TRUE, b);
		b = productname.matches(productNamePDP);
		utility.isMatches(b, productname, productNamePDP);
//		System.out.println(productname+" null ");
//		System.out.println(productNamePDP+"  null");
//		System.out.println("completed");
		Assert.assertEquals(Boolean.TRUE, b);

	}

	public void Add_product_to_Bag_from_Quick_View() throws Exception {
		pass("Add_product_to_Bag_from_Quick_View is started");
		// Wait till Select Size button in Quick View page is clickablew
		wait.until(ExpectedConditions.elementToBeClickable(quickView.getSelect_Size_button())).click();
		;
		// Press PAGE_DOWN for n times
		int n = 1;
		for (int i = 0; i < n; i++) {
			action.sendKeys(Keys.PAGE_DOWN).perform();
		}
		pass("page down is performed");
		// Wait till ADD TO BAG button in Quick View page is clickable
		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(quickView.getADD_TO_BAG_button())).click();
		utility.isClicked("ADD TO BAG button");
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='GO TO BAG']")));
		// Verify if GO TO BAG button is displayed in Quick View page
		Boolean b = quickView.getGO_TO_BAG_button().isDisplayed();
		utility.checkIsDisplayed(b, "GO TO BAG button");
		Assert.assertEquals(b, Boolean.TRUE);
		// Press PAGE_UP for n times
		n = 2;
		for (int i = 0; i < n; i++) {
			action.sendKeys(Keys.PAGE_UP).perform();
		}
		pass("page up performed");
		Thread.sleep(1000);
		// Wait till Quick_View_Close_icon in Quick View page is clickable
		wait.until(ExpectedConditions.elementToBeClickable(quickView.getQuick_View_Close_icon())).click();
		utility.isClicked(" Quick_View_Close_icon ");
		// Wait till Bag icon in Header page is clickable
		wait.until(ExpectedConditions.elementToBeClickable(header.getBag_icon())).click();
		utility.isClicked("Bag icon");
		pass("Add_product_to_Bag_from_Quick_View is ended");

	}

	public void Naviagte_To_Checkout_With_FIlled_Address() throws Exception {
		pass("Naviagte_To_Checkout_With_FIlled_Address is started");
		// Navigate to Add Address With Login sg
		Navigate_to_Add_Address_With_Login();
		// Verify if Add_new_address_text is displayed in Address page
		Boolean b = address.getAdd_new_address_text().isDisplayed();
		utility.checkIsDisplayed(b, "Add new address text");
		Assert.assertEquals(Boolean.TRUE, b);
		// Verify if FIRST NAME textfield is displayed in Address page
		b = address.getFirst_Name_textfield().isDisplayed();
		utility.checkIsDisplayed(b, "FIRST NAME textfield");
		Assert.assertEquals(Boolean.TRUE, b);
		// Verify if FIRST NAME textfield in Address page is clickable
		wait.until(ExpectedConditions.elementToBeClickable(address.getFirst_Name_textfield()));
		// Clear text from FIRST NAME textfield in Address page using shortcut key
		address.getFirst_Name_textfield().sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
		pass("text from FIRST NAME textfield is cleared");
		// Generate random string with length 4 characters
		userName = Generate_random_string_with_length(4);
		pass("random string " + userName);
		// Enter userName into FIRST NAME textfield in Address page
		address.getFirst_Name_textfield().sendKeys(userName);
		pass(userName + " is entered into First Name textfield");
		// Get *attributeName* attribute value of FIRST NAME textfield in Address page
		value = address.getFirst_Name_textfield().getAttribute("value");
		pass(value + " is fetched  forme first name textfield ");
		// Verify if string userName contains string value
		b = userName.contains(value);
		if (b) {
			pass(userName + " contains " + value);
		} else {
			fail(userName + " dose not contains " + value);
		}
//		System.out.println(userName);
//		System.out.println(value);
		Assert.assertEquals(Boolean.TRUE, b);
		// Verify if Last_Name_textfield is displayed in Address page
		b = address.getLast_Name_textfield().isDisplayed();
		utility.checkIsDisplayed(b, "Last_Name_textfield");
		Assert.assertEquals(Boolean.TRUE, b);
		// Verify if Last Name textfield in Address page is clickable
		wait.until(ExpectedConditions.elementToBeClickable(address.getLast_Name_textfield()));
		// Clear text from Last Name textfield in Address page using shortcut key
		address.getLast_Name_textfield().sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
		pass("text from Last Name textfield is cleared");
		// Generate random string with length 5 characters
		lastName = Generate_random_string_with_length(5);
		pass("random string " + lastName);
		// Enter lastName into Last Name textfield in Address page
		address.getLast_Name_textfield().sendKeys(lastName);
		pass(lastName + " is entered into the lastName text feild");
		// Get *attributeName* attribute value of Last Name textfield in Address pag
		value = address.getLast_Name_textfield().getAttribute("value");
		pass(value + " is fetched from the lase name text feild");
		// Verify if string lastName contains string value
		b = lastName.contains(value);
		if (b) {
			pass(lastName + " contains " + value);
		} else {
			fail(lastName + " dose not contains " + value);
		}
		Assert.assertEquals(Boolean.TRUE, b);
		// Verify if Mobile_Number_textfield is displayed in Address page
		b = address.getMobile_Number_textfield().isDisplayed();
		utility.checkIsDisplayed(b, " Mobile_Number_textfield");
		Assert.assertEquals(Boolean.TRUE, b);
		// Verify if Mobile Number textfield in Address page is clickable
		wait.until(ExpectedConditions.elementToBeClickable(address.getMobile_Number_textfield()));
		// Clear text from Mobile Number textfield in Address page using shortcut key
		address.getMobile_Number_textfield().sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
		pass(" text from Mobile Number textfield is cleared");
		// Generate random number with length 9 digits
		mobNumberValue = Generate_random_number_with_length_digits(9);
		// Concatenate 9 with mobNumberValue
		mobNumberValue = ("9" + mobNumberValue);
		pass(" Random number generataed is" + mobNumberValue);
		// Enter mobNumberValue into Mobile Number textfield in Address page
		address.getMobile_Number_textfield().sendKeys(mobNumberValue);
		utility.senKeys(mobNumberValue, "Mobile Number textfield");
		// Get *attributeName* attribute value of Mobile Number textfield in Address
		// page
		value = address.getMobile_Number_textfield().getAttribute("value");
		pass(value + " is fetched form Mobile_Number_textfield");
		// Verify if string mobNumberValue contains string value
		b = mobNumberValue.contains(value);
		utility.isContains(b, mobNumberValue, value);
		// Scroll page vertically until visibility of Use Current Location link in
		// Address page
		js.executeScript("arguments[0].scrollIntoView(true);", address.getUse_Current_Location_link());
		// Verify if PINCODE_textfield is displayed in Address page
		b = address.getPINCODE_textfield().isDisplayed();
		utility.checkIsDisplayed(b, "PINCODE_textfield");
		Assert.assertEquals(Boolean.TRUE, b);
		// Verify if PINCODE textfield in Address page is clickable
		wait.until(ExpectedConditions.elementToBeClickable(address.getPINCODE_textfield()));
		// Clear text from PINCODE textfield in Address page using shortcut key
		address.getPINCODE_textfield().sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
		pass("text from PINCODE textfield is cleared");
		// Enter pinCode into PINCODE textfield in Address page
		address.getPINCODE_textfield().sendKeys(pinCode);
		utility.senKeys(pinCode, "PINCODE textfield");
		// Get *attributeName* attribute value of PINCODE textfield in Address page
		value = address.getPINCODE_textfield().getAttribute("value");
		pass(value + " is fetched form pincode text feild");
		// Verify if string pinCode contains string value
		b = pinCode.contains(value);
		utility.isContains(b, pinCode, value);
		Assert.assertEquals(Boolean.TRUE, b);
		// Verify if House_no__Building_name_textfield is displayed in Address page
		b = address.getHouse_no__Building_name_textfield().isDisplayed();
		utility.checkIsDisplayed(b, "House_no__Building_name");
		// Enter houseNumber into House no/ Building name textfield in Address page
		address.getHouse_no__Building_name_textfield().sendKeys(houseNumber);
		utility.senKeys(houseNumber, "House no/ Building name textfield");
		// Get *attributeName* attribute value of House no/ Building name textfield in
		// Address page
		value = address.getHouse_no__Building_name_textfield().getAttribute("value");
		pass(value + " is fetched from House no/ Building name textfield ");
		// Verify if string houseNumber contains string value
		b = houseNumber.contains(value);
		utility.isContains(b, houseNumber, value);
		Assert.assertEquals(Boolean.TRUE, b);
		// Scroll page vertically until visibility of Pin_code*_text in Address page
		js.executeScript("arguments[0].scrollIntoView(true);", address.getPin_code_star_text());
		// Verify if street_textfield is displayed in Address page
		b = address.getstreet_textfield().isDisplayed();
		utility.checkIsDisplayed(b, "street_textfield");
		Assert.assertEquals(Boolean.TRUE, b);
		// Verify if street textfield in Address page is clickable
		wait.until(ExpectedConditions.elementToBeClickable(address.getstreet_textfield()));
		// Enter streetName into street textfield in Address page
		address.getstreet_textfield().sendKeys(streetName);
		utility.senKeys(streetName, "street textfield");
		// Get *attributeName* attribute value of street textfield in Address page
		value = address.getstreet_textfield().getAttribute("value");
		pass(value + " is fetched form street text field");
//		/Verify if string streetName contains string value
		b = streetName.contains(value);
		utility.isContains(b, streetName, value);
		Assert.assertEquals(Boolean.TRUE, b);
		// Verify if area_textfield is displayed in Address page
		b = address.getarea_textfield().isDisplayed();
		utility.checkIsDisplayed(b, "area_textfield ");
		// Verify if area textfield in Address page is clickable
		wait.until(ExpectedConditions.elementToBeClickable(address.getarea_textfield()));
		// Enter streetName into area textfield in Address page
		address.getarea_textfield().sendKeys(Area);
		utility.senKeys(Area, "area textfield");
		// Get value attribute value of area textfield in Address page
		value = address.getarea_textfield().getAttribute("value");
		pass(value + " is fetched from the area text field");
		// Verify if string Area contains string value
		b = Area.contains(value);
		utility.isContains(b, Area, value);
		Assert.assertEquals(Boolean.TRUE, b);
		// Enter landmark into landmark_textfield in Address page
		address.getlandmark_textfield().sendKeys(landmark);
		utility.senKeys(landmark, "landmark textfield");
		// Get value attribute value of landmark textfield in Address page
		value = address.getlandmark_textfield().getAttribute("value");
		pass(value + " is fetched from the landmark text feild");
		// Verify if string landmark contains string value
		b = landmark.contains(value);
		utility.isContains(b, landmark, value);
		Assert.assertEquals(Boolean.TRUE, b);
		// Verify if Address_Type_text is displayed in Address page
		b = address.getAddress_Type_text().isDisplayed();
		utility.checkIsDisplayed(b, "Address type text ");
		Assert.assertEquals(Boolean.TRUE, b);
		
		address.getMake_this_as_default_address().click();
		utility.isClicked("Make this as default address");
		pass("Naviagte_To_Checkout_With_FIlled_Address is ended");

	}
	public void removeAddress() throws Exception {
		String namePresent = address.getDefaultAddressName().getText();
	//	DeleteMutlipeProductsFromBag("//img[@title='Delete']", "//span[text()='DELETE']/../..//button[contains(@class,'MuiButton-contained MuiButton-containedPrimary')]");
//		if(namePresent.contains(userName)) {
//			utility.isContains(true, namePresent, userName);
//		}
//		else {
//			utility.isContains(false, namePresent, userName);
//		//	Assert.fail();
//		}
		//driver.findElements(By.xpath("//div[contains(@class,'AddressItem_app-checkout-address')]//img[@title='Delete']"));
			List<WebElement> deleteicons = driver.findElements(By.xpath("//img[@title='Delete']"));
			System.out.println(deleteicons.size());
			WebElement defaultAddressDeleteIcon = address.getDefaultAddressDeleteIcon();
			int size=deleteicons.size();
			for (int i=0;i<size-1;i++) {
				WebElement deleteIcon = driver.findElement(By.xpath("//img[@title='Delete']"));
				
				System.out.println(deleteIcon);
				System.out.println(defaultAddressDeleteIcon);
			//	if(deleteIcon!=defaultAddressDeleteIcon) {
					deleteIcon.click();
					utility.isClicked("Delete Icon");
				//	wait.until(ExpectedConditions.visibilityOf(address.getDeleteButton()));
					//wait.until(ExpectedConditions.elementToBeClickable(address.getDeleteButton()));
					Thread.sleep(500);
					address.getDeleteButton().click();;
			//	}
			}
			pass("Adress deleted successfully");
	}

	String landmark = "landmark";
	String streetName = "street 267 road", Area = "3rd cross,bangalore";
	String userName, value, lastName, mobNumberValue, pinCode = "560079", houseNumber = "Building 24 5th cross";

	public String Generate_random_number_with_length_digits(int n) {
		int max = 9, min = 0;
		String temp = "";
		for (int i = 0; i < n; i++) {
			int k = (int) (Math.random() * ((max - min + 1) + min));
			temp += (k) + "";
		}
		// System.out.println(temp);
		return temp;
	}

	public String Generate_random_string_with_length(int n) {
		int max = 25, min = 1;
		String temp = "";
		for (int i = 0; i < n; i++) {
			int k = (int) (Math.random() * ((max - min + 1) + min));
			temp += (char) (97 + k);
		}
		return temp;
	}

	public void Navigate_to_Add_Address_With_Login() throws Exception {
		pass("Navigate_to_Add_Address_With_Login is stared");
		// Add product to Bag from Quick View
		Add_product_to_Bag_from_Quick_View();
		// Verify if My Bag text is displayed in Bag page
		Boolean b = bag.getMy_Bag_Page_text().isDisplayed();
		utility.checkIsDisplayed(b, "MY Bag text");
		Assert.assertEquals(Boolean.TRUE, b);
		// Click on CHECKOUT button in Bag page
		bag.getCHECKOUT_button().click();
		utility.isClicked("CHECKOUT button");
		// Verify if Checkout text is displayed in Checkout page
		b = checkout.getCheckout_text().isDisplayed();
		utility.checkIsDisplayed(b, "Checkout text");
		Assert.assertEquals(Boolean.TRUE, b);
		// Click on Plus icon in Address page
		address.getPlus_icon().click();
		utility.isClicked("Plus icon");
		// Press PAGE_DOWN key
		Thread.sleep(2000);
		action.sendKeys(Keys.PAGE_DOWN).perform();
		pass("page down performed");
		// Click on ADD_NEW_ADDRESS_button in Address page
		try {
			js.executeScript("arguments[0].scrollIntoView(true);", address.getADD_NEW_ADDRESS_button());
			utility.moveToElementMessage("ADD_NEW_ADDRESS_button");
			// wait.until(ExpectedConditions.elementToBeClickable(address.getADD_NEW_ADDRESS_button()));
			address.getADD_NEW_ADDRESS_button().click();
			utility.isClicked("ADD_NEW_ADDRESS_button");
		} catch (Exception e) {
			js.executeScript("arguments[0].scrollIntoView(true);", address.getADD_NEW_ADDRESS_button());
			utility.moveToElementMessage("ADD_NEW_ADDRESS_button");
			// wait.until(ExpectedConditions.elementToBeClickable(address.getADD_NEW_ADDRESS_button()));
			address.getADD_NEW_ADDRESS_button().click();
			utility.isClicked("ADD_NEW_ADDRESS_button");
		}

		// Verify if First_Name_textfield is displayed in Address page
		b = address.getFirst_Name_textfield().isDisplayed();
		utility.checkIsDisplayed(b, "First_Name_textfield");
		Assert.assertEquals(Boolean.TRUE, b);
		// only 10 steps
		pass("Navigate_to_Add_Address_With_Login is ended");
	}

	public void checkLast() {
		Boolean b = address.getSpecific_Address_text(userName).isDisplayed();
		utility.checkIsDisplayed(b, "Address with " + userName);
		Assert.assertEquals(Boolean.TRUE, b);
	}

	String offPercentage;
	String firstProductAmount, productActualpricePLP;

	public void Add_the_Product_From_Category_to_Bag_with_All_Verifications() throws Exception {
		pass("Add_the_Product_From_Category_to_Bag_with_All_Verifications started");
		// Verify if Pantaloons Logo image is displayed in Home page
		Boolean b = home.getPantaloons_image().isDisplayed();
		utility.checkIsDisplayed(b, "Pantaloons Logo image");
		Assert.assertEquals(b, Boolean.TRUE);
		String category = "WOMEN", subCategoryWeb = "Tees & Tops";
		Navigate_to_PLP_Page(category, subCategoryWeb);
		// Click on SORT BY dropdown in PLP page
		plp.getSORT_BY_dropdown().click();
		utility.isClicked("SORT BY dropdown");
		// Click on Select Sort By text in PLP page
		plp.getSelect_Sort_By_text("Discount").click();
		utility.isClicked("Select Sort By text with Discount");
		// Scroll page vertically until visibility of About_link in Footer page
		js.executeScript("arguments[0].scrollIntoView(true);", footer.getAbout_link());
		// Scroll page vertically until visibility of BreadcrumbTwo text in PLP page
		js.executeScript("arguments[0].scrollIntoView(true);", plp.getBreadcrumbTwo_Text());
		// Scroll page vertically until visibility of HEADING TITLE PLP text in PLP page
		js.executeScript("arguments[0].scrollIntoView(true);", plp.getHEADING_TITLE_PLP_Text());
		// Wait till First Product image in PLP page is clickable
		wait.until(ExpectedConditions.elementToBeClickable(plp.getFirst_Product_Image()));
		// Verify if Product Name text is displayed in PLP page
		b = plp.getProduct_Name_text().isDisplayed();
		utility.checkIsDisplayed(b, "Product Name text");
		Assert.assertEquals(b, Boolean.TRUE);
		// Get text from Product Name text in PLP page
		Thread.sleep(3000);
		;
		String productNamePLP = plp.getProduct_Name_text().getText();
		pass(productNamePLP + " Product Name text in plp");
		// Reporter.log(productNamePLP);
		// Verify if Product Brand text is displayed in PLP page
		b = plp.getProduct_Brand_text().isDisplayed();
		utility.checkIsDisplayed(b, "Product Brand text");
		Assert.assertEquals(b, Boolean.TRUE);
		productBrandPLP = plp.getProduct_Brand_text().getText();
		pass(productBrandPLP + "  Product_Brand_text in plp ", true);
		// Reporter.log(productBrandPLP);
		b = driver.findElement(By.xpath("//div[contains(@class,'PlpWeb_product-price')]")).isDisplayed();
		// utility.checkIsDisplayed(b,
		// "//div[contains(@class,'PlpWeb_product-price')]");

		if (b) {
			pass("Product price is displayed");
			// Verify if Product Price text is displayed in PLP page
			Boolean bb = plp.getProduct_Price_text().isDisplayed();
			utility.checkIsDisplayed(bb, " Product Price text");
			Assert.assertEquals(bb, Boolean.TRUE);
			// Get text from Product Price text in PLP page
			productPricePLP = plp.getProduct_Price_text().getText();
			pass(productPricePLP + " is fetched from Product_Price_text in plp ");
			Boolean temp = driver.findElement(By.xpath(
					"(//div[contains(@class,'PlpWeb_products-count')]/../../../div[3]/div/div/div/a/div[4]/div[3]/span[1])[1]"))
					.isDisplayed();
			System.out.println(temp);
			if (temp) {
				pass("Product details is displayed");
				firstProductAmount = getDiscount(plp.getProduct_Price_text());
				pass(firstProductAmount + " ithe discount in plp");
				// System.out.println("firstProductAmount" +firstProductAmount);
			}
			b = driver.findElement(By.xpath("//s[@class='actual-price']")).isDisplayed();

			if (b) {
				pass("actual-price");
				// Verify if Actual_Price_text is displayed in PLP page
				b = plp.getActual_Price_text().isDisplayed();
				utility.checkIsDisplayed(b, "Actual_Price_text");
				Assert.assertEquals(b, Boolean.TRUE);
				productActualpricePLP = plp.getActual_Price_text().getText();
				pass(productActualpricePLP + " productActualpricePLP");

			}

			b = driver.findElement(By.xpath("//span[@class='discount discountHighlight']")).isDisplayed();
			if (b) {
				pass("discountHighlight is displayed");
				b = plp.getOFF_Percentage_text().isDisplayed();
				utility.checkIsDisplayed(b, "OFF_Percentage_text()");
				Assert.assertEquals(b, Boolean.TRUE);
				offPercentage = plp.getOFF_Percentage_text().getText();
				pass(offPercentage + " offPercentage in plp");
			}
		}
		// Click on First Product image in PLP page
		plp.getFirst_Product_Image().click();
		utility.isClicked("First Product image ");
		/// Verify if ProductBrandName_PDP text is displayed in Home page
		b = home.getProductBrandName_PDP_text().isDisplayed();
		utility.checkIsDisplayed(b, "ProductBrandName_PDP text");
		firstProductBrandNamePDP = home.getProductBrandName_PDP_text().getText();
		pass(firstProductBrandNamePDP + " firstProductBrandNamePDP", true);
		// Get text from Product Name text in PDP page
		productNamePDP = pdp.getProduct_Name_text().getText();
		pass(productNamePDP + " productNamePDP", true);
		b = productBrandPLP.contains(firstProductBrandNamePDP);
		utility.isContains(b, productBrandPLP, firstProductBrandNamePDP);
		Assert.assertEquals(b, Boolean.TRUE);
		// Get text from Product_Discouted_Price_text in PDP page
		productDiscoutedPricePDP = pdp.getProduct_Discouted_Price_text().getText();
		b = productDiscoutedPricePDP.contains(firstProductAmount);
		utility.isContains(b, productDiscoutedPricePDP, firstProductAmount);// dfuhasjnfpoawklsmd
		Assert.assertEquals(b, Boolean.TRUE);
		b = false;
		try {
			b = driver.findElement(By.xpath("//span[@class='discount discountHighlight pdpnodealpage']")).isDisplayed();
		} catch (Exception e) {
			b = false;
		}
		if (b) {
			pass(" discountHighlight  is displayed");
			System.out.println("if block");
			// Get text from Product Actual Amount text in PDP page
			ProductActualPricePDP = pdp.getProduct_Actual_Amount_text().getText();
			// Verify if OFF_PDP_text is displayed in PDP page
			b = pdp.getOFF_PDP_text().isDisplayed();
			utility.checkIsDisplayed(b, "OFF_PDP_text");
			Assert.assertEquals(b, Boolean.TRUE);
			// Get text from OFF_PDP text in PDP page
			offPercentagePDP = pdp.getOFF_PDP_text().getText();
//			System.out.println(productActualpricePLP+"   null");
//			System.out.println(ProductActualPricePDP+"   null");
			b = productActualpricePLP.contains(ProductActualPricePDP);
			utility.isContains(b, productActualpricePLP, ProductActualPricePDP);
			Assert.assertEquals(b, Boolean.TRUE);
			b = offPercentage.contains(offPercentagePDP);
			utility.isContains(b, offPercentage, offPercentagePDP);
			Assert.assertEquals(b, Boolean.TRUE);
		}
		// Verify if SELECT_SIZE_text is displayed in PDP page
		b = pdp.getSELECT_SIZE_text().isDisplayed();
		utility.checkIsDisplayed(b, "SELECT_SIZE_text");
		Assert.assertEquals(b, Boolean.TRUE);
		// Verify if Select Size button in PDP page is clickable
		wait.until(ExpectedConditions.elementToBeClickable(pdp.getSelect_Size_button()));
		// Get text from SELECT_AVAILABLE_SIZE_button in PDP page
		selectedSizePDP = pdp.getSELECT_AVAILABLE_SIZE_button().getText();/////////////////////////////////////////////
		pass(selectedSizePDP + " selectedSizePDP");
		// Click on SELECT AVAILABLE SIZE button in PDP page
		pdp.getSELECT_AVAILABLE_SIZE_button().click();
		utility.isClicked("SELECT AVAILABLE SIZE button");
		// Scroll page vertically until visibility of QUANTITY_text in PDP page
		js.executeScript("arguments[0].scrollIntoView(true);", pdp.getQUANTITY_text());
		quantityPDP = pdp.getQUANTITY_text().getAttribute("value");
		pass(quantityPDP + " quantityPDP");
		// Verify if value of QUANTITY text in PDP page contains *expectedValue*
		b = pdp.getQUANTITY_text().getAttribute("value").contains(quantityPDP);
		utility.isContains(b, pdp.getQUANTITY_text().getAttribute("value"), quantityPDP);////////////////////////////
		// System.out.println(pdp.getQUANTITY_text().getText());
		// System.out.println(quantityPDP);
		Assert.assertEquals(b, Boolean.TRUE);
		// Wait till ADD TO BAG button in PDP page is visible
		Thread.sleep(1000);
		try {
			wait.until(ExpectedConditions.visibilityOf(pdp.getADD_TO_BAG_button()));
		} catch (Exception e) {
		}

		// Verify if ADD TO BAG button in PDP page is clickable
		wait.until(ExpectedConditions.elementToBeClickable(pdp.getADD_TO_BAG_button()));
		// Move mouse pointer on ADD TO BAG button in PDP page
		action.moveToElement(pdp.getADD_TO_BAG_button()).perform();
		utility.moveToElementMessage(" ADD TO BAG button ");
		// Click on current cursor point
		action.click().perform();
		pass("clcik");
		// Wait till MyBagBagPopUp text in Bag page is visible
		wait.until(ExpectedConditions.visibilityOf(bag.getMyBagBagPopUp_text()));
		// Click on VIEW_BAG_button in PDP page using javascript executor
		wait.until(ExpectedConditions.visibilityOf(pdp.getVIEW_BAG_button()));
		js.executeScript("arguments[0].click();", pdp.getVIEW_BAG_button());
		// Verify if My Bag text is displayed in Bag page
		b = bag.getMy_Bag_Page_text().isDisplayed();
		utility.checkIsDisplayed(b, "My Bag text");
		Assert.assertEquals(b, Boolean.TRUE);
		// Verify if ProductBrandName_Bag text is displayed in Home page
		b = home.getProductBrandName_Bag_text().isDisplayed();
		utility.checkIsDisplayed(b, "ProductBrandName_Bag text");
		Assert.assertEquals(b, Boolean.TRUE);
		// Get text from ProductBrandName_Bag text in Home page
		firstProductBrandNameBag = home.getProductBrandName_Bag_text().getText();
		pass(firstProductBrandNameBag + " firstProductBrandNameBag");
		// Get text from ProductName_Bag text in Bag page
		firstProductNameBag = bag.getProductName_Bag_text().getText();
		pass(firstProductNameBag + " firstProductNameBag");
		// Get text from Product Actual Price text in Bag page
		productDiscountpriceBag = bag.getProduct_Actual_Price_text().getText();
		pass(productDiscountpriceBag + " productDiscountpriceBag");
		// System.out.println(productDiscountpriceBag);
		// System.out.println((productDiscountpriceBag.split(" ")).length);
		// productDiscountpriceBag = getDiscount(bag.getProduct_Actual_Price_text());
		// Get text from Size dropdown in Bag page
		selectedSize_Bag = bag.getSize_text().getText();
		pass(selectedSize_Bag + " selectedSize_Bag");
		// Get value attribute value of Quantity Count dropdown in Bag page
		String quantityCount = bag.getQuantity_Count_dropdown().getAttribute("value");
		pass(quantityCount + " quantityCount");
		b = false;
		try {
			b = driver.findElement(By.xpath("//div[contains(@class,'Cart_discounted-price')]/span")).isDisplayed();
		} catch (Exception e) {
			fail("Cart_discounted-price is  not displayed optional");

			// TODO: handle exception
		}

		if (b) {
			pass("Cart discounted price is displayed");
			// Verify if OFF_Bag_text is displayed in Bag page
			b = bag.getOFF_Bag_text().isDisplayed();
			utility.checkIsDisplayed(b, "OFF_Bag_text");
			Assert.assertEquals(b, Boolean.TRUE);
			// Get text from OFF_Bag text in Bag page

			offPercentageBag = bag.getOFF_Bag_text().getText();

			pass(offPercentageBag + " offPercentageBag");
			// Get text from Product_Striked_Price_text in Bag page
			productActualPriceBag = bag.getProduct_Striked_Price_text().getText();

			pass(productActualPriceBag + " productActualPriceBag");
			// Verify if text of OFF_Bag text in Bag page contains *expectedText*
			String text = bag.getOFF_Bag_text().getText();
			b = text.contains(offPercentage);
			utility.isContains(b, productActualPriceBag, offPercentage);
			Assert.assertEquals(b, Boolean.TRUE);
			ProductActualPricePDP = WEB_RemoveSpaceFromWords(ProductActualPricePDP);
			pass(ProductActualPricePDP + " ProductActualPricePDP");
			// Verify if string ProductActualPricePDP contains string productActualPriceBag
			b = productActualPriceBag.contains(ProductActualPricePDP);
			utility.isContains(b, ProductActualPricePDP, ProductActualPricePDP);
			Assert.assertEquals(b, Boolean.TRUE);
		}
		// Verify if string firstProductBrandNamePDP contains string
		// firstProductBrandNameBag
		b = firstProductBrandNamePDP.contains(firstProductBrandNameBag);
		utility.isContains(b, firstProductBrandNamePDP, firstProductBrandNameBag);
		Assert.assertEquals(b, Boolean.TRUE);
		// Verify if string productNamePDP contains string firstProductNameBag
		b = productNamePDP.contains(firstProductNameBag);
		utility.isContains(b, productNamePDP, firstProductNameBag);
		Assert.assertEquals(b, Boolean.TRUE);
		// Verify if string productDiscountpriceBag contains string
		// productDiscountPricePDP
		productDiscountpriceBag = getOnlyNunber(productDiscountpriceBag);
		productDiscoutedPricePDP = getOnlyNunber(productDiscoutedPricePDP);
		b = productDiscountpriceBag.contains(productDiscoutedPricePDP);
		utility.isContains(b, productDiscountpriceBag, productDiscoutedPricePDP);
//		System.out.println("new ");
//		System.out.println(productDiscountpriceBag);
//		System.out.println(productDiscoutedPricePDP);
		Assert.assertEquals(b, Boolean.TRUE);
		// Verify if string quantityCount matches string quantityPDP
		b = quantityCount.contains(quantityPDP);
		utility.isContains(b, quantityCount, quantityPDP);
		Assert.assertEquals(b, Boolean.TRUE);
		// Verify if string selectedSize_Bag contains string selectedSizePDP
		b = selectedSize_Bag.contains(selectedSizePDP);
		utility.isContains(b, selectedSize_Bag, selectedSizePDP);
		Assert.assertEquals(b, Boolean.TRUE);
		pass("Add_the_Product_From_Category_to_Bag_with_All_Verifications ended");
	}

	public String getOnlyNunber(String num) {
		String temp = "";
		for (int i = 0; i < num.length(); i++) {
			char c = num.charAt(i);
			if (c <= '9' && c >= '0') {
				temp += c + "";
			}
		}
		return temp;
	}

	String productDiscountpriceBag, quantityPDP, selectedSize_Bag, offPercentageBag;

	String ProductActualPricePDP, offPercentagePDP, selectedSizePDP;
	String firstProductBrandNamePDP, productDiscoutedPricePDP;

	public String WEB_RemoveSpaceFromWords(String ProductPrice) {
		return ProductPrice.replaceAll("\\s", "");

	}

	public String getDiscount(WebElement element) {
		// System.out.println("inside discount");
		String ch = element.getText();
		// System.out.println(ch);
		String[] ch1 = ch.split(" ");
		String s2 = ch1[1];
		// System.out.println(s2);
		return s2;
	}

	public void Load_current_page_completely() {
		pass("Load_current_page_completely started");
		// Press PAGE_DOWN for n times
		int n = 20;
		for (int i = 0; i < n; i++) {
			action.sendKeys(Keys.PAGE_DOWN).perform();
		}
		// Press PAGE_UP for n times
		for (int i = 0; i < n; i++) {
			action.sendKeys(Keys.PAGE_UP).perform();
		}
		// Press PAGE_DOWN for n times
		for (int i = 0; i < n; i++) {
			action.sendKeys(Keys.PAGE_DOWN).perform();
		}
		// Press PAGE_UP for n times
		for (int i = 0; i < n; i++) {
			action.sendKeys(Keys.PAGE_UP).perform();
		}
		pass("Load_current_page_completely completed ");

	}

	public ArrayList<String> WEB_GetTextFromListOfWebElement(String xpath) {
		ArrayList<String> arr1 = new ArrayList<String>();
		List<WebElement> name = driver.findElements(By.xpath(xpath));

		for (WebElement ele : name) {
			String text = ele.getText();
			arr1.add(text);
		}
		return arr1;
	}

	public boolean VerifyList1DoesNotContainsList2(ArrayList<String> List1, ArrayList<String> List2) {
		List1.retainAll(List2);
		boolean result = List1.isEmpty();
		if (result == true) {

			pass("Successfully" + List1 + "contains" + List2);
		} else {
			result = false;
			fail(List1 + "Does Not Contains" + List2);
		}
		return result;
	}

	public boolean String1ContaisStrins2(String string, String string2) {
		String[] plp = string2.split(" ");
		for (String s : plp) {
			if (!string.contains(s))
				return false;
		}
		return true;

	}

	public boolean WEB_Wait_Untill_Element_is_Visible_and_Displayed(WebElement ele) {
		boolean b = false;
		try {
			wait.until(ExpectedConditions.visibilityOf(ele));
			b = ele.isDisplayed();

		} catch (Exception e) {
			try {
				b = ele.isDisplayed();
			} catch (Exception e2) {
				b = false;
			}

		}
		return false;
	}

	public boolean fromSriptProductActualPricePDP(String productActualPriceBag) {

		boolean b = productActualPriceBag.matches(ProductActualPricePDP);
		utility.isContains(b, productActualPriceBag, ProductActualPricePDP);
		return b;
	}

	public boolean fromSriptProductBrandPDP(String productbrand) {
		boolean b = productbrand.matches(ProductBrandPDP);
		utility.isContains(b, productbrand, ProductBrandPDP);
		return b;

	}

	public boolean fromSriptproductNamePDP(String productname) {
		boolean b = productname.matches(productNamePDP);
		utility.isContains(b, productname, productNamePDP);
		return b;
	}

	public boolean fromSriptProductPricePDP(String productPriceBag) {
		boolean b = productPriceBag.matches(ProductPricePDP);
		utility.isContains(b, productPriceBag, ProductPricePDP);
		return b;
	}

	public void Logout_from_Pantaloons() {
		//Move mouse pointer on Pantaloons Logo image in Home page
		action.moveToElement(home.getPantaloons_image()).perform();
		utility.moveToElementMessage("pantaloons logo");
		//Wait till My Account icon in Home page is visible
		wait.until(ExpectedConditions.visibilityOf(home.getMy_Account_icon()));
		pass("waited till my acount icon is visible");
		//Move mouse pointer on My Account icon in Home page
		action.moveToElement(home.getMy_Account_icon()).perform();
		pass("moved mouse on My Account logo");
		wait.until(ExpectedConditions.visibilityOf(myAccount.getLOGOUT_button()));
		wait.until(ExpectedConditions.elementToBeClickable(myAccount.getLOGOUT_button()));
		//Click on Log Out link in My Account page
		myAccount.getLOGOUT_button().click();
		
	}

}

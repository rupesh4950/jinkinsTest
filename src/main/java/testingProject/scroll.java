package testingProject;

import static org.testng.Assert.expectThrows;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import generic.ScreenRecorderUtil;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class scroll {
	public static void main(String[] args) throws Exception {
		//AppiumDriver a=new AppiumDriver<WebElement>(null);
		//MobileDriver driv=a;
	//	ScreenRecorderUtil.startRecord("hi1");
		WebDriverManager.chromedriver().setup();
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().getPosition();
		System.out.println();
		//driver.manage().window().maximize();
		driver.get("https://amazon.in/");
		WebElement ele = driver.findElement(By.xpath("//h2[contains(text(),\"Today’s Deals\")]"));
		System.out.println(ele.getLocation());
		System.out.println(driver.manage().window().getSize());
		Actions a=new Actions(driver);
	//	a.sendKeys(Keys.PAGE_DOWN).perform();
		ele = driver.findElement(By.xpath("//h2[contains(text(),\"Today’s Deals\")]"));
		System.out.println(ele.getLocation());
		
		System.out.println(driver.manage().window().getSize());
		WebDriverWait wait=new WebDriverWait(driver, 0);
		int n=10;
		while (n>0) {
		try {
			ele = driver.findElement(By.xpath("//h2[contains(text(),\"Today’s Deals\")]"));
			Thread.sleep(500);
			a.moveByOffset(ele.getLocation().x, ele.getLocation().y).perform();
			//ele.click();
			System.out.println("element is visible");
			break;
		} catch (Exception e) {
			n--;
			System.out.println("failes to clcik");
			a.sendKeys(Keys.ARROW_DOWN).perform();
		}
		}
		driver.quit();
//		ScreenRecorderUtil.stopRecord();
//		
		
	}
}

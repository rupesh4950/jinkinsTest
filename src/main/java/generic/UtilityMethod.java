package generic;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Set;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;



public class UtilityMethod implements FrameworkConstants{
	
	public static WebDriver driver;
	public static ExtentReports report;
	public static ExtentTest test;
	public static WebDriverWait wait;
//	public static String URL;
	public static String browserName;
	public static  JavascriptExecutor js;
	public static Actions action;
	public static String className="";
	public static boolean bool;
	public static int shs,she,sms,sme,sss,sse,ihs,ihe,ims,ime,iss,ise;
	public static ArrayList<String >arr=new ArrayList<String>();


    public void initObjects() {
    	js=(JavascriptExecutor) driver;
    	action=new Actions(driver);
    }
    
    public static String name() {
    	LocalDateTime sysdate=LocalDateTime.now();
    	String name=sysdate.toString().replace(":", "-");
    	return name;
    }
//    public String get_Title() {
//    	String title=driver.getTitle();
//    	return title;
//    }
//    public String get_Url() {
//    	String currentUrl=driver.getCurrentUrl();
//    	return currentUrl;
//    }
//    
//    public void clickAction(WebElement element_To_Click) {
//    	element_To_Click.click();
//    }
//    public void enter_Value(WebElement textfield,String value) {
//    	textfield.sendKeys(value);
//    }
    public void switchToSpecificTitleWindow(String title) {
    	String parentWindowId=driver.getWindowHandle();
    	
    	Set<String> allWindow = driver.getWindowHandles();
    	allWindow.remove(parentWindowId);
    	
    	for(String windowId:allWindow) {
    		driver.switchTo().window(windowId);
    		if(driver.getTitle().equalsIgnoreCase(title))
    			break;
    	}
    }
    public void switchToSpecificWindow(WebElement element) {
    	String parent=driver.getWindowHandle();
    	Set<String> allWid = driver.getWindowHandles();
    	allWid.remove(parent);
    	for(String sessionId:allWid) {
    		driver.switchTo().window(sessionId);
    		if(element.isDisplayed())
    			break;
    	}
    }
    public static String getPhoto(WebDriver driver) {
    	String imgpath=SCREENSHOT_PATH+name()+".png";
    	TakesScreenshot t=(TakesScreenshot) driver;
    	File src=t.getScreenshotAs(OutputType.FILE);
    	File dest=new File(imgpath);
    	try {
    		FileUtils.copyFile(src, dest);
    	}
    	catch(Exception e) {
    		e.printStackTrace();
    	}
    	return "."+imgpath;
    }
    
    public String getValueProperty(String key) throws IOException {
    	FileInputStream fis=new FileInputStream(PROPERTIES_PATH);
    	Properties p=new Properties();
    	p.load(fis);
    	return p.getProperty(key);
    }
}

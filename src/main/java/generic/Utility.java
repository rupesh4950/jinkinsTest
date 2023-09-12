package generic;

import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import static extentReporter.ExtentLogger.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import com.google.common.util.concurrent.Uninterruptibles;
import io.github.bonigarcia.wdm.WebDriverManager;
public class Utility extends UtilityMethod{
	
	// Take Screenshot as BASE64 method
	public static String getBase64Image() throws DriverIsNullException {
		String screenshotAs = "";
		Uninterruptibles.sleepUninterruptibly(5,TimeUnit.SECONDS);
		if(Objects.isNull(driver)) {
			throw new DriverIsNullException("The Driver Object is Null when it reached Utility class");
		}else {
			screenshotAs = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
		}
		return screenshotAs;
	}

	public void suiteStartTime() {
		LocalDateTime now = LocalDateTime.now();
		shs = now.getHour();
		sms = now.getMinute();
		sss = now.getSecond();

	}

	public void classStartTime() {
		LocalDateTime now = LocalDateTime.now();
		ihs = now.getHour();
		ims = now.getMinute();
		iss = now.getSecond();
		  
		
	}

	public void clssEndTime() {
		LocalDateTime now = LocalDateTime.now();
		ihe = now.getHour();
		ime = now.getMinute();
		ise = now.getSecond();
		System.out.print("Time taken to execuite " + className+"    :   ");
		check("Time taken to execuite " + className+"    :   ",ihs, ims, iss,ihe, ime, ise);

	}

	public String suiteEndTime() {
		LocalDateTime now = LocalDateTime.now();
		she = (int) now.getHour();
		sme = (int) now.getMinute();
		sse = (int) now.getSecond();
		System.out.print ("Time taken to execuite suite:  ");
	return	check1("Time taken to execuite suite:  ",shs, sms, sss, she, sme, sse);
	}

	private String check1(String string, int shs, int sms, int sss, int she, int sme, int sse) {
		System.out.println(shs+" : "+sms+" : "+ sss+" ---- "+ she+" : "+sme+" : "+ sse);
		int h = she - shs;
		int m = 0;
		int s = 0;
		if (sme < sms) {
			h--;
			m = (60 - sms) + sme;
		} else {
			m = sme - sms;
		}
		if (sse < sss) {
			m--;
			s = (60 - sss) + sse;
		} else {
			s = sse - sss;
		}
		String prin=(h + " : " + m + " : " + s);
		System.out.println(h + " : " + m + " : " + s);
		return (prin);
	}

	public static void check(String s1,int shs, int sms, int sss, int she, int sme, int sse) {
		System.out.println(shs+" : "+sms+" : "+ sss+" ---- "+ she+" : "+sme+" : "+ sse);
		int h = she - shs;
		int m = 0;
		int s = 0;
		if (sme < sms) {
			h--;
			m = (60 - sms) + sme;
		} else {
			m = sme - sms;
		}
		if (sse < sss) {
			m--;
			s = (60 - sss) + sse;
		} else {
			s = sse - sss;
		}
		String prin=(s1+h + " : " + m + " : " + s);
		System.out.println(h + " : " + m + " : " + s);
		pass(prin);
		//test.log(Status.INFO,prin);
	}
	
	public  void OpenBrowser() {
		System.out.println("open browser");
		
		
		WebDriverManager.chromedriver().setup();
		
		
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		ChromeOptions cp = new ChromeOptions();
		// cp.addArguments("--headless");
		driver = new ChromeDriver(cp);
		driver.manage().deleteAllCookies();
		System.out.println("chreome lonched");
//		test.log(Status.PASS, "Browser is launched");
		driver.manage().window().maximize();
		driver.get("https://pantaloons.com/");
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		wait = new WebDriverWait(driver, TIMEOUTS_WAIT);
		bool=false;
		// Wait till I’ll do this later button in Home page is clickable
//		Home home = new Home(driver);
//		wait.until(ExpectedConditions.elementToBeClickable(home.getIlldothislater()));
//		// Click on I’ll do this later button in Home page
//		home.getIlldothislater().click();

		// URL=getValueProperty("https://www.google.com");
		initObjects();
	}
	public void BrowserInDeburger() throws Exception {
		String dir="C:\\DataOfDebugger";
		String cmdCommand = "chrome.exe -remote-debugging-port=9292 --no-first-run --no-default-browser-check --user-data-dir=" + dir;
		String chromePath = "C:\\Program Files\\Google\\Chrome\\Application";
		Runtime.getRuntime().exec("cmd /c start cmd.exe /K " + cmdCommand, null, new File(chromePath));
		Thread.sleep(500);
		System.setProperty("webdriver.http.factory", "jdk-http-client");
		WebDriverManager.chromedriver().setup();
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
//		Connect to launched browser	
		ChromeOptions opt = new ChromeOptions();
		opt.setExperimentalOption("debuggerAddress", "localhost:9292");
		opt.addArguments("--disable notifications");
		opt.addArguments("--remote-allow-origins=*");
//		
		 driver = new ChromeDriver(opt);
		Runtime.getRuntime().exec("taskkill /f /im cmd.exe");
		Runtime.getRuntime().exec("taskkill /F /FI \"WINDOWTITLE eq Terminal\"");
	
		driver.manage().window().maximize();
		driver.get("https://pantaloons.com/");
		bool=false;
		className="";
		initObjects();
	}

	public void checkAssert(boolean b, String string) {
		if(b) {
			pass(string);
		}
		else {
			fail(string);
		}
		
	}

	public void checkIsDisplayed(boolean b, String PrintStatement) {
		if(b) {
			pass(PrintStatement+"   is displayed");
		}
		else {
			fail(PrintStatement+"   is not displayed");
			Assert.assertEquals(b, true);
		}
		
	}

	public void isClicked(String s) {
		pass(s+" is Clicked");
		
	}

	public void moveToElementMessage(String s) {
		pass("mouse moved on to the "+s);
	}

	public void senKeys(String s, String string) {
		pass(s+" is enterd into "+string);
		
	}
	public void isContains(boolean b, String v1,String v2) {
		if(b) {
			pass(v1+" contains "+v2);
		}
		else {
			fail(v1+" dose not contains "+v2);
		}
	}

	public void isEquals(Boolean b, String v1, String v2) {
		
		if(b) {
			pass(v1+" equals "+v2);
		}
		else {
			fail(v1+"  not equals "+v2);
		}
	}

	public void isMatches(boolean b, String v1, String v2) {
		if(b) {
			pass(v1+" matches "+v2);
		}
		else {
			fail(v1+"  not matches "+v2);
		}
		
	}
	public static String getCurrentDateAndTime() {
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd_MM_yyyy hh-mm-ss a")).toUpperCase();
	}

	public void isWaited(String string,String reason) {
		
		pass("waited till "+string+" is "+reason);
	}
	

	
}
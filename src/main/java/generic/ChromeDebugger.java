package generic;

import java.awt.AWTException;
import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class ChromeDebugger {

	public static void main(String[] args) throws AWTException, InterruptedException, IOException {
		String msDURL="https://www.pantaloons.com/";
		String dir="C:\\DataOfDebugger";
		String cmdCommand = "chrome.exe -remote-debugging-port=9292 --no-first-run --no-default-browser-check --user-data-dir=" + dir;
		String chromePath = "C:\\Program Files\\Google\\Chrome\\Application";
		Runtime.getRuntime().exec("cmd /c start cmd.exe /K " + cmdCommand, null, new File(chromePath));
		Thread.sleep(500);
		System.setProperty("webdriver.http.factory", "jdk-http-client");
		
//		Connect to launched browser	
		ChromeOptions opt = new ChromeOptions();
		opt.setExperimentalOption("debuggerAddress", "localhost:9292");
		opt.addArguments("--disable notifications");
		opt.addArguments("--remote-allow-origins=*");
//		
		WebDriver driver = new ChromeDriver(opt);
		Runtime.getRuntime().exec("taskkill /f /im cmd.exe");
		Runtime.getRuntime().exec("taskkill /F /FI \"WINDOWTITLE eq Terminal\"");
	
		driver.manage().window().maximize();
		//Time Starts here
		long start = System.currentTimeMillis();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get(msDURL);
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//a[@title='Pantaloons']")).click();
		
		long end = System.currentTimeMillis();
    	NumberFormat formatter = new DecimalFormat("#0.00000");
    	System.out.print("Execution time is " + formatter.format((end - start) / 1000d) + " seconds");

		
		
		
	}
}

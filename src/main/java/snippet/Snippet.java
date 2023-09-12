package snippet;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Snippet {
	public static void main(String[] args) {
		 WebDriverManager.chromedriver().setup();
		 System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		 ChromeOptions op=new ChromeOptions();
		 op.setBinary("C:\\Program Files\\BraveSoftware\\Brave-Browser\\Application\\brave.exe");
		 WebDriver driver=new ChromeDriver(op);
	}
}


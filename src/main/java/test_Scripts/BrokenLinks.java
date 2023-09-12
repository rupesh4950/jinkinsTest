package test_Scripts;

import java.net.URL;

import java.util.List;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.net.HttpURLConnection;

public class BrokenLinks {

	public static void main(String[] args) throws Exception {
		chek("https://amazon.com/", "C:\\Users\\DELL\\OneDrive\\Desktop\\folder.txt");
	}

	private static void chek(String ip, String path) throws Exception {
		File f = new File(path);
		BufferedReader br = new BufferedReader(new FileReader(f));
		String st;
		while ((st = br.readLine()) != null) {
			 verifyLink(ip, st);
		}

//		// Finding all the available links on webpage
//		List<WebElement> links = driver.findElements(By.tagName("a"));
//
//		// Iterating each link and checking the response status
//		for (WebElement link : links) {
//			String url = link.getAttribute("href");
//			verifyLink(url);
//		}

	}
	public static void verifyLink(String ip, String path) {
		String url = ip + path;
		// System.out.println(url);
		try {
			URL link = new URL(url);
			HttpURLConnection httpURLConnection = (HttpURLConnection) link.openConnection();
			httpURLConnection.setConnectTimeout(3000); // Set connection timeout to 3 seconds
			httpURLConnection.connect();
			int code=httpURLConnection.getResponseCode();
			if (code < 400) {
				System.out.println(url + " - " + httpURLConnection.getResponseMessage()+"    "+code);
			} else {
			//	System.out.println(url + " - " + httpURLConnection.getResponseMessage() + " - " + "is a broken link"+ "   "+ code);
			}
		} catch (Exception e) {
		//	System.out.println("warning !!! "+url + " - " + "is b broken link");
		}
	}

}

package test_Scripts;

import static extentReporter.ExtentLogger.pass;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class hlo {
public static void main(String[] args) throws Exception {
	String path="//android.view.ViewGroup[@resource-id='android:id/group_message_container']";
	DesiredCapabilities cap = new DesiredCapabilities();
	cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
	cap.setCapability(MobileCapabilityType.NO_RESET, true);
	URL url = new URL("http://localhost:4723/wd/hub");
	AndroidDriver mobileDriver = new AndroidDriver(url, cap);
//	pass("connected to device");
	mobileDriver.openNotifications();
	pass("Opened notification in mobile");
	//"//android.widget.TextView[@resource-id='android:id/message_text']
	String OTP = mobileDriver
			.findElement(By.xpath(path)).getText();
	System.out.println(OTP);
	 String onlyNumberOTP = OTP.replaceAll("[^0-9]", "").trim().substring(0, 6);
	 System.out.println(onlyNumberOTP);
	String mob[] = { onlyNumberOTP };
	for (String string : mob) {
		System.out.println(string +"index from o");
	}
	System.out.println(onlyNumberOTP);
}
}

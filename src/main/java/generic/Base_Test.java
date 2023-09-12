package generic;

import java.io.IOException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import extentReporter.ExtentConfig;

public class Base_Test extends UtilityMethod {
	Utility utility = new Utility();

	@BeforeSuite
	public void beforeSuite() {
		className = "NotEnterd";
		ExtentConfig.extentConfig();
	}

	@BeforeClass(alwaysRun = true)
	public void browserSetup() throws IOException {

		utility.classStartTime();

	}

	TakeSCreenShort ts = new TakeSCreenShort();

	@AfterClass
	public void CloseApp() throws Exception {
		ScreenRecorderUtil recordScript = ExtentConfig.getScriptTecorderObj();
		if(screenRecordScriptAll) {
			ScreenRecorderUtil.stopRecord(recordScript);
		}
		else if (screenRecordForFailedScripts){
			ScreenRecorderUtil.stopRecord(recordScript);
			//ScreenRecorderUtil.
		//	ScreenRecorderUtil.delete();
		}
		utility.clssEndTime();
		System.out.println(className + " :  " + bool);
//		Set<String> l = driver.getWindowHandles();
//		for (String string : l) {
//			driver.switchTo().window(string);
//			driver.close();
		
	//	}
		if(closeBrowser)
			driver.quit();
	}

	@AfterSuite
	public void afterSuite() {
		// report.
		ExtentConfig.flushExtentReport();
		System.out.println(arr);
	}
}

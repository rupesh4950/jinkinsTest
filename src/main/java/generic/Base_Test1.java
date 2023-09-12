package generic;

import java.io.IOException;
import java.util.Set;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class Base_Test1 extends UtilityMethod{
	public String className="";
	TakeSCreenShort ts=new TakeSCreenShort();
	public boolean bool=false;
//	@BeforeSuite
//	public void beforeSuite(){
//		ts.suiteStartTime();
//		report=new ExtentReports(REPORTS_PATH+name()+"1111.pdf");
//		test=report.startTest(TEST_NAME);
//	}
	
	@BeforeClass(alwaysRun = true)
	public void browserSetup() throws IOException, InterruptedException {
		// ts.classStartTime();
	
	}
	
	@AfterClass
	public void CloseApp() throws Exception {
	//	ExtentConfig.
		//System.out.println(className+"  "+bool);
		ts.getScrennShort(className,bool);
		//driver.quit();
		Set<String> l = driver.getWindowHandles();
		for (String string : l) {
			driver.switchTo().window(string);
			driver.close();
		}
		//ts.clssEndTime();

	//	test.log(LogStatus.INFO,"End Test");
		//Thread.sleep(10000);
	}
//	@AfterSuite
//	public void afterSuite() {
//		ts.suiteEndTime();
//		report.endTest(test);
//		report.flush();
//		System.out.println(arr);
//	}

}

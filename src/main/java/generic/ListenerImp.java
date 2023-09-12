package generic;

import java.util.Arrays;
import org.testng.ISuite;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import extentReporter.ExtentConfig;
import extentReporter.ExtentLogger;

public class ListenerImp extends Base_Test implements ITestListener{
	//This is like @BeforeSuite
	Utility utility=new Utility();
	public void onStart(ISuite arg0) {
		
		ExtentConfig.extentConfig();		
	}
	
	//This is like @AfterSuite
	public void onFinish(ISuite arg0) {
		
		//spark.config().setReportName("Pantaloons Automation Report"+" | Suite Duration : "+overAllExecutionTime);
		ExtentConfig.flushExtentReport();
		
	}

	//This is like @BeforeMethod
	public void onTestStart(ITestResult result) {
		String name = result.getTestClass().toString();
		
		String[] strArray = name.split("test_Scripts.");
		name=strArray[1].strip().substring(0, strArray[1].length()-1);
		
		ExtentConfig.createTest("Script Name : "+name);
	
//		ExtentConfig.createTest("Hmoow");
	}

	public void onTestSuccess(ITestResult result) {
		ExtentLogger.pass(result.getMethod().getDescription()+" script is PASSED");
		
	}
	
	
	public void onTestFailure(ITestResult result) {
		//String logMessString = result.getMethod().getMethodName()+" script is FAILED";
		//ExtentLogger.fail("Log Message : "+logMessString,true);
		
		String exceptionName = result.getThrowable().toString();
		ExtentLogger.fail(result.getMethod().getDescription()+" script is FAILED");
		ExtentLogger.fail("Exception Name : "+exceptionName);
		
		String stackTrace = Arrays.toString(result.getThrowable().getStackTrace());
		ExtentLogger.fail("Stack Trace : "+stackTrace);
		
		ExtentLogger.fail(result.getMethod().getDescription()+" script is FAILED");
		
	}
	
	public void onTestSkipped(ITestResult result) {
		ExtentLogger.skip(result.getMethod().getDescription()+" script is SKIPPED",true);
	}
     UtilityMethod um=new UtilityMethod();
	



	

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		
	}

	public void onStart(ITestContext context) {
		
	}

	public void onFinish(ITestContext context) {
	
	}
	
	

}

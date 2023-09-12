package extentReporter;

import java.util.Objects;
import generic.FrameworkConstants;
import generic.ScreenRecorderUtil;
import generic.Utility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

//This class is final because no one should extend it
public final class ExtentConfig implements FrameworkConstants {
	static String dateTime="";
	// This is because no one should create object for this
	static ExtentSparkReporter spark;
	public  static ScreenRecorderUtil suiteRecorderObj,scriptRecorderObj;
	public static String testCaseName="";
	public static String getDateTime() {
		return dateTime;}
	public static String getTestCaseName() {
		return testCaseName;
		
	}
	public static ScreenRecorderUtil getScriptTecorderObj() {
		return scriptRecorderObj;	
	}
	static Utility utility = new Utility();
	static int i=0;
	
	private ExtentConfig() {
	}

	private static ExtentReports extent;

	// Thread safety for ExtentTest object
	private static ThreadLocal<ExtentTest> tl = new ThreadLocal<ExtentTest>();

	// Keep these methods as default modifier(not specifying any modifier), so that
	// these can be accessed only within the package
	static ExtentTest getExtentTest() {
		return tl.get();
	}

	static void setExtentTest(ExtentTest test) {
		tl.set(test);
	}

	static void removeExtentTest() {
		tl.remove();
	}

	// To configure extent reports. Call this method in @BeforeSuite
	public static void extentConfig() {
		dateTime = utility.getCurrentDateAndTime();
		if (Objects.isNull(extent)) {
			String dateTime = Utility.getCurrentDateAndTime();
			System.out.println(dateTime);
			String path = "Report - " + dateTime;
			if (screenRecordSuite) {
				try {
					suiteRecorderObj=	ScreenRecorderUtil.startRecord(path);
				//	System.out.println("recording started");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			utility.suiteStartTime();
			dateTime = Utility.getCurrentDateAndTime();
			System.out.println(dateTime);
			
			path = "Report - " + dateTime + ".html";
			
			extent = new ExtentReports();
			spark = new ExtentSparkReporter(FrameworkConstants.REPORTS_PATH + path); // path and name of report file
			extent.attachReporter(spark);
			
			spark.config().setTheme(Theme.STANDARD);
			spark.config().setDocumentTitle("ABFRL Document Title"); // HTML title
			spark.config().setReportName("Pantaloons Web Automation"); // This name will be displayed inside the report
																		// at right top corner

		}
	}

	// To create a entry of script in extent reports. This method will be called in
	// every scripts
	public static void createTest(String testCaseName1)// (, String... group)
	
	{
		testCaseName=testCaseName1;
		//In this method every time the screenrecord is  tryes to stop and then it will start 
//		System.out.println(testCaseName);
//		System.out.println(testCaseName.split(": ")[1].strip());
//		System.out.println(testCaseName.split(": ")[0].strip());
		testCaseName=testCaseName.split(": ")[1].strip();
		if(screenRecordScriptAll){
		{
			try {
				
				scriptRecorderObj=ScreenRecorderUtil.startRecord(testCaseName);
				System.out.println("recording started");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		}
		
		ExtentTest test = extent.createTest(testCaseName);
		setExtentTest(test); // Insert ExtentTest object in ThreadLocal object
//		 getExtentTest().assignAuthor("Author Name");
//		 getExtentTest().assignDevice("Device Name");
		// getExtentTest().assignCategory(group);

	}

	// This method need to be called in @AfterSuite once the execution is completed
	// in order to push all the reports in html page
	public static void flushExtentReport() {
		// add additional details
		extent.setSystemInfo("Tester name", System.getProperty("user.name"));
		extent.setSystemInfo("Operating System", System.getProperty("os.name"));
		extent.setSystemInfo("Browser name", "Chrome");
		String time = utility.suiteEndTime();
		spark.config().setReportName("Pantaloons Automation Report" + " | Suite Duration : " + time);
		if (Objects.nonNull(extent)) {
			extent.flush();
		}
		if (screenRecordSuite) {
			try {
				ScreenRecorderUtil.stopRecord(suiteRecorderObj);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}

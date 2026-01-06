package ReusableCode;

import org.testng.annotations.BeforeMethod;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class TestReport {

	
	@BeforeMethod
	public static ExtentReports reportGen()
	{
		//ExtendReports  , ExtentSparkReporter  (This are main 2 classes here)
		String path = System.getProperty("user.dir")+"\\Reports\\index.html";
		ExtentSparkReporter report = new ExtentSparkReporter(path);
		report.config().setReportName("Web Autmation Results");
		report.config().setDocumentTitle("Test Results");
		
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(report);
		extent.setSystemInfo("Tester", "Shiv");
		return extent;
	}
	
	
	
}

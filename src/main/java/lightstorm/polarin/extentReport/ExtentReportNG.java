
package lightstorm.polarin.extentReport;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.IReporter;
import org.testng.IResultMap;
import org.testng.ISuite;
import org.testng.ISuiteResult;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.xml.XmlSuite;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;


public class ExtentReportNG implements IReporter{
	private ExtentReports extent;
	private ExtentTest extenttest;
	public WebDriver driver;
	ITestResult t;
	public  void generateReport( List<XmlSuite> xmlSuites, List<ISuite> suites, String filepath) {
		String FS = FileSystems.getDefault().getSeparator();
		String timeStamp = new SimpleDateFormat("yyyy-MM-dd_HHmmss").format(new Date());
		filepath = System.getProperty("user.dir") + FS + "ExecutionReport" + FS + "HtmlReport";
		// filepath="D:\\EclipsWorkspace\\lightstorm.polarin\\ExecutionReport\\HtmlReport"+timeStamp
		// + "_TestReport.html";
		extent = new ExtentReports(filepath+File.separator+timeStamp+"_TestReport.html", true);
		extent.assignProject("Polarin");
		for (ISuite suite : suites) {
			
			Map<String, ISuiteResult> result = suite.getResults();
			for (ISuiteResult r : result.values()) {
				ITestContext context = r.getTestContext();
				buildTestNodes(context.getPassedTests(), LogStatus.PASS);
				buildTestNodes(context.getFailedTests(), LogStatus.FAIL);
				buildTestNodes(context.getSkippedTests(), LogStatus.SKIP);
			}
		}
		extent.flush();
		extent.close();
	}

	private void buildTestNodes(IResultMap tests, LogStatus status)  {
		ExtentTest test;
		if (tests.size() > 0) {
			for (ITestResult result : tests.getAllResults()) {
				test = extent.startTest(result.getMethod().getMethodName());
				test.setStartedTime(getTime(result.getStartMillis()));
				
				test.setEndedTime(getTime(result.getEndMillis()));
				
				for (String group : result.getMethod().getGroups())
					test.assignCategory(group);
				
				if (result.getThrowable() != null) {
					test.log(status, result.getThrowable());
				} else {
					test.log(status, "Test " + status.toString().toLowerCase() + "ed");
				}
				extent.endTest(test);
			
			}

		}

	}

	private Date getTime(long millis) {
		Calendar calender = Calendar.getInstance();
		calender.setTimeInMillis(millis);
		return calender.getTime();
	}
}

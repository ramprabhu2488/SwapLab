package SwagResouces;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNG {
	
	/**
	 * This Method helps us to create the extend report.
	 * we can design, how our testcases should look like... 
	 * Report will only get generated, when we execute from TestSuite.{XML file}
	 * 
	 * To get the path, we have to create Listeners class
	 */

	
	
	public static ExtentReports getReportObject() {
		String path = System.getProperty("user.dir") + "\\reports\\index.html";
		//String path = System.getProperty("C:\\Users\\DeepakVaithylingam\\eclipse-workspace\\SwagLab\\reports\\index.html");
		//C:\Users\DeepakVaithylingam\eclipse-workspace\SwagLab\reports
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);

		reporter.config().setReportName("WebAutomationResults"); // TesterName
		reporter.config().setDocumentTitle("Test Results"); // TitleName

		ExtentReports extend = new ExtentReports();
		extend.attachReporter(reporter);
		extend.setSystemInfo("Tester", "Deepak");
		return extend;

	}
	
	
}

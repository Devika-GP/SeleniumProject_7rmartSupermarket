package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportUtility {

	public static final ExtentReports extentReports = new ExtentReports();

	public synchronized static ExtentReports createExtentReports() { // mult testcases should not collide so
																		// synchronisation is given
		ExtentSparkReporter reporter = new ExtentSparkReporter("./extent-reports/extent-report.html"); // LOCATION OF
																										// THE HTML REP
																										// TO BE
																										// GENERATED,./-directory,extent-reports-folder

		reporter.config().setReportName("7rmartsupermarket"); // config().setReportName("7Mart Project") 2 methods in
																// ExtentSparkReporter
		extentReports.attachReporter(reporter); // attaching od extend report and extendssparkrep for report generation
		extentReports.setSystemInfo("Organization", "Obsquara"); // org name
		extentReports.setSystemInfo("Name", "Devika"); // team membersname
		return extentReports; // createExtentReports() returns extentReports
	}
}

package Config;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Protocol;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.io.File;
import java.io.IOException;
import java.util.Date;

public class ExtentReporterNG
{
	static ExtentReports extent;
	public static String OSName = System.getProperty("os.name");
	public static String OSArchitecture = System.getProperty("os.arch");
	public static String OSVersion = System.getProperty("os.version");
	public static String OSBit = System.getProperty("sun.arch.data.model");

	public static ExtentReports getReportObject() throws IOException {
		String path =System.getProperty("user.dir")+"//Reports//AutomationTestReport.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("Mobile App Automation Results");
		reporter.config().setDocumentTitle("Test Results");
		extent =new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Browser", "Chorme Browser");
		extent.setSystemInfo("OS", OSName);
		extent.setSystemInfo("OS Version", OSVersion);
		extent.setSystemInfo("OS Architecture", OSArchitecture);
		extent.setSystemInfo("OS Bit", OSBit);
		extent.setSystemInfo("JAVA Version", System.getProperty("java.version"));
		extent.setSystemInfo("OS Bit", OSBit);
		reporter.config().setTheme(Theme.DARK);
		reporter.config().setEncoding("utf-8");
		reporter.config().setProtocol(Protocol.HTTPS);
		return extent;
	}
}
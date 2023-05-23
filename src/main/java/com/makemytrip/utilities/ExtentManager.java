package com.makemytrip.utilities;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager {
	public static ExtentHtmlReporter htmlreporter ;
	public static ExtentReports extent;
	public static ExtentTest test;
	
	public static void setExtent() {
		htmlreporter =new ExtentHtmlReporter(System.getProperty("user.dir")+"\\test-output\\extentreport\\makemytrip.html");		
		htmlreporter.loadXMLConfig(".\\extent-config.xml");
		htmlreporter.config().setDocumentTitle("MakeMyTrip");
		htmlreporter.config().setReportName("MakeMyTrip Report");
		htmlreporter.config().setTheme(Theme.DARK);
		extent=new ExtentReports();
		extent.attachReporter(htmlreporter);
		extent.setSystemInfo("Hostname", "MYPC");
		extent.setSystemInfo("OS", "Window 10");
		extent.setSystemInfo("Selenium", "4.1.2");
	}
	public static void endExtent() {
		extent.flush();
	}
	}

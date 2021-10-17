package com.clrtrp.qa.util;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReport {

	public static ExtentSparkReporter htmlReporter;
	public static ExtentReports extent;
	public static ExtentTest extentTest;
	
	public static ExtentReports HtmlReport() {
	
		htmlReporter=new ExtentSparkReporter("./report/extent.html");
		htmlReporter.config().setEncoding("utf-8");
		htmlReporter.config().setDocumentTitle("Automation Report");
		htmlReporter.config().setReportName("Automation Test Results");
		htmlReporter.config().setTheme(Theme.STANDARD);
	
		
		extent=new ExtentReports();
	
		extent.setSystemInfo("Organization", "Selenium");
		extent.setSystemInfo("Browser", "Chrome");
		extent.setSystemInfo("Author", "MUKESH MAURYA");
		extent.attachReporter(htmlReporter);
	
		return extent;
	}
}

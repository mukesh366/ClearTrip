package com.clrtrp.qa.util;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.clrtrp.qa.Base.Base;


public class Listener extends Base implements ITestListener{

	public static ExtentTest logger;
	public Listener() throws IOException {
		super();
		
	}

	public void onTestStart(ITestResult result) {
	}

	public void onTestSuccess(ITestResult result) {
		logger=ExtentReport.extent.createTest("Result");
		logger.pass("Test Pass Succesfully");
		
	}

	public void onTestFailure(ITestResult result) {
		System.out.println("The name of failed test cases is "+ result.getName());
			Screenshot.screenShot();
			
			
	}

	public void onTestSkipped(ITestResult result) {
		logger.skip(result.getTestClass().getName());
		System.out.println("The name of skipped test cases is "+ result.getName());
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
		
		
	}

	public void onStart(ITestContext context) {
		System.out.println(context.getName()+" test case started");
		
	}

	public void onFinish(ITestContext context) {
		System.out.println("The name of the testcase completed is :"+context.getName());	
		
	}

}

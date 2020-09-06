package com.clrtrp.qa.util;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.clrtrp.qa.Base.Base;


public class Listener extends Base implements ITestListener{

	public Listener() throws IOException {
		super();
		
	}

	public void onTestStart(ITestResult result) {
		
		
	}

	public void onTestSuccess(ITestResult result) {
		
		
	}

	public void onTestFailure(ITestResult result) {
		System.out.println("The name of failed test cases is "+ result.getName());
		
			Screenshot.screenShot();
	}

	public void onTestSkipped(ITestResult result) {
		System.out.println("The name of skipped test cases is "+ result.getName());
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		System.out.println("The name of failed test cases is "+ result.getName());
		
		
		
	}

	public void onStart(ITestContext context) {
		System.out.println(context.getName()+" test case started");
		
	}

	public void onFinish(ITestContext context) {
		System.out.println("The name of the testcase passed is :"+context.getName());	
		
	}

}

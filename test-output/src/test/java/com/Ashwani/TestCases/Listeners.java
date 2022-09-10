package com.Ashwani.TestCases;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;







public class Listeners extends BaseTest implements ITestListener  {
	String path;
	ExtentSparkReporter reporter;
	ExtentReports ex=config();
	ExtentTest test;
	WebDriver driver;
	ThreadLocal<ExtentTest> th;
	@Override
	public void onTestStart(ITestResult result) {
		th=new ThreadLocal<ExtentTest>();
	test=	ex.createTest(result.getMethod().getMethodName());
	th.set(test);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		th.get().fail(result.getThrowable());
		
		System.out.println(driver);
	  try {
		driver=	(WebDriver) result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
		
				
				
  
	System.out.println(driver);
	
		path = getScreensShot(result.getMethod().getMethodName(),driver);
		System.out.println(result.getMethod().getMethodName());
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}	
	
	  th.get().addScreenCaptureFromPath(path, result.getMethod().getMethodName());

	}


	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		ex.flush();
		
	}

	
	
}

package com.Listeners;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.Reports.Extent;
import com.Utils.Utils;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class Listeners extends Utils implements ITestListener {
	private ExtentReports extentReports;
	String testMethodName;
	ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();

	@Override
	public void onStart(ITestContext context) {
		extentReports = new Extent().getExtentReports();
	}

	@Override
	public void onFinish(ITestContext context) {
		extentReports.flush();
	}

	@Override
	public void onTestStart(ITestResult result) {
		testMethodName = result.getMethod().getMethodName();
		ExtentTest test = extentReports.createTest(testMethodName);
		extentTest.set(test);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		extentTest.get().log(Status.PASS, "Test Passed !");

	}

	@Override
	public void onTestSkipped(ITestResult result) {
		extentTest.get().log(Status.SKIP, "Test Skipped !");
	}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		extentTest.get().fail(result.getThrowable());

		WebDriver driver = null;
		try {
			driver = (WebDriver) result.getTestClass().getRealClass().getDeclaredField("driver")
					.get(result.getInstance());
			extentTest.get().addScreenCaptureFromPath(captureScreenShot(testMethodName, driver), testMethodName);
		} catch (Exception e) {
			System.out.println("unable to capture screenshot: " + e.getMessage());
			e.printStackTrace();
		}

	}

}

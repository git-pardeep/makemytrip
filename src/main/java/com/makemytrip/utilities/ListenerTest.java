package com.makemytrip.utilities;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.Status;
import com.makemytrip.base.BaseClass;

public class ListenerTest extends ExtentManager implements ITestListener {
	TakeScreenShot screenshot = new TakeScreenShot();
	public void onTestStart(ITestResult Result) {
		System.out.println("test on started");
		Reporter.log("test on started");
		Log.info("onTestStart " + Result.getName());
		test = extent.createTest(Result.getName());

	}

	public void onFinish(ITestContext Result) {
		System.out.println("test has been tested");
		Reporter.log("test has been tested" + Result.getName());
		Log.info("onfinish " + Result.getName());
		test.log(Status.PASS, "test finish"+Result.getName());

	}

	public void onStart(ITestContext Result) {
		System.out.println("test started");
		Reporter.log("test started" + Result.getName());
		Log.info("onstart " + Result.getName());
	
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult Result) {
		// TODO Auto-generated method stub

	}

	public void onTestFailure(ITestResult Result) {
		Reporter.log("screenshot failure test" + Result.getName());
		Log.info("onTestFailure " + Result.getName());
		if (Result.getStatus() == ITestResult.FAILURE) {
			test.log(Status.FAIL, " test fail " + Result.getName());
			screenshot.takeScreenShot();
		}

	}

	public void onTestSkipped(ITestResult Result) {
		System.out.println("test skipped");
		Reporter.log("test skipped");
		Log.info("onTestSkipped " + Result.getName());
	}

	

	public void onTestSuccess(ITestResult Result) {
		// TODO Auto-generated method stub

	}
}

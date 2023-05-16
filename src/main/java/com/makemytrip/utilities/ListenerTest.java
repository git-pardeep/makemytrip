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

import com.makemytrip.base.BaseClass;

public class ListenerTest extends BaseClass implements ITestListener {
	
	 public void onFinish(ITestContext Result) {					
	        System.out.println("test has been tested");			
	        		Reporter.log("test has been tested"+ Result.getName());
	    }	
	 public void onStart(ITestContext Result) {					
		 System.out.println("test started");			
		 Reporter.log("test started"+ Result.getName());		
	    }		

		
	    public void onTestFailedButWithinSuccessPercentage(ITestResult Result) {					
	        // TODO Auto-generated method stub				
	        		
	    }		
		
	    public void onTestFailure(ITestResult Result) {					
	    Reporter.log("screenshot failure test" +Result.getName());
	    	File srcFile = ((TakesScreenshot)getDriver()).getScreenshotAs(OutputType.FILE);
	    	Date d = new Date();
	    	String TimeStamp = d.toString().replace(":", "-").replace(" ", "_");
	    	try {
				FileUtils.copyFile(srcFile, new File("./Screenshots/" + "_" + TimeStamp + ".png"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        		
	    }		
		
	    public void onTestSkipped(ITestResult Result) {					
	    	System.out.println("test skipped");				
	        		Reporter.log("test skipped");
	    }		

	 		
	    public void onTestStart(ITestResult Result) {					
	    	System.out.println("test on started");	
	    	Reporter.log("test on started");
	        		
	    }		

			
	    public void onTestSuccess(ITestResult Result) {					
	        // TODO Auto-generated method stub				
	        		
	    }		
}

package com.makemytrip.utilities;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.makemytrip.base.BaseClass;

public class TakeScreenShot extends BaseClass {
public void takeScreenShot() {
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
}

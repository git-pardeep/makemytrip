package com.makemytrip.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.makemytrip.base.BaseClass;
import com.makemytrip.dataprovider.DataProvider1;
import com.makemytrip.pageobjects.HomePage;
import com.makemytrip.utilities.Log;
import com.makemytrip.utilities.ReadExcelFile;

public class HomePageTest extends BaseClass {
	HomePage hp;
	@Parameters("browser")
	@BeforeMethod
	public void setup(String browser) {
		launchBrowser(browser);
	}
	@AfterMethod
	public void tearDown() {
		closeBrowser();
	}

//	@Test(dataProvider="test1",dataProviderClass=DataProvider1.class)
	@Test(dataProvider="bvttest",dataProviderClass=ReadExcelFile.class)
	public void homePageTest(String from1 , String destination ) throws InterruptedException {
		 hp = new HomePage();
		 Log.startTest("gettitle");
		hp.title();
		Log.endTest("gettitle");
		Log.startTest("searchflight");
		hp.searchFlight(from1 ,destination);
		Log.startTest("saearchflight");
	}
}

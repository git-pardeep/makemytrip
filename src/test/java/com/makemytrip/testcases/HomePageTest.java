package com.makemytrip.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.makemytrip.base.BaseClass;
import com.makemytrip.dataprovider.DataProvider1;
import com.makemytrip.pageobjects.HomePage;
import com.makemytrip.utilities.ReadExcelFile;

public class HomePageTest extends BaseClass {
	HomePage hp;
	@BeforeMethod
	public void setup() {
		launchBrowser();
	}
	@AfterMethod
	public void tearDown() {
		closeBrowser();
	}

//	@Test(dataProvider="test1",dataProviderClass=DataProvider1.class)
	@Test(dataProvider="bvttest",dataProviderClass=ReadExcelFile.class)
	
	public void homePageTest(String from1 , String destination ) throws InterruptedException {
		 hp = new HomePage();
		hp.title();
		hp.searchFlight(from1 ,destination);
	}
}

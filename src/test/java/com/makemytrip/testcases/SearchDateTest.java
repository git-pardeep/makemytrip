package com.makemytrip.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.makemytrip.base.BaseClass;
import com.makemytrip.dataprovider.DataProvider1;
import com.makemytrip.pageobjects.ButtonClick;
import com.makemytrip.pageobjects.HomePage;
import com.makemytrip.pageobjects.SearchDate;
import com.makemytrip.utilities.Log;

public class SearchDateTest extends BaseClass{
	private HomePage hp ;
	private SearchDate sd;
	private ButtonClick bc;
	
	@Parameters("browser")
	@BeforeMethod
	public void setup(String browser) {
		launchBrowser(browser);
	}
	@AfterMethod
	public void tearDown() {
		closeBrowser();
	}
	@Test(dataProvider="test1",dataProviderClass= DataProvider1.class)
	public void searchDate(String from1 , String destination,String date1) throws InterruptedException {
		hp=new HomePage();
		Log.startTest("searchDate");
		sd=hp.searchFlight(from1,destination);
		bc=sd.dateSelect(date1);
		bc.searchFlight();
		Log.endTest("searchDate");
		
	}

}

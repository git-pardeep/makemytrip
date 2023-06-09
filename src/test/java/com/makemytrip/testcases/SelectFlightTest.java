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
import com.makemytrip.pageobjects.SelectFlight;
import com.makemytrip.utilities.Log;
import com.makemytrip.utilities.ReadExcelFile;

public class SelectFlightTest extends BaseClass{
	private HomePage hp ;
	private SearchDate sd;
	private ButtonClick bc;
	private SelectFlight sf ;
	
	
	@Parameters("browser")
	@BeforeMethod
	public void setup(String browser) {
		launchBrowser(browser);
	}
	@AfterMethod
	public void tearDown() {
		closeBrowser();
	}
	@Test(dataProvider="bvttest",dataProviderClass=ReadExcelFile.class)
	public void selectFlightTest(String from1 , String destination,String date1) throws InterruptedException {
		hp=new HomePage();
		Log.startTest("selectFlightTest");
		sd=hp.searchFlight(from1, destination);
		bc=sd.dateSelect(date1);
		sf=bc.searchFlight();
		sf.verifiedStop();
		Log.endTest("selectFlightTest");
	}
}

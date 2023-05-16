package com.makemytrip.dataprovider;

import org.testng.annotations.DataProvider;

public class DataProvider1 {
	@DataProvider(name = "test1")
	public Object[][] createData1() {
	 return new Object[][] {
	   { "Delhi", "new york" ,"Sat Jun 17 2023"},
	   { "Mumbai","London","Sun Jun 18 2023"},
	 };
	}
}

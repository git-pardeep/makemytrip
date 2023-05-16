package com.makemytrip.pageobjects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import org.testng.asserts.SoftAssert;

import com.makemytrip.base.BaseClass;

public class SelectFlight extends BaseClass {
	@FindBy(xpath = "//p[contains(text(),'1 stop') or contains(text(),'2 stop') or contains(text(),'3 stop') or contains(text(),'4 stop') ]")
	private List<WebElement> stop;

	public SelectFlight() {
		PageFactory.initElements(getDriver(), this);

	}

	SoftAssert softassert = new SoftAssert();

	public void verifiedStop() {
		for (WebElement stp : stop) {
			boolean st= stp.getText().contains("1 stop");
			if(st) {
			softassert.assertEquals(true,st);
//			Assert.assertEquals(stp, "1 stop");
			System.out.println(st);}
			Reporter.log(stp.getText());
			System.out.println(stp.getText());
		}
	}
}

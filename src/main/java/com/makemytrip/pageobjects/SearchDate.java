package com.makemytrip.pageobjects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import com.makemytrip.base.BaseClass;

public class SearchDate extends BaseClass {
	@FindBy(xpath="//span[text()='Departure']")
	private WebElement departure;
	@FindBy(xpath="//div[@class='DayPicker-wrapper']//div[@aria-disabled!='true']")
	private List<WebElement> date;
	public SearchDate() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public ButtonClick dateSelect(String date1) throws InterruptedException {
		departure.click();
		Thread.sleep(5000);
		System.out.println("success");
		Reporter.log("success ");
		System.out.println(date.size());
		Thread.sleep(2000);
		for (WebElement dt : date) {
			if (dt.getAttribute("aria-label").equals(date1)) {
				dt.click();
				Thread.sleep(2000);
				break;
			}
		}
		return new ButtonClick();
	}

}

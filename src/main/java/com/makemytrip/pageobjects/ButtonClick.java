package com.makemytrip.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.makemytrip.base.BaseClass;

public class ButtonClick extends BaseClass{
	@FindBy(xpath="//a[text()='Search']") private WebElement search;
	public ButtonClick() {
		PageFactory.initElements(getDriver(),this);
	}
	public SelectFlight  searchFlight() throws InterruptedException {
		search.click();
		Thread.sleep(5000);
		return new SelectFlight();
	}
	

}

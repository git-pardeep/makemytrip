package com.makemytrip.pageobjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

import com.makemytrip.base.BaseClass;

public class HomePage extends BaseClass {
	@FindBy(id = "fromCity")
	private WebElement from;
	@FindBy(xpath = "//input[@placeholder='From']")
	private WebElement sourcecity;
	@FindBy(id = "toCity")
	private WebElement to;
	@FindBy(xpath = "//input[@placeholder='To']")
	private WebElement tocity;

	public HomePage() {
		PageFactory.initElements(getDriver(), this);
	}
	public String getTitel() {
		String title=getDriver().getTitle();
		return title;
	}
	public void title() {
		String title = getDriver().getTitle();
		Reporter.log("Page Title is " +title);
		System.out.println("page title is "+title);
	}
	
	public  SearchDate searchFlight(String from1 , String destination) throws InterruptedException {
		from.click();
		sourcecity.sendKeys(from1);
		Thread.sleep(2000);
		sourcecity.sendKeys(Keys.ARROW_DOWN);
		Thread.sleep(2000);
		sourcecity.sendKeys(Keys.ENTER);
		to.click();
		tocity.sendKeys(destination);
		Thread.sleep(2000);
		tocity.sendKeys(Keys.ARROW_DOWN);
		Thread.sleep(2000);
		tocity.sendKeys(Keys.ENTER);
		return new SearchDate();
			
	}
}

package com.makemytrip.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.makemytrip.utilities.ExtentManager;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public static Properties prop = new Properties();
	public static FileInputStream fis;
	public static ThreadLocal<RemoteWebDriver> driver = new ThreadLocal<>();

	@BeforeSuite
	public void loadConfig()throws IOException {
		ExtentManager.setExtent();
		DOMConfigurator.configure("log4j.xml");
			fis = new FileInputStream(
					"C:\\java-test\\javaDemo\\SeleniumAutomationFramework\\makeMyTrip\\testdata\\config.properties");
			prop.load(fis);
	}

	public static WebDriver getDriver() {
		return driver.get();
	}

	public void launchBrowser(String browser) {
		if (browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver.set(new FirefoxDriver());
		}
		else if (browser.equalsIgnoreCase("chrome")){
			WebDriverManager.chromedriver().setup();
			driver.set(new ChromeDriver());
		} else {
			System.out.println("enetr valid browser");
		}
		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
		getDriver().get(prop.getProperty("url"));
	}

	@AfterSuite
	public static void closeBrowser() {
		ExtentManager.endExtent();
	}

}
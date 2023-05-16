package com.makemytrip.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public static Properties prop = new Properties();
	public static FileInputStream fis ;
	public static ThreadLocal<RemoteWebDriver > driver = new ThreadLocal<>();
	
	@BeforeSuite
	public void loadConfig() {
		try {
			fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\testdata\\config.properties");
			prop.load(fis);
		}
		catch(IOException e) {
			e.getStackTrace();
		}
	}
	public static WebDriver getDriver() {
		return driver.get();
	}
	public void launchBrowser() {
		if (prop.getProperty("browser").equalsIgnoreCase("firefox")) {
			FirefoxOptions options= new FirefoxOptions();
			options.addArguments("--disable-notifications");
			WebDriverManager.firefoxdriver().setup();
			driver.set(new FirefoxDriver(options));
		}else if (prop.getProperty("browser").equalsIgnoreCase("chrome")) {
			ChromeOptions co =new ChromeOptions();
			co.addArguments("--disable-notifications");
			WebDriverManager.chromedriver().setup();
			driver.set(new ChromeDriver(co));
		}else {
			System.out.println("enetr valid browser");
		}
		getDriver().manage().window().maximize();
		getDriver().manage().deleteAllCookies();
		getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		getDriver().get(prop.getProperty("url"));
	}
	@AfterSuite
	public void closeBrowser() {
		getDriver().close();
	}
	
	
}
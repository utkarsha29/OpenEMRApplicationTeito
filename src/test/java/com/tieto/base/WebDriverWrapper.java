package com.tieto.base;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.tieto.utilities.PropUtills;

public class WebDriverWrapper {
	protected WebDriver driver;

	@Parameters({"browser"})
	@BeforeMethod
	
//	@optional is added to avoid exception becuase if we give browser value in testng xml we are not able to execute 
//	this class from here.also in case if no parameter is given in xml in that case it will take value as ch from here.
	public void init(@Optional("ch") String browserName) throws IOException {
		
		System.out.println(browserName);
		System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
		System.setProperty("webdriver.gecko.driver", "driver/geckodriver.exe");
		
		if(browserName.toLowerCase().equalsIgnoreCase("ff")) {
			driver = new FirefoxDriver();
		}
		else if(browserName.toLowerCase().equalsIgnoreCase("ch")) {
			driver = new ChromeDriver();
		}
		else
		{
			driver = new InternetExplorerDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		String baseUrl=PropUtills.getValueFromKey("testdata/data.properties", "url");
		
		driver.get(baseUrl);

	}

	@AfterMethod
	public void end() {
		driver.quit();
	}

}

package com.qa.testbase;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.qa.utilities.ReadConfig;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LaunchBrowser {
	public static Logger log;
	public WebDriver driver;
	ReadConfig rc=new ReadConfig();
	public String readUrl=rc.readData();
	
	@BeforeClass
	public void openBrowsers() {
		log=LogManager.getLogger(LaunchBrowser.class);
		String Browser="Chrome";
		
		if (Browser.equals("Chrome")) {
			WebDriverManager.chromedriver().setup();
			driver =new ChromeDriver();
			log.info("Chrome Browser launch successfully");
		}else if(Browser.equals("FireFox")) {
			WebDriverManager.firefoxdriver().setup();
			driver =new FirefoxDriver();
		}else if(Browser.equals("Edge")) {
			WebDriverManager.edgedriver().setup();
			driver =new EdgeDriver();

		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(readUrl);
		log.info("Browser launch successfully");
		
		
	}
	
	@AfterClass
	public void closeBrowser() {
		
		driver.close();
	}
	
	public void screenshot(WebDriver driver, String tname) {
		
		try {
			TakesScreenshot ts=(TakesScreenshot)driver;
			File source=ts.getScreenshotAs(OutputType.FILE);
			File dest=new File(System.getProperty("user.dir")+"/Screenshots/"+tname+".png");
			FileUtils.copyFile(source, dest);
			log.info("Screenshot taken successfully");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	

}

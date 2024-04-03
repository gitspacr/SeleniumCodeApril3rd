package com.qa.pagelayer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.testbase.LaunchBrowser;

public class LandingPage extends LaunchBrowser{
	
	WebDriver driver;
	
	
	@FindBy (id="btn2")
	WebElement skipBtn;
	
	public LandingPage(WebDriver rdriver) {
		driver=rdriver;
		PageFactory.initElements(driver, this);
	}
	
	
	public void clickOnskipSignin() {
		
		skipBtn.click();
		
	}

}

package com.qa.pagelayer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.testbase.LaunchBrowser;

public class RegistrationPage extends LaunchBrowser{
	
	WebDriver driver;
	
	@FindBy (xpath="//input[@placeholder='First Name']")
	WebElement firstname;
	
	@FindBy (xpath="//input[@placeholder='Last Name']")
	WebElement lastname;
	
	@FindBy (xpath="//input[@ng-model='EmailAdress']")
	WebElement emailID;
	
	@FindBy (xpath="//input[@ng-model='Phone']")
	WebElement phoneNumber;
	
	@FindBy (xpath="//input[@value='FeMale']")
	WebElement rdbtn;
	
	@FindBy (xpath="//input[@value='Cricket']")
	WebElement checkBox;
	
	@FindBy (xpath="//button[@value='Refresh']")
	WebElement refreshBtn;
	
	public RegistrationPage(WebDriver rdriver){
		
		driver=rdriver;
		PageFactory.initElements(driver, this);		
	}
	
	public void registrationForm(String firstName,String lastName,String eid,String phoneNo) throws Exception {
		firstname.sendKeys(firstName);
		lastname.sendKeys(lastName);
		emailID.sendKeys(eid);
		phoneNumber.sendKeys(phoneNo);
		if(!(rdbtn.isSelected())) {
			rdbtn.click();
		}else {
			System.out.println("selected");
		}
		checkBox.click();
		screenshot(driver,"registerFormWithValue");
		Thread.sleep(3000);
		refreshBtn.click();
		log.info("registration form refreshed");
	}

}

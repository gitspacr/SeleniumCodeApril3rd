package com.qa.testlayer;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.qa.pagelayer.LandingPage;
import com.qa.pagelayer.RegistrationPage;
import com.qa.testbase.LaunchBrowser;
import com.qa.testdata.ReadDataFromExcel;

public class TC_001_Registrationform extends LaunchBrowser{
	RegistrationPage rp;
	
	LandingPage lp;
	
	
	@Test(dataProvider="supplyData", dataProviderClass=ReadDataFromExcel.class)
	public void tovalidateRegistrationForm(String firstName,String lastName,String eid,String phoneNo) throws Exception {
		lp=new LandingPage(driver);
		lp.clickOnskipSignin();
		rp=new RegistrationPage(driver);
		rp.registrationForm(firstName,lastName,eid,phoneNo);
		screenshot(driver,"registerFormWithoutValue");
		log.info("registration form success");
	}
	
	
	
	
	
	
	
	
	

}

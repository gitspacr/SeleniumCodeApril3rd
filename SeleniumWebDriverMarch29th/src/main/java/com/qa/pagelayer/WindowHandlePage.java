package com.qa.pagelayer;

import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.testbase.LaunchBrowser;

public class WindowHandlePage extends LaunchBrowser {
	
	WebDriver driver;
	String parentWindow;
	
	@FindBy (xpath="//a[text()='SwitchTo']")
	WebElement switchTomenu;
	
	@FindBy (xpath="//a[text()='Windows']")
	WebElement winLink;
	
	@FindBy (xpath="(//button[@class='btn btn-info'])[1]")
	WebElement winClick;

	@FindBy (xpath="//a[text()='Open New Seperate Windows']")
	WebElement newWin;
	
	@FindBy (xpath="//button[@class='btn btn-primary']")
	WebElement newWinClick;
	
	public WindowHandlePage(WebDriver rdriver) {
		driver=rdriver;
		PageFactory.initElements(driver, this);
	}
	
	
	public void hoverOnMenu() {
		Actions action=new Actions(driver);
		action.moveToElement(switchTomenu).build().perform();
		action.click(winLink).build().perform();
		String currentURL= driver.getCurrentUrl();
		System.out.println(currentURL);
	
	}
	
	public void clickOnNewTab() {
		parentWindow=driver.getWindowHandle();
		System.out.println(parentWindow);
		winClick.click();

	}
	
	public void clickOnNewWindow() {
		parentWindow=driver.getWindowHandle();
		System.out.println(parentWindow);
		newWin.click();
		newWinClick.click();

	}
	
	public void windowHandle() {
		
		Set<String> childWindow=driver.getWindowHandles();
		System.out.println(childWindow);
		for (String handles : childWindow) {
			if(!handles.equals(parentWindow)) {
				driver.switchTo().window(handles);
				screenshot(driver,"childwindow1");
				System.out.println(driver.getCurrentUrl());
				driver.close();
			}
			
		}
		driver.switchTo().window(parentWindow);
		System.out.println(driver.getCurrentUrl());
		driver.quit();
		screenshot(driver,"parentwindow");

	}
	
	
	
}

package org.appium.ios.testcase;

import org.appium.pageobject.ios.HomePage;
import org.testng.annotations.Test;

import Config.AndroidBase;
import Config.IOSBase;

public class CaptureAlertMessage_TC extends IOSBase{

	@Test
	public void captureAlert_Testcase(){
		HomePage page = new HomePage(driver);
		page.navigateToAlertPage();
		
	}
	
}

package org.appium.android.testcase;

import org.testng.annotations.Test;
import org.appium.pageobject.android.HomePage;
import org.testng.annotations.Test;

import Config.AndroidBase;

public class LongPress_TC extends AndroidBase{

	@Test
	public void longPress_Testcase(){
		HomePage page = new HomePage(driver);
		page.navigateToPreference();
		
	}
	
}

package org.appium.pageobject.android;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import Helper.AndroidActions;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class HomePage extends AndroidActions{

	AndroidDriver driver;

	public HomePage(AndroidDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(accessibility= "Preference")
	private WebElement preference;
	
	@AndroidFindBy(accessibility= "3. Preference dependencies")
	private WebElement option3;

	@AndroidFindBy(id= "android:id/checkbox")
	private WebElement checkBox;
	
	public void navigateToPreference(){
		click(preference);
	}
	
	
	
	

}

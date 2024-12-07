package org.appium.pageobject.ios;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import Helper.AndroidActions;
import Helper.IOSActions;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class HomePage extends IOSActions{

	IOSDriver driver;

	public HomePage(IOSDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@iOSXCUITFindBy(accessibility= "Alert Views")
	private WebElement alertViews;
	
	@iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`name == 'Text Entry'`]")
	private WebElement textEntry;

	@iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeOther")
	private WebElement textfiled;
	
	@iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`name == 'OK'`]")
	private WebElement okButton ;
	
	@iOSXCUITFindBy(iOSNsPredicate = "value == 'Confirm / Cancel'")
	private WebElement confirmOrCancel ;
	
	@iOSXCUITFindBy(iOSNsPredicate = "value BEGINSWITH[c] 'A message' ")
	private WebElement message ;
	

			
	public void navigateToAlertPage(){
		click(alertViews);
		click(textEntry);
		senkeys(textfiled,"Sathesh");
		click(okButton);
		click(confirmOrCancel);
		print(message);
	}
}

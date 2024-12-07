package Helper;

import org.openqa.selenium.WebElement;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;

public class IOSActions {
	
	IOSDriver driver;
	
	public IOSActions(IOSDriver driver2) {
		this.driver = driver;
	}

	public void click(WebElement element) {
		element.click();
	}
	
	public void senkeys(WebElement element,String value) {
		element.sendKeys(value);
	}
	
	public void print(WebElement element) {
		System.out.println(element.getText());
	}

	
	
	
	
	
}

package Helper;

import org.openqa.selenium.WebElement;

import io.appium.java_client.android.AndroidDriver;

public class AndroidActions {
	
	AndroidDriver driver;

	public AndroidActions(AndroidDriver driver) {
		this.driver = driver;
	}
	
	public void click(WebElement element) {
		element.click();
	}

	
	
	
	
	
}

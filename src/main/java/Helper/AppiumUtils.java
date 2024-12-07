package Helper;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import io.appium.java_client.AppiumDriver;

public class AppiumUtils {
	
	public String takeScreenshotAtEndOfTest(String testname,AppiumDriver driver) throws IOException {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir") + "/reports/" + testname + ".png";
		FileUtils.copyFile(scrFile, new File(currentDir));
		return currentDir;
	}
}

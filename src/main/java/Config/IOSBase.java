package Config;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.UnreachableBrowserException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class IOSBase {
	public static Properties properties = null;
	public static IOSDriver driver;
	public AppiumDriverLocalService service;

	public Properties loadpropertiesfile() throws IOException {
		FileInputStream fileinputstream = new FileInputStream(
				System.getProperty("user.dir") + "//src//main//resources//config_ios.properties");
		properties = new Properties();
		properties.load(fileinputstream);
		return properties;
	}

	@BeforeClass
	public void configuration() throws IOException, InterruptedException, URISyntaxException {
		loadpropertiesfile();
		String ipAddress = properties.getProperty("ipAddress");
		int portNumber = Integer.parseInt(properties.getProperty("portNumber"));
		String deviceDetails = properties.getProperty("deviceDetails");
		String appDetails = properties.getProperty("appDetails");
		String versionDetails = properties.getProperty("versionDetails");
		String platformDetails = properties.getProperty("platformDetails");
		
		Map<String, String> env = new HashMap<>();
		//env.put("ANDROID_HOME", "//users//satheshkumarmurugan//Library//Android//sdk");
		AppiumServiceBuilder builder = new AppiumServiceBuilder()
				.withAppiumJS(new File("//usr//local//lib//node_modules//appium//build//lib//main.js"))
				.withIPAddress(ipAddress).usingPort(portNumber).withEnvironment(env).withTimeout(Duration.ofMinutes(1));
		service = builder.build();
		service.start();

		XCUITestOptions options = new XCUITestOptions();
		options.setDeviceName(deviceDetails);
		options.setApp(appDetails);
		options.setPlatformVersion(versionDetails);
		options.setPlatformName(platformDetails);
		options.setWdaLaunchTimeout(Duration.ofSeconds(20));

		driver = new IOSDriver(builder, options);
		driver.manage().timeouts().implicitlyWait(Duration.ofMinutes(1));
		Thread.sleep(10000);
	}

	@AfterClass
	public void teardown() throws IOException {

		try {
			service.stop();
			driver.quit();
		} catch (UnreachableBrowserException e) {

		}
	}

}
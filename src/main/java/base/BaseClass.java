package base;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import pages.Calculator;
import pages.Calculator_android;
import pages.Calculator_ios;
import pages.HomePage;
import pages.HomePage_android;
import pages.HomePage_ios;
import utils.Configuration;

public class BaseClass {
	
	public static WebDriver driver;
	public Configuration configuration = new Configuration();
	protected Calculator calculator;
	protected HomePage homePage;
	
	@Parameters("automationType")
	@BeforeMethod
	public void setUp(String automationType) {
		DesiredCapabilities dc;
		
		switch (automationType) {
		case "installedApp":
			dc = capsForInstalledApp();
			break;
		case "installationFile":
			dc = capsForInstallationFile();
			break;
		case "mobileBrowser":
			dc = capsForWebView();
			break;
		default:
			dc = capsForWebView();
			break;
		}
		
		try {
			URL url = new URL(configuration.getProperty("urlPath"));
			driver = new RemoteWebDriver(url,dc);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		initClasses();
	}
	
	public DesiredCapabilities capsForInstalledApp() {
		DesiredCapabilities dc = new DesiredCapabilities();
		String platform = configuration.getProperty("devicePlatform");
		if(platform.equalsIgnoreCase("android")) {
			dc.setPlatform(Platform.ANDROID);
			dc.setCapability("appActivity", configuration.getProperty("appActivity"));
			dc.setCapability("appPackage", configuration.getProperty("appPackage"));
		}else if(platform.equals("ios")){
			dc.setPlatform(Platform.IOS);
		}
		dc.setVersion(configuration.getProperty("devcieVersion"));
		
		return dc;
	}
	
	public DesiredCapabilities capsForInstallationFile() {
		DesiredCapabilities dc = new DesiredCapabilities();
		String platform = configuration.getProperty("devicePlatform");
		if(platform.equalsIgnoreCase("android")) {
			dc.setPlatform(Platform.ANDROID);
			dc.setCapability("app", new File(configuration.getProperty("appLocation")).getAbsolutePath());
		}else if(platform.equals("ios")){
			dc.setPlatform(Platform.IOS);
			dc.setCapability("app", new File(configuration.getProperty("appLocation")).getAbsolutePath());
		}
		dc.setVersion(configuration.getProperty("devcieVersion"));
		
		return dc;
	}
	
	public DesiredCapabilities capsForWebView() {
		DesiredCapabilities dc = new DesiredCapabilities();
		String platform = configuration.getProperty("devicePlatform");
		if(platform.equalsIgnoreCase("android")) {
			dc.setPlatform(Platform.ANDROID);
		}else if(platform.equals("ios")){
			dc.setPlatform(Platform.IOS);
		}
		dc.setVersion(configuration.getProperty("devcieVersion"));
		dc.setBrowserName(configuration.getProperty("browserName"));
		return dc;
	}
	
	public void initClasses() {
		String platform = configuration.getProperty("devicePlatform");
		if(platform.equalsIgnoreCase("android")) {
			homePage = new HomePage_android(driver);
			calculator = new Calculator_android(driver);
		}else if(platform.equals("ios")){
			homePage = new HomePage_ios(driver);
			calculator = new Calculator_ios(driver);
		}
	}
	
	@AfterMethod
	public void quittingDriver() {
		driver.quit();
	}

}

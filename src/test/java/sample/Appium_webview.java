package sample;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeClass;

public class Appium_webview {
	
static WebDriver driver;
	
	@BeforeMethod
	@BeforeClass
	public void setUp() throws MalformedURLException {
		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setPlatform(Platform.ANDROID);
		dc.setVersion("12");
		dc.setBrowserName("chrome");
		
		URL url = new URL("http://127.0.0.1:4723/wd/hub/");
		driver = new RemoteWebDriver(url, dc);
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	@Test
	public void test() {
		driver.get("https://www.amazon.com/");
		WebElement searchElement = driver.findElement(By.id("nav-search-keywords"));
		searchElement.sendKeys("Iphone 14pro case", Keys.ENTER);
	}


}

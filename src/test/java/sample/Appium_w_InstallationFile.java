package sample;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.AssertJUnit;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeClass;

public class Appium_w_InstallationFile {
	
	static WebDriver driver;
	
	@BeforeMethod
	@BeforeClass
	public void setUp() throws MalformedURLException {
		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setPlatform(Platform.ANDROID);
		dc.setVersion("12");
		dc.setCapability("app", new File("src/main/resources/Demo.apk").getAbsolutePath());
		
		URL url = new URL("http://127.0.0.1:4723/wd/hub/");
		driver = new RemoteWebDriver(url, dc);
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	@Test
	public void test() {
		WebElement item = driver.findElement(By.xpath("(//android.view.ViewGroup[@content-desc=\"store item\"])[1]/android.view.ViewGroup[1]/android.widget.ImageView"));
		item.click();
		WebElement addToCartElement = driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"Add To Cart button\"]/android.widget.TextView"));
		addToCartElement.click();
		WebElement viewCartElement = driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"cart badge\"]/android.widget.ImageView"));
		viewCartElement.click();
		WebElement proceedToCheckoutElement = driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"Proceed To Checkout button\"]/android.widget.TextView"));
		proceedToCheckoutElement.click();
		WebElement userNameText = driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"login screen\"]/android.widget.ScrollView/android.view.ViewGroup/android.widget.TextView[2]"));
		AssertJUnit.assertEquals(userNameText.getText(), "Username");
	}


}

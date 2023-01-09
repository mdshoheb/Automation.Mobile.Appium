package common;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import reporting.Logs;

public class CommonActions {
	
	public static void input(WebElement element, String value) {
		try {
			element.sendKeys(value);
			Logs.log(value + " : has been passed to ---> " + element);
		} catch (NoSuchElementException | NullPointerException e) {
			e.printStackTrace();
			Logs.log("ELEMENT NOT FOUND ---> " + element);
			fail();
		}
	}
	
	public static void clear(WebElement element) {
		try {
			element.clear();
			Logs.log("Clearing element ---> " + element);
		} catch (NoSuchElementException | NullPointerException e) {
			e.printStackTrace();
			Logs.log("ELEMENT NOT FOUND ---> " + element);
			fail();
		}
	}
	
	public static void click(WebElement element) {
		try {
			element.click();
			Logs.log(element + " <--- has been clicked");
		} catch (NoSuchElementException | NullPointerException e) {
			e.printStackTrace();
			Logs.log("ELEMENT NOT FOUND ---> " + element);
			fail();
		}
	}
	
	public static void assertGetText(WebElement element, String expected) {
		if(element != null) {
			Logs.log(element + " <--- has text = " + element.getText());
			assertEquals(element.getText(), expected);
		}else {
			Logs.log("ELEMENT NOT FOUND -->" + element);
			fail();
		}
	}

}

package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Calculator_ios implements Calculator{
	
	public Calculator_ios(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@Override
	public int getSumTotal(int... arr) {
		// TODO Auto-generated method stub
		return 0;
	}

}

package ecommerce;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;

import base.BaseClass;

public class Installation_File_Test extends BaseClass{
	
	@Test
	public void test() {
		homePage.clickItem();
		homePage.clickAddToCart();
		homePage.clickViewCart();
		homePage.clickProceedToCheckout();
		homePage.assertUserNameText();
	}

}

package installed_app;

import org.testng.annotations.Test;

import base.BaseClass;

public class InstalledApp_test extends BaseClass{
	
	@Test
	public void test() {
		int [] arr = {2, 333, 222, 43, 22, 870, 100, 5};
		calculator.getSumTotal(arr);
	}

}

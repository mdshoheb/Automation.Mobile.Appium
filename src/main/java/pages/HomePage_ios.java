package pages;

import static common.CommonActions.assertGetText;
import static common.CommonActions.click;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage_ios implements HomePage{
	
	public HomePage_ios(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath = "(//android.view.ViewGroup[@content-desc='store item'])[2]/android.view.ViewGroup[1]/android.widget.ImageView")
	WebElement item;
	@FindBy(xpath = "//android.view.ViewGroup[@content-desc='Add To Cart button']/android.widget.TextView")
	WebElement addToCartElement;
	@FindBy(xpath = "//android.view.ViewGroup[@content-desc='cart badge']/android.widget.ImageView")
	WebElement viewCartElement;
	@FindBy(xpath = "//android.view.ViewGroup[@content-desc='Proceed To Checkout button']/android.widget.TextView")
	WebElement proceedToCheckoutElement;
	@FindBy(xpath = "//android.view.ViewGroup[@content-desc='container header']/android.widget.TextView")
	WebElement loginTextElement;
	
	public void clickItem() {
		click(item);
	}
	
	public void clickAddToCart() {
		click(addToCartElement);
	}
	
	public void clickViewCart() {
		click(viewCartElement);
	}
	
	public void clickProceedToCheckout() {
		click(proceedToCheckoutElement);
	}
	
	public void assertUserNameText() {
		assertGetText(loginTextElement, "Login");
	}

}

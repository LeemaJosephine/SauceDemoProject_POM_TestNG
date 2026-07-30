package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.ProjectSpecificMethods;

public class CartPage extends ProjectSpecificMethods{

	@FindBy(id = "continue-shopping")
	WebElement continueShopping;
	
	@FindBy(id="checkout")
	WebElement checkout;
	
	public CartPage(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	public CartPage continueShop() {
		
		continueShopping.click();
		return this;
	}
	
	public CheckOutPage checkOut() {
		
		checkout.click();
		return new CheckOutPage(driver);
	}
}

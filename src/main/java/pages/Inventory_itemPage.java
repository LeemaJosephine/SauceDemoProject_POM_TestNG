package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import base.ProjectSpecificMethods;

public class Inventory_itemPage extends ProjectSpecificMethods{
	
	@FindBy(xpath="//div[@data-test='inventory-item-name']")
	WebElement product;
	
	@FindBy(className="inventory_details_price")
	WebElement price;
	
	@FindBy(id="add-to-cart")
	WebElement addToCart;
	
	@FindBy(className = "shopping_cart_link")
	WebElement cartButton;
	
	public Inventory_itemPage(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public Inventory_itemPage checkProductName(String productName) {
		
		Assert.assertEquals(productName, product.getText());
		return this;
	}
	
	public Inventory_itemPage checkProductPrice(String productPrice) {
		
		Assert.assertEquals(productPrice, price.getText());
		return this;
	}
	
	public Inventory_itemPage clickAddToCart() {
		
		addToCart.click();
		return this;
	}
	
	public CartPage clickCartButton() {
		
		cartButton.click();
		return new CartPage(driver);
		
	}

}

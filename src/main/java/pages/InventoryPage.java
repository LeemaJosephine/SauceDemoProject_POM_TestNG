package pages;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import base.ProjectSpecificMethods;

public class InventoryPage extends ProjectSpecificMethods{

	@FindBy(xpath="//div[@class='inventory_item_name ']")
	List<WebElement> list;
	
	
	public InventoryPage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	public InventoryPage productList(String size) {
		
		int productSize = list.size();
		int expectedSize = Integer.parseInt(size);
		
		Assert.assertTrue(expectedSize==productSize);
		return this;
	}
	
	public Inventory_itemPage selectProduct(String productName) throws IOException {
		
		for(WebElement ele: list) {
			if(ele.getText().equals(productName)) {
				//String itemprice = driver.findElement(By.xpath("//div[text()='"+productName+"']/following::div[@class='inventory_item_price']")).getText();
				String itemprice =driver.findElement(By.xpath("//div[text()='"+productName+"']/ancestor::div[@class='inventory_item']//div[@class='inventory_item_price']")).getText();
				prop.setProperty("productPrice", itemprice);
				prop.setProperty("productInPage", ele.getText());
				ele.click();
				break;
			}
		}
		
		return new Inventory_itemPage(driver);
	}
}

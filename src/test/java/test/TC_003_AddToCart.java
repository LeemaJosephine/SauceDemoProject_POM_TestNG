package test;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.ProjectSpecificMethods;
import pages.HomePage;
import pages.InventoryPage;

public class TC_003_AddToCart extends ProjectSpecificMethods{

	@BeforeTest
	public void setup() throws Exception {
	
		testname="Product add to cart";
		testdescription="Testing whether the product added to cart";
		testCategory="Smoke Testing";
		testAuthor="Leema Josephine";
		readAndWritePropFile();
		
	}
	
	@Test
	public void productListTest() throws IOException{
		
		new HomePage(driver)
			.enterUserName(prop.getProperty("username"))
			.enterPassword(prop.getProperty("password"))
			.clickLogin();
		
		 new InventoryPage(driver)
		 	.productList(prop.getProperty("productSize"))
		 	.selectProduct(prop.getProperty("productName"))
		 	.checkProductName(prop.getProperty("productInPage"))
		 	.checkProductPrice(prop.getProperty("itemprice"))
		 	.clickAddToCart()
		 	.clickCartButton()
		 	.checkOut();
	}
}

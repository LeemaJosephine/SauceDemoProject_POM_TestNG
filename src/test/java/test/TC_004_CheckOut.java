package test;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.ProjectSpecificMethods;
import pages.HomePage;
import pages.InventoryPage;

public class TC_004_CheckOut extends ProjectSpecificMethods{

	@BeforeTest
	public void setup() throws Exception {
	
		testname="Checkout page test";
		testdescription="Testing the checkout page";
		testCategory="Smoke Testing";
		testAuthor="Leema Josephine";
		readAndWritePropFile();
		
	}
	
	@Test
	public void checkOutTest() throws IOException{
		
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
		 	.checkOut()
		 	.enter_firstname("leema")
		 	.enter_lasrname("jo")
		 	.enter_postalCode("600001")
		 	.click_continue();
	}
}

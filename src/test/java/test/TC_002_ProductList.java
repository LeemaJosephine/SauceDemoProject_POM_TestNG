package test;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.ProjectSpecificMethods;
import pages.HomePage;
import pages.InventoryPage;

public class TC_002_ProductList extends ProjectSpecificMethods{

	@BeforeTest
	public void setup() throws Exception {
	
		testname="Product List Test";
		testdescription="Testing whether the product list is correct";
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
		 	.selectProduct(prop.getProperty("productName"));
	}
}

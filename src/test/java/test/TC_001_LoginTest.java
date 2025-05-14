package test;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.ProjectSpecificMethods;
import pages.HomePage;

public class TC_001_LoginTest extends ProjectSpecificMethods{

	@BeforeTest
	public void setup() {
		
		sheetname="Login";
		testname="Login Test";
		testdescription="Testing the login up functionality with valid and invalid details";
		testCategory="Smoke Testing";
		testAuthor="Leema Josephine";
	}
	@Test(dataProvider = "readData")
	public void loginTest(String username, String password, String testtype, String ExpectedMessage) {
		
		new HomePage(driver)
			.enterUserName(username)
			.enterPassword(password)
			.clickLogin()
			.validateLogin(testtype, ExpectedMessage);
	
	}

}

package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import base.ProjectSpecificMethods;

public class HomePage extends ProjectSpecificMethods{

	@FindBy(id="user-name")
	WebElement userName;
	
	@FindBy(id="password")
	WebElement password;
	
	@FindBy(id="login-button")
	WebElement loginButton;
	
	@FindBy(xpath="//h3[@data-test='error']")
	WebElement loginError;
	
	public HomePage(WebDriver driver) {
		
		HomePage.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public HomePage enterUserName(String un) {
		
		userName.sendKeys(un);
		return this;
		
	}
	
	public HomePage enterPassword(String pass) {
		
		password.sendKeys(pass);
		return this;
		
	}
	
	public HomePage clickLogin() {
		
		loginButton.click();
		return this;
	}
	
	public HomePage validateLogin(String testType, String expectedMessage) {
		
		if(testType.equalsIgnoreCase("ValidInputs")) {
			
			String actual = driver.getCurrentUrl();
			Assert.assertEquals(actual, expectedMessage);
			
		} else if(testType.equalsIgnoreCase("InvalidUsername")) {
			
			String actual = loginError.getText();
			Assert.assertEquals(actual, expectedMessage);
			
		} else if(testType.equalsIgnoreCase("InvalidPassword")) {
			
			String actual = loginError.getText();
			Assert.assertEquals(actual, expectedMessage);
			
		} else if(testType.equalsIgnoreCase("BlankInputs")) {
			
			String actual = loginError.getText();
			Assert.assertEquals(actual, expectedMessage);
			
		} else if(testType.equalsIgnoreCase("InvalidInputs")) {
			
			String actual = loginError.getText();
			Assert.assertEquals(actual, expectedMessage);
			
		}
		
		return this;
		
		
	}
}

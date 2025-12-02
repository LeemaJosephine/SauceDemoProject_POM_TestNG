package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.ProjectSpecificMethods;

public class CheckOutPage extends ProjectSpecificMethods{
	
	@FindBy(id="first-name")
	WebElement firstName;
	
	@FindBy(id="last-name")
	WebElement lastName;
	
	@FindBy(id="postal-code")
	WebElement postalCode;
	
	@FindBy(id="continue")
	WebElement continueButton;
	
	public CheckOutPage(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	public CheckOutPage enter_firstname(String firstname) {
		
		firstName.sendKeys(firstname);
		return this;
		
	}
	
	public CheckOutPage enter_lasrname(String lastname) {
		
		lastName.sendKeys(lastname);
		return this;
		
	}
	
	public CheckOutPage enter_postalCode(String postalcode) {
		
		postalCode.sendKeys(postalcode);
		return this;
		
	}
	
	public CheckOutPage click_continue() {
		
		continueButton.click();
		return this;
		
	}

}

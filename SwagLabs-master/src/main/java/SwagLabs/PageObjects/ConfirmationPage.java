package SwagLabs.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import SwagLabs.AbstractClass.AbstractComponents;

public class ConfirmationPage extends AbstractComponents {
	
WebDriver driver;
	
/**
 * PageFactory.initElements(driver, this) is must, when use go with PageFactory Technique
 * Through super, we send the driver access to Parent class.
 */

	public ConfirmationPage(WebDriver driver) {
		super(driver);
		this.driver =driver;
		PageFactory.initElements(driver, this);
		
	}
	
	
	
	@FindBy(id="first-name")
	private WebElement firstName; // Encapsulation example 
	
	@FindBy(id="last-name")
	private WebElement lastName; // Encapsulation example 
	
	@FindBy(id="postal-code")
	private WebElement postalCode; // Encapsulation example
	
	@FindBy(xpath="//input[@type='submit']")
	private WebElement continue_btn; // Encapsulation example
	
	
	/**
	 * This method will open new page, so we created Object of the class, and returning the object
	 */
	
	public  OverviewPage provideUserDetails(String Username, String userLastName, String postal_Code) {
		
		firstName.sendKeys(Username);
		lastName.sendKeys(userLastName);
		postalCode.sendKeys(postal_Code);
		continue_btn.click();
		
		OverviewPage overviewPage = new OverviewPage(driver);
		return overviewPage;
	}
	


}

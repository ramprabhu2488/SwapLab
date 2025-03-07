package SwagLabs.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import SwagLabs.AbstractClass.AbstractComponents;

public class OrderConfirmationPage extends AbstractComponents {
	
	WebDriver driver;
	
	/**
	 * PageFactory.initElements(driver, this) is must, when use go with PageFactory Technique
	 * Through super, we send the driver access to Parent class.
	 */

	public OrderConfirmationPage(WebDriver driver) {
		super(driver);
		this.driver =driver;
		PageFactory.initElements(driver, this);

	}
	
	
	@FindBy(xpath = "//h2[@class='complete-header']")
	private WebElement confirmation_MSG; // Encapsulation example
	
	
	
	
	public String getConfirmation_Message() {
		String confirmation_Msg = confirmation_MSG.getText();
		return confirmation_Msg;

	}
	
	
	
	

}

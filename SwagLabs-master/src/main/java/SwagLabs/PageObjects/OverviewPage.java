package SwagLabs.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import SwagLabs.AbstractClass.AbstractComponents;

public class OverviewPage extends AbstractComponents {	

	WebDriver driver;

	/**
	 * PageFactory.initElements(driver, this) is must, when use go with PageFactory Technique
	 * Through super, we send the driver access to Parent class.
	 */
	
	public OverviewPage(WebDriver driver) {
		super(driver);
		this.driver =driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//div[@class='inventory_item_name']")
	private WebElement getProductName; // Encapsulation example

	@FindBy(xpath = "//div[@class='summary_info']//div[2]" )
	private WebElement getSauceCode; // Encapsulation example

	@FindBy(xpath = "//a[text()='FINISH']")
	private WebElement finish_btn; // Encapsulation example


	public String getProductNameFromList() {
		String productName = getProductName.getText();
		return productName;

	}


	public String getSauceCode() {
		String sauceCode = getSauceCode.getText();
		return sauceCode;
	}	

	/**
	 * This method will open new page, so we created Object of the class, and returning the object
	 */
	
	public OrderConfirmationPage click_finish_btn() {
		finish_btn.click();
		OrderConfirmationPage orderConfirmation = new OrderConfirmationPage(driver);
		return orderConfirmation;
	}





}

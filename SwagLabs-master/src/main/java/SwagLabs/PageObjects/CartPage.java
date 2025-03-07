package SwagLabs.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import SwagLabs.AbstractClass.AbstractComponents;

public class CartPage extends AbstractComponents {
	
WebDriver driver;
	
/**
 * PageFactory.initElements(driver, this) is must, when use go with PageFactory Technique
 * Through super, we send the driver access to Parent class.
 */
	public CartPage(WebDriver driver) {
		super(driver);
		this.driver =driver;
		PageFactory.initElements(driver, this);
		
	}trgyh
	
	
	@FindBy(xpath = "//div[@class='inventory_item_name']")
	private WebElement getProductName; // Encapsulation example
	
	
	@FindBy(xpath = "//a[text()='CHECKOUT']")
	private WebElement checkOut_btn; // Encapsulation example
	
	
	
	public String getProductName() {
		String Product = getProductName.getText();
		return Product;
	}
	
	
	/**
	 * This method will open new page, so we created Object of the class, and returning the object
	 */
	
	public ConfirmationPage goToConfimationPage() {
		checkOut_btn.click();
		ConfirmationPage confirmationPage = new ConfirmationPage(driver);
		return confirmationPage;
	}
	
	

	

}

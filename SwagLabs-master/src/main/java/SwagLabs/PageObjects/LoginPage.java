package SwagLabs.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import SwagLabs.AbstractClass.AbstractComponents;


public class LoginPage extends AbstractComponents {
	
	WebDriver driver ;
	
	/**
	 * PageFactory.initElements(driver, this) is must, when use go with PageFactory Technique
	 * Through super, we send the driver access to Parent class.
	 */
	
	public LoginPage(WebDriver driver) {
		super(driver);
		this.driver =driver;
		PageFactory.initElements(driver, this);
		
	}	
	
	
	@FindBy(id = "user-name")
	private WebElement userName;// Encapsulation example 
	
	@FindBy(id = "password")
	private WebElement passWord; // Encapsulation example
	
	@FindBy(id = "login-button")
	private WebElement login_btn; // Encapsulation example
	
	@FindBy(xpath = "//h3[@data-test='error']")
	private WebElement login_ErrorMSG; // Encapsulation example
	
	
	/**
	 * This method will open new page, so we created Object of the class, and returning the object
	 */
	public ProductsPage login_Credentials(String user, String Pass) {		
		userName.sendKeys(user);
		passWord.sendKeys(Pass);
		login_btn.click();		
		ProductsPage ProductsPage = new ProductsPage(driver);
		return  ProductsPage;
	}

	
	public String invalidCredentialError() {
		String error_msg = login_ErrorMSG.getText();
		return error_msg;

	}
	
	
}

package SwagLabs.PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import SwagLabs.AbstractClass.AbstractComponents;

public class ProductsPage extends AbstractComponents {

	WebDriver driver;

	/**
	 * PageFactory.initElements(driver, this) is must, when use go with PageFactory
	 * Technique Through super, we send the driver access to Parent class.
	 */

	public ProductsPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//div[@class='inventory_item_label']//div[@class='inventory_item_name']")

	private List<WebElement> listofProducts; // Encapsulation example

	@FindBy(xpath = "//div[@class='shopping_cart_container']")

	private WebElement addToCart_btn; // Encapsulation example

	public void addProductToCart(String product) {
		int count = 0;
		for (int i = 0; i < listofProducts.size(); i++) {
			WebElement ProductName = listofProducts.get(i);
			String text = ProductName.getText();
			count = count + 1;

			if (text.equals(product)) {

				ProductName.findElement(By.xpath("(//button[text()='ADD TO CART'])[" + count + "]")).click();
				break;
			}
		}

	}

	/**
	 * This method will open new page, so we created Object of the class, and
	 * returning the object
	 */

	public CartPage goToAddToCart() {
		addToCart_btn.click();
		CartPage cartPage = new CartPage(driver);
		return cartPage;
	}

}

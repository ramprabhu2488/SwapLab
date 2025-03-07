package SwagLabs.Project;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RND {
	
	@Test
	public void Sample() {
//		String product = "Sauce Labs Onesie";
//		String Confirmation ="THANK YOU FOR YOUR ORDER";

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		driver.get("https://www.saucedemo.com/v1/");

		//login
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce_1");
		driver.findElement(By.id("login-button")).click();
		
		WebElement element = driver.findElement(By.xpath("//h3[@data-test='error']"));
		String text = element.getText();
		System.out.println(text);

//		//ProductList
//		//Sauce Labs Bolt T-Shirt
//
//
//		int count = 0 ;
//
//		List<WebElement> listofProducts = driver.findElements(By.xpath("//div[@class='inventory_item_label']//div[@class='inventory_item_name']"));
//
//		for (int i = 0; i < listofProducts.size(); i++) {
//			WebElement ProductName = listofProducts.get(i);
//			String text = ProductName.getText();
//			count=count+1;
//
//			if (text.equals(product)) {
//
//				ProductName.findElement(By.xpath("(//button[text()='ADD TO CART'])[" + count + "]")).click();
//				break;
//			}			
//		}
//
//
//
//
//
//		driver.findElement(By.xpath("//div[@class='shopping_cart_container']")).click();
//
//		//Checkout
//		String ProductName = driver.findElement(By.xpath("//div[@class='inventory_item_name']")).getText();
//		Assert.assertEquals(ProductName, product);
//
//		driver.findElement(By.xpath("//a[text()='CHECKOUT']")).click();
//
//		//YourInformation
//		driver.findElement(By.id("first-name")).sendKeys("Deepak");
//		driver.findElement(By.id("last-name")).sendKeys("V");
//		driver.findElement(By.id("postal-code")).sendKeys("600112");
//
//		driver.findElement(By.xpath("//input[@type='submit']")).click();
//
//
//		//OverViewPage
//
//		String item = driver.findElement(By.xpath("//div[@class='inventory_item_name']")).getText();
//		Assert.assertEquals(ProductName, item);
//
//		String sauceCode = driver.findElement(By.xpath("//div[@class='summary_info']//div[2]")).getText();
//		System.out.println(sauceCode);
//
//
//		driver.findElement(By.xpath("//a[text()='FINISH']")).click();
//
//
//		//ConfirmationPage
//		String orderConfirmation = driver.findElement(By.xpath("//h2[@class='complete-header']")).getText();
//		Assert.assertEquals(orderConfirmation, Confirmation);
	driver.close();

	}

	}

	
		










package SwagLabs.Project;

import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import SwagLabs.PageObjects.CartPage;
import SwagLabs.PageObjects.ConfirmationPage;
import SwagLabs.PageObjects.LoginPage;
import SwagLabs.PageObjects.OrderConfirmationPage;
import SwagLabs.PageObjects.OverviewPage;
import SwagLabs.PageObjects.ProductsPage;
import SwagLabs.TestComponents.BaseClass;
import SwagLabs.TestComponents.Retry;

public class SwagLabs extends BaseClass {
	String product = "Sauce Labs Onesie";
	String Confirmation = "THANK YOU FOR YOUR ORDER";
	String Error_Msg = "Epic sadface: Username and password do not match any user in this service";
	String url = "https://www.saucedemo.com/v1/";

	
	/**
	 * This is the example for dataProvider.
	 * We should specify the IretryListeners class, on the test, if we feel that testcase might fail due to flaky
	 * When fail for first time, it consider the first try is skipped. and will try for how many times we define for retry. and only last try consider as failure.
	 */
	
	@Test(dataProvider = "getData" , retryAnalyzer=Retry.class)
	public void orderProduct(HashMap<String, String> input) { // Getting the data set from dataProvider

		ProductsPage ProductsPage =  loginPage.login_Credentials(input.get("userName"), input.get("passWord"));
		ProductsPage.addProductToCart(product);
		CartPage cartPage = ProductsPage.goToAddToCart();
		String productName = cartPage.getProductName();
		Assert.assertEquals(productName, product);
		ConfirmationPage confirmationPage = cartPage.goToConfimationPage();
		OverviewPage OverviewPage = confirmationPage.provideUserDetails("Deepak", "V", "600115");

		String productNameFromList = OverviewPage.getProductNameFromList();
		Assert.assertEquals(productNameFromList, product);

		String sauceCode = OverviewPage.getSauceCode();
		System.out.println(sauceCode);
		OrderConfirmationPage orderconfirmationPage = OverviewPage.click_finish_btn();

		String confirmation_Message = orderconfirmationPage.getConfirmation_Message();
		Assert.assertEquals(confirmation_Message, Confirmation);
	}

	
	/**
	 * if dependsMethod is failed, then this depended method will be skipped automatically.
	 * This is the method, example for JSON
	 */

	//
	@Test(dataProvider = "getDataFromExternalResource" )
	public void DifferntLogin(HashMap<String, String> JSONData) {


		ProductsPage ProductsPage =  loginPage.login_Credentials(JSONData.get("userName"), JSONData.get("passWord"));		
		String invalidCredentialError = loginPage.invalidCredentialError();
		if (invalidCredentialError.contains("Username and password")) {
			System.out.println(invalidCredentialError);
		}

	}
	
	

	/**
	 * Passing the value to the Test method by using dataProvider. See Method 1, for reference.
	 * we can give multiple set of data for single method. This for first method
	 */


	@DataProvider
	public Object[][] getData() {
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("userName", "standard_user1");
		map.put("passWord", "secret_sauce");

		HashMap<String, String> map1 = new HashMap<String, String>();
		map1.put("userName", "problem_user1");
		map1.put("passWord", "secret_sauce");

		return new Object[][] {{map}, {map1}};


	}




	/**
	 * By using External Source of JSON, this is for second method
	 * Create one JSON file, with the extension of .JSON
	 * Preconditions -> We have to create one method to read data from JSON file, in BaseClass. Jackson dependency is mandatory.
	 * By using that method, we are actually read the data, and passing that value in the test method. See Method : 2
	 * return new Object[][] {{jsonData.get(0)}, {jsonData.get(1)}}; // this will take the data from 
	 */

	@DataProvider
	public Object[][] getDataFromExternalResource() throws IOException {

		List<HashMap<String, String>> jsonData = getJSONData(System.getProperty("user.dir")+"//src//test//java//SwagLabs//data//UserCredentials.json");
		return new Object[][] {{jsonData.get(0)}, {jsonData.get(1)}}; 


	}





}

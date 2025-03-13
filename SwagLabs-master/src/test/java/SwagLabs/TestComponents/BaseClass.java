package SwagLabs.TestComponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.fasterxml.jackson.databind.ObjectMapper;

import SwagLabs.PageObjects.LoginPage;

public class BaseClass {
	
	/**
	 * We set this as global variable, so that, we can give life to the methods, wherever they used this.
	 */

	public WebDriver driver;
	public LoginPage loginPage;

	public WebDriver initializeBrowser() throws IOException {
		
		
		/**
		 * This the function we use to read the data from property file. Based on the value, this defines the browser. This is also Key:Pair combination
		 * Path of the file, where exits
		 * We have to set the instances for other browsers
		 */

	
		Properties prop = new Properties();
		
		FileInputStream path = new FileInputStream(System.getProperty("user.dir") + "//src//main//java//SwagResouces//global.properties"); 
		prop.load(path);
		
		/**
		 * we getting the value from properties, based on key & Value pair combination
		 */
		String browserName = prop.getProperty("browser");
		
		/**
		 * if we pass the global properties, from maven command, use the below line of code, which gives first preference to maven command, if the key value not present, then it will check the property file
		 *  To do that, we use ternary Operator as below, and disable above line "String browserName = prop.getProperty("browser");"
		 *  
		 *  String browserName = System.getProperty("browser") != null ? System.getProperty("browser") : prop.getProperty("browser");
		 *  
		 */
		
		

		if (browserName.equalsIgnoreCase("chrome")) {
			//WebDriverManager.chromedriver.setup();
			driver = new ChromeDriver();
		}
		else if (browserName.equalsIgnoreCase("firefox")) {
			//System.setProperty("webdriver.gecko.driver", "Path of firefox driver");
			driver = new FirefoxDriver();
			
		}
		else if (browserName.equalsIgnoreCase("edge")) {		
			//System.setProperty("webdriver.edge.driver", "Path of edge driver");
			driver  = new EdgeDriver();

		}

		driver.manage().window().maximize();
		return driver;
	}
	
	/**
	 * This is the method, execute first, before all the method. So we have called InitializeBrowser method here, and receiving driver.
	 *All the browser related things, handling here.
	 *Once we hit the URL, we will get new page. So we are returning the object of the page. 
	 * This way, we can reach loginPage 
	 */

	@BeforeMethod(alwaysRun = true)
	public LoginPage launchBrowser() throws IOException {
		driver = initializeBrowser();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
		driver.get("https://www.saucedemo.com/v1");

		loginPage = new LoginPage(driver);
		return loginPage;
	}
	
	
/**
 * Close method will close the browser instance
 */
	
	@AfterMethod(alwaysRun = true)
	public void tearDown() {
		driver.close();

	}
	
	/**
	 * This is the method, to read the data from JSON
	 * Jackson Dependency should be added in POM.XML
	 * This is one time implementation, we can use the method, by just changing the file path in different methods.
	 * 
	 */
	

	public List<HashMap<String, String>> getJSONData(String Filepath) throws IOException {
		String JsonContent = FileUtils.readFileToString(new File(Filepath), StandardCharsets.UTF_8);
		ObjectMapper mapper = new ObjectMapper();
		
		List<HashMap<String, String>> data = mapper.readValue(JsonContent,
				new TypeReference<List<HashMap<String, String>>>() {
				});
		return data;

	}
	
	
	
	/**
	 * We sending the testcaseName dynamically, it will get the failed testcaseName. and store the screenshot with the same name.
	 * This method will only gets trigger, when any Testcase got failed.
	 * We need to have listeners dependency, and listeners class to handle this.
	 * 
	 * download it from -> https://mvnrepository.com/artifact/com.aventstack/extentreports/5.1.2
	 */
	
	
	public String takeScreenShot(String testCaseName, WebDriver driver) throws IOException {
		TakesScreenshot ts =  (TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		
		File desc = new File(System.getProperty("user.dir")+"//reports//" + testCaseName + ".png");
		
		// Use Paths correctly
		FileUtils.copyFile(src, desc);
		return System.getProperty("user.dir")+"//reports//" + testCaseName + ".png";

	}

}

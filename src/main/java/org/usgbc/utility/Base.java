package org.usgbc.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.browserlaunchers.locators.SafariLocator;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class Base extends Report{

	public static WebDriver driver ;
	public static XlsReader reader;
	public static String baseUrl;
	public static Properties prop ;
	
	@BeforeMethod
	@Parameters({"browserName","environment"})
	public WebDriver  getDriver(String browser,String environment) throws Exception {
		
		Report.ExtentReportConfig();
		reader= new XlsReader(System.getProperty("user.dir")+"\\TestData_usgbc.xlsx");
		
	    //Check if parameter passed from TestNG is 'firefox'
		if(browser.equalsIgnoreCase("Firefox")){
			//create firefox instance
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\Groupten\\Drivers\\geckodriver.exe");    
			driver =new FireFoxDriver();
			driver.manage().window().maximize(); 
			System.out.println("-----Firefox Browser Launched----- ");		    	
		}
				
		//Check if parameter passed as 'chrome'
		else if(browser.equalsIgnoreCase("Chrome")){
			//set path to chromedriver.exe
			System.setProperty("webdriver.chrome.driver","C:\\Users\\Groupten\\Drivers\\chromedriver.exe");
			driver =new ChromeDriver();
			// Add options to Google Chrome. The window-size is important for responsive sitess
			driver.manage().window().maximize();
		    System.out.println("-----Chrome Browser Launched----- ");		
		}
		
		//Check if parameter passed as 'Edge'
		else if(browser.equalsIgnoreCase("Edge")){
			//set path to Edge.exe
			System.setProperty("webdriver.edge.driver","C:\\Users\\Groupten\\Drivers\\MicrosoftWebDriver.exe");
		    //create Edge instance
			driver = new InternetExplorerDriver();
			driver.manage().window().maximize();
			System.out.println("-----I.E Browser Launched----- ");	
		}
		/*//Check if parameter passed as 'Safari'
		else if(browser.equalsIgnoreCase("Safari")){
			//set path to Edge.exe
			System.setProperty("webdriver.edge.driver","C:\\Users\\Groupten\\Drivers\\MicrosoftWebDriver.exe");
			//create Safari instance
			driver = new SafariDriver();
			driver.manage().window().maximize();
			System.out.println("-----I.E Browser Launched----- ");	
	   }*/
	   //Check if parameter is phantom
		else if(browser.equalsIgnoreCase("HtmlUnit")) {
		   driver = new HtmlUnitDriver();	
	   }
		//Check if parameter is phantom
		else if(browser.equalsIgnoreCase("Phantom")) {
			 File src=new File("C:\\Program Files\\phantomjs-2.1.1-windows\\bin\\phantomjs.exe");
		     System.setProperty("phantomjs.binary.path", src.getAbsolutePath());
		     driver = new PhantomJSDriver();	
		}
		else{
		//If no browser passed throw exception
		throw new Exception("Browser is not correct");
		}
		
		
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		prop= new Properties();
		  FileInputStream file = new FileInputStream(System.getProperty("user.dir")+"/src/main/resources/Environment.properties");
		  prop.load(file);
		  String devurl=prop.getProperty("ENV_DEV");
		  String testurl=prop.getProperty("ENV_TEST");
		  String productionurl=prop.getProperty("ENV_PRODUCTION");
		  
		  if(environment.equalsIgnoreCase("dev")){
		   driver.get(devurl);
		   
		  }
		  else if(environment.equalsIgnoreCase("test")){
		   driver.get(testurl);
		   
		  }
		  else if(environment.equalsIgnoreCase("production")){
		   driver.get(productionurl);

		  }
		return driver;
	}
		
		

	@AfterMethod
	public WebDriver closeDriver(ITestResult result ) {
		Report.afterMethod(driver, result);
		driver.quit();
		System.out.println("--------Browser Closed--------");
		return driver;
	}
	
}

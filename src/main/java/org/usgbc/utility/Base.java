package org.usgbc.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class Base extends Report{

	public static WebDriver driver ;
	public static XlsReader reader;
	public static String baseUrl;
	public static Properties prop ;
	
	
	@Parameters({"browser","environment"})
	@BeforeMethod
	public void  setup(String browser,String environment) throws Exception {
		
		Report.ExtentReportConfig();
		reader= new XlsReader(System.getProperty("user.dir")+"/TestData_usgbc.xlsx");
		System.out.println(reader);	
		
	    //Check if parameter passed from TestNG is 'firefox'
		if(browser.equalsIgnoreCase("Firefox")){
			//create firefox instance
			//System.setProperty("webdriver.firefox.marionette", System.getProperty("user.dir")+"/geckodriver.exe");    
			driver = new FirefoxDriver();
			System.out.println("-----Firefox Browser Launched----- ");		    	
		}
				
		//Check if parameter passed as 'chrome'
		else if(browser.equalsIgnoreCase("Chrome")){
			//set path to chromedriver.exe
			System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"/chromedriver.exe");
			driver =new ChromeDriver();
			// Add options to Google Chrome. The window-size is important for responsive sitess
		    System.out.println("-----Chrome Browser Launched----- ");		
		}

		//Check if parameter passed as 'Edge'
		else if(browser.equalsIgnoreCase("Edge")){
			//set path to Edge.exe
			System.setProperty("webdriver.edge.driver",System.getProperty("user.dir")+"/MicrosoftWebDriver.exe");
		    //create Edge instance
			driver = new InternetExplorerDriver();
			System.out.println("-----I.E Browser Launched----- ");	
		}
	
		//Check if parameter passed as 'Safari'
		else if(browser.equalsIgnoreCase("Safari")){
			//set path to Safari.exe
			System.setProperty("webdriver.edge.driver",System.getProperty("user.dir")+"/MicrosoftWebDriver.exe");
		    //create safari instance
			driver = new SafariDriver();
			System.out.println("-----Safari Browser Launched----- ");	
		}
		
	  /* //Check if parameter is HtmlUnit
		else if(browser.equalsIgnoreCase("HtmlUnit")) {
		   driver = new HtmlUnitDriver();	
	   }
		
		//Check if parameter is PhantomJs
		else if(browser.equalsIgnoreCase("PhantomJs")) {
			File src=new File("C:\\Program Files\\phantomjs-2.1.1-windows\\bin\\phantomjs.exe");
	        System.setProperty("phantomjs.binary.path", src.getAbsolutePath());
	       	driver = new PhantomJSDriver();
		}
*/
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		  prop= new Properties();
		  FileInputStream file = new FileInputStream(System.getProperty("user.dir")+"/src/main/resources/Environment.properties");
		  prop.load(file);
		  String devurl=prop.getProperty("ENV_DEV");
		  String testurl=prop.getProperty("ENV_TEST");
		  String productionurl=prop.getProperty("ENV_PRODUCTION");
		  
		  if(environment.equalsIgnoreCase("dev")){
			  baseUrl = devurl;
			  driver.get(baseUrl); 
		  }
		  
		  else if(environment.equalsIgnoreCase("test")){
			  baseUrl = testurl;
			  driver.get(baseUrl); 
		  }
		  
		  else if(environment.equalsIgnoreCase("production")){
			  baseUrl = productionurl;
			  driver.get(baseUrl); 
		   
		  }	
}
	
/*	public static void closeBrowser() throws Exception{
	    if (webDriver == null) {
	        return;
	    }
	    webDriver.quit();
	    webDriver = null;
	}*/
	
	
	/*public WebDriver tearDown(ITestResult result ) {
		Report.afterMethod(driver, result);
		driver.close();
		driver.quit();
		System.out.println("--------Browser Closed--------");
		return driver;
	}
	
	public static void tearDown(ITestResult result ) {
		Report.afterMethod(driver, result);
		  if (driver == null) {
		        return;
		    }
		    driver.quit();
		    driver = null;
		System.out.println("--------Browser Closed--------");
		
	}*/
	
	@AfterMethod
	public static void tearDown(ITestResult result ) {
		Report.afterMethod(driver, result);
      	driver.quit();
		System.out.println("--------Browser Closed--------");
	}
}

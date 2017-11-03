package org.usgbc.utility;

import java.io.File;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class Base extends Report{

	public static WebDriver driver ;
	public static XlsReader reader;
	public static String baseUrl;
	 
	//@Parameters("browser"), getDriver(String browser)
	//@Parameters( {"SheetName", "ColumnName", "rowNum"} ) , getDriver(String SheetName ,String ColumnName ,int rowNum), getCellData(SheetName ,ColumnName , rowNum)
	
	
	@BeforeMethod
	@Parameters({"sheetName", "colName", "rowNum"} )
	public WebDriver  getDriver(String SheetName ,String ColumnName ,int rowNum)
	 throws Exception {
		
		Report.ExtentReportConfig();
		reader= new XlsReader(System.getProperty("user.dir")+"\\TestData_usgbc.xlsx");
	    baseUrl= reader.getCellData(SheetName ,ColumnName , rowNum);
	   
	/*  File src=new File("C:\\Program Files\\phantomjs-2.1.1-windows\\bin\\phantomjs.exe");
        System.setProperty("phantomjs.binary.path", src.getAbsolutePath());
        driver = new PhantomJSDriver();*/
        
	    driver = new FirefoxDriver();
		driver.manage().window().maximize();
		System.out.println("--------FireFox Browser Launched-------- ");
		return driver;
		/*	//Check if parameter passed from TestNG is 'firefox'
				if(browser.equalsIgnoreCase("firefox")){
				//create firefox instance
					System.setProperty("webdriver.firefox.marionette", "C:\\Users\\Groupten\\Drivers\\geckodriver.exe");
					driver = new FirefoxDriver();
					driver.manage().window().maximize();
					System.out.println("FireFox Browser Launched ");	
				}
				//Check if parameter passed as 'chrome'
				else if(browser.equalsIgnoreCase("chrome")){
					//set path to chromedriver.exe
					System.setProperty("webdriver.chrome.driver","C:\\Users\\Groupten\\Drivers\\chromedriver.exe");
					//create chrome instance
					driver = new ChromeDriver();
					driver.manage().window().maximize();
					System.out.println("Chrome Browser Launched ");		
				}
				//Check if parameter passed as 'Edge'
				else if(browser.equalsIgnoreCase("Edge")){
					//set path to Edge.exe
					System.setProperty("webdriver.edge.driver","C:\\Users\\Groupten\\Drivers\\MicrosoftWebDriver.exe");
				    //create Edge instance
					driver = new EdgeDriver();
					driver.manage().window().maximize();
					System.out.println("I.E Browser Launched ");	
				}
				else{
					//If no browser passed throw exception
					throw new Exception("Browser is not correct");
				}
				
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);*/
				
	}
		
		

	@AfterMethod
	public WebDriver closeDriver(ITestResult result ) {
		Report.afterMethod(driver, result);
		driver.quit();
		System.out.println("--------Browser Closed--------");
		return driver;
	}
	
}

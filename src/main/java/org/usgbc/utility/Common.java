package org.usgbc.utility;

import java.util.List;
import java.io.FileInputStream;	
import java.io.IOException;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.relevantcodes.extentreports.LogStatus;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.usgbc.utility.Base;
import org.usgbc.utility.Report;


public class Common extends Base{

	 static Properties properties;
	 static FileInputStream Locator;
	 static WebElement locaterInstance;
	 static WebElement element;
	 
	// public static WebDriverWait wait = new WebDriverWait(driver, 60);
	 
	 
	 public static WebElement findLocater(final String name) throws IOException {
		 
		 Locator = new FileInputStream(System.getProperty("user.dir") + "/src/main/resources/ObjectLocator.properties");
	     properties = new Properties();
	     properties.load(Locator);
	     String[] locaters = properties.getProperty(name).split("~");

	     // Split the value which contains locator type and locator value
	     String locaterType = locaters[0];
	     String stringLocater = locaters[1];
	  
	     // use switch case to get the type of locater provided

	     switch (locaterType) {
		  case "xpath":
		    locaterInstance= driver.findElement(By.xpath(stringLocater));
		    break;
		  case "id":
		    locaterInstance=  driver.findElement(By.id(stringLocater));
		    break;
		  case "name":
		   locaterInstance= driver.findElement(By.name(stringLocater));
		   break;
		  case "class":
		   locaterInstance=  driver.findElement(By.className(stringLocater));
		   break;
		  case "css":
		   locaterInstance=  driver.findElement(By.cssSelector(stringLocater));
		   break;
		  case "tag":
		   locaterInstance=  driver.findElement(By.tagName(stringLocater));
		   break;
		  case "linkText":
		   locaterInstance=  driver.findElement(By.linkText(stringLocater));
		   break;
		  case "partialLink":
		   locaterInstance=  driver.findElement(By.partialLinkText(stringLocater));
		   break;
	     }
	  return locaterInstance;
	 }
	 
	 
	 // get the text of the web element
	 public String getText(String locaterName)throws IOException  {
	   return findLocater(locaterName).getText();
	 }
	  
	 
	 // send the values to the web element
	 public  void setText(String locaterName, String sendValue) throws IOException {
	  findLocater(locaterName).sendKeys(sendValue);
	 }

	 
	 // click the button
	 public  void  clickBtn(String locaterName) throws IOException {
	  findLocater(locaterName).click(); 
	 }

	 
	 // clear the text filed
	 public void clearField(String locaterName) throws IOException {
	  findLocater(locaterName).click();
	 }
	 
	 // submit the form
	 public  void submitForm(String locaterName) throws IOException {
	  findLocater(locaterName).click();
	 }

	 // select the option or click the check box
	 public  void select(String locaterName) throws IOException {
	  findLocater(locaterName).isSelected();
	 }
	 
	//user defined click Method
	 public void click(String locaterName) throws IOException {	
		 findLocater(locaterName).click();			
	}
	 
	 public void sendKeys(String objectLocater,String value) throws IOException {
			findLocater(objectLocater).sendKeys(value);
	}
	 
	public void selectdropdown(String objectLocator,String value) throws IOException, InterruptedException{
	    	Select se = new Select(findLocater(objectLocator));
	    	se.selectByVisibleText(value);	
	    	Thread.sleep(3000);
	}
	
	public void selectdropdownrandom(String objectLocator) throws IOException{
    	
    	Select se = new Select(findLocater(objectLocator));
    	List<WebElement> ele = se.getOptions();
    	se.selectByIndex(new Random().nextInt(ele.size()));
   
    }
	
	public void assertEqualsMessage(String objectLocator,String expected, String message) throws IOException{
		
		Assert.assertEquals(getText(objectLocator), expected, message);
	}
	
	public void isDisplayed(String objectLocater,String message) throws IOException{
	    	
	    Assert.assertTrue(findLocater(objectLocater).isDisplayed(),message);
	    	
	}
	
	  public void testlog(String log, String message){
	    	
	    	switch(log){
	    	
	    	case "Pass":
	    		test.log(LogStatus.PASS, message);
	    		break;
	    		
	    	case "Info":
	    		test.log(LogStatus.INFO, message);
	    		break;
	    		
	    	 default:
	         	
	         	System.out.println("Not Valid Input");
	    	}
	    }
	    
	public  void testlogError(String error){
	    		test.log(LogStatus.FAIL,"<pre>" + error.toString() + "</pre>");	
	    	}

	 
	/* //call the aftermethod() from report library
	 
	 public void screenShot(String methodName) {
	  
	  Report.afterMethod(driver, methodName);
	  
	 }
	 */
	 
	public void fluentWaitClick(final String locater) throws IOException {
	  
		  Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)       
		    .withTimeout(30, TimeUnit.SECONDS)    
		    .pollingEvery(5, TimeUnit.SECONDS)    
		    .ignoring(NoSuchElementException.class);
		  
		   wait.until(new Function<WebDriver, WebElement>() {
		   @Override
		   public WebElement  apply(WebDriver t) {
			    //return t.findElement(By.xpath(".//*[contains(text(),'+ Add')]"));
			    try {
			     System.out.println(locater);
			     element= findLocater(locater);
			     System.out.println(element);
			    } catch (IOException e) {
			     e.printStackTrace();
			    }
			    return element;
		    }
		 }); 
	 }
	
	public void scrollScreen(int length) throws InterruptedException {
		((JavascriptExecutor)driver).executeScript("scroll(0,length)");
		Thread.sleep(5000);
	}
	
	public void scrolldowntoLast(WebDriver driver){
	    	JavascriptExecutor js = ((JavascriptExecutor) driver);
	        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
	    }
	      
	public void scrolldowntoElement(String objectLocater) throws IOException{    	
	    	JavascriptExecutor js = ((JavascriptExecutor) driver);
	        js.executeScript("arguments[0].scrollIntoView(true);",findLocater(objectLocater));
	    }
	
	public boolean waitForJsToLoad() {

	    WebDriverWait wait = new WebDriverWait(driver, 30);
	    final JavascriptExecutor js = (JavascriptExecutor)driver;

	    // wait for Javascript to load
	    ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {
	      @Override
	      public Boolean apply(WebDriver driver) {
	        return js.executeScript("return document.readyState")
	            .toString().equals("complete");
	      }
	    };

	  return wait.until(jsLoad);
	}
	
	
	public void waitForElementLoad(final String objectLocater ) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement element = wait.until(
		        ExpectedConditions.visibilityOfElementLocated(By.xpath(objectLocater)));
	}
	
	
		
}

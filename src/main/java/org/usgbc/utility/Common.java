package org.usgbc.utility;

import java.io.FileInputStream;	
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import com.google.common.base.Function;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.usgbc.utility.Base;
import org.usgbc.utility.Report;


public class Common extends Base{

	 static Properties property;
	 
	 static FileInputStream fs;
	 
	 static WebElement locaterInstance;
	 
	 static WebElement element;
	 
	 public static WebElement findLocater(final String name) throws IOException {
	  
	  fs = new FileInputStream(System.getProperty("user.dir") + "\\config.properties");
	  
	  property = new Properties();
	  
	  property.load(fs);
	  
	  String[] locaters = property.getProperty(name).split("~");

	  // here we will pass the split element as parameter having index[0] to get the
	  // type of locater available

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

	 
	/* //call the aftermethod() from report library
	 
	 public void screenShot(String methodName) {
	  
	  Report.afterMethod(driver, methodName);
	  
	 }
	 */
	 
	/* public void fluentWaitClick(final String locater) throws IOException {
	  
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
	 }*/
}

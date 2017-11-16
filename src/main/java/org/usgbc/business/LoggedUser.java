package org.usgbc.business;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.usgbc.page.UsgbcWebLocators;
import org.usgbc.utility.ReusableMethods;

public class LoggedUser extends ReusableMethods {
	
	 public LoggedUser(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	 
	public  void loggedUserVerification() throws InterruptedException {
		
	    Thread.sleep(3000);
	    getcommunityRegistration().click();
		Thread.sleep(3000);
		JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("arguments[0].scrollIntoView(true);",driver.findElement(By.xpath(".//*[@id='main-menu']/li[4]/a")));
	        try {
	        	
		        if(driver.findElement(By.linkText("Sign out")).isDisplayed()) {
		        	System.out.println("user is logged in");
		        }
	        }
	        catch(Exception e) {
	        	System.out.println("user is not logged in");
	        	
	        }
	   }

	
	public  void loggedUserVerification2() throws InterruptedException {
		
	    Thread.sleep(4000);
	    getUsgbcCore().click();
	    Thread.sleep(3000);
	    signInForm("signin",2);	
	    Thread.sleep(3000);
	    String currentUrl = driver.getCurrentUrl();
	    //just to give a good output in console y test case is failing here
	    System.out.println("Navigated to:"+ currentUrl);
	    if(getCommunityRegistration().isDisplayed()) {
	    	getCommunityRegistration().click();
	 	    Thread.sleep(3000);
	 		JavascriptExecutor js = ((JavascriptExecutor) driver);
	        js.executeScript("arguments[0].scrollIntoView(true);",driver.findElement(By.xpath(".//*[@id='main-menu']/li[4]/a")));
	 	    	try {
	 	    		if(driver.findElement(By.linkText("Sign out")).isDisplayed()) {
	 		        	System.out.println("user is logged in");
	 		        }
	 	        }
	 	        catch(Exception e) {
	 	        	System.out.println("user is not logged in");	
	 	        }
	 	}else {
	 		System.out.println("Element is not Visible");
	 	}
	}
}
	
   
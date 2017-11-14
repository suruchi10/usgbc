package org.usgbc.regression;


import com.relevantcodes.extentreports.LogStatus;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import org.usgbc.business.UsgbcCore;
import org.usgbc.utility.Base;
import org.usgbc.utility.BrokenLink;

public class UsgbcCoreTest extends Base {
	

	@Test	
	public void testUsgbcCoreForNonExistingUser() throws Exception {
	
		 System.out.println("Usgbc Core Module for Non Existing User");
		 System.out.println("Broken Link for :"+driver.getTitle());
	     BrokenLink.BrokenLinkCheck(baseUrl);
	     UsgbcCore usgbcCore = PageFactory.initElements(driver, UsgbcCore.class);    
		    try {
		    	test= extent.startTest("Usgbc Core Module for Non Existing User");
		    	test.log(LogStatus.INFO, "Test Started");
		    	usgbcCore.UsgbcCoreForNonExistingUser();
		    	System.out.println("Usgbc Core Module for Non Existing User Test Finished ");
			}catch (Throwable t) {
				System.out.println(t.getLocalizedMessage());
				Error e1 = new Error(t.getMessage());
				e1.setStackTrace(t.getStackTrace());
				throw e1;
			}	
	}
	
	
	@Test	
	public void testUsgbcCoreForNonExistingUserToGetRegistered() throws Exception {
		
		 System.out.println("Usgbc Core Module for Non Existing User To Get Registered");
		 System.out.println("Broken Link for :"+driver.getTitle());
	    // BrokenLink.BrokenLinkCheck(baseUrl);
	     UsgbcCore usgbcCore = PageFactory.initElements(driver, UsgbcCore.class);    
		    try {
		    	test= extent.startTest("Usgbc Core Module for Non Existing User To Get Registered");
		    	test.log(LogStatus.INFO, "Test Started");
		    	usgbcCore.UsgbcCoreForNonExistingUserToGetRegistered();
		    	System.out.println("Usgbc Core Module User for Non Existing User To Get Registered Test Finished ");
			}catch (Throwable t) {
				System.out.println(t.getLocalizedMessage());
				Error e1 = new Error(t.getMessage());
				e1.setStackTrace(t.getStackTrace());
				throw e1;
			}	
	}
	
	@Test	
	public void testUsgbcCoreForExistingUser() throws Exception {

		 System.out.println("Usgbc Core Module for Existing User");
		 System.out.println("Broken Link for :"+driver.getTitle());
	     //BrokenLink.BrokenLinkCheck(baseUrl);
	     UsgbcCore usgbcCore = PageFactory.initElements(driver, UsgbcCore.class);    
		    try {
		    	test= extent.startTest("Usgbc Core Module for Existing User ");
		    	test.log(LogStatus.INFO, "Test Started");
		    	usgbcCore.UsgbcCoreForExistingUser();
		    	System.out.println("Usgbc Core Module User for Existing User Test Finished ");
			}catch (Throwable t) {
				System.out.println(t.getLocalizedMessage());
				Error e1 = new Error(t.getMessage());
				e1.setStackTrace(t.getStackTrace());
				throw e1;
			}	
	}
}
package org.usgbc.regression;

import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.usgbc.business.CommunityRegistration;
import org.usgbc.utility.Base;
import org.usgbc.utility.BrokenLink;

public class CommunityRegistrationTest extends Base {
	
	
	public String newBaseUrl = "";
	@Parameters({"environment"})
	@Test
	public void environmentUrls (String environment) throws Exception {
		String urls = "";
		System.out.println("hi Gaurav it is working"+environment);
		urls = callingUrls(environment);
		System.out.println("hi Gaurav it is working"+urls);
		testCommunityRegistrationForNonExistingUser(urls);
		
	}
	public void testCommunityRegistrationForNonExistingUser(String baseUrl) throws Exception {
		driver.get(baseUrl);
		System.out.println("Communtiy Registration Module for non existing user");
		System.out.println("Broken Link for :" + driver.getTitle());
		//BrokenLink.BrokenLinkCheck(baseUrl);
	    CommunityRegistration communityRegistration = PageFactory.initElements(driver, CommunityRegistration.class);    
	    try {
	    	test= extent.startTest("Communtiy Registration Module for non existing user");
	    	test.log(LogStatus.INFO, "Test Started");
	    	communityRegistration.CommunityRegistartionModuleForNonExistingUser(baseUrl);
	    	System.out.println("Communtiy Registration Module for non existing user Test Finished");
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		 }
	
	}
	@Parameters({"environment"})
	@Test
	public void testCommunityRegistrationForNonExistingUserToGetRegistered(String environment) throws Exception {
		
		driver.get(baseUrl);
		System.out.println("Communtiy Registration Module for non existing user To Get Registered");
		System.out.println("Broken Link for :"+ driver.getTitle());
		//BrokenLink.BrokenLinkCheck(baseUrl);
	    CommunityRegistration communityRegistration = PageFactory.initElements(driver, CommunityRegistration.class);    
	    try {
	    	test= extent.startTest("Communtiy Registration Module for non existing user To Get Registered");
	    	test.log(LogStatus.INFO, "Test Started");
	    	communityRegistration.CommunityRegistartionModuleForNonExistingUserToGetRegistered(baseUrl);
	    	System.out.println("Communtiy Registration Module for non existing user To Get Registered Test Finished");
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		 }
	
	}
	
	
	public void testCommunityRegistrationForExistingUser() throws Exception {
		
		driver.get(baseUrl);
		System.out.println("Communtiy Registration Module for existing user");
		System.out.println("Broken Link for :"+ driver.getTitle());
		BrokenLink.BrokenLinkCheck(baseUrl);
	    CommunityRegistration communityRegistration = PageFactory.initElements(driver, CommunityRegistration.class);    
	    try {
	    	test= extent.startTest("Communtiy Registration Module for existing user");
	    	test.log(LogStatus.INFO, "Test Started");
	    	communityRegistration.CommunityRegistartionModuleForExistingUser();
	    	System.out.println("Communtiy Registration Module for existing user Test Finished");
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		 }
	}
	
	
}

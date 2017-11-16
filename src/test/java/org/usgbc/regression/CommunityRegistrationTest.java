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
	
	@Test
	public void testCommunityRegistrationForNonExistingUser() throws Exception {
		
		System.out.println("Communtiy Registration Module for non existing user");
		System.out.println("Broken Link for :" + driver.getTitle());
		BrokenLink.BrokenLinkCheck(baseUrl);
		
	    CommunityRegistration communityRegistration = PageFactory.initElements(driver, CommunityRegistration.class);    
	    try {
	    	test= extent.startTest("Communtiy Registration Module for non existing user");
	    	test.log(LogStatus.INFO, "Test Started");
	    	communityRegistration.CommunityRegistartionModuleForNonExistingUser();
	    	System.out.println("Communtiy Registration Module for non existing user Test Finished");
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		 }
	}
	
	@Test(invocationCount=2)
	public void testCommunityRegistrationForNonExistingUserToGetRegistered() throws Exception {
		
		System.out.println("Communtiy Registration Module for non existing user To Get Registered");
		System.out.println("Broken Link for :"+ driver.getTitle());
		BrokenLink.BrokenLinkCheck(baseUrl);
		
	    CommunityRegistration communityRegistration = PageFactory.initElements(driver, CommunityRegistration.class);    
	    try {
	    	test= extent.startTest("Communtiy Registration Module for non existing user To Get Registered");
	    	test.log(LogStatus.INFO, "Test Started");
	    	communityRegistration.CommunityRegistartionModuleForNonExistingUserToGetRegistered();
	    	System.out.println("Communtiy Registration Module for non existing user To Get Registered Test Finished");
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		 }
	
	}
	
	@Test(invocationCount=2)
	public void testCommunityRegistrationForExistingUser() throws Exception {
		
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

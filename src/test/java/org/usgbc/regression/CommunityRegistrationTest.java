package org.usgbc.regression;

import com.relevantcodes.extentreports.LogStatus;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.usgbc.business.CommunityRegistration;
import org.usgbc.utility.Base;
import org.usgbc.utility.BrokenLink;

public class CommunityRegistrationTest extends Base {
	
	
	@Test
	public void testCommunityRegistration() throws Exception {
		
		driver.get(baseUrl);
		System.out.println("Communtiy Registration Module");
		System.out.println("Broken Link for / ");
		BrokenLink.BrokenLinkCheck(baseUrl);
	    CommunityRegistration communityRegistration = PageFactory.initElements(driver, CommunityRegistration.class);    
	    try {
	    	test= extent.startTest("Communtiy Registration Module");
	    	test.log(LogStatus.INFO, "Test Started");
	    	communityRegistration.CommunityRegistartionModule();
	    	System.out.println("Communtiy Registration Module Test Finished");
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		 }
	
	}
	
	
}

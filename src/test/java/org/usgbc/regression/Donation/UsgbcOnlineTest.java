package org.usgbc.regression.Donation;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import org.usgbc.business.Donation.UsgbcOnline;
import org.usgbc.utility.Base;

import com.relevantcodes.extentreports.LogStatus;

public class UsgbcOnlineTest extends Base{
	
	@Test
	public void testDonateForUsgbcByOnline() throws Exception {
	
	    UsgbcOnline usgbcOnline = PageFactory.initElements(driver, UsgbcOnline.class);    
	    try {
	    	test= extent.startTest("Donation module for USGBC Online");
	    	test.log(LogStatus.INFO, "Test Started");
	    	usgbcOnline.DonateForUsgbcByOnline();
	    	System.out.println("Donation module for USGBC Online Test Finished");
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		 }
	}

}
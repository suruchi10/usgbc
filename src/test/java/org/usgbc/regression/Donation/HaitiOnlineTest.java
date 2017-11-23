package org.usgbc.regression.Donation;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import org.usgbc.business.Donation.HaitiMail;
import org.usgbc.business.Donation.HaitiOnline;
import org.usgbc.utility.Base;

import com.relevantcodes.extentreports.LogStatus;

public class HaitiOnlineTest extends Base{
	
	@Test
	public void testDonateForHaitiByOnline() throws Exception {
	
	    HaitiOnline haitiOnline = PageFactory.initElements(driver, HaitiOnline.class);    
	    try {
	    	test= extent.startTest("Donation module for Haiti Online");
	    	test.log(LogStatus.INFO, "Test Started");
	    	haitiOnline.DonateForHaitiByOnline();
	    	System.out.println("Donation module for Haiti Online Test Finished");
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		 }
	}

}

package org.usgbc.regression.Donation;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import org.usgbc.business.Donation.HaitiMail;
import org.usgbc.utility.Base;
import org.usgbc.utility.BrokenLink;
import com.relevantcodes.extentreports.LogStatus;

public class HaitiMailTest extends Base {
	
	@Test
	public void testDonateForHaitiByMail() throws Exception {
	
	    HaitiMail haitiMail = PageFactory.initElements(driver, HaitiMail.class);    
	    try {
	    	test= extent.startTest("Donation module for Haiti Mail");
	    	test.log(LogStatus.INFO, "Test Started");
	    	haitiMail.DonateForHaitiByMail();
	    	System.out.println("Donation module for Haiti Mail Test Finished");
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		 }
	}

}

package org.usgbc.regression.Donation;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import org.usgbc.business.Donation.mygreenappleOnline;
import org.usgbc.utility.Base;
import com.relevantcodes.extentreports.LogStatus;

public class mygreenappleOnlineTest extends Base{
	
	@Test
	public void testDonateFormygreenappleByOnline() throws Exception {
	
		mygreenappleOnline mygreenappleOnline = PageFactory.initElements(driver, mygreenappleOnline.class);    
	    try {
	    	test= extent.startTest("Donation module for mygreenapple Online");
	    	test.log(LogStatus.INFO, "Test Started");
	    	mygreenappleOnline.DonateFormygreenappleByOnline();
	    	System.out.println("Donation module for mygreenapple Online Test Finished");
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		 }
	}
}
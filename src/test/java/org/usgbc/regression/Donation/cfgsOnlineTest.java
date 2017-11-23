package org.usgbc.regression.Donation;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import org.usgbc.business.Donation.cfgsOnline;
import org.usgbc.utility.Base;
import com.relevantcodes.extentreports.LogStatus;

public class cfgsOnlineTest extends Base{
	
	@Test
	public void testDonateForcfgsByOnline() throws Exception {
	
	    cfgsOnline cfgsOnline = PageFactory.initElements(driver, cfgsOnline.class);    
	    try {
	    	test= extent.startTest("Donation module for cfgs Online");
	    	test.log(LogStatus.INFO, "Test Started");
	    	cfgsOnline.DonateForcfgsByOnline();
	    	System.out.println("Donation module for cfgs Online Test Finished");
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		 }
	}
}
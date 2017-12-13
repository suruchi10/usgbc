package org.usgbc.regression.Donation;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import org.usgbc.business.Donation.AmountValidation;
import org.usgbc.utility.Base;

import com.relevantcodes.extentreports.LogStatus;

public class AmountValidationTest extends Base {
	
	@Test
	public void testDatavalidation() throws Exception {
	
	    AmountValidation amountValidation = PageFactory.initElements(driver, AmountValidation.class);    
	    try {
	    	test= extent.startTest("Donation module for Data Validation");
	    	test.log(LogStatus.INFO, "Test Started");
	    	amountValidation.amountTextValidation();
	    	System.out.println("Donation module for Data Validation  Test Finished");
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		 }
	}

}

package org.usgbc.regression;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import org.usgbc.business.ErrorMessageCommReg;
import org.usgbc.utility.Base;

import com.relevantcodes.extentreports.LogStatus;


public class ErrorMessageCommRegTest extends Base {
    	
	@Test(priority=0)	
	public void testErrorMessagesCommReg() throws Exception {
		
		System.out.println("Communtiy Registration Error Message Validation Test");
		
	    ErrorMessageCommReg errorMessageCommReg = PageFactory.initElements(driver, ErrorMessageCommReg.class);    
	    try {
	    	test= extent.startTest("Communtiy Registration Error Message Validation Test");
	    	test.log(LogStatus.INFO, "Test Started");
	    	errorMessageCommReg.CommunityRegistrationErrorMessage();
	    	System.out.println("Communtiy Registration Error Message Validation Test Finished");
		}  catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		 }
	
	}
	
	
	
	@Test(priority=1)	
	public void testErrorMessagesCommRegCondition2() throws Exception {
		
		System.out.println("Communtiy Registration Error Message Validation Condition 2 Test");
		
	    ErrorMessageCommReg errorMessageCommReg2 = PageFactory.initElements(driver, ErrorMessageCommReg.class);    
	    try {
	    	test= extent.startTest("Communtiy Registration Error Message Validation Condition 2 Test");
	    	test.log(LogStatus.INFO, "Test Started");
	    	errorMessageCommReg2.CommunityRegistrationErrorMessageCondition2();
	    	System.out.println("Communtiy Registration Error Message Validation Condition 2 Test Finished");
		}  catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		 }
	
	}
	
	@Test(priority=2)	
	public void testErrorMessagesCommRegCondition3() throws Exception {
		
		System.out.println("Communtiy Registration Error Message Validation Condition 3 Test");
		
	    ErrorMessageCommReg errorMessageCommReg3= PageFactory.initElements(driver, ErrorMessageCommReg.class);    
	    try {
	    	test= extent.startTest("Communtiy Registration Error Message Validation Condition 3 Test");
	    	test.log(LogStatus.INFO, "Test Started");
	    	errorMessageCommReg3.CommunityRegistrationErrorMessageCondition3();
	    	System.out.println("Communtiy Registration Error Message Validation Condition 3 Test Finished");
		}  catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		 }
	
	}

}

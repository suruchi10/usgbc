package org.usgbc.regression;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import org.usgbc.business.CommunityRegistration;
import org.usgbc.business.CommunityRegistrationPriceValidation;
import org.usgbc.utility.Base;
import org.usgbc.utility.CommunityRegistrationFormData;
import org.usgbc.utility.ReusableMethods;

import com.relevantcodes.extentreports.LogStatus;

public class CommunityRegistrationPriceValidationTest  extends Base {

	@Test(priority=0)
	public void testCommunityRegistrationForCostValidationDefault35() throws Exception {
		
		System.out.println("Communtiy Registration Module for cost validationas default $35");
	
		CommunityRegistrationPriceValidation communityRegistrationPriceValidation = PageFactory.initElements(driver,CommunityRegistrationPriceValidation.class);    
	    try {
	    	test= extent.startTest("Communtiy Registration Module for cost validation default $35");
	    	test.log(LogStatus.INFO, "Test Started");
	    	communityRegistrationPriceValidation.CommunityRegistartionModuleForCostValidationDefault35();
	    	System.out.println("Communtiy Registration Module for cost validation default $35 Test Finished");
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		 }
	}
	
	@Test(priority=1)
	public void testCommunityRegistrationForCostValidationStudentMember50() throws Exception {
		
		System.out.println("Communtiy Registration Module for cost validation as Student Member $50");
	
		CommunityRegistrationPriceValidation communityRegistrationPriceValidation = PageFactory.initElements(driver,CommunityRegistrationPriceValidation.class);    
	    try {
	    	test= extent.startTest("Communtiy Registration Module for cost validation as Student Member $50");
	    	test.log(LogStatus.INFO, "Test Started");
	    	communityRegistrationPriceValidation.CommunityRegistrationForCostValidationStudentMember50();
	    	System.out.println("Communtiy Registration Module for cost validation as Student Member $50 Test Finished");
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		 }
	}
	
	@Test(priority=2)
	public void testCommunityRegistrationForCostValidationEmergingprofessionalMember75() throws Exception {
		
		System.out.println("Communtiy Registration Module for cost validation as Emerging professional Member $75");
	
		CommunityRegistrationPriceValidation communityRegistrationPriceValidation = PageFactory.initElements(driver,CommunityRegistrationPriceValidation.class);    
	    try {
	    	test= extent.startTest("Communtiy Registration Module for cost validation as Emerging professional Member $75");
	    	test.log(LogStatus.INFO, "Test Started");
	    	communityRegistrationPriceValidation.CommunityRegistrationForCostValidationEmergingProfessionalMember75();
	    	System.out.println("Communtiy Registration Module for cost validationas as Emerging professional Member $75 Test Finished");
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		 }
	}
}

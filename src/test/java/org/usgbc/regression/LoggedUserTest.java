package org.usgbc.regression;


import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import org.usgbc.business.LoggedUser;
import org.usgbc.utility.Base;
import org.usgbc.utility.BrokenLink;

import com.relevantcodes.extentreports.LogStatus;

public class LoggedUserTest extends Base{
	
	@Test
	public void testLoggedUser() throws Exception {
		
	    driver.get(baseUrl+"/community/registration");
	    System.out.println("Logged User  Test");
	    BrokenLink.verifyLinkActive(baseUrl+"/community/registration");	    
	    LoggedUser loggedUser = PageFactory.initElements(driver, LoggedUser.class);    
		    try {
		    	test= extent.startTest("Logged User Test");
		    	test.log(LogStatus.INFO, "Test Started");
		    	loggedUser.loggedUserVerification();
		    	System.out.println("Logged User Test Finished ");
			} catch (Throwable t) {
				System.out.println(t.getLocalizedMessage());
				Error e1 = new Error(t.getMessage());
				e1.setStackTrace(t.getStackTrace());
				throw e1;
			 }
		    
	
	}
	@Test
	public void testLoggedUser2() throws Exception {
	
	    driver.get(baseUrl);
	    System.out.println("Logged User  Test case 2");
	    BrokenLink.verifyLinkActive(baseUrl);	    
	    LoggedUser loggedUser = PageFactory.initElements(driver, LoggedUser.class);    
		    try {
		    	test= extent.startTest("Logged User Test case 2");
		    	test.log(LogStatus.INFO, "Test Started");
		    	loggedUser.loggedUserVerification2();
		    	System.out.println("Logged User Test case 2 Finished ");
			} catch (Throwable t) {
				System.out.println(t.getLocalizedMessage());
				Error e1 = new Error(t.getMessage());
				e1.setStackTrace(t.getStackTrace());
				throw e1;
			 }
		    
	
	}

}

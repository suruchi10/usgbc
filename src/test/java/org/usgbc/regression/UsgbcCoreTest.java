package org.usgbc.regression;


import com.relevantcodes.extentreports.LogStatus;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import org.usgbc.business.UsgbcCore;
import org.usgbc.utility.Base;
import org.usgbc.utility.BrokenLink;

public class UsgbcCoreTest extends Base {
	

	@Test	
	public void testUsgbcCore() throws Exception {
		
		 String url ="https://test-dynamic-usgbc.pantheonsite.io/";
		 driver.get(url);
		 System.out.println("Usgbc Core Module");
		 System.out.println("Broken Link for / ");
	     BrokenLink.BrokenLinkCheck(url);
	     UsgbcCore usgbcCore = PageFactory.initElements(driver, UsgbcCore.class);    
		    try {
		    	test= extent.startTest("Usgbc Core Module");
		    	test.log(LogStatus.INFO, "Test Started");
		    	usgbcCore.UsgbcCoreForm();
		    	System.out.println("Usgbc Core Module Test Finished ");
			}catch (Throwable t) {
				System.out.println(t.getLocalizedMessage());
				Error e1 = new Error(t.getMessage());
				e1.setStackTrace(t.getStackTrace());
				throw e1;
			 }	
	}
}
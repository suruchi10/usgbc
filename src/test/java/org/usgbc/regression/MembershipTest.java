package org.usgbc.regression;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import org.usgbc.business.Membership;
import org.usgbc.business.Store;
import org.usgbc.utility.Base;
import org.usgbc.utility.BrokenLink;

import com.relevantcodes.extentreports.LogStatus;

public class MembershipTest extends Base{
	
	@Test	
	public void testMembership() throws Exception {
		
		Thread.sleep(3000);
		driver.get(baseUrl+"/membership/contact");
		System.out.println("Membership Module ");
		System.out.println("Broken Link for :" + driver.getTitle());
		BrokenLink.BrokenLinkCheck(baseUrl+"/membership/contact");
	    Membership membership = PageFactory.initElements(driver, Membership.class);  
		    try {
		    	test= extent.startTest("Membership Module");
		    	test.log(LogStatus.INFO, "Test Started");
		    	membership.MembershipModule();
		    	System.out.println("Memberships Module Test Finished ");
			}catch (Throwable t) {
				System.out.println(t.getLocalizedMessage());
				Error e1 = new Error(t.getMessage());
				e1.setStackTrace(t.getStackTrace());
				throw e1;
			 }
	}
}
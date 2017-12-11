package org.usgbc.business.Donation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.usgbc.utility.Common;
import org.usgbc.utility.ReusableMethods;

import com.relevantcodes.extentreports.LogStatus;

public class cfgsOnline extends ReusableMethods {
	
	public cfgsOnline(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	Common common =new Common();
	
	public void DonateForcfgsByOnline() throws Exception {
		
		System.out.println("Donation module for cfgs Online");
		
		Thread.sleep(2000);
		driver.get(baseUrl+"/donations/center/online/cfgs");
		//driver.navigate().to(baseUrl+"/donations/center/online/cfgs");
		
		common.scrolldowntoElement("Donate_Nav");
		Thread.sleep(2000);
 		common.testlog("Pass", "Scrolled till Donation Nav ");
 				
		donationByOnline("DonationByOnline",2);
		
		Assert.assertTrue(true);
		
		common.assertEqualsMessage("PaymentInfo","Payment info","Verifying Navigation from Donation online page to Payment page");
		Thread.sleep(2000);
	    common.testlog("Pass","Navigation Verified Successfully");
	    
		paymentReceiptdownload();
	}

}

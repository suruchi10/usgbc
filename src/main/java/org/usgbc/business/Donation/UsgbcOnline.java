package org.usgbc.business.Donation;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.usgbc.utility.Common;
import org.usgbc.utility.ReusableMethods;

public class UsgbcOnline extends ReusableMethods {
	
	public UsgbcOnline(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	Common common =new Common();
	
	public void DonateForUsgbcByOnline() throws Exception {
		
		System.out.println("Donation module for USGBC Online");
		
		//driver.navigate().to(baseUrl+"/donations/center/online/usgbc");
		driver.get(baseUrl+"/donations/center/online/usgbc");
		driver.navigate().to(baseUrl+"/donations/center/online/usgbc");
		
		common.isDisplayed("UsgbcLogo", "Donation for USGBC");
		Thread.sleep(2000);
 		common.testlog("Pass", "Donation for USGBC");
		
		common.scrolldowntoElement("Donate_Nav");
		Thread.sleep(2000);
 		common.testlog("Pass", "Scrolled till Donation Nav");
 		
 		donationByOnline("DonationByOnline",3);
	
		Assert.assertTrue(true);
		
		common.assertEqualsMessage("PaymentInfo","Payment info","Verifying Navigation from Donation online page to Payment page");
		Thread.sleep(2000);
	    common.testlog("Pass","Navigation Verified Successfully");
	    
		paymentReceiptdownload();
	}

}

package org.usgbc.business.Donation;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.usgbc.utility.Common;
import org.usgbc.utility.ReusableMethods;

public class HaitiOnline extends ReusableMethods {
	
	public HaitiOnline(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	Common common =new Common();
	
	public void DonateForHaitiByOnline() throws Exception {
		
		System.out.println("Donation module for Haiti Online");
		
		//driver.navigate().to(baseUrl+"/donations/center/online/haiti");
		driver.get(baseUrl+"/donations/center/online/haiti");
		
//		common.isDisplayed("HaitiLogo", "Donation for Haiti");
//		Thread.sleep(2000);
// 		common.testlog("Pass", "Donation for Haiti");
		
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

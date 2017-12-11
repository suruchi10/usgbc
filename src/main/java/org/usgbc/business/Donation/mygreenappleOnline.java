package org.usgbc.business.Donation;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.usgbc.utility.Common;
import org.usgbc.utility.ReusableMethods;

public class mygreenappleOnline extends ReusableMethods {
	
	public mygreenappleOnline(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	Common common =new Common();
	
	public void DonateFormygreenappleByOnline() throws Exception {
		
		System.out.println("Donation module for mygreenapple Online");
		
		driver.get(baseUrl+"/donations/center/online/mygreenapple/");
		//driver.navigate().to(baseUrl+"/donations/center/online/mygreenapple");
		
		common.isDisplayed("mygreenappleLogo", "Donation for mygreenapple");
		Thread.sleep(2000);
 		common.testlog("Pass", "Donation for mygreenapple");
		
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

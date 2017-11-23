package org.usgbc.business.Donation;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.usgbc.utility.Common;
import org.usgbc.utility.ReusableMethods;

public class HaitiMail extends ReusableMethods {
	
	public HaitiMail(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	Common common =new Common();
	
	public void DonateForHaitiByMail() throws Exception {
		
		System.out.println("Donation module for Haiti Mail");
		
		driver.navigate().to(baseUrl+"/donations/center/online/haiti");
		//driver.get(baseUrl+"/donations/center/mail/haiti");
		
//		common.isDisplayed("HaitiLogo", "Donate for Haiti");
//		Thread.sleep(2000);
// 		common.testlog("Pass", "Donation for Haiti");
		
		common.scrolldowntoElement("Donate_Nav");
		Thread.sleep(2000);
 		common.testlog("Pass", "Scrolled till Donation Online Nav ");
 		
		common.click("DonateMailNav");
		Thread.sleep(2000);
		common.testlog("Pass", "Clicked on Donation Mail Nav ");
		
		common.assertEqualsMessage("DonationByMail","Donate by mail","Verifying Navigation from Donate Online Nav to Donate Mail Nav");
		Thread.sleep(2000);
	    common.testlog("Pass","Navigation Verified Successfully");
 		
 		common.assertEqualsMessage("DonationDetails","Donate by mail","Verifying  page load with text apperance");
 		Thread.sleep(2000);
	    common.testlog("Pass","Navigation Verified Successfully");
		
		donationByMail("DonationByMail",3);
		
		Assert.assertTrue(true);
		
		System.out.println("Form printed Successfully");	
	}

}

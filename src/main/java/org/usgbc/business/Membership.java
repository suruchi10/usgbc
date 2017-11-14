package org.usgbc.business;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.usgbc.utility.BrokenLink;
import org.usgbc.utility.ReusableMethods;

public class Membership extends ReusableMethods {
	
	public Membership(WebDriver driver) {
			super(driver);
			// TODO Auto-generated constructor stub
		}
	
	public void MembershipModule() throws Exception {
		
			Assert.assertTrue(getContactinfo().getText().contains("Click here to Sign in"));
			System.out.println("User not logged in");
		    getMembershipSignin().click();
			Thread.sleep(3000);
			String MembershipSignin_url = driver.getCurrentUrl();
			 if (MembershipSignin_url.equals(baseUrl+"/signin?destination=/membership/contact")) {
				 Assert.assertTrue(true);
				 signInForm("signin",7);
				 String Signin_url = driver.getCurrentUrl();
				   if (Signin_url.equalsIgnoreCase(baseUrl+"/signin?destination=/membership/contact") && getUserNotExist().isDisplayed()){
					   Assert.assertTrue( getUserNotExist().getText().contains("This user does not exist in the system")); 
					   System.out.println("This user does not exist in the system.");
					   getRegister().click();
					   signUpForm();
					   Thread.sleep(3000);
					   String membershipContatct_url = driver.getCurrentUrl();
					   if(membershipContatct_url.equalsIgnoreCase(baseUrl+"/membership/contact")) {
						   Assert.assertTrue(true);
						   System.out.println("User registration is successful");
						   System.out.println("*****contact-membership-payment-receipt*****");
						   Contact_Form_membership("contact" , 3);
						   membership();
						   Assert.assertEquals( driver.getCurrentUrl(),baseUrl+"/usgbc/payment");
						   paymentReceiptdownload();
					   }else {
						   System.out.println("User registration is not successful");
					   }
				   }else {
					   Assert.assertEquals(Signin_url, baseUrl+"/membership/contact");
					   Assert.assertTrue(getContactinfo().getText().contains("You are signed in as"));
					   System.out.println("Signin successful");
					   System.out.println("*****contact-membership-payment-receipt*****");
					   Contact_Form_membership("contact" , 3);
					   membership();
					   Assert.assertEquals( driver.getCurrentUrl(),baseUrl+"/usgbc/payment");
					   numberOfRowsAndColumnInTable();
					   paymentReceiptdownload();
				   }
			 }else
			 {
				 System.out.println("Signin link not working or clicked");
			 }
		}
}
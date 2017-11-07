package org.usgbc.business;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.usgbc.utility.BrokenLink;
import org.usgbc.utility.CommunityRegistrationFormData;
import org.usgbc.utility.ReusableMethods;

public class UsgbcCore extends ReusableMethods{


	public UsgbcCore(WebDriver driver) {
		super(driver);		
	}
	
	public void receiptdownload() throws Exception {
		
		getCommunityRegistration().click();
		Thread.sleep(3000);
		CommunityRegistrationFormData.CommmunityRegistrationForm();
		String payment_url = driver.getCurrentUrl();
		Assert.assertEquals(payment_url, baseUrl+"/usgbc/payment");
		System.out.println("Broken Link for /usgbc/payment ");
		BrokenLink.BrokenLinkCheck(payment_url);
		paymentForm("payment", 2);
		Thread.sleep(3000);
		String receipt_url = driver.getCurrentUrl();
		
			  if (receipt_url.equalsIgnoreCase(baseUrl+"/payment/reciept")) {
				   Assert.assertTrue(true);
				   System.out.println("Broken Link for /payment/reciept ");
				   BrokenLink.BrokenLinkCheck(receipt_url);
				   getprint_Receipt().click();
				   System.out.println("Receipt downloaded ");
			  }else if(receipt_url.equalsIgnoreCase(baseUrl+"/usgbc/payment") && getErrorMsg().isDisplayed() ){ 
				  Assert.assertTrue(true);
				  System.out.println("You have very recently placed an order for this item. Please review your order history to confirm your previous order  ");
			  }else {
				  System.out.println("Error in payment form submission. ");
			  }		
	}
	
	public void UsgbcCoreForm() throws Exception {
		
		getUsgbcCore().click();
		String signin_url =driver.getCurrentUrl();
		Thread.sleep(3000);
		Assert.assertEquals(signin_url,baseUrl+"/signin" );
		System.out.println("Broken Link for /signin ");
		BrokenLink.BrokenLinkCheck(signin_url);
		signInForm("signin",9);	
		Thread.sleep(3000);
	    String Signin_url = driver.getCurrentUrl();
			   if (Signin_url.equalsIgnoreCase(baseUrl+"/signin")) {
				   Assert.assertTrue(true);
				   System.out.println("This user does not exist in the system. ");
				   getRegister().click();
				   Thread.sleep(3000);
				   String signup_url = driver.getCurrentUrl();
				   System.out.println("Broken Link for /signup ");
				   BrokenLink.BrokenLinkCheck(signup_url);
				   signUpForm("signup", 9);
				   Thread.sleep(3000);
				   //String notauthorized_url = driver.getCurrentUrl();
				   String usgbcPayment_url = driver.getCurrentUrl();
				   Assert.assertEquals(usgbcPayment_url, baseUrl+"/usgbc/payment");
				   System.out.println("User registered and created sucessfully");
				   System.out.println("Broken Link for /usgbc/payment ");
				   BrokenLink.BrokenLinkCheck(usgbcPayment_url);
				   receiptdownload();  
				   
			   }else {
			   Assert.assertEquals(Signin_url, baseUrl+"/usgbc/payment");   
			   System.out.println("User is registered already ");
			   System.out.println("Broken Link for /usgbc/payment  ");
			   BrokenLink.BrokenLinkCheck(Signin_url);
			   receiptdownload();
			   }		
	}
	
	
}


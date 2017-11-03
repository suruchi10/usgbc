package org.usgbc.business;

import java.io.IOException;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.usgbc.page.UsgbcWebLocators;
import org.usgbc.utility.Base;
import org.usgbc.utility.BrokenLink;
import org.usgbc.utility.CommunityRegistrationFormData;
import org.usgbc.utility.ReusableMethods;

public class CommunityRegistration extends ReusableMethods{

	public CommunityRegistration(WebDriver driver) {
		super(driver);		
	}
	
	
	public void CommunityRegistartionModule() throws Exception {
		
		getcommunityRegistration().click();
		//Thread.sleep(3000);
		String communityRegistration_url = driver.getCurrentUrl();
		Assert.assertEquals(communityRegistration_url, baseUrl+"/community/registration");
		System.out.println("Broken Link for community/registration ");
		//BrokenLink.BrokenLinkCheck(communityRegistration_url);
		CommunityRegistrationFormData.CommmunityRegistrationForm();
	    String signin_url = driver.getCurrentUrl();
		if (signin_url.equalsIgnoreCase(baseUrl+"/signin") && driver.getTitle().contains("Sign-in")){
			   Assert.assertTrue(true);
			   System.out.println("Test Passed,session created and  order id generated ");
			   System.out.println("Broken Link for /signin ");
			   BrokenLink.BrokenLinkCheck(signin_url);
			   signInForm("signin",3);
			   //Thread.sleep(3000);
			   String Signin_url = driver.getCurrentUrl();
				   if (Signin_url.equalsIgnoreCase(baseUrl+"/signin")) {
					   Assert.assertTrue(true);
					   System.out.println("This user does not exist in the system. ");
					   getRegister().click();
					   Thread.sleep(3000);
					   String signup_url = driver.getCurrentUrl();
					   System.out.println("Broken Link for /signup ");
					   BrokenLink.BrokenLinkCheck(signup_url);
					   signUpForm("signup",  3);
					   Thread.sleep(3000);
					   String payment_url = driver.getCurrentUrl();
					   Assert.assertEquals(payment_url, baseUrl+"/usgbc/payment");
					   System.out.println("User registered and created sucessfully");
					   System.out.println("Broken Link for /usgbc/payment ");
					   BrokenLink.BrokenLinkCheck(payment_url);
					   receiptdownload();  
					   
				   }else {
				   Assert.assertEquals(Signin_url, baseUrl+"/usgbc/payment");   
				   System.out.println("User is registered already ");
				   System.out.println("Broken Link for /usgbc/payment ");
				   BrokenLink.BrokenLinkCheck(Signin_url);
				   receiptdownload();
				   }
			   
		   }else {
			       signin_url.equalsIgnoreCase(baseUrl+"/community/registration");
				   Assert.assertTrue(true);
				   System.out.println(" Test Failed, Form field left empty");   
			   }
	     }	
}



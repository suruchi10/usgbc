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
	
	public void UsgbcCoreForNonExistingUser() throws Exception {
			
		getUsgbcCore().click();
		Thread.sleep(3000);
		String signin_url =driver.getCurrentUrl();
		Thread.sleep(3000);
		Assert.assertEquals(signin_url,baseUrl+"/signin" );
		System.out.println("Broken Link for :"+driver.getTitle());
		BrokenLink.BrokenLinkCheck(signin_url);
		signInForm("signin",10); //signin 10 => (amayra@gmail.com,amayra)
		Thread.sleep(3000);
		String Signin_url = driver.getCurrentUrl();
		Thread.sleep(3000);
		//System.out.println("Broken: "+Signin_url);
		//System.out.println(getStatusMessageBlock().getText());
		if (Signin_url.equalsIgnoreCase(baseUrl+"/signin") && getStatusMessageBlock().getText().contains("This user does not exist in the system.")) {
			Assert.assertTrue(true);
			System.out.println("-----This user does not exist in the system.------");
		}
		else {
			System.out.println("else block");
		}
	}
	
	 public void UsgbcCoreForNonExistingUserToGetRegistered() throws Exception {
		 	
		getUsgbcCore().click();
		Thread.sleep(3000);
		String signin_url =driver.getCurrentUrl();
		Thread.sleep(2000);
		Assert.assertEquals(signin_url,baseUrl+"/signin" );
		System.out.println("Broken Link for :"+driver.getTitle());
		BrokenLink.BrokenLinkCheck(signin_url);
		getRegister().click();
		Thread.sleep(2000);
		String signup_url = driver.getCurrentUrl();
		System.out.println("Broken Link for :"+driver.getTitle());
		BrokenLink.BrokenLinkCheck(signup_url);
		signUpForm();//  modified with faker class
		Thread.sleep(3000);
		String payment_url = driver.getCurrentUrl();
		Thread.sleep(3000);
		//System.out.println(payment_url);
		Assert.assertEquals(payment_url, baseUrl+"/usgbc/payment");
		System.out.println("-----User registered and created sucessfully-----");
		
	}

	public void UsgbcCoreForExistingUser() throws Exception {
		
		getUsgbcCore().click();
		Thread.sleep(3000);
		String signin_url =driver.getCurrentUrl();
		Thread.sleep(3000);
		Assert.assertEquals(signin_url,baseUrl+"/signin" );
		System.out.println("Broken Link for :"+driver.getTitle());
		BrokenLink.BrokenLinkCheck(signin_url);
		signInForm("signin",3);	//signin 3 => (abi@gmail.com,abi)
		Thread.sleep(3000);
		String payment_url = driver.getCurrentUrl();
		Thread.sleep(3000);
		Assert.assertEquals(payment_url, baseUrl+"/usgbc/payment");
		System.out.println("Broken Link for :"+driver.getTitle());
		BrokenLink.BrokenLinkCheck(payment_url);	
		System.out.println("-----User logged in sucessfully-----");
	}	
}



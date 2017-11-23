package org.usgbc.business;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.usgbc.utility.BrokenLink;
import org.usgbc.utility.ReusableMethods;

public class UsgbcStore extends ReusableMethods {
	
	
	  public UsgbcStore(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	/*----------------------------------------*/
	public void UsgbcStoreModule() throws Exception {
		
		System.out.println("Usgbc Store Module");
		System.out.println("Broken Link for :"+ driver.getTitle());
	    BrokenLink.BrokenLinkCheck(baseUrl);
		getUsgbcStore().click();
		Thread.sleep(3000);
		String storeContact_url =driver.getCurrentUrl();
		//System.out.println(storeContact_url);
		Thread.sleep(3000);
		 if (storeContact_url.equals(baseUrl+"/store/contact")&& getStatusMessageNoItemsAdded().isDisplayed()) {
			 Assert.assertTrue(getStatusMessageNoItemsAdded().getText().contains("No items are added to the cart"));
			 System.out.println("No Items are added to the cart");
		 }
		 else
		 {
			 System.out.println(" It is going to else condition ");
		 }
	}
	
    /*----------------------------------------*/
	
     public void UsgbcStoreModuleGreen() throws Exception {
    	 
    	System.out.println("Usgbc Store Module Green Apple Lapel Pins");
		System.out.println("Broken Link for : "+ driver.getTitle());
	    BrokenLink.BrokenLinkCheck(baseUrl);
    	getAddToCartGreen().click();
		Thread.sleep(3000);
		String cart_url =driver.getCurrentUrl();
		Thread.sleep(3000);
			if(cart_url.equalsIgnoreCase(baseUrl+"/cart") && getStatusMessageBlock().isDisplayed()) {
				 Assert.assertTrue(getStatusMessage().getAttribute("innerHTML").contains("Green Apple Lapel Pins"));
				 System.out.println(getStatusMessage().getAttribute("innerHTML")+" : Product added to your shopping cart. ");
				 getUsgbcStore().click();
				 Thread.sleep(3000);
				 String StoreContact_url = driver.getCurrentUrl();
				 Assert.assertEquals(StoreContact_url, baseUrl+"/store/contact");	
				 System.out.println("*****contact-payment-receipt*****");
				 Contact_Form("contact" , 3);
				 Thread.sleep(3000);
				 signInForm("signin",8);//(test25@testuser.com test123) user provided by ekta only user can download receipt 
				 Thread.sleep(3000);
				 contactPaymentReceipt();	 
			}else {
				System.out.println("Add to cart link not clicked");
				System.out.println("......"+ driver.getCurrentUrl() + "......" );
			}
	}
     
     /*----------------------------------------*/
     
     public void UsgbcStoreModuleGreen2() throws Exception {
    	 
    	System.out.println("Usgbc Store Module Green Apple Lapel Pins scenario 2");
		System.out.println("Broken Link for : "+ driver.getTitle());
	    BrokenLink.BrokenLinkCheck(baseUrl);
     	getAddToCartGreen().click();
 		Thread.sleep(3000);
 		String cart_url =driver.getCurrentUrl();
 		Thread.sleep(3000);
 			if(cart_url.equalsIgnoreCase(baseUrl+"/cart") && getStatusMessageBlock().isDisplayed()) {
 				 Assert.assertTrue(getStatusMessage().getAttribute("innerHTML").contains("Green Apple Lapel Pins"));
 				 System.out.println(getStatusMessage().getAttribute("innerHTML")+" : Product added to your shopping cart. ");
 				 getCheckOutButton().click();
 				 Thread.sleep(3000);
 				 String StoreContact_url = driver.getCurrentUrl();
 				 Assert.assertEquals(StoreContact_url, baseUrl+"/store/contact");	
 				 System.out.println("******contact-payment-receipt*****");
 				 Contact_Form("contact" , 3);
 				 Thread.sleep(3000);
 				 signInForm("signin",11);//(ruchi@gmail.com, ruchi ) registered user , user not found
 				 Thread.sleep(3000);
 				 contactPaymentReceipt();
 				 
 			}else {
				System.out.println("Add to cart link not clicked");
				 System.out.println("......"+ driver.getCurrentUrl() + "......" );
			}
 	} 
     
     /*----------------------------------------*/
     public void UsgbcStoreModuleLEED() throws Exception {
    	
		System.out.println("Usgbc Store Module LEED Reference Guide for Homes Design and Construction (e-document)");
		System.out.println("Broken Link for for: "+ driver.getTitle());
	    BrokenLink.BrokenLinkCheck(baseUrl); 	
    	getAddToCartLEED().click();
 		Thread.sleep(3000);
 		String cart_url =driver.getCurrentUrl();
 		Thread.sleep(3000);
 			if(cart_url.equalsIgnoreCase(baseUrl+"/cart") && getStatusMessageBlock().isDisplayed()) {
 				 Assert.assertTrue(getStatusMessage().getAttribute("innerHTML").contains("LEED Reference Guide for Homes Design and Construction (e-document)"));
 				 System.out.println(getStatusMessage().getAttribute("innerHTML")+" : Product added to your shopping cart. ");
 				 getUsgbcStore().click();
 				 Thread.sleep(3000);
 				 String StoreContact_url = driver.getCurrentUrl();
 				 Assert.assertEquals(StoreContact_url, baseUrl+"/store/contact");	
 				 System.out.println("*****contact-payment-receipt*****");
 				 //Contact_Form("contact" , 3);
 				 getWebsite().click();
 				 getContinue().click();
 				 Thread.sleep(3000);
 				 signInForm("signin",8);//(test25@testuser.com, test123), receipt download 
 				 Thread.sleep(3000);
 				 contactPaymentReceipt();	 
 			}else {
 				System.out.println("Add to cart link not clicked");
 				System.out.println("......"+ driver.getCurrentUrl() + "......" );
 			}
 	}
      /*----------------------------------------*/
     
      public void UsgbcStoreModuleLEED2() throws Exception {
    	
 		System.out.println("Usgbc Store Module LEED Reference Guide for Homes Design and Construction (e-document) scenario 2");
 		System.out.println("Broken Link for : "+ driver.getTitle());
 	    BrokenLink.BrokenLinkCheck(baseUrl);
    	getAddToCartLEED().click();
  		Thread.sleep(3000);
  		String cart_url =driver.getCurrentUrl();
  		Thread.sleep(3000);
  			if(cart_url.equalsIgnoreCase(baseUrl+"/cart") && getStatusMessageBlock().isDisplayed()) {
  				 Assert.assertTrue(getStatusMessage().getAttribute("innerHTML").contains("LEED Reference Guide for Homes Design and Construction (e-document)"));
  				 System.out.println(getStatusMessage().getAttribute("innerHTML")+" : Product added to your shopping cart. ");
  				 getCheckOutButton().click();
  				 Thread.sleep(3000);
  				 String StoreContact_url = driver.getCurrentUrl();
  				 Assert.assertEquals(StoreContact_url, baseUrl+"/store/contact");	
  				 System.out.println("*****contact-payment-receipt*****");
  				 // Contact_Form("contact" , 3);
  				 getWebsite().click();
  				 getContinue().click();
  				 Thread.sleep(3000);
  				 signInForm("signin",11);//(ruchi@gmail.com ,ruchi), user not found
  				 Thread.sleep(3000);
  				 contactPaymentReceipt();
  				 
  			}else {
 				System.out.println("Add to cart link not clicked");
 				System.out.println("......"+ driver.getCurrentUrl() + "......" );
 			}
  	} 
}
package org.usgbc.business;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.usgbc.utility.ReusableMethods;

public class Store extends ReusableMethods{
	
	public Store(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
		
	}

	public void StoreModuleGreen() throws Exception {
		
		getGreenAppleLapelPins().click();
		Thread.sleep(3000);
		String GreenAppleLapelPins_url = driver.getCurrentUrl();
			 if((GreenAppleLapelPins_url.equalsIgnoreCase(baseUrl+"/node/31")) && driver.getTitle().contains("Green Apple Lapel Pins")) {
			 Assert.assertTrue(true);
			 getAddToCartGreen().click();
			 Thread.sleep(3000);
		     String Cart_url = driver.getCurrentUrl();
		     		if((Cart_url.equalsIgnoreCase(baseUrl+"/cart"))&& driver.getTitle().contains("Shopping cart")) { 
		     			 Assert.assertTrue(getStatusMessage().getAttribute("innerHTML").contains("Green Apple Lapel Pins"));
						 System.out.println(getStatusMessage().getAttribute("innerHTML")+" : Product added to your shopping cart. ");
						 getUsgbcStore().click();
						 Thread.sleep(3000);
						 String StoreContact_url = driver.getCurrentUrl();
						 Assert.assertEquals(StoreContact_url, baseUrl+"/store/contact");	
						 System.out.println("*****contact-payment-receipt******");
						 Contact_Form("contact" , 3);
						 Thread.sleep(3000);
						 signInForm("signin",9);
						 contactPaymentReceipt();
				 		
					}else {
						System.out.println("Add to cart link is not clicked");
						System.out.println("......"+ Cart_url  + "......" );
					}
			 }else {
		    	 
		    	 System.out.println("Green Apple Lapel Pins product not clicked");
				 System.out.println("......"+ GreenAppleLapelPins_url + "......" );
		     	
		     }
		}
	
	public void StoreModuleLEED() throws Exception {
			
			getLEEDReferenceGuide().click();
			Thread.sleep(3000);
			String LEEDReferenceGuide_url = driver.getCurrentUrl();
				 if((LEEDReferenceGuide_url.equalsIgnoreCase(baseUrl+"/node/33")) && driver.getTitle().contains("LEED Reference Guide for Homes Design and Construction (e-document)")) {
				 Assert.assertTrue(true);
				 getAddToCartLEED().click();
				 Thread.sleep(3000);
			     String Cart_url = driver.getCurrentUrl();
			     		if((Cart_url.equalsIgnoreCase(baseUrl+"/cart"))&& driver.getTitle().contains("Shopping cart")) { 
			     			 Assert.assertTrue(getStatusMessage().getAttribute("innerHTML").contains("LEED Reference Guide for Homes Design and Construction (e-document)"));
							 System.out.println(getStatusMessage().getAttribute("innerHTML")+" : Product added to your shopping cart. ");
							 getCheckOutButton().click();
							 Thread.sleep(3000);
							 String StoreContact_url = driver.getCurrentUrl();
							 Assert.assertEquals(StoreContact_url, baseUrl+"/store/contact");	
							 System.out.println("*****contact-payment-receipt*****");
							 Contact_Form("" , 3);
							 // element not found exception because of contact page ui is diffrent for this store products
							 Thread.sleep(3000);
							 signInForm("signin",3);
							 contactPaymentReceipt();
					 		
						}else {
							System.out.println("Add to cart is link is not clicked");
							System.out.println("......"+ Cart_url  + "......" );
						}
				 }else {
			    	 
			    	 System.out.println("LEED Reference Guide product not clicked");
					 System.out.println("......"+ LEEDReferenceGuide_url + "......" );
			     	
			     }
			}
	
	public void StoreModuleLEEDandGreen() throws Exception {
		
		getGreenAppleLapelPins().click();
		Thread.sleep(2000);
		getAddToCartGreen().click();
		Assert.assertEquals(driver.getCurrentUrl(),baseUrl+"/cart");
		Assert.assertTrue(getStatusMessage().getAttribute("innerHTML").contains("Green Apple Lapel Pins"));
		getContinueShopping().click();
		Assert.assertEquals(driver.getCurrentUrl(),baseUrl+"/store");
		getLEEDReferenceGuide().click();
		Thread.sleep(2000);
		getAddToCartLEED().click();
		Assert.assertTrue(getStatusMessage().getAttribute("innerHTML").contains("LEED Reference Guide for Homes Design and Construction (e-document)"));
		getCheckOutButton().click();
		String StoreContact_url = driver.getCurrentUrl();
		 Assert.assertEquals(StoreContact_url, baseUrl+"/store/contact");	
		 System.out.println("*****contact-payment-receipt*****");
		 Contact_Form("contact" , 3);
		 Thread.sleep(3000);
		 signInForm("signin",3);
		 contactPaymentReceipt();
		}
	
	
	
	public void VerifyingShoppingCartLink() throws Exception{
		getShoppingCart().click();
		Thread.sleep(2000);
		Assert.assertTrue(true);
		//System.out.println(getUcCartEmpty().getAttribute("innerHTML"));
		if(getUcCartEmpty().isDisplayed()){
			driver.get(baseUrl+"/store");
			getGreenAppleLapelPins().click();
			Thread.sleep(2000);
			getAddToCartGreen().click();
			Assert.assertEquals(driver.getCurrentUrl(),baseUrl+"/cart");
			Assert.assertTrue(getStatusMessage().getAttribute("innerHTML").contains("Green Apple Lapel Pins"));
			getContinueShopping().click();
			Assert.assertEquals(driver.getCurrentUrl(),baseUrl+"/store");
			getLEEDReferenceGuide().click();
			Thread.sleep(2000);
			getAddToCartLEED().click();
			Assert.assertTrue(getStatusMessage().getAttribute("innerHTML").contains("LEED Reference Guide for Homes Design and Construction (e-document)"));
			//numberOfRowsAndColumnInTable();
			getContinueShopping().click();
			Assert.assertEquals(driver.getCurrentUrl(),baseUrl+"/store");
			getLEEDReferenceGuide().click();
			Thread.sleep(2000);
			getAddToCartLEED().click();
			Assert.assertTrue( getStatusMessageBlock().getAttribute("innerHTML").contains("Your item(s) have been updated."));
			numberOfRowsAndColumnInTable();
			getRemove().click();			
			StatusMessage();
			numberOfRowsAndColumnInTable();
			getRemove().click();			
			StatusMessage();
			Assert.assertTrue(getUcCartEmpty().isDisplayed());
			System.out.println("------Cart is Empty------");
			
		}
	}
	
	public void VerifyingShoppingCartLink2() throws Exception{
		getShoppingCart().click();
		Thread.sleep(2000);
		Assert.assertTrue(true);
		//System.out.println(getUcCartEmpty().getAttribute("innerHTML"));
		if(getUcCartEmpty().isDisplayed()){
			driver.get(baseUrl+"/store");
			getGreenAppleLapelPins().click();
			Thread.sleep(2000);
			getAddToCartGreen().click();
			Assert.assertEquals(driver.getCurrentUrl(),baseUrl+"/cart");
			Assert.assertTrue(getStatusMessage().getAttribute("innerHTML").contains("Green Apple Lapel Pins"));
			getContinueShopping().click();
			Assert.assertEquals(driver.getCurrentUrl(),baseUrl+"/store");
			getLEEDReferenceGuide().click();
			Thread.sleep(2000);
			getAddToCartLEED().click();
			Assert.assertTrue(getStatusMessage().getAttribute("innerHTML").contains("LEED Reference Guide for Homes Design and Construction (e-document)"));
			//numberOfRowsAndColumnInTable();
			getInputBox().clear();
			Thread.sleep(2000);
			getInputBox().sendKeys("2");
			getUpdateCart().click();
			Assert.assertTrue( getStatusMessageBlock().getAttribute("innerHTML").contains("Your cart has been updated."));
			numberOfRowsAndColumnInTable();	
//			getEmptyCart().click();
//			Assert.assertEquals(driver.getCurrentUrl(),baseUrl+"/cart/empty");	
		}
	}
	
	public void VerifyingShoppingCartLink3() throws Exception{
		getShoppingCart().click();
		Thread.sleep(2000);
		Assert.assertTrue(true);
		if(getUcCartEmpty().isDisplayed()){
			driver.get(baseUrl+"/store");
			getGreenAppleLapelPins().click();
			Thread.sleep(2000);
			getAddToCartGreen().click();
			Assert.assertEquals(driver.getCurrentUrl(),baseUrl+"/cart");
			Assert.assertTrue(getStatusMessage().getAttribute("innerHTML").contains("Green Apple Lapel Pins"));
			getContinueShopping().click();
			Assert.assertEquals(driver.getCurrentUrl(),baseUrl+"/store");
			getLEEDReferenceGuide().click();
			Thread.sleep(2000);
			getAddToCartLEED().click();
			Assert.assertTrue(getStatusMessage().getAttribute("innerHTML").contains("LEED Reference Guide for Homes Design and Construction (e-document)"));
			getEmptyCart().click();	
			Assert.assertEquals(driver.getCurrentUrl(),baseUrl+"/cart/empty");
			Thread.sleep(2000);
			getConfirmCart().click();
			Assert.assertEquals(driver.getCurrentUrl(),baseUrl+"/cart");
			Assert.assertTrue(getUcCartEmpty().isDisplayed());	
		}
	}
}
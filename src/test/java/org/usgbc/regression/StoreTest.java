package org.usgbc.regression;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import org.usgbc.business.Store;
import org.usgbc.utility.Base;
import org.usgbc.utility.BrokenLink;

import com.relevantcodes.extentreports.LogStatus;

public class StoreTest extends Base {

	@Test	
	public void testStoreGreen() throws Exception {
	
		 driver.get(baseUrl +"/store");
		 System.out.println("Store Module Green Apple Lapel Pins");
		 System.out.println("Broken Link for /store ");
		 BrokenLink.BrokenLinkCheck(baseUrl +"/store");
	     Store store = PageFactory.initElements(driver, Store.class);    
		    try {
		    	test= extent.startTest("Store Module Green Apple Lapel Pins  ");
		    	test.log(LogStatus.INFO, "Test Started");
		    	store.StoreModuleGreen();
		    	System.out.println("Store Module Green Apple Lapel Pins Test Finished ");
			}catch (Throwable t) {
				System.out.println(t.getLocalizedMessage());
				Error e1 = new Error(t.getMessage());
				e1.setStackTrace(t.getStackTrace());
				throw e1;
			 }
	}
	
	@Test	
	public void testStoreLEED() throws Exception {
	
		 driver.get(baseUrl +"/store");
		 System.out.println("Store Module LEED Reference Guide for Homes Design and Construction (e-document)");
		 System.out.println("Broken Link for /store ");
		 BrokenLink.BrokenLinkCheck(baseUrl +"/store");
	     Store store = PageFactory.initElements(driver, Store.class);    
		    try {
		    	test= extent.startTest("Store Module LEED Reference Guide for Homes Design and Construction (e-document)");
		    	test.log(LogStatus.INFO, "Test Started");
		    	store.StoreModuleLEED();
		    	System.out.println("Store Module LEED Reference Guide for Homes Design and Construction (e-document) Test Finished ");
			}catch (Throwable t) {
				System.out.println(t.getLocalizedMessage());
				Error e1 = new Error(t.getMessage());
				e1.setStackTrace(t.getStackTrace());
				throw e1;
			 }
	}
	
	@Test	
	public void testStoreLEEDandGreen() throws Exception {
		
		 String url ="https://test-dynamic-usgbc.pantheonsite.io/store";
		 driver.get(url);
		 System.out.println("Store Module LEED And Green");
		 System.out.println("Broken Link for /store ");
		 BrokenLink.BrokenLinkCheck(url);
	     Store store = PageFactory.initElements(driver, Store.class);    
		    try {
		    	test= extent.startTest("Store Module LEED And Green");
		    	test.log(LogStatus.INFO, "Test Started");
		    	store.StoreModuleLEEDandGreen();
		    	System.out.println("Store Module LEED And Green test Finished");
			}catch (Throwable t) {
				System.out.println(t.getLocalizedMessage());
				Error e1 = new Error(t.getMessage());
				e1.setStackTrace(t.getStackTrace());
				throw e1;
			 }
	}

	@Test	
	public void testShoppingCartLink() throws Exception {
		
		 String url ="https://test-dynamic-usgbc.pantheonsite.io/";
		 driver.get(url);
		 System.out.println("Shopping Cart link with 3 Products");
	     Store store = PageFactory.initElements(driver, Store.class);    
		    try {
		    	test= extent.startTest("Shopping Cart link with 3 Products");
		    	test.log(LogStatus.INFO, "Test Started");
		    	store.VerifyingShoppingCartLink();
		    	System.out.println("Shopping Cart Link with 3 Products Test Finished ");
			}catch (Throwable t) {
				System.out.println(t.getLocalizedMessage());
				Error e1 = new Error(t.getMessage());
				e1.setStackTrace(t.getStackTrace());
				throw e1;
			 }
	}
	
	@Test	
	public void testShoppingCartLink2() throws Exception {
		
		 String url ="https://test-dynamic-usgbc.pantheonsite.io/";
		 driver.get(url);
		 System.out.println("Shopping Cart link with the use of update cart button ");
	     Store store = PageFactory.initElements(driver, Store.class);    
		    try {
		    	test= extent.startTest("Shopping Cart link with the use of update cart button");
		    	test.log(LogStatus.INFO, "Test Started");
		    	store.VerifyingShoppingCartLink2();
		    	System.out.println("Shopping Cart Link with the use of update cart button Test Finished ");
			}catch (Throwable t) {
				System.out.println(t.getLocalizedMessage());
				Error e1 = new Error(t.getMessage());
				e1.setStackTrace(t.getStackTrace());
				throw e1;
			 }
	}
	
	@Test	
	public void testShoppingCartLink3() throws Exception {
		
		 String url ="https://test-dynamic-usgbc.pantheonsite.io/";
		 driver.get(url);
		 System.out.println("Shopping Cart link with the use of empty cart buttton");
	     Store store = PageFactory.initElements(driver, Store.class);    
		    try {
		    	test= extent.startTest("Shopping Cart link with the use of empty cart buttton ");
		    	test.log(LogStatus.INFO, "Test Started");
		    	store.VerifyingShoppingCartLink3();
		    	System.out.println("Shopping Cart Link with the use of empty cart buttton Test Finished ");
			}catch (Throwable t) {
				System.out.println(t.getLocalizedMessage());
				Error e1 = new Error(t.getMessage());
				e1.setStackTrace(t.getStackTrace());
				throw e1;
			 }
	}
}
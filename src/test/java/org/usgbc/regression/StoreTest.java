package org.usgbc.regression;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import org.usgbc.business.Store;
import org.usgbc.utility.Base;
import org.usgbc.utility.BrokenLink;

import com.relevantcodes.extentreports.LogStatus;

public class StoreTest extends Base {

	@Test(priority=0)
	public void testStoreGreen() throws Exception {
	
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
	
	@Test(priority=1)
	public void testStoreLEED() throws Exception {
	
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
	
	@Test(priority=2)	
	public void testStoreLEEDandGreen() throws Exception {
		
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

	@Test(priority=3)	
	public void testShoppingCartLink() throws Exception {
		
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
	
	@Test(priority=4)	
	public void testShoppingCartLink2() throws Exception {
		
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
	
	@Test(priority=5)	
	public void testShoppingCartLink3() throws Exception {
		
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
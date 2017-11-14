package org.usgbc.regression;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import org.usgbc.business.UsgbcStore;
import org.usgbc.page.UsgbcWebLocators;
import org.usgbc.utility.Base;
import org.usgbc.utility.BrokenLink;

import com.relevantcodes.extentreports.LogStatus;

public class UsgbcStoreTest extends Base {
	
	//No items in cart
	@Test	
	public void testUsgbcStore() throws Exception {
		
	     UsgbcStore usgbcStore = PageFactory.initElements(driver, UsgbcStore.class);    
		    try {
		    	test= extent.startTest("Usgbc Store Module");
		    	test.log(LogStatus.INFO, "Test Started");
		    	usgbcStore.UsgbcStoreModule();
	 	    	System.out.println("Usgbc Store Module Test Finished ");
			}catch (Throwable t) {
				System.out.println(t.getLocalizedMessage());
				Error e1 = new Error(t.getMessage());
				e1.setStackTrace(t.getStackTrace());
				throw e1;
			 }	
	}
	
	//Green with user  test25@testuser.com, usgbc store link and  receipt download 
	@Test	
	public void testUsgbcStoreGreen() throws Exception {

	     UsgbcStore usgbcStore = PageFactory.initElements(driver, UsgbcStore.class);    
		    try {
		    	test= extent.startTest("Usgbc Store Module Green Apple Lapel Pins");
		    	test.log(LogStatus.INFO, "Test Started");
		    	usgbcStore.UsgbcStoreModuleGreen();
		    	System.out.println("Usgbc Store Module scenario 2 Test Finished ");
			}catch (Throwable t) {
				System.out.println(t.getLocalizedMessage());
				Error e1 = new Error(t.getMessage());
				e1.setStackTrace(t.getStackTrace());
				throw e1;
			 }	
	}
	
	//Green with user not found , checkout button and no receipt download
	@Test	
	public void testUsgbcStoreGreen2() throws Exception {
	
	     UsgbcStore usgbcStore = PageFactory.initElements(driver, UsgbcStore.class);    
		    try {
		    	test= extent.startTest("Usgbc Store Module Green Apple Lapel Pins scenario 2");
		    	test.log(LogStatus.INFO, "Test Started");
		    	usgbcStore.UsgbcStoreModuleGreen2();
		    	System.out.println("Usgbc Store Module Green Apple Lapel Pins scenario 2 Test Finished ");
			}catch (Throwable t) {
				System.out.println(t.getLocalizedMessage());
				Error e1 = new Error(t.getMessage());
				e1.setStackTrace(t.getStackTrace());
				throw e1;
			 }	
		
	}
	
	//LEED with user  test25@testuser.com, usgbc store link and  receipt download 
	@Test	
	public void testUsgbcStoreLEED() throws Exception {
		
	     UsgbcStore usgbcStore = PageFactory.initElements(driver, UsgbcStore.class);    
		    try {
		    	test= extent.startTest("Usgbc Store Module LEED Reference Guide for Homes Design and Construction (e-document)");
		    	test.log(LogStatus.INFO, "Test Started");
		    	usgbcStore.UsgbcStoreModuleLEED();
		    	System.out.println("Usgbc Store Module LEED Reference Guide for Homes Design and Construction (e-document) Test Finished ");
			}catch (Throwable t) {
				System.out.println(t.getLocalizedMessage());
				Error e1 = new Error(t.getMessage());
				e1.setStackTrace(t.getStackTrace());
				throw e1;
			 }	
	}
	
   // LEED with user not found , checkout button and no receipt download
	@Test	
	public void testUsgbcStoreLEED2() throws Exception {
		
	     UsgbcStore usgbcStore = PageFactory.initElements(driver, UsgbcStore.class);    
		    try {
		    	test= extent.startTest("Usgbc Store Module LEED Reference Guide for Homes Design and Construction (e-document) scenario 2");
		    	test.log(LogStatus.INFO, "Test Started");
		    	usgbcStore.UsgbcStoreModuleLEED2();
		    	System.out.println("Usgbc Store Module LEED Reference Guide for Homes Design and Construction (e-document) scenario Test Finished ");
			}catch (Throwable t) {
				System.out.println(t.getLocalizedMessage());
				Error e1 = new Error(t.getMessage());
				e1.setStackTrace(t.getStackTrace());
				throw e1;
			 }		
	}
}
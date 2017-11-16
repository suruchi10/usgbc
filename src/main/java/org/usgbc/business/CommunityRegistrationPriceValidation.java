package org.usgbc.business;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.usgbc.utility.CommunityRegistrationFormData;
import org.usgbc.utility.ReusableMethods;

public class CommunityRegistrationPriceValidation extends ReusableMethods {
	
	public CommunityRegistrationPriceValidation(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public void CommunityRegistartionModuleForCostValidationDefault35() throws Exception {
		
		getcommunityRegistration().click();
		Thread.sleep(2000);
		if (driver.getTitle().contains("Community Form") ) {
			Assert.assertTrue(true);
			//for selecting community name
			Select community = new Select(getCommunity_Name());
			community.selectByIndex(2);
			
			//for selecting country
			Select country = new Select(getCountry());
			country.selectByVisibleText("Togo");
			Thread.sleep(5000);
		
			//Java script code for scrolling the window
			((JavascriptExecutor)driver).executeScript("scroll(0,400)");
			Thread.sleep(2000);
			
			// for street address
			getStreet_Address().sendKeys("green street");
			getStreet_Address2().sendKeys("red wood");

			//for city
	     	getCity().sendKeys("gurgaon");
	     	
	     	// for how did you hear me checkboxes
	     	getEmail().click();
	     	
	     	// for selecting terms
		    boolean terms =getTerms().isSelected();
		    if (terms == false)
		    	getTerms().click();
		    
		    String total= getTotalText().getText();
			//System.out.println("Total Text:"+total);
			//System.out.println("text length:"+total.length());
			String Total= total.substring(7,13);
			//System.out.println("After truncating:"+Total);
		    
	     	Thread.sleep(2000);
		    getContinue().click();
			
			Thread.sleep(2000);
			
			if (driver.getTitle().contains("Sign-in")) {
				Assert.assertTrue(true);
				signInForm("signin",2);
				Thread.sleep(2000);
				if(driver.getTitle().contains("Payment Form")) {
					Assert.assertTrue(true);
					String Amount = getAmount().getText();
					//System.out.println("Amount:"+Amount);
					if (Total.equals(Amount)) {
						Assert.assertTrue(true);
						System.out.println("Total: " + Total + " is equal with the Price Displayed in Payment Page as Amount: " + Amount);
					}
				}
			}					
		}	
	}
	
	public void CommunityRegistrationForCostValidationStudentMember50() throws InterruptedException {
		
		getcommunityRegistration().click();
		Thread.sleep(2000);
		if (driver.getTitle().contains("Community Form") ) {
			Assert.assertTrue(true);
			//for selecting community name
			Select community = new Select(getCommunity_Name());
			community.selectByIndex(2);
			
			//for selecting country
			Select country = new Select(getCountry());
			country.selectByVisibleText("Togo");
			Thread.sleep(5000);
		
			//Java script code for scrolling the window
			((JavascriptExecutor)driver).executeScript("scroll(0,400)");
			Thread.sleep(2000);
			
			// for street address
			getStreet_Address().sendKeys("green street");
			getStreet_Address2().sendKeys("red wood");

			//for city
	     	getCity().sendKeys("gurgaon");
	     	
	     	//for full time student  radio button
			List<WebElement>radioButton =driver.findElements(By.name("is_student"));
		    boolean bValue = false;
		    bValue = radioButton.get(0).isSelected();
		    if(bValue = true){
		    	radioButton.get(1).click();
		    	//getSchool().clear();
				getSchool().sendKeys("Carmel");
			   // getStudent_ID().clear();
				getStudent_ID().sendKeys("12");
				//getGraduation().clear();
				getGraduation().sendKeys("2020-05-21");		
			 }else {
				radioButton.get(0).click();	
			}
	     	
	     	// for how did you hear me checkboxes
	     	getEmail().click();
	     	
	     	// for selecting terms
		    boolean terms =getTerms().isSelected();
		    if (terms == false)
		    	getTerms().click();
		    
		    String total= getTotalText().getText();
			//System.out.println("Total Text:"+total);
			//System.out.println("text length:"+total.length());
			String Total= total.substring(7,13);
			//System.out.println("After truncating:"+Total);
		    
	     	Thread.sleep(5000);
		    getContinue().click();
			
			Thread.sleep(2000);
			
			if (driver.getTitle().contains("Sign-in")) {
				Assert.assertTrue(true);
				signInForm("signin",2);
				Thread.sleep(2000);
				if(driver.getTitle().contains("Payment Form")) {
					Assert.assertTrue(true);
					String Amount = getAmount().getText();
					//System.out.println("Amount:"+Amount);
					if (Total.equals(Amount)) {
						Assert.assertTrue(true);
						System.out.println("Total: " + Total + " is equal with the Price Displayed in Payment Page as Amount: " + Amount);
					}
				}
			}					
		}	
	}	
	
public void CommunityRegistrationForCostValidationEmergingProfessionalMember75() throws InterruptedException {
		
		getcommunityRegistration().click();
		Thread.sleep(2000);
		if (driver.getTitle().contains("Community Form") ) {
			Assert.assertTrue(true);
			//for selecting community name
			Select community = new Select(getCommunity_Name());
			community.selectByIndex(2);
			
			//for selecting country
			Select country = new Select(getCountry());
			country.selectByVisibleText("Togo");
			Thread.sleep(5000);
		
			//Java script code for scrolling the window
			((JavascriptExecutor)driver).executeScript("scroll(0,400)");
			Thread.sleep(2000);
			
			// for street address
			getStreet_Address().sendKeys("green street");
			getStreet_Address2().sendKeys("red wood");

			//for city
	     	getCity().sendKeys("gurgaon");
	     	
	     	//for emerging professional radio button
			List<WebElement>radioButton2 =driver.findElements(By.name("is_emerging_prof")); 
		    boolean bValue2 = false;
		    bValue2 = radioButton2.get(0).isSelected();
		    if(bValue2 = true){ 
		    	radioButton2.get(1).click();
		    	//getBirthday().clear();
		    	getBirthday().sendKeys("1992-03-10");
			 }else {
				 radioButton2.get(0).click();
			 }
	     	
	     	// for how did you hear me checkboxes
	     	getEmail().click();
	     	
	     	// for selecting terms
		    boolean terms =getTerms().isSelected();
		    if (terms == false)
		    	getTerms().click();
		    
		    String total= getTotalText().getText();
			//System.out.println("Total Text:"+total);
			//System.out.println("text length:"+total.length());
			String Total= total.substring(7,13);
			//System.out.println("After truncating:"+Total);
		    
	     	Thread.sleep(5000);
		    getContinue().click();
			
			Thread.sleep(2000);
			
			if (driver.getTitle().contains("Sign-in")) {
				Assert.assertTrue(true);
				signInForm("signin",2);
				Thread.sleep(2000);
				if(driver.getTitle().contains("Payment Form")) {
					Assert.assertTrue(true);
					String Amount = getAmount().getText();
					//System.out.println("Amount:"+Amount);
					if (Total.equals(Amount)) {
						Assert.assertTrue(true);
						System.out.println("Total: " + Total + " is equal with the Price Displayed in Payment Page as Amount: " + Amount);
					}
				}
			}					
		}	
	}	
}
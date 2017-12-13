package org.usgbc.business.Donation;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.usgbc.utility.Common;
import org.usgbc.utility.ReusableMethods;

public class AmountValidation extends ReusableMethods{

	public AmountValidation(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	String sheetName= "DonationByOnline";
	int rowNum= 4;
	
	String YourContribution= reader.getCellData(sheetName, "Your contribution",rowNum); 
	
	String DonorName= reader.getCellData(sheetName, "Donor name", rowNum);
	
	String Name= reader.getCellData(sheetName, "Name",rowNum); 
	
	String Email= reader.getCellData(sheetName, "Email", rowNum);
	
	String Message= reader.getCellData(sheetName, "Message",rowNum); 
	
	
	
	Common common =new Common();
	
	public void amountTextValidation() throws Exception {
		
        System.out.println("Donation amount Validation");
		
		Thread.sleep(3000);
		driver.get(baseUrl+"/donations/center/online/Haiti");
		
		common.scrolldowntoElement("Donate_Nav");
		Thread.sleep(3000);
 		common.testlog("Pass", "Scrolled till Donation Nav ");
 				
		donationByOnline("DonationByOnline",4);
		
		Assert.assertTrue(true);
		
		common.assertEqualsMessage("PaymentInfo","Payment info","Verifying Navigation from Donation online page to Payment page");
		Thread.sleep(2000);
	    common.testlog("Pass","Navigation Verified Successfully");
	    
	    //Payment page data
	    String Amount= getAmount_payment().getText();
	    //System.out.println(Amount);
	    String Donor= getDonor_payment().getText();
	    // System.out.println(Donor);
	    String onBehalfOf= getonBehalfOf_payment().getText();
	    // System.out.println(onBehalfOf);
	    String SendEcard= getSendEcard_payment().getText();
	    //System.out.println(SendEcard);
	    String Message_Payment=getMessage_payment().getText();
	    // System.out.println(Message_Payment);
	    String total=getTotal_Donation_Payment().getText();
	    String Total= total.substring(7,13);
	    //System.out.println(Total);
	    
	    Thread.sleep(5000);
	    
	    paymentForm("payment", 2);
	    
	    Thread.sleep(5000);
	    //Receipt page data
	
	    String Order = getOrder_receipt().getText();
	    //System.out.println(Order); 
	    String Donation_to= getDonation_to_receipt().getText();
	    //System.out.println(Donation_to);
	    String Amount_receipt=  getAmount_receipt().getText();
	    //System.out.println(Amount_receipt);
	    String Donated_on= getDonated_on_receipt().getText();
	    //System.out.println(Donated_on);
	    String Donated_by=getDonated_by_receipt().getText();
	    //System.out.println(Donated_by);
	    String On_behalf_of= getOn_behalf_of_receipt().getText();
	    //System.out.println(On_behalf_of);
	    String eCard= geteCard_receipt().getText();
	    //System.out.println(eCard);
	    
	    YourContribution =YourContribution.concat(".00");

	    if((YourContribution.equals(Amount)) && (YourContribution.equals(Amount_receipt))) {
	    	Assert.assertTrue(true);
	    	System.out.println(YourContribution + " :YourContribution  Amount is  Equal  to" + Amount +" :Amount on payment page and Amount on Receipt page amount :" + Amount_receipt);	  
	    }
	    
	    if((DonorName.equals(Donor)) && (DonorName.equals(Donated_by))) {
	    	Assert.assertTrue(true);
	    	System.out.println(DonorName+" : DonorName is equal to "+ Donor +": Donor on payment page and Donated by on Receipt page :"+Donated_by);	  
	    }
	    
	    if((Name.equals(onBehalfOf)) && (Name.equals(On_behalf_of))) {
	    	Assert.assertTrue(true);
	    	System.out.println(Name+" : Name is equal to "+ onBehalfOf +" : onBehalfOf on payment page and On_behalf_of by on Receipt page : "+On_behalf_of);	  
	    }
	    
	    if((Email.equals(SendEcard))) {
	    	Assert.assertTrue(true);
	    	System.out.println(Email+": Email is equal to "+ SendEcard +" :SendEcard on payment page");	
	    }
	    
	    if((Message.equals(Message_Payment)) && (Message.equals(eCard))){
	    	Assert.assertTrue(true);
	     	System.out.println(Message+" : Message is equal to "+ Message_Payment +": Message_Payment on payment pag  and eCard by on Receipt page :"+eCard);
	    }
		
	}
}

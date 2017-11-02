package com.usgbc.utility;



	import java.io.BufferedWriter;
	import java.io.File;
	import java.io.FileWriter;
	import org.openqa.selenium.Cookie;
	import org.openqa.selenium.WebDriver;

import com.usgbc.dev.page.UsgbcWebLocators;


	 
	public class StoringCookie extends UsgbcWebLocators {
		
			public StoringCookie(WebDriver driver) {
			super(driver);
			// TODO Auto-generated constructor stub
		}

			//main(String[] args)
			public static void sCookies()
			{

			driver.get("https:http://test-dynamic-usgbc.pantheonsite.io/signin");
			getEusername().sendKeys("abi@gmail.com");
			getEpassword().sendKeys("abhisek");
			getSigninContinue().click();
			// create file named Cookie to store username Information
			File file = new File("Cookie.data");
			try { // Delete if any old file exists
			file.delete();
			file.createNewFile();
			FileWriter fileWriter = new FileWriter(file);
			BufferedWriter bufferwrite = new BufferedWriter(fileWriter);
			for(Cookie cook : driver.manage().getCookies()){
			String writeup = cook.getName()+";"+cook.getValue()+";"+cook.getDomain()+";"+cook.getPath()+""
			+ ";"+cook.getExpiry()+";"+cook.isSecure();
			bufferwrite.write(writeup);
			System.out.println(writeup);
			bufferwrite.newLine();
			}
			bufferwrite.flush();bufferwrite.close();fileWriter.close();
			}catch(Exception exp){
			
			exp.printStackTrace();
			}
			}


}

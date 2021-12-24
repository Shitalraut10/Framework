package com.automation.testcases;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.openqa.selenium.support.PageFactory;

import com.automation.pages.BaseClass;
import com.automation.pages.LoginPage;
import com.automation.pages.SignUpPage;

public class SignupTest extends BaseClass {

	public void signup()
	{
		SignUpPage signup=PageFactory.initElements(driver, SignUpPage.class);
	/*	signup.signupApplication(excel.getStringData("Login", 0, 0),excel.getStringData("Login", 0, 1), 
								 excel.getStringData("Login", 0, 0),excel.getStringData("Login", 0, 1),
								 excel.getStringData("Login", 0, 0),excel.getStringData("Login", 0, 1),
								 excel.getStringData("Login", 0, 0),excel.getStringData("Login", 0, 1));*/
		
	}
	
	
	
	
}

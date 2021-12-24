package com.automation.testcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import com.automation.pages.BaseClass;
import com.automation.pages.LoginPage;
import com.automation.utility.Helper;

public class LoginTest extends BaseClass {
	
	
	@Test
	public void loginApp() 
	{
		logger=report.createTest("Login to CRM");
		LoginPage loginpage=PageFactory.initElements(driver, LoginPage.class);
		
		logger.info("Starting application");
		
		excel.ExcelDataProvider("./TestData/TestData.xlsx");
		loginpage.loginToApplication(excel.getStringData("Login", 0, 0),excel.getStringData("Login", 0, 1));
		
		logger.pass("Login sucessful");
		Helper.captureScreenshot(driver);
	}

	
	
	
	
	
	
	
	
}

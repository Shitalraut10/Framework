package com.automation.pages;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.automation.utility.BrowserFactory;
import com.automation.utility.ConfigDataProvider;
import com.automation.utility.ExcelDataProvider;
import com.automation.utility.Helper;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.beust.jcommander.Parameter;

public class BaseClass {

	public WebDriver driver;
	public ExcelDataProvider excel;
	public ConfigDataProvider config;
	public ExtentReports report;
	public ExtentTest logger;
	
	@BeforeSuite
	public void setUpSuit()
	{
		 excel=new ExcelDataProvider();
		 config=new ConfigDataProvider();
		 
		 ExtentHtmlReporter extent=new ExtentHtmlReporter(new File(System.getProperty("user.dir")+"/Reports/Freecrm"+Helper.getCurrentDateTime()+".html"));
		 report= new ExtentReports();
		 report.attachReporter(extent);
	}
	
	
	//@Parameters({"browser","url"})
	@BeforeClass
	public void setup()//String browser,String url
	{
		driver=BrowserFactory.startApplication(driver,config.getBrowser(),config.getStagingURL());
	//	driver=BrowserFactory.startApplication(driver,browser,url);

	}
	
	
	@AfterClass
	public 	void tearDown()
	{
		BrowserFactory.quitBrowser(driver);
	}
	
	@AfterMethod
	public void tearDownMethod(ITestResult result) throws IOException
	{
	//	Helper.captureScreenshot(driver);

		if(result.getStatus()==ITestResult.FAILURE)
		{
			
			logger.fail("Test Failed",MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build());
		}
		
		else if(result.getStatus()==ITestResult.SUCCESS)
		{
			logger.pass("Test Failed",MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build());

		}
		
		report.flush();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

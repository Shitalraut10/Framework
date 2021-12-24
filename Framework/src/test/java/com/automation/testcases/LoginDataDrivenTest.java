package com.automation.testcases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.test.utility.XLUtility;
import io.github.bonigarcia.wdm.WebDriverManager;


public class LoginDataDrivenTest {

	WebDriver driver;
	
	@BeforeMethod
	public void setup()
	{
		WebDriverManager.chromedriver().setup();
	    driver=new ChromeDriver();
		driver.manage().window().maximize();
		//driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(40,TimeUnit.SECONDS);
		

	}
	
	
	@Test(dataProvider="LoginData")
	public void loginTest(String user,String pwd,String exp)
	{
		driver.get("https://admin-demo.nopcommerce.com/login");
		System.out.println(user + pwd + exp);
   
		WebElement email=driver.findElement(By.id("Email"));
		email.clear();
		email.sendKeys(user);

		WebElement password=driver.findElement(By.id("Password"));
		password.clear();
		password.sendKeys(pwd);
		
		driver.findElement(By.xpath("//button[contains(text(),'Log in')]")).click();
		
		String exp_title="Dashboard / nopCommerce administration";
		String act_title=driver.getTitle();
		
		if(exp.equals("Valid"))
		{
			if(exp_title.equals(act_title))
			{
				driver.findElement(By.linkText("Logout")).click();
				Assert.assertTrue(true);
			}
			else
			{
				Assert.assertTrue(false);

			}
		}
		else
			if(exp.equals("Invalid"))
			{

				if(exp_title.equals(act_title))
				{
				    driver.findElement(By.linkText("Logout")).click();
				    Assert.assertTrue(false);
				}
				else
				{
					Assert.assertTrue(true);

				}
			}
	
	}
	

/*	@DataProvider(name="LoginData")
	
	public String[][] getData()
	{
	String loginData[][]=
     {
		
		{"admin@yourstore.com",	"admin","Valid"},
		{"admin@yourstore.com","adm","Invalid"},
		{"adm@yourstore.com","admin","Invalid"},
		{"adm@yourstore.com","adm","Invalid"}

     };
	return loginData;
	}*/
	
	
	@DataProvider(name="LoginData")
	public String[][] getData() throws IOException
	{
		//get data from excel
		
		String path="C:\\Users\\HP\\eclipse-workspace\\maven\\ExcelData\\LoginData.xlsx";
		XLUtility xlutil= new XLUtility(path);
		
		int totalrows=xlutil.getRowCount("Sheet1");
		int totalcols=xlutil.getCellCount("Sheet1",1);
		
		String loginData[][]=new String[totalrows][totalcols];
		
		for(int i=1;i<=totalrows;i++)//1
		{
			for(int j=0;j<totalcols;j++)//0
			{
				loginData[i-1][j]=xlutil.getCellData("Sheet1", i, j);
			}
		}
		
		
		return loginData;

	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
}

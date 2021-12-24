package com.automation.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class SignUpPage {

	WebDriver driver;
	public SignUpPage(WebDriver ldriver)
	{
		this.driver=ldriver;
	}
	
	@FindBy(name="firstname")WebElement firstname;				//firstname
	
	@FindBy(name="lastname")WebElement lastname;				//lastname
	
	List<WebElement>rdbtns= driver.findElements(By.id("gender")); //gender radio
	
	for(int i=0;i<rdbtns.size();i++)
	{
		String gender=rdbtns.get(i).getAttribute("value");
		
	//	if(gender.equals("male"))
		
		if(gender.equals("female"))
		{
			rdbtns.get(i).click();
		}
	}
	
	
	Select drop=new Select(driver.findElement(By.id("country")));   //country dropdown
	drop.selectByIndex(1);
	
	List<WebElement>checkb=driver.findElements(By.id("language"));  //language checkbox
	
	for(int j=0;i<checkb.size();i++)
	{

		String lang=checkb.get(j).getAttribute("value");
		
		if(lang.equals("English")||(lang.equals("marathi")))
		{
			checkb.get(j).click();
		}

	}

	@FindBy(id="mobilenumber")WebElement mobile;			//mobile
	
	@FindBy(id="emailid")WebElement email;					//email
	
	@FindBy(id="address")WebElement address;				//address
	
//	@FindBy(id="login")WebElement fileUpload;				//file upload

	@FindBy(name="submit")WebElement submitbutton;			//submit button


	
	public void signupApplication(String firstname,String lastname,String gender,String country,String language,int mobile,String email,String address)
	{
		firstname.sendKeys(firstname);
		lastname.sendKeys(lastname);
		gender.sendKeys(gender);
		country.sendKeys(country);
		language.sendKeys(language);
		mobile.sendKeys(mobile);
		email.sendKeys(email);
		address.sendKeys(address);

		submitbutton.click();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

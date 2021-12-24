package com.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {

	WebDriver driver;
	public LoginPage(WebDriver ldriver)
	{
		this.driver=ldriver;
	}
	
	@FindBy(name="userid")WebElement username;
	@FindBy(name="pswrd")WebElement password;
	@FindBy(id="login")WebElement loginbutton;

	
	public void loginToApplication(String usernameApplication,String passwordApplication)
	{
		username.sendKeys(usernameApplication);
		password.sendKeys(passwordApplication);
		loginbutton.click();
	}
	
	
	
	
	
	
	
	
}

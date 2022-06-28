package com.ecomm.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ecomm.base.TestBase;

import dev.failsafe.internal.util.Assert;

public class LoginPage extends TestBase{


	// objectrepository
	@FindBy(xpath="//input[@id=\'user-name\']")
	public static WebElement username;

	@FindBy(xpath="//input[@id='password']")
	WebElement password;

	@FindBy(xpath="//input[@id='login-button']")
	public WebElement lgb;

	@FindBy(xpath="//div[@class='bot_column']")
	WebElement botimage;

	@FindBy(xpath="//h3[text()=\"Epic sadface: Username is required\"]")
	WebElement message_loginpage;


	// Actions
	public LoginPage() 
	{
		PageFactory.initElements(driver, this);
	}

	public static String validate_page_titl() 
	{
		String title = driver.getTitle();
		return title;

	}

	public boolean validateimage_login() 
	{
		return botimage.isDisplayed();
	}


	public HomePage login(String un,String pwd) throws IOException 
	{
		username.sendKeys(un);
		password.sendKeys(pwd);
		lgb.click();
		return new HomePage();

	}


	public String validateplaceholder_loginpage() 
	{
		String placeholder_username = username.getAttribute("placeholder");
		return placeholder_username;
		//	String placeholder_password = password.getAttribute("Placeholder");
		//	String login_btname = lgb.getAttribute("value");
	}

	public boolean login_mndtry_msg() 
	{
		boolean message = message_loginpage.isDisplayed();
		return message;
	}

}

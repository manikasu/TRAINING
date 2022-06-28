package com.ecomm.testcases;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.ecomm.base.TestBase;
import com.ecomm.pages.HomePage;
import com.ecomm.pages.LoginPage;

public class Loginpage_test extends TestBase{
	LoginPage loginpage;
	HomePage homepage;


	public Loginpage_test() throws IOException {
		readfile();
	}

	@BeforeTest
	public void logintestcase001() 
	{
		initialization();
		loginpage = new LoginPage();
	}


	@Test(priority=0)
	public void loginpage_title_test() 
	{
		String title = loginpage.validate_page_titl();
		Assert.assertEquals(title, "Swag Labs");
	}


	@Test(priority=1)
	public void verify_appimage() 
	{
		boolean img = loginpage.validateimage_login();
		Assert.assertTrue(img);
	}

	////////////

	@Test(priority=2)
	public void validate_placeholder_test() 
	{
		String username_lbl = loginpage.validateplaceholder_loginpage();
		Assert.assertEquals(username_lbl, "Username");
	}


	@Test(priority=4)
	public void login_flow() throws IOException 
	{
		homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));

	}
	@Test(priority=3)
	public void message_log() 
	{
		loginpage.lgb.click();
		boolean msg_true = loginpage.login_mndtry_msg();
		Assert.assertEquals(msg_true, true,"om");
	}
	
	@Test
	public void img() 
	{
		List<WebElement> om =	driver.findElements(By.cssSelector(".product_sort_container"));
		
		
	}
	@AfterTest
	public void teardown() 
	{
		driver.quit();
	}

}

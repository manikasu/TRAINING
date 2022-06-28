package com.ecomm.testcases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Rough {
	WebDriver driver;
	@BeforeTest
	public void browserset() 
	{

		System.setProperty("webdriver.chrome.driver", "D:\\chrome\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.saucedemo.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@Test(priority=1)
	public void validateplaceholder_loginpage() 
	{
		driver.findElement(By.id("login-button")).click();
		String placeholder_username = driver.findElement(By.xpath("//input[@id='user-name']")).getCssValue("border-bottom-color");
		System.out.println("the placeholder" + placeholder_username);
	}

	@Test(priority=2)
	public void quit() 
	{
		driver.close();
	}
}

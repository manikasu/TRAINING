package com.ecomm.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
//omg
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.Test;

public class TestBase {
	public static WebDriver driver;
	public static Properties prop;



	public static void readfile()  throws IOException {
		prop = new Properties();

		FileInputStream file = new FileInputStream("D:\\Selenium project\\com.ecomm\\src\\main\\java\\com\\ecomm\\config"
				+ "\\config.properties");
		prop.load(file);


	}


	public static void initialization() {
		String browsername = prop.getProperty("browser");

		if(browsername.equals("Chrome")) 
		{
			System.setProperty("webdriver.chrome.driver", "D:\\chrome\\chromedriver.exe");
			driver = new ChromeDriver();
		}

		else if(browsername.equals("FF"))
		{
			driver = new FirefoxDriver();
		}
		else {
			driver= new SafariDriver();
		}

		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		/*	
		driver.findElement(By.xpath(prop.getProperty("username_xpath"))).sendKeys(prop.getProperty("username"));
		driver.findElement(By.xpath(prop.getProperty("password_xpath"))).sendKeys(prop.getProperty("password"));
		driver.findElement(By.xpath(prop.getProperty("loginbtn"))).click();
		 */

	}

}





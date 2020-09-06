package com.clrtrp.TestPages;

import java.awt.AWTException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.clrtrp.qa.Base.Base;
import com.clrtrp.qa.pages.HotelPage;
import com.clrtrp.qa.pages.LoginPage;

public class HotelPageTest extends Base {

	public HotelPage hotelpage;
	public LoginPage loginpage;
	
	public HotelPageTest() throws IOException {
		super();
		
		
	}
@BeforeMethod
public void setup() throws IOException, AWTException, InterruptedException{
	intitialisation();
	loginpage=new LoginPage(driver);
	loginpage.robot();
	loginpage.login(pro.getProperty("username")	, pro.getProperty("password"));
	Thread.sleep(3000);
	driver.switchTo().parentFrame();
}
	@Test
	public void hotelsearch() throws IOException, AWTException, InterruptedException
	{
		Thread.sleep(3000);
		driver.switchTo().parentFrame();
		driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
		
		hotelpage=new HotelPage(driver);
		loginpage.robot();
		hotelpage.details();
		hotelpage.datepicker();
	}
	@AfterMethod	
	
	public void teardown() throws InterruptedException{
		Thread.sleep(10000);
		driver.quit();
	}
}

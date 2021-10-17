package com.clrtrp.TestPages;

import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.clrtrp.qa.Base.Base;
import com.clrtrp.qa.pages.HotelPage;
import com.clrtrp.qa.pages.LoginPage;

@Listeners(com.clrtrp.qa.util.Listener.class)
public class HotelPageTest extends Base {

	public HotelPage hotelpage;
	public LoginPage loginpage;

	public HotelPageTest() throws IOException {
		super();


	}		
	@BeforeClass
	public void setup() {
		intitialisation();
		try {
			loginpage=new LoginPage(driver);
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			loginpage.login(pro.getProperty("username")	, pro.getProperty("password"));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	@Test(priority=1)
	public void clickOnHotel() {
		hotelpage=new HotelPage(driver);
		hotelpage.clickon();
	}
	@Test(priority=2)
	public void WhereTo(String Pune) {
		
		hotelpage.details(Pune);
	}


	@Test(priority=3)
	public void Check_In() 
	{
		
		hotelpage.CheckIn();
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		hotelpage.datepicker("17", "December 2021");
	}
	@Test(priority=4)
	public void Check_Out() 
	{
		
		hotelpage.CheckOut();
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		hotelpage.datepicker("20", "December 2021");
	}

	@AfterClass
	public void teardown(){
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.quit();
	}
}

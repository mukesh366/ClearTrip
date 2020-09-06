package com.clrtrp.TestPages;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.clrtrp.qa.Base.Base;
import com.clrtrp.qa.pages.LoginPage;

public class LoginPageTest extends Base {

	
	
	public LoginPage loginpage;
	

	public LoginPageTest() throws IOException {
		super();
		
	}
   
	
	@BeforeMethod
	public void setup(){
		intitialisation();
	}

	
	@Test
	public void LoginTest() throws AWTException, InterruptedException, IOException {
		loginpage=new LoginPage(driver);
		loginpage.robot();
		loginpage.login(pro.getProperty("username")	, pro.getProperty("password"));
	}
	@AfterMethod	
		
	public void teardown() throws InterruptedException{
		Thread.sleep(10000);
		driver.quit();
	}
}

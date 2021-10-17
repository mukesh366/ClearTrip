package com.clrtrp.TestPages;

import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.clrtrp.qa.Base.Base;
import com.clrtrp.qa.pages.LoginPage;
import com.clrtrp.qa.util.ExtentReport;

@Listeners(com.clrtrp.qa.util.Listener.class)
public class LoginPageTest extends Base {

	
	//ExtentReport htmlReport=new ExtentReport();
	
	public LoginPage loginpage;
	

	public LoginPageTest() throws IOException {
		super();
		
	}
   @BeforeClass
   public void setUp() {
	   ExtentReport.HtmlReport();
	   intitialisation();
   }
	


	
	@Test
	public void LoginTest() throws Exception {
		
		loginpage=new LoginPage(driver);
		//loginpage.robot();
		loginpage.login(pro.getProperty("username")	, pro.getProperty("password"));
		
	}
	@AfterClass	
		
	public void teardown() throws InterruptedException{
		Thread.sleep(10000);
		driver.quit();
		ExtentReport.extent.flush();
		
	}
}

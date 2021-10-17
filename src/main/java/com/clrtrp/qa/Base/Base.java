package com.clrtrp.qa.Base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Base {


	public static Properties pro;
	public static WebDriver driver;

	public Base(){
		pro=new Properties();
		FileInputStream ip = null;
		try {
			ip = new FileInputStream("./configuration/config.properties");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			pro.load(ip);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public   void intitialisation(){

     
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		driver=new ChromeDriver();

		driver.get(pro.getProperty("url"));
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
	}

	public void teardown() throws InterruptedException{
		Thread.sleep(10000);
		driver.quit();
	}
}

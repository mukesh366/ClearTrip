package com.clrtrp.qa.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.clrtrp.qa.Base.Base;

public class LoginPage extends Base {
	
	WebDriver driver;
	
	public LoginPage(WebDriver driver) throws IOException {
		this.driver=driver;
		
		PageFactory.initElements(driver, this);
	}



	@FindBy(xpath = "//*[contains(text(),'Your trips')]")
	WebElement logintab;

	@FindBy(xpath = "//div[@class='pt-2']//button")
	public WebElement signclick;

	@FindBy(xpath="//input[@data-testid='email']")
	WebElement username;

	@FindBy(xpath = "//input[@data-testid='password']")
	WebElement password;

	@FindBy(xpath = "//span[@class='fs-3 fw-550']")
	WebElement submit;


	public void login(String user, String pass) throws InterruptedException {

		
		logintab.click();
		signclick.click();
		Thread.sleep(4000);
//		driver.switchTo().frame("_hjRemoteVarsFrame");
		username.sendKeys(user);
		password.sendKeys(pass);
		submit.click();
		
	}

	public void robot() throws AWTException, InterruptedException {

		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(3000);
		robot.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(3000);
		robot.keyPress(KeyEvent.VK_ENTER);
	}

}

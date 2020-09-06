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



	@FindBy(id = "userAccountLink")
	WebElement logintab;

	@FindBy(id = "SignIn")
	public WebElement signclick;

	@FindBy(id="email")
	WebElement username;

	@FindBy(id = "password")
	WebElement password;

	@FindBy(id = "signInButton")
	WebElement submit;


	public void login(String user, String pass) throws InterruptedException {

		
		logintab.click();
		signclick.click();
		Thread.sleep(4000);
		driver.switchTo().frame("modal_window");
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

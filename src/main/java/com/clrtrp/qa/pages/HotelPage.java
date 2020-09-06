package com.clrtrp.qa.pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.clrtrp.qa.Base.Base;

public class HotelPage extends Base{

	
	WebDriver driver;
	public HotelPage(WebDriver driver) throws IOException {
		super();
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}


	@FindBy(xpath="//a[@title='Find flights from and to international destinations around the world']")
	WebElement hotelpage;
	
	@FindBy(id="Tags")
	WebElement place;
	
	@FindBy(id="CheckInDate")
	WebElement checkin;

	@FindBy(id="CheckOutDate")
	WebElement checkout;
	@FindBy(xpath="//*[@id='ui-datepicker-div']/div[1]/div/div")
	WebElement month_xpath;
	
	@FindBy(xpath="//*[@id='ui-datepicker-div']/div[2]/div/a")
	WebElement arrow;
	
	public void details() throws InterruptedException
	{
		Thread.sleep(3000);
		hotelpage.click();
		place.sendKeys("Pune");
		
	}
	
	
	public void datepicker()
	{
		checkin.click();

		String checkin_month="September 2020";
		String checkin_date="26";

		while(true){
			String text= month_xpath.getText();

			if(text.equals(checkin_month)){
				break;
			}
			else{
				arrow.click();
			}
		}
		driver.findElement(By.xpath("//*[@id='ui-datepicker-div']/div[1]/table/tbody/"
				+ "tr/td/a[contains(text(),"+checkin_date+")]")).click();

	
	}
	
}

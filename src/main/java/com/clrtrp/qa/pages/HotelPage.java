package com.clrtrp.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.clrtrp.qa.Base.Base;


public class HotelPage extends Base{

	
	WebDriver driver;
	public HotelPage(WebDriver driver) {
		//super();
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}


	@FindBy(xpath="//div[@class='ml-2 mr-2 c-grey-50 fs-4 flex flex-1'][contains(text(),'Hotels')]")
	WebElement hotelpage;
	
	@FindBy(xpath="//input[@name='search']")
	WebElement place;
	
	@FindBy(xpath="//button[@name='from']")
	WebElement checkin;

	@FindBy(xpath="//button[@name='to']")
	WebElement checkout;
	////div[contains(text(),'December 2021')]
	@FindBy(xpath="//*[@id='root']//div[@class='DayPicker-Caption']/div")
	WebElement month_xpath;
	
	@FindBy(xpath="//*[@data-testid='rightArrow']")
	WebElement arrow;
	
	@FindBy(xpath="//*[@id='root']//div[@class='DayPicker-Body']/div/div/div/div")
	List<WebElement> day_xpath;
	
	public void clickon() {
		hotelpage.click();
	}
	
	public void details(String location)
	{
		place.sendKeys(location);
		
	}
	
	public void CheckIn() {
		checkin.click();
	}
	public void CheckOut() {
		checkout.click();
	}
	
	public void datepicker(String DDay, String Dmonth)
	{
		for(int i=0; i<12; i++) {
			String month=month_xpath.getText();
		if(!month.contains(Dmonth)) {
			arrow.click();
		}else {
			for(WebElement day:day_xpath) {
				if(day.getText().equals(DDay)) {
					WebElement Disabled = day.findElement(By.xpath("./../.."));
					if(Disabled.getAttribute("aria-disabled").equals(true)){
						System.out.println("Please enter a valid date");
						break;
					}else
					day.click();
					break;
				}
			}
			break;
		}
	

	
		}
	}
}
	


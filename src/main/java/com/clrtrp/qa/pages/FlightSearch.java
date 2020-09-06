package com.clrtrp.qa.pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.clrtrp.qa.Base.Base;

public class FlightSearch extends Base{

	WebDriver driver;
	public FlightSearch(WebDriver driver) throws IOException {
		super();
		this.driver=driver;
		PageFactory.initElements(driver, this);

	}





	@FindBy(xpath="//a[@title=\"Find flights from and to international destinations around the world\"]")
	WebElement clickonflight;

	@FindBy(id="OneWay")
	WebElement oneway;

	@FindBy(id="FromTag")
	WebElement from;

	@FindBy(id="ToTag")
	WebElement to;

	@FindBy(id="DepartDate")
	WebElement departuredate;

	@FindBy(xpath="//*[@id='ui-datepicker-div']/div[1]/div/div")
	WebElement month_xpath;

	@FindBy(xpath="//*[@id='ui-datepicker-div']/div[2]/div/a")
	WebElement rarrowclick;

	@FindBy(id="SearchBtn")
	WebElement submit;
	
	
	//method for date
	public void datepicker()
	{
		departuredate.click();

		String checkin_month="June 2020";
		String checkin_date="26";

		while(true){
			String text= month_xpath.getText();

			if(text.equals(checkin_month)){
				break;
			}
			else{
				rarrowclick.click();
			}
		}
		driver.findElement(By.xpath("//*[@id='ui-datepicker-div']/div[1]/table/tbody/"
				+ "tr/td/a[contains(text(),"+checkin_date+")]")).click();


	}

	public void select(){
		//driver.switchTo().parentFrame();
		//flightoptions.click();
		oneway.click();

		from.sendKeys("Pune, IN - Lohegaon (PNQ)");
		to.sendKeys("New Delhi, IN - Indira Gandhi Airport (DEL)");


	}

	public void submitbtn(){
		submit.click();
	}

}

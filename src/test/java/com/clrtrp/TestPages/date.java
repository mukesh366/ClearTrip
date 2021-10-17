package com.clrtrp.TestPages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class date {

	static WebDriver driver;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
////div[@class='DayPicker-Week']//div[@role='gridcell']//div[@class='Day-grid flex flex-middle flex-column flex-center']//div
		
		String dat="15";
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		driver=new ChromeDriver();

		driver.get("https://www.cleartrip.com/");
		//driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(4, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//div[@class='ml-2 mr-2 c-grey-50 fs-4 flex flex-1'][contains(text(),'Hotels')]")).click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.xpath("//button[@name='from']")).click();
		
		//*[@id="root"]//div[@class='DayPicker-Caption']/div
	//System.out.println(month);
	String dmont="January 2022";
	String months=null;	
	String gday = "17";
	for(int i=0; i<12; i++) {
		String month=	driver.findElement(By.xpath("//*[@id='root']//div[@class='DayPicker-Caption']/div")).getText();//driver.findElement(By.xpath("//div[contains(text(),'October 2021')]")).getText();

	if(!month.contains(dmont)) {
		driver.findElement(By.xpath("//*[@data-testid='rightArrow']")).click();
	}else {
		List<WebElement> daytab = driver.findElements(By.xpath("//*[@id='root']//div[@class='DayPicker-Body']/div/div/div/div"));
		for(WebElement ele:daytab) {
			
			
			if(ele.getText().equals(gday)) {
				WebElement dele = ele.findElement(By.xpath("./../.."));
				if(dele.getAttribute("aria-disabled").equals(true)){
					System.out.println("Please enter a valid date");
					break;
				}else
				ele.click();
				break;
			}
			
		}
		break;
	}
	}
//	for( int i=0; i<=12; i++) {
//		try {
//	 months=driver.findElement(By.xpath("//div[contains(text(),"+"'"+dmont+"'"+")]")).getText();
//	 if(months.equals(dmont)) {
//		 Thread.sleep(6000);
//		 break;
//	 }
//		}
//		catch(Exception e) {
//			driver.findElement(By.xpath("//*[@data-testid='rightArrow']")).click();
//		}
//		
//	}
//	System.out.println(months);
//	//driver.navigate().refresh();
//	Thread.sleep(6000);
//	
//	
//		List<WebElement> xpath=driver.findElement(By.xpath("//div[contains(text(),'October 2021')]")).findElements(By.xpath("//div[@class='DayPicker-Week']//div[@role='gridcell']//div[@class='Day-grid flex flex-middle flex-column flex-center']//div"));
//		
//		for(int i=0; i<xpath.size(); i++) {
//			
//		//	System.out.println(xpath.get(i).getText());
//			if(xpath.get(i).getText().equals(dat)) {
//				xpath.get(i).click();
//			}
//		
//			
//		}
	}
	}


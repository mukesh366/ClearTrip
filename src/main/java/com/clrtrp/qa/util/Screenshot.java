package com.clrtrp.qa.util;


import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Formatter;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.Test;

import com.clrtrp.qa.Base.Base;

public class Screenshot extends Base {

	public Screenshot() throws IOException  {
		super();
		
	}


//public static void screenShot()  {
//	
//	SimpleDateFormat format=new SimpleDateFormat("dd-MM-yyyy-HH-mm-ss");
//	Date date=new Date();
//	String time=format.format(date);
//	File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//	File dest=new File("./Screenshot/output"+time+".png");
//	
//        try {
//			FileUtils.copyFile(src, dest);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//      
//}
	
	
}

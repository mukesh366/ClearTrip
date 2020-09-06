package com.clrtrp.qa.util;


import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.clrtrp.qa.Base.Base;

public class Screenshot extends Base {

	public Screenshot() throws IOException  {
		super();
		
	}

	
public static void screenShot()  {
	
 
	
	
	File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	
	File dest=new File("./Screenshot/output.png");
	
        try {
			FileUtils.copyFile(src, dest);
		} catch (IOException e) {
			e.printStackTrace();
		}
      
}
	
	
}

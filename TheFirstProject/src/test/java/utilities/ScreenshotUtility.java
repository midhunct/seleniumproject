package utilities;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.google.common.io.Files;

public class ScreenshotUtility{
	
	WebDriver driver;
	
    public ScreenshotUtility(WebDriver driver) {
	
		this.driver = driver;
	}

public void takeScreenshot(String screenshotFileName) throws IOException {
		
		String directory="src/test/resources/screenshots/";
		//String filename="ElementScreenshot";
		//String savename=filename+".jpg";
		String savename= screenshotFileName+".jpg";
		int num = 1;
		
		TakesScreenshot scrShot = ((TakesScreenshot) driver);
		File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);

		File DestFile = new File(directory,savename);
		while(DestFile.exists()) 
		{
			 //savename=filename+(num++)+".jpg";
			 savename= screenshotFileName+(num++)+".jpg";
			 DestFile = new File(directory,savename);
		}
		
		Files.copy(SrcFile, DestFile);

	}

}

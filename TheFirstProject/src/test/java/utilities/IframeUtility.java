package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class IframeUtility{
	
	WebDriver driver;
	
	
	
	public IframeUtility(WebDriver driver) {
	
		this.driver = driver;
	}

	public void iframeEnter(By value) throws InterruptedException
	{
		 driver.switchTo().frame(driver.findElement(value));
		 Thread.sleep(2000);
	}
	
	public void iframeExit()
	{
		 driver.switchTo().parentFrame();
		 //driver.switchTo().defaultContent();
	}

}

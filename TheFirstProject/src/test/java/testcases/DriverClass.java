package testcases;

import org.openqa.selenium.WebDriver;

public class DriverClass {
	
	
	public static WebDriver driver;

	public DriverClass(WebDriver driver) {
		
		this.driver=driver;
	}
	public static WebDriver getDriver()
	{
		return driver;
	}
	
	

}

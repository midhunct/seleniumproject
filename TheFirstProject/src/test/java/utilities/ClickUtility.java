package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import testcases.DriverClass;

public class ClickUtility {
	
	

	WebDriver driver;
	public static WebDriver driver2=DriverClass.getDriver();
	
	public ClickUtility(WebDriver driver) {

		this.driver = driver;
	}
	
	
	public void clickByValue(By value) {
		driver.findElement(value).click();

	}
	
	// used with page factory
	public void clickWebElement(WebElement value)
	{
		 value.click();
	}
	
	
	public static boolean isClickable(WebElement webe)      
	{
	    try
	    {
	        WebDriverWait wait = new WebDriverWait(driver2, 5);
	        wait.until(ExpectedConditions.elementToBeClickable(webe));
	        return true;
	    }
	    catch (Exception e)
	    {
	        return false;
	    }
	}

}

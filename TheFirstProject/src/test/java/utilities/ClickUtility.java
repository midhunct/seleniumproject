package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ClickUtility {
	
	

	WebDriver driver;
	
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

}

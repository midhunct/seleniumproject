package utilities;

import org.openqa.selenium.WebElement;

public class SendKeysUtility {
	
	
	public void enterUsername(WebElement element,String username)
	{
	    element.sendKeys(username);
	}
	
	public void enterPassword(WebElement element,String password)
	{
		element.sendKeys(password);
	}

	public void enterValueInTextbox(WebElement element,String text)
	{
		element.sendKeys(text);
	}

}

package utilities;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class ActionClassUtility {
	
	WebDriver driver;
	
	
	public ActionClassUtility(WebDriver driver)
	{
		this.driver=driver;
	}
	
	
	public void dragAndDropByFun(WebElement element,int x,int y)
	{
		
		  Actions builder=new Actions(driver);
		  Action movebar=builder.dragAndDropBy(element,x,y).build();
		  movebar.perform();
	}
	
	
	public void actionScrollDownToBottom()
	{
		 Actions actions = new Actions(driver);
		 actions.keyDown(Keys.CONTROL).sendKeys(Keys.END).perform();

	}
	
	public void actionScrollUpToTop()
	{
		 Actions actions = new Actions(driver);
		 actions.keyDown(Keys.CONTROL).sendKeys(Keys.HOME).perform();
	}
}

package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class ActionClassUtility {
	
	
	public void dragAndDropByFun(WebElement element,WebDriver driver,int x,int y)
	{
		
		  Actions builder=new Actions(driver);
		  Action movebar=builder.dragAndDropBy(element,x,y).build();
		  movebar.perform();
	}
	

}

package utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JsScrollDownUtility {
	
	
	public void jsScrollDownByPixel(WebDriver driver,int width,int height)
	{
		 JavascriptExecutor js = (JavascriptExecutor) driver;
		 js.executeScript("window.scrollBy("+width+","+height+")");

	}

	
	public void jsScrollDownToBottom(WebDriver driver)
	{
		 JavascriptExecutor js = (JavascriptExecutor) driver;
		 js.executeScript("window.scrollTo(0, document.body.scrollHeight)");

	}
	
	public void jsHorVerScrollTillElementFound(WebElement element,WebDriver driver)
	{
		 JavascriptExecutor js = (JavascriptExecutor) driver;
		 js.executeScript("arguments[0].scrollIntoView();",element);

	}

}

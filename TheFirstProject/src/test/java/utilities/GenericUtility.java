package utilities;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.google.common.io.Files;

public class GenericUtility {

	WebDriver driver;
	public static WebDriver driver2;

	public WebDriver launchBrowser(String baseurl, String browser) {

		switch (browser) {
        
		case "chrome":

			System.setProperty("webdriver.chrome.driver","src/test/resources/drivers/chromedriver.exe");
			driver = new ChromeDriver();
			
			//implicit wait
			driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
			
			// launch browser and redirect it to the Base URL
			driver.get(baseurl);
			
			driver.manage().window().maximize();
			
			break;

		case "edge":
			System.setProperty("webdriver.edge.driver","src/test/resources/drivers/msedgedriver.exe");
			driver = new EdgeDriver();
			
			//implicit wait
			driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
			driver.get(baseurl);
			driver.manage().window().maximize();
			break;

		case "firefox":
			System.setProperty("webdriver.gecko.driver","src/test/resources/drivers/geckodriver.exe");
			driver = new FirefoxDriver();
			
			//implicit wait
			driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
			driver.get(baseurl);
			driver.manage().window().maximize();
			break;

		}

		return driver;
	}
	
	
	public void urlVerification(WebDriver driver,String expectedUrl,String screenshotFileName) throws IOException
	{
		 
		 
		  String actualUrl=driver.getCurrentUrl(); 
		  SoftAssert objassert=new SoftAssert(); 
		  
		  if (actualUrl.equals(expectedUrl)) 
		  {
			  objassert.assertTrue(true);
			  objassert.assertAll();
			  
		  } 
		  else 
		  {
			  
			  ScreenshotUtility scrobj=new ScreenshotUtility(driver);
			  scrobj.takeScreenshot(screenshotFileName);
			  
			  objassert.assertTrue(false);
			  objassert.assertAll();
		  }
	}
   
	
	public void titleVerification(WebDriver driver,String expectedTitle,String screenshotFileName) throws IOException
	{
		 
		 
		  String actualTitle=driver.getTitle(); 
		  SoftAssert objassert=new SoftAssert(); 
		  
		  if (actualTitle.equals(expectedTitle)) 
		  {
			  objassert.assertTrue(true);
			  objassert.assertAll();
			  
		  } 
		  else 
		  {
			  
			  ScreenshotUtility scrobj=new ScreenshotUtility(driver);
			  scrobj.takeScreenshot(screenshotFileName);
			  
			  objassert.assertTrue(false);
			  objassert.assertAll();
		  }
	}
	
	public void messageVerification(WebDriver driver,String actualMessage,String expectedMessage,String screenshotFileName) throws IOException
	{
		 
		  SoftAssert objassert=new SoftAssert(); 
		  
		  if (actualMessage.equals(expectedMessage)) 
		  {
			  objassert.assertTrue(true);
			  objassert.assertAll();
			  
		  } 
		  else 
		  {
			  
			  ScreenshotUtility scrobj=new ScreenshotUtility(driver);
			  scrobj.takeScreenshot(screenshotFileName);
			  
			  objassert.assertTrue(false);
			  objassert.assertAll();
		  }
	}
	
	
	
	
	public void click(By value) {
		driver.findElement(value).click();

	}
	// used with page factory
	public void click1(WebElement value)
	{
		   value.click();
	}

	public void sendKey(By value, String message) {
		driver.findElement(value).sendKeys(message);
	}

	public String getText(WebElement value) {
		String text =value.getText();
		return text;
	}
	
	

	public void selectByValue(WebElement value, String key) {
		Select obj = new Select(value);
		obj.selectByValue(key);

	}

	public void selectByIndex(WebElement value, int index) {
		Select obj = new Select(value);
		obj.selectByIndex(index);

	}

	public void selectByVisibleText(WebElement value, String text) {
		Select obj = new Select(value);
		obj.selectByVisibleText(text);

	}

	public boolean isMultiple(WebElement value) {
		boolean flg = false;
		Select obj = new Select(value);
		if (obj.isMultiple()) {
			flg = true;
			return flg;
		}
		return flg;
	}

	public void alertAccept() {

		org.openqa.selenium.Alert objalert = driver.switchTo().alert();
		objalert.accept();

	}

	public void alertDismiss() {

		org.openqa.selenium.Alert objalert = driver.switchTo().alert();
		objalert.dismiss();

	}

	public void alertConfirmAccept() {

		org.openqa.selenium.Alert objalert = driver.switchTo().alert();
		objalert.accept();

	}

	public void alertPromptAccept(String message) {

		org.openqa.selenium.Alert objprompt = driver.switchTo().alert();
		objprompt.sendKeys(message);
		objprompt.accept();

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
	
	
	
	
	//newly created methods for project
	
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
	
	public void dragAndDropByFun(WebElement element,WebDriver driver,int x,int y)
	{
		
		  Actions builder=new Actions(driver);
		  Action movebar=builder.dragAndDropBy(element,x,y).build();
		  movebar.perform();
	}
	
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

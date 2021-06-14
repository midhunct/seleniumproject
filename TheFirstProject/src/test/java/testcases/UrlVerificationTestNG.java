package testcases;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import utilities.GenericUtility;
import utilities.ScreenshotUtility;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;

public class UrlVerificationTestNG {


	WebDriver driver;
	GenericUtility utilobj;
	ScreenshotUtility scrobj;
	
	//String baseurl="http://buffalocart.com/demo/erp/login";
	//String browser="chrome";
    
	//used @Parameters annotation with testng.xml
	@BeforeClass
	@Parameters({"baseurl","browser"})
	public void beforeClass(String baseurl,String browser) {


		utilobj=new GenericUtility();
		driver=utilobj.launchBrowser(baseurl, browser);
		scrobj=new ScreenshotUtility(driver);


	}

	@Test(priority=1)
	public void urlVerification() throws InterruptedException, IOException {
		
		String expectedUrl="http://buffalocart.com/demo/erp/login";
		String screenshotFileName="initialPageUrlFailed"; 	
		utilobj.urlVerification(driver, expectedUrl, screenshotFileName);		
	}

	
	@Test(priority=2,dataProvider="TitleProvider")
	public void titleVerification(String key,String expectedTitle) throws IOException
	{
		
		//String expectedTitle="Welcome to Codecarrots";
		String screenshotFileName="initialPageTitleFailed";
		utilobj.titleVerification(driver, expectedTitle, screenshotFileName);
	}

    //used data provider for parameterization
	@DataProvider(name="TitleProvider")
	public Object[][] getDataFromDataprovider()
	{
		
		return new Object[][] 
		{
			{"expectedTitle", "Welcome to Codecarrots"}
		};

	}



	@AfterClass
	public void afterClass() {

		driver.close();
		driver.quit();


	}

}

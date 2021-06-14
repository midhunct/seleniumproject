package testcases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pageobjects.LoginPage;
import pageobjects.LogoutPage;
import pageobjects.TaskPage;
import utilities.GenericUtility;

public class LogoutPageTestNG {
	
	
	
	WebDriver driver;
	GenericUtility genutilobj;
	LogoutPage logoutpageobj;

	String baseurl="http://buffalocart.com/demo/erp/login";
	String browser="chrome";
	
	
	
	
	 @BeforeClass
	 public void beforeClass() throws InterruptedException {
		  
		  genutilobj=new GenericUtility();
		  
		  //getting driver from driver class
	      driver=DriverClass.driver;
	    
	      //page object initialization
	      logoutpageobj=new LogoutPage(driver); 
	      
	      driver.navigate().to("http://buffalocart.com/demo/erp/admin/dashboard");
	      Thread.sleep(4000);
	 }
	 
	 
	 @Test(priority=1)
	  public void logoutVerification() throws InterruptedException, IOException {
		  
		    
		    //logout
			genutilobj.click1(logoutpageobj.demomenurighttop); 
			Thread.sleep(2000);
			genutilobj.click1(logoutpageobj.logout);
			
			//avoid 403 error
			Thread.sleep(4000);
			
			//login check
			String expectedUrl="http://buffalocart.com/demo/erp/login";
			String screenshotFileName="logoutFailed";
			genutilobj.urlVerification(driver,expectedUrl,screenshotFileName);  
			
			 
		  
		
		  		 
	 }
	 
	 
	 @AfterClass
	  public void afterClass() {
		  
		   driver.close(); 
		   driver.quit();
	  }

}

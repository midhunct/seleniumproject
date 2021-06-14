package testcases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pageobjects.LeavePage;
import utilities.GenericUtility;

public class LeavePageTestNG {
	
	WebDriver driver;
	GenericUtility genutilobj;
	LeavePage pageobj;
	
	@BeforeClass
	public void beforeClass()
	{
		genutilobj=new GenericUtility();
		
		driver=DriverClass.getDriver();
		pageobj=new LeavePage(driver);
		
	}
	
	@Test(priority=1)
	public void leaveMenuVerification() throws InterruptedException, IOException {


		genutilobj.click1(pageobj.leavemenu);
		Thread.sleep(1000);

		String leavemenuactual=pageobj.leavemenu.getText();
		String leavemenuexpected="Leave Management";
		String screenshotFileName="leavemenufailed";
		genutilobj.messageVerification(driver,leavemenuactual,leavemenuexpected, screenshotFileName);
		

	}
	

}

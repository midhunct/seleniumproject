package testcases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pageobjects.LeavePage;
import utilities.ActionClassUtility;
import utilities.ClickUtility;
import utilities.GenericUtility;
import utilities.JsScrollDownUtility;
import utilities.SelectUtility;

public class LeavePageTestNG {

	WebDriver driver;
	GenericUtility genutilobj;
	LeavePage pageobj;
	ClickUtility clickutilobj;
	SelectUtility selectutilobj;
	ActionClassUtility actioutilobj;

	@BeforeClass
	public void beforeClass()
	{
		genutilobj=new GenericUtility();

		driver=DriverClass.getDriver();
		pageobj=new LeavePage(driver);
		clickutilobj=new ClickUtility(driver);
		selectutilobj=new SelectUtility();
		
		

	}

	@Test(priority=1)
	public void leaveMenuVerification() throws InterruptedException, IOException {

		
		Thread.sleep(2000);
		genutilobj.click1(pageobj.leavemenu);
		

		String leavemenuactual=pageobj.leavemenu.getText();
		String leavemenuexpected="Leave Management";
		String screenshotFileName="leavemenufailed";
		genutilobj.messageVerification(driver,leavemenuactual,leavemenuexpected, screenshotFileName);
		Thread.sleep(3000);


	}

	@Test(priority=2)
	public void applyLeave() throws InterruptedException
	{
		
		 clickutilobj.clickWebElement(pageobj.applyleavemenu);
		
		//WebDriverWait wait = new WebDriverWait(driver,30);
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='select2-users_id-container']")));
		 Thread.sleep(3000);
        int uservalue=2; 
		selectutilobj.selectByIndex(pageobj.selectusers,uservalue);
		
		//2 sick leave
		int categoryvalue=2;
		selectutilobj.selectByIndex(pageobj.selectleavecategory,categoryvalue);
		
		Thread.sleep(2000);


	}


}

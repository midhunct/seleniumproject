package testcases;

import java.awt.AWTException;
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
import utilities.RobotClassUtility;
import utilities.SelectUtility;

public class LeavePageTestNG {

	WebDriver driver;
	GenericUtility genutilobj;
	LeavePage pageobj;
	ClickUtility clickutilobj;
	SelectUtility selectutilobj;
	ActionClassUtility actioutilobj;
	RobotClassUtility robotutilobj;

	@BeforeClass
	public void beforeClass()
	{
		genutilobj=new GenericUtility();

		driver=DriverClass.getDriver();
		pageobj=new LeavePage(driver);
		clickutilobj=new ClickUtility(driver);
		selectutilobj=new SelectUtility();
		robotutilobj=new RobotClassUtility();
		

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
	public void leaveMenuTitleVerification() throws InterruptedException, IOException {

		genutilobj.click1(pageobj.leavemenu);
		Thread.sleep(1000);

		
		String expectedTitle="Leave Management";	
		String screenshotFileName="leavemenutitlefailed";
		genutilobj.titleVerification(driver, expectedTitle, screenshotFileName);

	}
	

	@Test(priority=3)
	public void applyLeave() throws InterruptedException, AWTException
	{
		
		 clickutilobj.clickWebElement(pageobj.applyleavemenu);
		
		//WebDriverWait wait = new WebDriverWait(driver,30);
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='select2-users_id-container']")));
		 Thread.sleep(3000);
		 
		//leave category
		//select users 
		//vishnu 
        int uservalue=2; 
		selectutilobj.selectByIndex(pageobj.selectusers,uservalue);
		Thread.sleep(3000);
		
		//2 sick leave
		int categoryvalue=2;
		selectutilobj.selectByIndex(pageobj.selectleavecategory,categoryvalue);
	
		
		//duration
		clickutilobj.clickWebElement(pageobj.durationradiobtn);
		Thread.sleep(1000);
		
		//start date
		String startDate="2021-06-19";
		genutilobj.enterValueInTextbox(pageobj.startdate,startDate);
		
		
		//end date
	
		//String endDate="2021-06-18";
		//genutilobj.enterValueInTextbox(pageobj.enddate,endDate);
      
		
		//reason
		String reasonText="I have been suffering from fever";
		clickutilobj.clickWebElement(pageobj.reason);
		genutilobj.enterValueInTextbox(pageobj.reason,reasonText);
		
		
		//attachment
		String filePath="C:\\Users\\admin\\git\\newprojectrepo\\TheFirstProject\\src\\test\\resources\\uploadedfiles\\medicalcertificate.txt";
		pageobj.attachment.click();
		Thread.sleep(2000);
		
		//robot class used for browsing file
		robotutilobj.robotUploadFile(filePath);
		
		Thread.sleep(2000);
		
		//save
		clickutilobj.clickWebElement(pageobj.submitbtn);


	}


}

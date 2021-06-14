package testcases;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pageobjects.LoginPage;
import utilities.GenericUtility;
import utilities.POIUtility;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class LoginPageTestNG {


	WebDriver driver;
	GenericUtility utilobj;
	LoginPage loginobj;

	String baseurl="http://buffalocart.com/demo/erp/login";
	String browser="chrome";

	String expectederrormsg="username or password information doesn't exist!";

	String validusername;
	String validpassword;
	String invalidusername;
	String invalidpassword;

	//@Parameters({"urls","browser"})


	@BeforeClass
	public void beforeClass() throws IOException {

		utilobj=new GenericUtility();
		driver=utilobj.launchBrowser(baseurl, browser);
		loginobj=new LoginPage(driver);


		//read login data from excel file using POI
		POIUtility objpoi=new POIUtility();
		String sheetname="login credentials";
		validusername=objpoi.readExcelFun(1,1,sheetname);
		validpassword=objpoi.readExcelFun(2,1,sheetname);
		invalidusername=objpoi.readExcelFun(3,1,sheetname);
		invalidpassword=objpoi.readExcelFun(4,1,sheetname);

	}

	@BeforeMethod()
	public void gotoLoginPage() throws InterruptedException
	{
		System.out.println("Before method");

		driver.navigate().to(baseurl);
		Thread.sleep(2000);
	}


	@Test(priority=1)
	public void invalidUsernameValidPassword() throws InterruptedException, IOException {

		utilobj.enterUsername(loginobj.username,invalidusername);
		utilobj.enterPassword(loginobj.password,validpassword);
		utilobj.click1(loginobj.siginbutton);

		String actualerrormsg=loginobj.invalidmessage.getText();
		String screenshotFileName="invalidUsernameValidPasswordFailed"; 
		utilobj.messageVerification(driver,actualerrormsg,expectederrormsg,screenshotFileName);		

	}

	@Test(priority=2)
	public void validUsernameInvalidPassword() throws InterruptedException, IOException {

		utilobj.enterUsername(loginobj.username,validusername);
		utilobj.enterPassword(loginobj.password,invalidpassword);
		utilobj.click1(loginobj.siginbutton);

		String actualerrormsg=loginobj.invalidmessage.getText();
		String screenshotFileName="validUsernameInvalidPasswordFailed"; 
		utilobj.messageVerification(driver,actualerrormsg,expectederrormsg,screenshotFileName);	

	}


	@Test(priority=3)
	public void invalidUsernameInvalidPassword() throws InterruptedException, IOException {


		utilobj.enterUsername(loginobj.username,invalidusername);
		utilobj.enterPassword(loginobj.password,invalidpassword);
		utilobj.click1(loginobj.siginbutton);

		String actualerrormsg=loginobj.invalidmessage.getText();
		String screenshotFileName="invalidUsernameInvalidPasswordFailed"; 
		utilobj.messageVerification(driver,actualerrormsg,expectederrormsg,screenshotFileName);	

		//to avoid 403 error
		Thread.sleep(2000);


	}

	@Test(priority=4) 
	public void validUsernameValidPassword() throws InterruptedException, IOException {

		utilobj.enterUsername(loginobj.username,validusername);
		utilobj.enterPassword(loginobj.password,validpassword);
		utilobj.click1(loginobj.siginbutton);

		//login verification
		String expectedUrl="http://buffalocart.com/demo/erp/admin/dashboard";
		String screenshotFileName="validUsernameAndPasswordFailed";
		utilobj.urlVerification(driver, expectedUrl, screenshotFileName);

		//avoid 403 error
		Thread.sleep(2000);

	}


	@AfterClass public void afterClass() {


		DriverClass driverobj=new DriverClass(driver);

	}




}

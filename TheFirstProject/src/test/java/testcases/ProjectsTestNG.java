package testcases;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pageobjects.LoginPage;
import pageobjects.ProjectPage;
import utilities.ActionClassUtility;
import utilities.ClickUtility;
import utilities.GenericUtility;
import utilities.ScreenshotUtility;
import utilities.SearchPaginationUtility;

import org.testng.annotations.BeforeTest;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;

public class ProjectsTestNG {

	WebDriver driver;
	GenericUtility utilobj;
	ProjectPage pageobj;
    ActionClassUtility actionutilobj;
    SearchPaginationUtility searchpagutilobj;
    ClickUtility clickutilobj;

	@BeforeClass
	public void beforeClass() throws InterruptedException {

		utilobj=new GenericUtility();
		driver=DriverClass.getDriver();	
		pageobj=new ProjectPage(driver);
		actionutilobj=new ActionClassUtility(driver);
		searchpagutilobj=new SearchPaginationUtility(driver);
		clickutilobj=new ClickUtility(driver);
	}


	@Test(priority=1)
	public void projectMenuVerification() throws InterruptedException, IOException {

		utilobj.click1(pageobj.projectsmenu);
		Thread.sleep(1000);

		String projectmenuactual=pageobj.projectsmenu.getText();
		String projectmenuexpected="Projects";	
		String screenshotFileName="projectmenufailed";
		utilobj.messageVerification(driver,projectmenuactual,projectmenuexpected,screenshotFileName);

	}
	
	
	
	@Test(priority=2)
	public void projectMenuTitleVerification() throws InterruptedException, IOException {

		utilobj.click1(pageobj.projectsmenu);
		Thread.sleep(1000);

		
		String expectedTitle="All Project";	
		String screenshotFileName="projectmenutitlefailed";
		utilobj.titleVerification(driver, expectedTitle, screenshotFileName);

	}


	@Test(priority=3)
	public void addNewProject() throws InterruptedException
	{

		utilobj.click1(pageobj.newprojectsmenu);

		//project no 
		String defaultvalue=pageobj.projectno.getAttribute("value");
		//System.out.println("ppppppppppppppppp"+defaultvalue);
		Assert.assertNotNull(defaultvalue);

		//project name
		String projectname="SampleProject006";
		utilobj.enterValueInTextbox(pageobj.projectname,projectname);

		Thread.sleep(2000);

		//select client
		String clientname="abc";
		utilobj.selectByVisibleText(pageobj.projectclientselect,clientname);

		//move progress element
		actionutilobj.dragAndDropByFun(pageobj.progressmovebar,18,0);
		Thread.sleep(2000);

		String progressDisplayValueActual=pageobj.progressbardisplayvalue.getText();
		String progressDisplayValueExpected="6%";

		SoftAssert progressassert=new SoftAssert();
		progressassert.assertEquals(progressDisplayValueActual,progressDisplayValueExpected);
		progressassert.assertAll();

		//start date
		String startDate="2021-06-04";
		utilobj.enterValueInTextbox(pageobj.startdate,startDate);
		Thread.sleep(2000);

		//end date
		String endDate="2021-07-07";
		utilobj.enterValueInTextbox(pageobj.enddate,endDate);
		Thread.sleep(2000);

		//select billing type
		//tasks_and_project_hours  
		//project_hours
		//fixed_rate
		//tasks_hours
		String billingtype="tasks_hours";
		utilobj.selectByValue(pageobj.billingtype,billingtype);


		//for sub fields
		switch(billingtype)
		{


		case "project_hours":        

			if(pageobj.projecthourlyrate.isEnabled()) 
			{ 
				String  projecthourrate="1000";
				utilobj.enterValueInTextbox(pageobj.projecthourlyrate,projecthourrate); 

			}
			break;

		case "tasks_and_project_hours":

			if(pageobj.projecthourlyrate.isEnabled()) 
			{ 
				String projectandtaskhourrate="2000";
				utilobj.enterValueInTextbox(pageobj.projecthourlyrate,projectandtaskhourrate);
			} 
			break;

		case "fixed_rate":                               

			if(pageobj.fixedrate.isEnabled()) 
			{ 
				String fixedrate="10000";
				utilobj.enterValueInTextbox(pageobj.fixedrate,fixedrate);
			} 
			break;


		}
		Thread.sleep(2000);

		//estimate hours
		String estimatehoursvalue="5";
		utilobj.enterValueInTextbox(pageobj.estimatehours,estimatehoursvalue);

		//status select
		String status="In Progress";
		utilobj.selectByVisibleText(pageobj.statusselect,status);

		//demo url
		String demourl="http://buffalocart.com/demo/erp/login";
		utilobj.enterValueInTextbox(pageobj.demourlelement,demourl);

		//assigned to radio button
		utilobj.click1(pageobj.assignedto);

		//select users checkbox
		if(pageobj.selectusers.isDisplayed())
		{
			utilobj.click1(pageobj.selectusers);
			Thread.sleep(2000);
		}


		//description
		String decriptiontext="This is my proect";
		utilobj.enterValueInTextbox(pageobj.description,decriptiontext);
		Thread.sleep(2000);


		//scroll down 
		utilobj.jsHorVerScrollTillElementFound(pageobj.save, driver);
		Thread.sleep(2000);

		//save
		utilobj.click1(pageobj.save);

		System.out.println("successssssssssssss");
		Thread.sleep(4000);


	}

	@Test(priority=4)
	public void verifyProjectInAllProjectsMenu() throws InterruptedException, IOException
	{

		utilobj.click1(pageobj.projectsmenu);
		Thread.sleep(1000);
		
		utilobj.click1(pageobj.allprojectsmenu);
		Thread.sleep(4000);
		
		String searchKey="SampleProject006";
		//boolean found=searchpagutilobj.contentSearchPagination(pageobj.pagenextallprojects,searchKey);
		
		WebElement  webtabletbody=driver.findElement(By.xpath("//table[@id='DataTables']//tbody"));
		boolean found=searchpagutilobj.contentSearchPagination2(pageobj.pagenextallprojects, webtabletbody,searchKey);
				
        SoftAssert assertprojectcheck=new SoftAssert();
		if(found==true)
		{
			assertprojectcheck.assertTrue(true);
			assertprojectcheck.assertAll();
		}
		else
		{
			String screenshotFileName="verifyprojectsinallprojectsfailed";
			ScreenshotUtility scrobj=new ScreenshotUtility(driver);
			scrobj.takeScreenshot(screenshotFileName);
			 
			assertprojectcheck.assertTrue(false);
			assertprojectcheck.assertAll();
		}
   

	}


	@Test(priority=5)
	public void projectChangeStatusCheck() throws InterruptedException, IOException
	{
		String projectname="SampleProject006";
		String expectedstatusmsg="On Hold";
		
		utilobj.click1(pageobj.allprojectsmenu);
		Thread.sleep(2000);
      

		int firstpage=1;

		do {

			if(firstpage==0)
			{

				utilobj.click1(pageobj.pagenextallprojects);
			}
			else
			{
				firstpage=0;
			}

			Thread.sleep(4000);
			WebElement webtable=driver.findElement(By.xpath("//table[@id='DataTables']//tbody"));
			List<WebElement> rows=webtable.findElements(By.tagName("tr"));


			int tableRowCount=rows.size();
			System.out.println("RowSize>> "+tableRowCount);
			int foundrow;
			boolean found=false;
			// utilobj.jsScrollDownToBottom(driver);

		   

			//changing the status of project to hold
			for(int i=0;i<tableRowCount;i++)
			{
				
				List<WebElement> columns=rows.get(i).findElements(By.tagName("td"));
				
				int columnsCount=columns.size();

				for(int j=0;j<columnsCount;j++)
				{

					String cellText=columns.get(j).getText();

					if(cellText.contains(projectname))
					{
						found=true;

						foundrow =i+1;
						System.out.println("Status Before Change:>>>> "+columns.get(5).getText());
						columns.get(5).click();
						Thread.sleep(1000);
						//li[4]=On Hold
						String xpth="//table[@id='DataTables']//tbody//"+"tr["+foundrow+"]//"+"td[6]//"+"div//ul//li[4]//a";
						driver.findElement(By.xpath(xpth)).click();
						Thread.sleep(4000);
						break;
					}

				}
				System.out.println();
			}


			if(found==true)
			{
				
				break;
			}

			
			//utilobj.jsScrollDownToBottom(driver);
			
			//check the absence of next page element to identify last page
			//here the next page is disabled at last page
			WebElement clknext=driver.findElement(By.xpath("//*[@id='DataTables_next']"));
			String actualval=clknext.getAttribute("class");
			String expectval="paginate_button next disabled";	
			if(actualval.equals(expectval))
			{
				break;
			}
			
			
		}
		while(pageobj.pagenextallprojects.isDisplayed());
		
		Thread.sleep(4000);


	}
	
	@Test(priority=6)
	public void statusChangeVerify() throws InterruptedException, IOException
	{
		
		String projectname="SampleProject006";
		String expectedstatusmsg="On Hold";
		System.out.println("inside statusChangeVerify");
		
		utilobj.click1(pageobj.projectsmenu);
		Thread.sleep(2000);


		int firstpage=1;

		do {

			if(firstpage==0)
			{

				utilobj.click1(pageobj.pagenextallprojects);
			}
			else
			{
				firstpage=0;
			}

			Thread.sleep(4000);
			WebElement webtable=driver.findElement(By.xpath("//table[@id='DataTables']//tbody"));
			List<WebElement> rows=webtable.findElements(By.tagName("tr"));


			int tableRowCount=rows.size();
			int foundrow;
			boolean found=false;
			// utilobj.jsScrollDownToBottom(driver);


			//changing the status of project to hold
			for(int i=0;i<tableRowCount;i++)
			{
				
				List<WebElement> columns=rows.get(i).findElements(By.tagName("td"));
				
				int columnsCount=columns.size();

				for(int j=0;j<columnsCount;j++)
				{

					String cellText=columns.get(j).getText();

					if(cellText.contains(projectname))
					{
						found=true;

						foundrow =i+1;
						System.out.println("Current Status >>>> "+columns.get(5).getText());
						String actualstatusmsg=columns.get(5).getText();
						String screenshotFileName="projectchangestatusfailed";
						utilobj.messageVerificationContains(driver,actualstatusmsg,expectedstatusmsg, screenshotFileName);
						Thread.sleep(4000);
						break;
					}

				}
				System.out.println();
			}


			if(found==true)
			{
				break;
			}

			
			//utilobj.jsScrollDownToBottom(driver);
			
			//check the absence of next page element to identify last page
			//here the next page is disabled at last page
			WebElement clknext=driver.findElement(By.xpath("//*[@id='DataTables_next']"));
			String actualval=clknext.getAttribute("class");
			String expectval="paginate_button next disabled";	
			if(actualval.equals(expectval))
			{
				break;
			}
			
			
		}
		while(pageobj.pagenextallprojects.isDisplayed());
			
	}





	@AfterClass
	public void afterClass() throws InterruptedException {

		driver.navigate().to("http://buffalocart.com/demo/erp/admin/dashboard");
		Thread.sleep(3000);


	}





}

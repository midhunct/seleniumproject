package testcases;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pageobjects.LoginPage;
import pageobjects.TaskPage;
import utilities.GenericUtility;
import utilities.ScreenshotUtility;

public class TaskPageTestNG {


	WebDriver driver;
	GenericUtility utilobj;
	TaskPage pageobj;


	@BeforeClass
	public void beforeClass() throws InterruptedException {

		utilobj=new GenericUtility();

		driver=DriverClass.getDriver();

		pageobj=new TaskPage(driver);

	}


	@Test(priority=1)
	public void taskMenuVerification() throws InterruptedException, IOException {


		utilobj.click1(pageobj.tasksmenu);
		Thread.sleep(1000);

		String taskmenuactual=pageobj.tasksmenu.getText();
		String taskmenuexpected="Tasks";
		String screenshotFileName="taskmenufailed";
		utilobj.messageVerification(driver,taskmenuactual,taskmenuexpected,screenshotFileName);

		
	}
	
	@Test(priority=2)
	public void taskMenuTitleVerification() throws InterruptedException, IOException {

		utilobj.click1(pageobj.tasksmenu);
		Thread.sleep(1000);

		
		String expectedTitle="All Task";	
		String screenshotFileName="taskmenutitlefailed";
		utilobj.titleVerification(driver, expectedTitle, screenshotFileName);

	}

	
	
	@Test(priority=3)
	public void addNewTask() throws InterruptedException, IOException
	{

		utilobj.click1(pageobj.newtasksmenu);
		Thread.sleep(4000);

		//taskname
		String taskname="evaluation";
		utilobj.enterValueInTextbox(pageobj.taskname,taskname);

		//select related to

		//none
		//project
		//opportunities
		//leads
		//bug
		//sub_task(Tasks)
		String relatedtotype="sub_task";
		utilobj.selectByValue(pageobj.relatedtoselect,relatedtotype);

		switch(relatedtotype)
		{

		case "project":

			if(pageobj.selectproject.isEnabled())
			{
				String selectvalue="SampleProject006";
				utilobj.selectByVisibleText(pageobj.selectproject,selectvalue);
			}
			break;

		case "opportunities":

			if(pageobj.selectopportunities.isEnabled())
			{
				String selectvalue="Q.A";
				utilobj.selectByVisibleText(pageobj.selectopportunities,selectvalue);
			}
			break;	

		case "leads": 

			if(pageobj.selectleads.isEnabled())
			{
				String selectvalue="Ecommerce App";
				utilobj.selectByVisibleText(pageobj.selectleads,selectvalue);
			}
			break; 

		case "bug":   

			if(pageobj.selectbugs.isEnabled())
			{
				String selectvalue="Text not write it";
				utilobj.selectByVisibleText(pageobj.selectbugs,selectvalue);
			}
			break; 

		case "sub_task":       

			if(pageobj.selectsubtasks.isEnabled())
			{
				String selectvalue="ID";
				utilobj.selectByVisibleText(pageobj.selectsubtasks,selectvalue);
			}
			break;



		}

		//start date
		String startDate="2021-06-04";
		utilobj.enterValueInTextbox(pageobj.startdate,startDate);
		Thread.sleep(2000);

		//end date
		String dueDate="2021-07-07";
		utilobj.enterValueInTextbox(pageobj.duedate,dueDate);
		Thread.sleep(2000);

		//hourly rate
		String hourlyrate="1000";
		utilobj.enterValueInTextbox(pageobj.hourlyrate,hourlyrate);
		Thread.sleep(2000);


		//estimate hours
		String estimatedhoursvalue="5";
		utilobj.enterValueInTextbox(pageobj.estimatedhour,estimatedhoursvalue);

		utilobj.jsHorVerScrollTillElementFound(pageobj.save, driver); 

		//move progress element
		utilobj.dragAndDropByFun(pageobj.progressmovebar, driver,2,0);
		Thread.sleep(2000);

		String progressDisplayValueActual=pageobj.progressbardisplayvalue.getText();
		String progressDisplayValueExpected="2%";

		SoftAssert progressassert=new SoftAssert();
		progressassert.assertEquals(progressDisplayValueActual,progressDisplayValueExpected);
		progressassert.assertAll();

		//select task status
		String taskstatusvalue="in_progress";
		utilobj.selectByValue(pageobj.taskstatus,taskstatusvalue);
		Thread.sleep(2000);

		//task description
		String decriptiontext="This is my task";
		utilobj.enterValueInTextbox(pageobj.taskdescription,decriptiontext);
		Thread.sleep(2000);

		//billable
		String billableonexpectedvalue="Yes";
		utilobj.click1(pageobj.billable);
		Thread.sleep(3000);
//		String  billableonactualvalue=pageobj.billableon.getText();
//
//		SoftAssert billableassert=new SoftAssert();
//		billableassert.assertEquals(billableonactualvalue,billableonexpectedvalue);
//		billableassert.assertAll();
//		Thread.sleep(2000);

		//assigned to radio button
		utilobj.click1(pageobj.assignedto);

		//select users checkbox

		if(pageobj.selectusers.isDisplayed()) 
		{ 
			utilobj.click1(pageobj.selectusers);

		}
		Thread.sleep(2000); 

		//save
		utilobj.click1(pageobj.save);
		
		String actualUrl=driver.getCurrentUrl();
		System.out.println("current url>> "+ actualUrl);		
		String expectedUrl="http://buffalocart.com/demo/erp/admin/tasks/view_task_details/";
		String screenshotFileName="addnewtaskfailed";
		utilobj.urlVerificationContains(driver, expectedUrl, screenshotFileName);
		Thread.sleep(3000); 

	}


	@Test(priority=4)
	public void importTaskFile() throws InterruptedException, IOException {

		utilobj.click1(pageobj.tasksmenu);
		Thread.sleep(1000);

		utilobj.click1(pageobj.importmenu);
		//String filePath=" C:\\Users\\admin\\Downloads\\tasks_sample_midhun.xlsx";
		String filePath="C:\\Users\\admin\\git\\newprojectrepo\\TheFirstProject\\src\\test\\resources\\uploadedfiles\\tasks_sample_midhun.xlsx";
		utilobj.enterValueInTextbox(pageobj.importmenuChooseFile,filePath);

		utilobj.click1(pageobj.importmenuAssignedToEveryone);

		String status="in_progress";
		utilobj.selectByValue(pageobj.importmenutaskStatus,status);


		utilobj.click1(pageobj.importmenuUploadBtn);
		Thread.sleep(2000);

		boolean newtaskstatus=false;
		if(driver.getPageSource().contains("My New Task"))
		{
			 newtaskstatus=true;
		}
		
		
		SoftAssert objassert=new SoftAssert();
		if(newtaskstatus==true)
		{	
			 objassert.assertTrue(true);
			 objassert.assertAll();
			
		}
		else
		{
			 String screenshotFileName="importtaskfailed";
			 ScreenshotUtility scrobj=new ScreenshotUtility(driver);
			 scrobj.takeScreenshot(screenshotFileName);

			 objassert.assertTrue(false);
			 objassert.assertAll();
		}



	}

	@Test(priority=5)
	public void downloadSampleFile() throws InterruptedException, IOException {



		utilobj.click1(pageobj.importmenu);
		Thread.sleep(4000);

		utilobj.click1(pageobj.importmenuDownloadSample);
		Thread.sleep(4000);

		String samplefilename= "tasks_sample.xlsx";
		File fileLocation = new File("C:\\Users\\admin\\Downloads");
		File[] totalfiles = fileLocation.listFiles();
		boolean filefound = false;
		for(File file : totalfiles)
		{
			if(file.getName().equals(samplefilename))
			{
				System.out.println(file.getName() +"File is downloaded");
				filefound=true;
				
				break;
			}
		}
		
		
		SoftAssert objassert=new SoftAssert();
		if(filefound==true)
		{	
			 objassert.assertTrue(true);
			 objassert.assertAll();
			
		}
		else
		{
			 String screenshotFileName="downloadsamplefilefailed";
			 ScreenshotUtility scrobj=new ScreenshotUtility(driver);
			 scrobj.takeScreenshot(screenshotFileName);
			
			 System.out.println("File not found");
			 objassert.assertTrue(false);
			 objassert.assertAll();
		}

	}

    //deleting imported task  my task
	@Test(priority=6)
	public void deleteTask() throws InterruptedException
	{

		utilobj.click1(pageobj.tasksmenu);
		Thread.sleep(2000);


		int firstpage=1;

		do {

			if(firstpage==0)
			{

				utilobj.click1(pageobj.pagenextasks);
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

			boolean found=false;
			// utilobj.jsScrollDownToBottom(driver);

			int foundrow;
			int foundrowcheckbox;
			String taskname="My New Task";

			//changing the status of project to hold
			for(int i=0;i<tableRowCount;i++)
			{
				List<WebElement> columns=rows.get(i).findElements(By.tagName("td"));
				int columnsCount=columns.size();

				for(int j=0;j<columnsCount;j++)
				{

					String cellText=columns.get(j).getText();

					if(cellText.contains(taskname))
					{
						foundrow=i+1;  
						foundrowcheckbox=i+2;
						found=true;

						String xpthvaluecheckbox="(.//*[@class='fa fa-check'])"+"["+foundrowcheckbox+"]";
						driver.findElement(By.xpath(xpthvaluecheckbox)).click();
						Thread.sleep(2000);

						String xpthvalue="(//*[@title='Delete']//i)"+"["+foundrow+"]";
						driver.findElement(By.xpath(xpthvalue)).click();

						Alert alert=driver.switchTo().alert();
						alert.accept();

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
			
			
			
			WebElement clknext=driver.findElement(By.xpath("//*[@id='DataTables_next']"));
			String actualval=clknext.getAttribute("class");
			String expectval="paginate_button next disabled";	
			if(actualval.equals(expectval))
			{
				break;
			}
			
		}
		while(pageobj.pagenextasks.isDisplayed());

		Thread.sleep(4000);


	}
	
	@AfterClass
	public void afterClass() throws InterruptedException {

		driver.navigate().to("http://buffalocart.com/demo/erp/admin/dashboard");
		Thread.sleep(3000);


	}






}

package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class TaskPage {
	
	
	
    WebDriver driver;
    
    public  TaskPage(WebDriver driver)
    {
    	this.driver=driver;
    	PageFactory.initElements(driver,this);
    }
    
    @FindBy(how=How.XPATH, using="//*[@title='Tasks']//span")
   	public WebElement tasksmenu;
    
    @FindBy(how=How.XPATH, using=".//*[@href='#assign_task']")
   	public WebElement newtasksmenu;
    
    @FindBy(how=How.XPATH, using="//*[@name='task_name']")
   	public WebElement taskname;
 
    
    @FindBy(how=How.NAME, using="related_to")
    public WebElement relatedtoselect;
    
    
    @FindBy(how=How.NAME, using="project_id")
   	public WebElement selectproject;
    
    @FindBy(how=How.NAME, using="opportunities_id")
   	public WebElement selectopportunities;
    
    @FindBy(how=How.NAME, using="leads_id")
   	public WebElement selectleads;
    
    @FindBy(how=How.NAME, using="bug_id")
   	public WebElement selectbugs;
    
    @FindBy(how=How.NAME, using="sub_task_id")
   	public WebElement selectsubtasks;
    
    @FindBy(how=How.NAME, using="task_start_date")
    public WebElement startdate;
    
    
    @FindBy(how=How.NAME,using="due_date")
    public WebElement duedate;
    
    @FindBy(how=How.NAME,using="hourly_rate")
    public WebElement hourlyrate;
    
    @FindBy(how=How.NAME,using="task_hour")
    public WebElement estimatedhour;
    
    @FindBy(how=How.XPATH, using="(.//*[@class='col-lg-5']//span)[1]")
    public WebElement progressmovebar;
    
    @FindBy(how=How.XPATH, using="//*[@class='pull-left mt']//span")
    public WebElement progressbardisplayvalue;
    
    
    @FindBy(how=How.NAME,using="task_status")
    public WebElement taskstatus;
    
    @FindBy(how=How.XPATH,using=".//*[@class='note-editable']")
    public WebElement taskdescription;
    
    @FindBy(how=How.XPATH,using="//*[@class='btn btn-danger active toggle-off']")
    public WebElement billable;
    
    @FindBy(how=How.XPATH,using=" //*[@class='btn btn-success toggle-on']")
    public WebElement billableon;
    
  
    
    @FindBy(how=How.XPATH,using="//input[@value='custom_permission']")
    public WebElement assignedto;
    
    @FindBy(how=How.XPATH,using="//*[@class='checkbox c-checkbox needsclick']//span")
    public WebElement selectusers;
    
    @FindBy(how=How.XPATH,using="//button[contains(text(),'Save')]")
    public WebElement save;
    
    @FindBy(how=How.XPATH,using="//a[contains(text(),'Import Tasks')]")
    public WebElement importmenu;
    
    @FindBy(how=How.XPATH,using="//*[@name='upload_file']")
    public WebElement importmenuChooseFile;
    
    
    @FindBy(how=How.XPATH,using="//select[@name='task_status']")
    public WebElement importmenutaskStatus;
    
    
    @FindBy(how=How.XPATH,using="//*[@id='border-none']/div/div[1]/label/input")
    public WebElement importmenuAssignedToEveryone;
    
    @FindBy(how=How.XPATH,using="//button[contains(text(),'Upload')]")
    public WebElement importmenuUploadBtn;
    
    @FindBy(how=How.XPATH,using="//*[@class='fa fa-download']")
    public WebElement importmenuDownloadSample;
    
    @FindBy(how=How.XPATH,using="//*[@id='DataTables_next']/a")
    public  WebElement pagenextasks;
    
    
    
    
    
  

}

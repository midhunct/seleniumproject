package pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class ProjectPage {
	
	
    WebDriver driver;
    
    public ProjectPage(WebDriver driver)
    {
    	this.driver=driver;
    	PageFactory.initElements(driver,this);
    }
    
    @FindBy(how=How.XPATH, using="(//*[@title='Projects']//span)")
	public WebElement projectsmenu;
    
    
    @FindBy(how=How.XPATH, using="(//a[contains(text(),'New Project')])")
   	public WebElement newprojectsmenu;
    
    
    @FindBy(how=How.XPATH, using="//*[@id='create']/form/div/div[1]/div[1]/div/input")
   	public WebElement projectno;
    
    
    @FindBy(how=How.XPATH, using="((//*[@type='text'])[3])")
    public WebElement projectname;
    
    @FindBy(how=How.NAME, using="client_id")
    public WebElement projectclientselect;
    
   
    @FindBy(how=How.XPATH, using=" (//*[@class='col-lg-8']//span)[7]")
    public WebElement progressmovebar;
    
    @FindBy(how=How.XPATH, using="//*[@class='pull-left mt']//span")
    public WebElement progressbardisplayvalue;
    
    
    @FindBy(how=How.XPATH, using="//*[@name='start_date']")
    public WebElement startdate;
    
    
    @FindBy(how=How.XPATH,using="//*[@name='end_date']")
    public WebElement enddate;
    
    @FindBy(how=How.NAME,using="billing_type")
    public WebElement billingtype;
    
    @FindBy(how=How.XPATH,using="//*[@class='form-control hourly_rate']")
    public WebElement projecthourlyrate;
    
    @FindBy(how=How.XPATH,using="//*[@class='form-control fixed_rate']")
    public WebElement fixedrate;
    
    @FindBy(how=How.XPATH,using="//*[@type='number']")
    public WebElement estimatehours;
    
    @FindBy(how=How.NAME,using="project_status")
    public WebElement statusselect;
    
    
    @FindBy(how=How.XPATH,using="//input[@name='demo_url']")
    public WebElement demourlelement;
    
   
    @FindBy(how=How.XPATH,using="//input[@value='custom_permission']")
    public WebElement assignedto;
    
    @FindBy(how=How.XPATH,using="(//*[@class='fa fa-check'])[14]")
    public WebElement selectusers;
    
    @FindBy(how=How.XPATH,using="//*[@class='note-editable']")
    public WebElement description;
    
    @FindBy(how=How.XPATH,using="//button[contains(text(),'Save')]")
    public WebElement save;
   
   
    @FindBy(how=How.XPATH,using=" //a[contains(text(),'All Projects')]") 
    public WebElement allprojectsmenu;
    
    @FindBy(how=How.XPATH,using="//a[contains(text(),'Next')]") 
    public WebElement pagenextallprojects;
    
    //thead's tr th
    @FindBy(how=How.XPATH,using="//*[@id='DataTables']/thead/tr/th") 
    public List<WebElement> tablecolumns;
    
    //tbody's tr
    @FindBy(how=How.XPATH,using="//*[@id='DataTables']/tbody/tr") 
    public List<WebElement> tablerows;
    
   
    
 
    @FindBy(how=How.XPATH,using="//tr[@role='row' and (@class='odd' or @class='even')]") 
    public List<WebElement> nexttablerow;
    
   
  //----------------------table---------------------------
    
    //toast-progress
    //toast-message
    @FindBy(how=How.CLASS_NAME,using="//div[@class='toast-progress']")
    public WebElement statuchangemeesage;
    
    
    
   
    
   
    
    
    
   
    
  
  
    
}

package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class LeavePage {

	
	WebDriver driver;
    
    public  LeavePage(WebDriver driver)
    {
    	this.driver=driver;
    	PageFactory.initElements(driver,this);
    }
    
    @FindBy(how=How.XPATH,using="//*[@title='Leave Management']")
    public WebElement leavemenu;
    
    @FindBy(how=How.XPATH, using="//*[@href='http://buffalocart.com/demo/erp/admin/leave_management/apply_leave']")
   	public WebElement applyleavemenu;
       
    @FindBy(how=How.XPATH, using="//select[@id='users_id']")
   	public WebElement selectusers;
    
 
    @FindBy(how=How.XPATH, using="//select[@name='leave_category_id']")
   	public WebElement selectleavecategory;
    
    @FindBy(how=How.XPATH, using="  //input[@name='leave_type' and @value='multiple_days']")
    public WebElement durationradiobtn;
    
    @FindBy(how=How.NAME, using="multiple_days_start_date")
    public WebElement startdate;
    
    
    @FindBy(how=How.NAME,using="multiple_days_end_date")
    public WebElement enddate;
    
    @FindBy(how=How.XPATH,using="//textarea[@id='present']")
    public WebElement reason;
    
    
    @FindBy(how=How.XPATH,using="//*[@class='dz-default dz-message']")
    public WebElement attachment;
    
 
    @FindBy(how=How.XPATH,using=" //button[@id='file-save-button']")
    public WebElement submitbtn;
    
    
   // @FindBy(how=How.XPATH, using="//*[@id='myModal_extra_lg']/div/div/div[1]")
    //public WebElement applyleaveelement;
   
    
    

}

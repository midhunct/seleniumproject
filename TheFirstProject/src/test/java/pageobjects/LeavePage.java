package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LeavePage {

	
	WebDriver driver;
    
    public  LeavePage(WebDriver driver)
    {
    	this.driver=driver;
    	PageFactory.initElements(driver,this);
    }
    
    @FindBy(how=How.XPATH,using="//*[@title='Leave Management']//span")
    public WebElement leavemenu;
    
    

}

package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	public WebDriver driver;

	public LoginPage( WebDriver driver) {
		
		this.driver=driver;
		
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(how=How.NAME, using="user_name")
	public WebElement username;
	
	@FindBy(how=How.NAME, using="password")
	public WebElement password;
	
	@FindBy(how=How.XPATH, using="//button[contains(text(),\"Sign in\")]")
	public WebElement siginbutton;
	
	@FindBy(how=How.XPATH, using="(//*[@class='alert alert-danger'])[1]")
	public WebElement invalidmessage;
	
	@FindBy(how=How.XPATH, using="(//*[@href='#']//span)[1]")
	public WebElement demomenurighttop;
	
	
	@FindBy(how=How.XPATH, using="(//*[@type='submit'])[1]")
	public WebElement logout;

}

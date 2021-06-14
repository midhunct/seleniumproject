package utilities;

import org.openqa.selenium.WebDriver;

public class AlertUtility{
	
	WebDriver driver;
	
	public AlertUtility(WebDriver driver) {

		this.driver = driver;
	}

	public void alertAccept() {

		org.openqa.selenium.Alert objalert = driver.switchTo().alert();
		objalert.accept();

	}

	public void alertDismiss() {

		org.openqa.selenium.Alert objalert = driver.switchTo().alert();
		objalert.dismiss();

	}

	public void alertConfirmAccept() {

		org.openqa.selenium.Alert objalert = driver.switchTo().alert();
		objalert.accept();

	}

	public void alertPromptAccept(String message) {

		org.openqa.selenium.Alert objprompt = driver.switchTo().alert();
		objprompt.sendKeys(message);
		objprompt.accept();

	}

}

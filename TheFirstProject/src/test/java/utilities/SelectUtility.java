package utilities;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class SelectUtility {
	
	
	public void selectByValue(WebElement value, String key) {
		Select obj = new Select(value);
		obj.selectByValue(key);

	}

	public void selectByIndex(WebElement value, int index) {
		Select obj = new Select(value);
		obj.selectByIndex(index);

	}

	public void selectByVisibleText(WebElement value, String text) {
		Select obj = new Select(value);
		obj.selectByVisibleText(text);

	}
	
	public boolean isMultiple(WebElement value) {
		boolean flg = false;
		Select obj = new Select(value);
		if (obj.isMultiple()) {
			flg = true;
			return flg;
		}
		return flg;
	}

}

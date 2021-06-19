package utilities;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchPaginationUtility {

	WebDriver driver;
	GenericUtility utilobj;
	WebElement nextelement;

	public SearchPaginationUtility(WebDriver driver)
	{
		this.driver=driver;
		utilobj=new GenericUtility();
	}

    //using page source
	public boolean contentSearchPagination(WebElement pagenext,String searchKey) throws InterruptedException
	{
		boolean itemFoundStatus=false;

		int firstpage=1;

		do{

			if(firstpage==0)
			{

				utilobj.click1(pagenext);
			}
			else
			{
				firstpage=0;
			}

			Thread.sleep(4000);

			if(driver.getPageSource().contains(searchKey))
			{
				itemFoundStatus=true;
				System.out.println(searchKey+" Found");
				break;
			}
			
			//not work in all projects depends 
			WebElement clknext=driver.findElement(By.xpath("//*[@id='DataTables_next']"));
			String actualval=clknext.getAttribute("class");
			String expectval="paginate_button next disabled";	
			
			if(actualval.equals(expectval))
			{
				break;
			}
			
			
			utilobj.jsScrollDownToBottom(driver);
		}
		while(pagenext.isDisplayed());

		return itemFoundStatus;

	}		

    // iterate through each cell
	public boolean contentSearchPagination2(WebElement pagenext,WebElement webtabletbody,String searchKey) throws InterruptedException
	{
		boolean found;
		int firstpage=1;

		do {

			if(firstpage==0)
			{
               
				utilobj.click1(pagenext);
			}
			else
			{
				firstpage=0;
			}

			Thread.sleep(4000);
			//WebElement webtable=driver.findElement(By.xpath("//table[@id='DataTables']//tbody"));
			List<WebElement> rows=webtabletbody.findElements(By.tagName("tr"));


			int tableRowCount=rows.size();
			System.out.println("RowSize>> "+tableRowCount);
			int foundrow;
			found=false;
			// utilobj.jsScrollDownToBottom(driver);

			//String projectname="SampleProject006";

			
			for(int i=0;i<tableRowCount;i++)
			{
				List<WebElement> columns=rows.get(i).findElements(By.tagName("td"));
				int columnsCount=columns.size();

				for(int j=0;j<columnsCount;j++)
				{

					String cellText=columns.get(j).getText();

					if(cellText.contains(searchKey))
					{
						found=true;
						break;
					}

				}

			}

            //break from do while when item found
			if(found==true)
			{
				break;
			}
			
			//check the absence of next page element to identify last page
			//here the next page is disabled at last page
			WebElement clknext=driver.findElement(By.xpath("//*[@id='DataTables_next']"));
			String actualval=clknext.getAttribute("class");
			String expectval="paginate_button next disabled";	
			
			//break from do while when no element is found at last page
			if(actualval.equals(expectval))
			{
				break;
			}


		}while(pagenext.isDisplayed());
		
		return found;
	}	


}

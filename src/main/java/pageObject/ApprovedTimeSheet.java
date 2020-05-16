package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class ApprovedTimeSheet {

WebDriver driver;	
	@FindBy(xpath="//a[@href=\"/payrollapp/timesheet/approvedlist\"]")
	WebElement approved;
	
	public void approvedTSheet()
	{
		approved.click();
		 WebDriverWait w=new WebDriverWait(driver,60);
		    w.until(ExpectedConditions.urlToBe("http://qabible.in/payrollapp/timesheet/approvedlist"));
		//Assert.assertEquals("http://qabible.in/payrollapp/timesheet/approvedlist", "http://qabible.in/payrollapp/timesheet/approvedlist");
		System.out.println("Approved timesheet loaded");
	}
	
public ApprovedTimeSheet(WebDriver driver)
	
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	

}

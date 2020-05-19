package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
//import org.testng.Assert;

public class ApprovedTimeSheet {

WebDriver driver;	
	//@FindBy(xpath="//div//ul//li//a[@href=\"/payrollapp/timesheet/approvedlist\"]")
	//WebElement approved;
	
	public void approvedTSheet()
	{
		String url=driver.getCurrentUrl();
		System.out.println(url);
		driver.findElement(By.xpath("//div//ul//li//a[@href=\"/payrollapp/timesheet/approvedlist\"]")).click();
		//WebDriverWait w1=new WebDriverWait(driver,60);
		//w1.until(ExpectedConditions.visibilityOf(approved));
		//approved.click();
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

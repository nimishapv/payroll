package pageObject;

import java.util.ArrayList;
import java.util.List;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;



public class TimeSheet {
	WebDriver driver;
	
	@FindBy(xpath="//a[@href=\"/payrollapp/timesheet/index\"]")
	WebElement timesheet;
	
	@FindBy(xpath="//button[@value=\"playslip\"]")
	WebElement payslip;
	@FindBy(xpath="//button[@value=\"invoice\"]")
	WebElement invoice;
	
	public void loadPage()
	{
//		WebDriverWait w=new WebDriverWait(driver,30);
//		w.until(ExpectedConditions.visibilityOf(timesheet));
		String url=driver.getCurrentUrl();
	    System.out.println("From time"+url);
		timesheet.click();
		System.out.println("loadPage");
		
	    WebDriverWait w=new WebDriverWait(driver,60);
	    w.until(ExpectedConditions.urlToBe("http://qabible.in/payrollapp/timesheet/index"));
	    System.out.println("Timesheet page loaded");
	}

	public void buttonAlerts()
	{
		WebDriverWait w=new WebDriverWait(driver,30);
		w.until(ExpectedConditions.visibilityOf(payslip));
		payslip.click();
		Alert al=driver.switchTo().alert();
		System.out.println(al.getText());
		al.accept();
		Assert.assertFalse(payslip.isEnabled());
		WebDriverWait w2=new WebDriverWait(driver,30);
		w2.until(ExpectedConditions.alertIsPresent());
		Alert al1=driver.switchTo().alert();
		System.out.println(al1.getText());
		al1.accept();
		
		//Assert.assertTrue(payslip.isEnabled());
		WebDriverWait w1=new WebDriverWait(driver,30);
		w1.until(ExpectedConditions.visibilityOf(invoice));
		invoice.click();
		System.out.println(al.getText());
		al.accept();
		Assert.assertFalse(invoice.isEnabled());
		WebDriverWait w3=new WebDriverWait(driver,40);
		w3.until(ExpectedConditions.alertIsPresent());
		Alert al2=driver.switchTo().alert();
		
		System.out.println(al2.getText());
		al2.accept();
		Actions act=new Actions(driver);
		act.moveToElement(invoice).build().perform();
		System.out.println("mouse moved to invoice");
		
		//Assert.assertFalse(invoice.isEnabled());
	}
	
	
	
	public void testPage() {
		loadPage();
		buttonAlerts();
	}
	
	public TimeSheet(WebDriver driver)
	
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
}

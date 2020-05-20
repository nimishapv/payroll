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
	
	public void pendingTimeSheet() throws InterruptedException {
		
		int size=driver.findElements(By.xpath("//table//tbody//tr")).size();
		System.out.println("Size of the table: "+size);
		
		List <WebElement> timeSheetNoElement=driver.findElements(By.xpath("//table//tbody//tr//td[2]"));
		
		List <String> timeSheetNoList= new ArrayList<String>();
		
		for (WebElement timeSheetNoElements : timeSheetNoElement) {
			timeSheetNoList.add(timeSheetNoElements.getText());
		}
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,2000)");
		
		//System.out.println(timeSheetNoList);
		
		String nextButtonClassName=driver.findElement(By.xpath("//li[@class=\"next\"]")).getAttribute("class");
		System.out.println(nextButtonClassName);
		
		while(!nextButtonClassName.contains("disabled")) {
			
			WebDriverWait w=new WebDriverWait(driver,30);
		
			WebElement nextButton = driver.findElement(By.xpath("//li[@class=\"next\"]//a"));
		
			w.until(ExpectedConditions.visibilityOf(nextButton));
			nextButton.click();
			
			Thread.sleep(5000);
			
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			System.out.println(driver.getCurrentUrl());
			js.executeScript("window.scrollBy(0,2000)");
			timeSheetNoElement=driver.findElements(By.xpath("//table//tbody//tr//td[2]"));
		
			
			for (WebElement timeSheetNoElements : timeSheetNoElement) {
				timeSheetNoList.add(timeSheetNoElements.getText());
			}
			WebDriverWait w1=new WebDriverWait(driver,30);
			w1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[contains(@class,'next')]")));
			nextButtonClassName=driver.findElement(By.xpath("//li[contains(@class,'next')]")).getAttribute("class");
			System.out.println(nextButtonClassName);
		}
	
		
		for (String timeSheetNoLists:timeSheetNoList) {
			System.out.println(timeSheetNoLists);
		}
		
		boolean isContains=timeSheetNoList.contains("345678");
		
		if(isContains) {
			driver.findElement(By.xpath("//tr[@data-key=\"9436\"]//td//input")).click();
			js.executeScript("window.scrollBy(0,-1500)");
			driver.findElement(By.xpath("/html/body/section/div/div/div[3]/form/button")).click();
		}
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

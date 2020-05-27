package pageObject;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PendingTimeSheet {
	
	@FindBy(name="Timesheet[timesheet_number]")
	WebElement timesheet_number;
	
	@FindBy(xpath="//select[@name=\"Timesheet[description]\"]")
	WebElement description;
	
	@FindBy(xpath="//div[@class=\"form-group\"]//button[@type=\"submit\"]")
	WebElement save;
	
	WebDriver driver;
	public String newTimeSheetNo,timesheet_id;
	
	/*public String getTimeSheetNo() {
		System.out.println("create timesheet url: "+driver.getCurrentUrl());
		WebElement timeSheetNo=driver.findElement(By.xpath("//table[@id=\"w0\"]//tbody//tr//td[1]"));
		   newTimeSheetNo=timeSheetNo.getText();
		  System.out.println(newTimeSheetNo);
		  return newTimeSheetNo;
	}*/
	
	public void pendingTimeSheetLoad() {
		
		System.out.println("created timesheet url: "+driver.getCurrentUrl());
		String url=driver.getCurrentUrl();
		//System.out.println(url);
		 String[] arr = url.split("=", 0);  
		 System.out.println(arr[1]);
		  timesheet_id=arr[1];

		WebElement timeSheetNo=driver.findElement(By.xpath("//table[@id=\"w0\"]//tbody//tr//td[1]"));
		   newTimeSheetNo=timeSheetNo.getText();
		  System.out.println(newTimeSheetNo);
		
		WebElement pendingButton=driver.findElement(By.xpath("//a[@href=\"/payrollapp/timesheet\"]"));
		pendingButton.click();
		System.out.println("Pending TimeSheet loaded");
		//System.out.println("Timesheet no "+timeSheetNo);
		
	}
	
public void validateWebTable() throws InterruptedException {
	
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
	
		
		/*for (String timeSheetNoLists:timeSheetNoList) {
			System.out.println(timeSheetNoLists);
		}*/
		
		
		
		//boolean isContains=timeSheetNoList.contains(newTimeSheetNo);
		//System.out.println(isContains);
		
		/*WebElement timeSheetid=driver.findElement(By.xpath("//input[@value="+timesheet_id+"]"));
		timeSheetid.click();
		WebElement approveButton=driver.findElement(By.xpath("/html/body/section/div/div/div[3]/form/button"));
		approveButton.click();*/
	}

public void viewPendingTimeSheetDetails() {
	//WebElement timeSheetid=driver.findElement(By.xpath("//input[@value="+timesheet_id+"]"));
	//timeSheetid.click();
	pagination();
	WebElement viewButton=driver.findElement(By.xpath("//a[@href=\"/payrollapp/timesheet/view?id="+timesheet_id+"\"]"));

	viewButton.click();
	driver.navigate().back();
}

public void updatePendingTimeSheetDetails() throws InterruptedException {
	
	WebElement updateButton=driver.findElement(By.xpath("//a[@href=\"/payrollapp/timesheet/update?id="+timesheet_id+"\"]"));
	updateButton.click();
	timesheet_number.sendKeys("635222");
	Thread.sleep(3000);
	Select s=new Select(description);
	s.selectByValue("Senior Carer");
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("window.scrollBy(0,2000)");
	save.submit();
	WebDriverWait w=new WebDriverWait(driver,30);
	w.until(ExpectedConditions.urlContains("view"));
	System.out.println("url after updating timesheet details: "+driver.getCurrentUrl());
	WebElement timesheet=driver.findElement(By.xpath("//ul[@class=\"breadcrumb\"]//li//a[@href=\"/payrollapp/timesheet/index\"]"));
	timesheet.click();
	pagination();
}

public void confirmTimeSheetDetails() {
	WebElement confirmButton=driver.findElement(By.xpath("//a[@href=\"/payrollapp/timesheet/approve?id="+timesheet_id+"\"]"));
	confirmButton.click();
	Alert al=driver.switchTo().alert();
	System.out.println(al.getText());
	al.accept();
	pagination();
	List <WebElement> checkboxes =driver.findElements(By.xpath("//input[@name=\"selection[]\"]"));
	
	Boolean found = false;
	
	for (WebElement checkbox : checkboxes) {
		if(checkbox.getAttribute("value") == timesheet_id) {
			found = true;
			break;
		}
	}
	
	
	if (!found) {
		System.out.println("Timesheet id " +timesheet_id+ " is approved");
	}
	else {
		System.out.println("Timesheet id " +timesheet_id+ " is not approved");
	}
}

public void testPendingTimeSheet() throws InterruptedException {
	pendingTimeSheetLoad();
	validateWebTable();
	
}

public void pagination() {
	
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("window.scrollBy(0,2000)");
	
	int size=driver.findElements(By.xpath("//ul[@class=\"pagination\"]//li")).size();
	
	int lastNumber=size-1;
	driver.findElement(By.xpath("//ul[@class=\"pagination\"]//li["+lastNumber+"]//a")).click();
	js.executeScript("window.scrollBy(0,2000)");
}

public PendingTimeSheet(WebDriver driver)

{
	
	this.driver=driver;
	PageFactory.initElements(driver,this);
}

}

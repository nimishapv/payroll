package pageObject;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
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
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateTimeSheet {
	WebDriver driver;
	
	@FindBy(xpath="//a[@href=\"/payrollapp/timesheet/create\"]")
	WebElement create;
	@FindBy(xpath="//button[@class=\"btn btn-success\"]")
	WebElement skip;
	@FindBy(xpath="//select[@name=\"Timesheet[branch_id]\"]")
	WebElement branch;
	@FindBy(xpath="//select[@name=\"Timesheet[division_id]\"]")
	WebElement division;
	@FindBy(xpath="//select[@name=\"Timesheet[description]\"]")
	WebElement description;
	@FindBy(name="Timesheet[timesheet_number]")
	WebElement number;
	
	@FindBy(xpath="//*[@id=\"dynamic-form\"]/div/div[2]/div[1]/span/span[1]/span/span[2]")
    WebElement client;
	@FindBy(xpath="//input[@class=\"select2-search__field\"]")
	WebElement clientInput;
	//@FindBy(xpath="//ul[@class=\"select2-results__options\"]//li")
	//WebElement clientOption;
	
	
	@FindBy(xpath="//input[@name=\"Timesheet[date]\"]")
	WebElement date;
	@FindBy(xpath="//div[@class=\"datepicker-days\"]//tr[2]//td[7]")
	WebElement weekendDate;
	@FindBy(xpath="//select[@name=\"Timesheet[category]\"]")
	WebElement category;
	@FindBy(xpath="//input[@id=\"timesheet-direct_client\"]")
	WebElement checkbox1;
	
	@FindBy(xpath="//*[@id=\"dynamic-form\"]/div/div[3]/div[1]/span/span[1]/span/span[2]")
	WebElement worker;
	
	@FindBy(xpath="//select[@name=\"Timesheet[employment_type]\"]")
	WebElement type;
	@FindBy(name="Timesheet[po_number]")
	WebElement PO;
	//@FindBy(xpath="//button[@class=\"pull-right add-item btn btn-success btn-xs\"]")
	//WebElement rate;
	@FindBy(xpath="//select[@name=\"Rate[0][type_id]\"]")
	WebElement rate_desc;
	@FindBy(name="Rate[0][frequency]")
	WebElement frequency;
	@FindBy(name="Rate[0][units]")
	WebElement unit;
	@FindBy(name="Rate[0][pay]")
	WebElement pay;
	@FindBy(name="Rate[0][bill]")
	WebElement bill;
	@FindBy(xpath="//input[@id=\"rate-0-awr\"]")
	WebElement awr;
	
	@FindBy(xpath="//*[@id=\"dynamic-form\"]/div/div[4]/div[2]/div/div[1]/button")
	WebElement expense;
	@FindBy(xpath="//select[@name=\"Expense[0][type_id]\"]")
	WebElement adhoc;
	@FindBy(name="Expense[0][units]")
	WebElement ex_unit;
	@FindBy(name="Expense[0][pay]")
	WebElement ex_pay;
	@FindBy(name="Expense[0][bill]")
	WebElement ex_bill;
	@FindBy(xpath="//*[@id=\"dynamic-form\"]/div/div[4]/div[3]/div/div[1]/button")
	WebElement deduction;
	@FindBy(xpath="//select[@name=\"Deduction[0][type]\"]")
	WebElement ded_type;
	@FindBy(name="Deduction[0][amount]")
	WebElement ded_amt;
	@FindBy(xpath="//div[@class=\"form-group\"]//button[@type=\"submit\"]")
	WebElement save;
	
	public String timesheet_id,newTimeSheetNo;
	
	public void createTSLink()
	{
		create.click();
		skip.click();
		Alert al=driver.switchTo().alert();
		System.out.println(al.getText());
		al.accept();
	}
	
	public WebElement selectRandomOption(String xPath)
	{
		int size = driver.findElements(By.xpath(xPath)).size();
		int randomNum = ThreadLocalRandom.current().nextInt(1, size);
	//	System.out.println(randomNum);
		WebElement option = driver.findElement(By.xpath(xPath + "["+randomNum+"]"));
		return option;
	}
	
	public void createTS() throws AWTException
	{
		System.out.println(driver.getCurrentUrl());
		Select s=new Select(branch);
		s.selectByIndex(1);
		Select s1=new Select(division);
		s1.selectByValue("1");
		Select s2=new Select(description);
		s2.selectByValue("Support Worker");
		number.sendKeys("4777");
		
		WebDriverWait w=new WebDriverWait(driver,50);
		w.until(ExpectedConditions.visibilityOf(client));
        //Select s3=new Select(client);
		//s3.selectByIndex(1);
		client.click();

		WebElement option = selectRandomOption("//ul[@class=\"select2-results__options\"]//li");
		
		option.click();
		
		
	/*	Robot r=new Robot();
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_CONTROL);
		r.keyRelease(KeyEvent.VK_ENTER);*/
		//clientOption.click();
		
	    date.click();
	    weekendDate.click();
	    Select c=new Select(category);
		c.selectByValue("Contractor");
		checkbox1.click();
		
		WebDriverWait w1=new WebDriverWait(driver,30);
		w1.until(ExpectedConditions.visibilityOf(worker));
		worker.click();
        WebElement worker_option = selectRandomOption("//ul[@class=\"select2-results__options\"]//li");
		worker_option.click();
		
		
		Select s5=new Select(type);
		s5.selectByIndex(2);
		PO.sendKeys("33434");
		
	}
	
	public void addRate() throws InterruptedException {
		//rate.click();
		Select de=new Select(rate_desc);
		de.selectByIndex(1);
		Select fr=new Select(frequency);
		fr.selectByIndex(1);
		unit.sendKeys("2");
		Thread.sleep(3000);
		//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	//	pay.click();
		pay.sendKeys("250");
		Thread.sleep(4000);
		//bill.click();
		bill.sendKeys("2500");
		Thread.sleep(3000);
		awr.click();
	}
	
	public void addExpense() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1000)");
		WebDriverWait w1=new WebDriverWait(driver,30);
		w1.until(ExpectedConditions.visibilityOf(expense));
		Actions act=new Actions(driver);
		act.moveToElement(expense).click().perform();
		
		w1.until(ExpectedConditions.visibilityOf(adhoc));
		Select ad=new Select(adhoc);
		ad.selectByIndex(1);
		ex_unit.sendKeys("3");
		//driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		Thread.sleep(4000);
		ex_pay.sendKeys("500");
		Thread.sleep(4000);
		
		ex_bill.sendKeys("600");
		Thread.sleep(3000);
	}
	
	public void addDeduction() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1000)");
		WebDriverWait w1=new WebDriverWait(driver,30);
		w1.until(ExpectedConditions.visibilityOf(deduction));
		Actions act=new Actions(driver);
		act.moveToElement(deduction).click().perform();
		
		//deduction.click();
		Select d=new Select(ded_type);
		d.selectByIndex(2);
		ded_amt.sendKeys("300");
		save.submit();
		//WebDriverWait w1=new WebDriverWait(driver,30);
		w1.until(ExpectedConditions.urlContains("view"));
		System.out.println(driver.getCurrentUrl());
		
		/*w1.until(ExpectedConditions.urlContains("view"));
		String url=driver.getCurrentUrl();
		System.out.println(url);
		 String[] arr = url.split("=", 0);  
		 System.out.println(arr[1]);
		  timesheet_id=arr[1];*/
		  
		  
	}
	
	public String getTimeSheetNo() {
		System.out.println("create timesheet url: "+driver.getCurrentUrl());
		WebElement timeSheetNo=driver.findElement(By.xpath("//table[@id=\"w0\"]//tbody//tr//td[1]"));
		   newTimeSheetNo=timeSheetNo.getText();
		  System.out.println(newTimeSheetNo);
		  return newTimeSheetNo;
	}
	
	public void testCreateTimeSheet() throws AWTException, InterruptedException {
		createTSLink();
		createTS();
		addRate();
		addExpense();
		addDeduction();
		//getTimeSheetNo();
	}
	
	public CreateTimeSheet(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

}

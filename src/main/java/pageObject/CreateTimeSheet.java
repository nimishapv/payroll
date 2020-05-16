package pageObject;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CreateTimeSheet {
	WebDriver driver;
	
	@FindBy(linkText="payrollapp/timesheet/create")
	WebElement create;
	@FindBy(className="btn btn-success")
	WebElement skip;
	@FindBy(xpath="//select[@name=\"Timesheet[branch_id]\"]")
	WebElement branch;
	@FindBy(xpath="//select[@name=\"Timesheet[division_id]\"]")
	WebElement division;
	@FindBy(xpath="//select[@name=\"Timesheet[description]\"]")
	WebElement description;
	@FindBy(name="Timesheet[timesheet_number]")
	WebElement number;
	@FindBy(xpath="//select[@name=\"Timesheet[client_id]\"]")
	WebElement client;
	@FindBy(xpath="//input[@name=\"Timesheet[date]\"]")
	WebElement date;
	@FindBy(xpath="//div[@class=\"datepicker-days\"]//tr[2]//td[7]")
	WebElement weekendDate;
	@FindBy(xpath="//select[@name=\"Timesheet[category]\"]")
	WebElement category;
	@FindBy(name="Timesheet[direct_client]")
	WebElement checkbox1;
	@FindBy(xpath="//span[@id=\"select2-timesheet-worker_id-container\"]")
	WebElement worker;
	@FindBy(xpath="//select[@name=\"Timesheet[employment_type]\"]")
	WebElement type;
	@FindBy(name="Timesheet[po_number]")
	WebElement PO;
	@FindBy(xpath="//button[@class=\"pull-right add-item btn btn-success btn-xs\"]")
	WebElement rate;
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
	@FindBy(xpath="//div[@class=\"form-group field-rate-0-awr has-success\"]")
	WebElement awr;
	@FindBy(xpath="//button[@class=\"pull-right add-item1 btn btn-success btn-xs\"]")
	WebElement expense;
	@FindBy(xpath="//select[@name=\"Expense[0][type_id]\"]")
	WebElement adhoc;
	@FindBy(name="Expense[0][units]")
	WebElement ex_unit;
	@FindBy(name="Expense[0][pay]")
	WebElement ex_pay;
	@FindBy(name="Expense[0][bill]")
	WebElement ex_bill;
	@FindBy(xpath="//button[@class=\"pull-right add-item2 btn btn-success btn-xs\"]")
	WebElement deduction;
	@FindBy(xpath="//select[@name=\"Deduction[0][type]\"]")
	WebElement ded_type;
	@FindBy(name="Deduction[0][amount]")
	WebElement ded_amt;
	@FindBy(className="btn btn-success")
	WebElement save;
	
	public void createTSLink()
	{
		create.click();
		skip.click();
		Alert al=driver.switchTo().alert();
		System.out.println(al.getText());
		al.accept();
	}
	
	public void createTS()
	{
		Select s=new Select(branch);
		s.selectByIndex(1);
		Select s1=new Select(division);
		s1.selectByValue("1");
		Select s2=new Select(description);
		s2.selectByValue("Support Worker");
		number.sendKeys("232323");
		Select s3=new Select(client);
		s3.selectByIndex(1);
	    date.click();
	    weekendDate.click();
	    Select c=new Select(category);
		c.selectByValue("Contractor");
		checkbox1.click();
		Select s4=new Select(worker);
		s4.selectByValue("2");
		Select s5=new Select(type);
		s5.selectByIndex(2);
		PO.sendKeys("33434");
		
	}
	
	public void addRate() {
		rate.click();
		Select de=new Select(rate_desc);
		de.selectByIndex(1);
		Select fr=new Select(frequency);
		fr.selectByIndex(1);
		unit.sendKeys("2");
		pay.sendKeys("250");
		bill.sendKeys("2500");
		awr.click();
	}
	
	public void addExpense() {
		expense.click();
		Select ad=new Select(adhoc);
		ad.selectByIndex(1);
		ex_unit.sendKeys("3");
		ex_pay.sendKeys("500");
		ex_bill.sendKeys("600");
	}
	
	public void addDeduction() {
		deduction.click();
		Select d=new Select(ded_type);
		d.selectByIndex(2);
		ded_amt.sendKeys("300");
		save.submit();
	}
	
	public CreateTimeSheet(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

}

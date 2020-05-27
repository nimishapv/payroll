package test;

import java.awt.AWTException;

import org.testng.annotations.Test;

import pageObject.CreateTimeSheet;
import pageObject.PendingTimeSheet;
import pageObject.TimeSheet;

public class PendingTimeSheetTest extends LoginTest{
	
	
	CreateTimeSheet ct;
  @Test(priority=0)
  public void runPendingTimeSheet () throws AWTException, InterruptedException {
	  TimeSheet t;
	  t=new TimeSheet(driver);
	  t.loadPage();
	  
	 ct=new CreateTimeSheet(driver);
	  ct.testCreateTimeSheet();
	  
	PendingTimeSheet p=new PendingTimeSheet(driver);
	
	//p.getTimeSheetNo();
	p.pendingTimeSheetLoad();
	
	p.viewPendingTimeSheetDetails();
	//p.pagination();
	p.updatePendingTimeSheetDetails();
	p.confirmTimeSheetDetails();
  }
 /* @Test(priority=1)
  public void getTS() {
		String timeSheetNo=ct.getTimeSheetNo();
		System.out.println(timeSheetNo);
	}*/
}

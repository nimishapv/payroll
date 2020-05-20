package test;

import org.testng.annotations.Test;

import pageObject.ApprovedTimeSheet;
import pageObject.TimeSheet;
import utility.BaseClass;

public class ApprovedTimeSheetTest extends LoginTest {
  @Test(priority=1)
  public void testApproved() {
	  
	  TimeSheet t;
	  t=new TimeSheet(driver);
	  t.loadPage();
	  ApprovedTimeSheet a =new ApprovedTimeSheet(driver);
	  a.approvedTSheet();
  }
}

package test;

import org.testng.annotations.Test;

import pageObject.ApprovedTimeSheet;
import pageObject.TimeSheet;
import utility.BaseClass;

public class ApprovedTimeSheetTest extends LoginTest {
  @Test 
  public void f() {
	  
	  TimeSheet t;
	  t=new TimeSheet(driver);
	  t.loadPage();
	  ApprovedTimeSheet a =new ApprovedTimeSheet(driver);
	  a.approvedTSheet();
  }
}

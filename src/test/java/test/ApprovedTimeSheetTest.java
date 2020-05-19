package test;

import org.testng.annotations.Test;

import pageObject.ApprovedTimeSheet;
import pageObject.TimeSheet;
import utility.BaseClass;

public class ApprovedTimeSheetTest extends TimeSheetTest {
  @Test(priority=2)
  public void t() {
	  
	  
	  ApprovedTimeSheet a =new ApprovedTimeSheet(driver);
	  a.approvedTSheet();
  }
}

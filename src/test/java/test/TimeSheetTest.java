package test;

import org.testng.annotations.Test;

import pageObject.TimeSheet;
import utility.BaseClass;

public class TimeSheetTest extends LoginTest {
	
  @Test(priority=1)
  public void second () {
	  
	  TimeSheet t;
	  t=new TimeSheet(driver);
	  t.loadPage();
	  t.buttonAlerts();
  }
}

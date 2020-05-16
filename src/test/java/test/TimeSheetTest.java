package test;

import org.testng.annotations.Test;

import pageObject.TimeSheet;
import utility.BaseClass;

public class TimeSheetTest extends LoginTest {
	
  @Test
  public void f () {
	  
	  TimeSheet t;
	  t=new TimeSheet(driver);
	  t.loadPage();
	  t.buttonAlerts();
  }
}

package test;

import java.awt.AWTException;

import org.testng.annotations.Test;

import pageObject.CreateTimeSheet;
import utility.BaseClass;

public class CreateTimeSheetTest extends ApprovedTimeSheetTest {
  @Test(priority=3)
  public void f() throws AWTException {
	 CreateTimeSheet c; 
	 c=new CreateTimeSheet(driver);
	 c.createTSLink();
	 c.createTS();
	 c.addRate();
	 c.addExpense();
	 c.addDeduction();
	
	  
  }
}

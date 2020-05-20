package test;

import java.awt.AWTException;

import org.testng.annotations.Test;

import pageObject.CreateTimeSheet;
import utility.BaseClass;

public class CreateTimeSheetTest extends TimeSheetTest {
  @Test
  public void f() throws AWTException, InterruptedException {
	 CreateTimeSheet c; 
	 c=new CreateTimeSheet(driver);
	c.testCreateTimeSheet();
	
	  
  }
}

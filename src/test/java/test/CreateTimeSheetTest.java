package test;

import org.testng.annotations.Test;

import pageObject.CreateTimeSheet;
import utility.BaseClass;

public class CreateTimeSheetTest extends BaseClass {
  @Test
  public void f() {
	 CreateTimeSheet c; 
	 c=new CreateTimeSheet(driver);
	 c.createTSLink();
	 c.createTS();
	 c.addRate();
	 c.addExpense();
	 c.addDeduction();
	
	  
  }
}
